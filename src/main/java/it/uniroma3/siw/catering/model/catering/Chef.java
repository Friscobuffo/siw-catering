package it.uniroma3.siw.catering.model.catering;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity @Getter @Setter
public class Chef {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String surname;
    
    private String nationality;

    @OneToMany(mappedBy = "chef", cascade = CascadeType.ALL)
    private List<Buffet> buffets;
}
