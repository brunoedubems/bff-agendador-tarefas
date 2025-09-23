package br.com.brunoedubems.bffagendador_tarefas.business.dto.out;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TelefoneDTOResponse {
    private Long id;
    private String numero;
    private String ddd;
}
