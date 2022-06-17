package it.uniroma3.siw.catering.controller;

import it.uniroma3.siw.catering.controller.validator.CredentialsValidator;
import it.uniroma3.siw.catering.controller.validator.UserValidator;
import it.uniroma3.siw.catering.model.userdata.Credentials;
import it.uniroma3.siw.catering.model.userdata.GoogleUser;
import it.uniroma3.siw.catering.model.userdata.User;
import it.uniroma3.siw.catering.service.userdata.CredentialsService;
import it.uniroma3.siw.catering.service.userdata.GoogleUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Iterator;

@Controller
public class AuthController {
    @Autowired private CredentialsService credentialsService;
    @Autowired private GoogleUserService googleUserService;
    @Autowired private UserValidator userValidator;
    @Autowired private CredentialsValidator credentialsValidator;

    @RequestMapping(value = "/user/register", method = RequestMethod.GET)
    public String showRegisterForm (Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("credentials", new Credentials());
        return "user/registerForm";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String showLoginForm () {
        return "loginForm";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout() {
        return "index";
    }

    @RequestMapping(value = "/default", method = RequestMethod.GET)
    public String defaultAfterLogin(@AuthenticationPrincipal OidcUser principal) {
        try {
            defaultAfterLoginGoogle(principal);
        }
        catch (Exception e) {
            UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            Credentials credentials = credentialsService.getCredentials(userDetails.getUsername());
            if (credentials.getRole().equals(Credentials.ADMIN_ROLE)) {
                return "admin/home";
            }
        }
        return "user/home";
    }

    private
    String defaultAfterLoginGoogle(OidcUser principal) {
        GoogleUser googleUser = this.googleUserService.getGoogleUser(principal.getEmail());
        if (googleUser == null) {
            saveGoogleUser(principal);
        }
        return "user/home";
    }

    private String saveGoogleUser(OidcUser principal) {
        GoogleUser googleUser = this.googleUserService.getGoogleUser(principal.getEmail());
        if (googleUser == null) {
            googleUser = new GoogleUser();
            googleUser.setEmail(principal.getEmail());
            googleUser.setFullName(principal.getFullName());
            this.googleUserService.saveGoogleUser(googleUser);
        }
        return "user/home";
    }

    @RequestMapping(value = { "/user/register" }, method = RequestMethod.POST)
    public String registerUser(
            @ModelAttribute("user") User user, BindingResult userBindingResult,
            @ModelAttribute("credentials") Credentials credentials, BindingResult credentialsBindingResult) {

        this.userValidator.validate(user, userBindingResult);
        this.credentialsValidator.validate(credentials, credentialsBindingResult);

        if (!userBindingResult.hasErrors() && !credentialsBindingResult.hasErrors()) {
            credentials.setUser(user);
            credentialsService.saveCredentials(credentials);
            return "user/registrationSuccessful";
        }
        return "user/registerForm";
    }
}
