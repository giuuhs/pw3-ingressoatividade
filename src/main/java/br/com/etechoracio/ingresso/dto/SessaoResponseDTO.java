package br.com.etechoracio.ingresso.dto;

import java.time.LocalTime;

public record SessaoResponseDTO(
        Long id,
        String Sala,
        LocalTime Preco,
        Double Data,
        String Horario
    ) {

}
