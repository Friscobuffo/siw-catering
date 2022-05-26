package com.servizio_catering.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Buffet {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nome;
    private String descrizione;

    @OneToMany
    private List<Piatto> piatti;

    @ManyToOne
    private Chef chef;
}
