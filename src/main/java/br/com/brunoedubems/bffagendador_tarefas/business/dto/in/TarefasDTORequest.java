package br.com.brunoedubems.bffagendador_tarefas.business.dto.in;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TarefasDTORequest {
    private String nomeTarefa;
    private String descricao;
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm")
    private LocalDateTime dataEvento;
}
