package br.com.etechoracio.ingresso.entity;

import br.com.etechoracio.ingresso.enums.ClassificacaoIndicativaEnum;
import br.com.etechoracio.ingresso.enums.CategoriaFilmeEnum;
import br.com.etechoracio.ingresso.enums.SimNaoEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Duration;

@Getter
@Setter
@Entity
@Table(name = "TBL_FILME")
public class Filme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_FILME")
    private Long id;

    @Column(name = "TX_NOME")
    private String nome;

    @Column(name = "NR_DURACAO")
    private Integer duracao;

    @Enumerated(EnumType.STRING)
    @Column(name = "TP_CATEGORIA")
    private CategoriaFilmeEnum categoria;

    @Enumerated(EnumType.STRING)
    @Column(name = "TP_CLASSIFICACAO")
    private ClassificacaoIndicativaEnum classificacao;

    @Column(name = "NR_ANO")
    private Integer ano;

    @Column(name = "TX_CAPA")
    private String capa;

    @Column(name = "TX_DIRETOR")
    private String diretor;

    @Column(name = "TX_ELENCO")
    private String elenco;

    @Column(name = "TX_DESCRICAO")
    private String descricao;

    @Column(name = "NR_AVALIACAO")
    private Double avaliacao;

    @Enumerated(EnumType.STRING)
    @Column(name = "CHK_EM_CARTAZ")
    private SimNaoEnum emCartaz;

    @OneToMany(mappedBy) = "filme", cascade = CascadeType.ALL, orphanRemoval = true)
    private List(Sessao) sessoes = new ArrayList<>();

}
