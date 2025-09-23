package br.com.brunoedubems.bffagendador_tarefas.business.dto.out;

import br.com.brunoedubems.bffagendador_tarefas.infrastructure.enums.StatusNotificacaoEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TarefasDTOResponse {
    private String id;
    private String nomeTarefa;
    private String descricao;
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm")
    private LocalDateTime dataCriacao;

    @JsonFormat(pattern = "dd-MM-yyyy HH:mm")
    private LocalDateTime dataEvento;
    private String emailUsuario;
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm")
    private LocalDateTime dataAlteracao;
    private StatusNotificacaoEnum statusNotificacaoEnum;

}
