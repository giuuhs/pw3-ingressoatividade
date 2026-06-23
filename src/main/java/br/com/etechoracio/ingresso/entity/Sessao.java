package br.com.etechoracio.ingresso.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@Entity
@Table(name = "TBL_SESSAO")
public class Sessao{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_SESSAO")
    private Long id;

    @Column(name = "DATA_SESSAO")
    private LocalDate data;

    @Column(name = "HORARIO")
    private LocalTime horario;

    @Column(name = "PRECO")
    private Double preco;

    @Column(name = "SALA")
    private String sala;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "filme_id", nullable = false)   //algo errado aq, arrumar isso no filme
    private Filme filme;
}