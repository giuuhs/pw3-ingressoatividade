package br.com.etechoracio.ingresso.dto;
import java.util.List;


public record FilmeComSessaoDTO(
    Long id,
    String titulo,
    String classificacao,
    Integer ano,
    String diretores,
    String elenco,
    String descricacao,
    Double avaliacao,
    List<SessaoResponseDTO> sessoes
    ){
}
