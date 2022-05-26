package it.uniroma3.siw.catering.model.catering;

import javax.persistence.*;
import java.util.List;

@Entity
public class Chef {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private String cognome;
    private String nazionalita;

    @OneToMany
    private List<Buffet> buffet;
}
