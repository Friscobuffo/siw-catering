package it.uniroma3.siw.catering.model.userdata;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity @Getter @Setter
@Table(name="users") //in postgres user is a reserved key
public class User {

	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String name;

	private String surname;

	private String email;
}
