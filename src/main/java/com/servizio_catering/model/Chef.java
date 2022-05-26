package com.servizio_catering.model;

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
