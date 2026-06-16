package br.com.etechoracio.ingresso.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public record SessaoResponseDTO(
    Long id,
    String Sala,
    Float Preco,
    LocalDate Data,
    LocalTime Horario
    ) {

}
