package br.com.brunoedubems.bffagendador_tarefas.business;


import br.com.brunoedubems.bffagendador_tarefas.business.dto.in.TarefasDTORequest;
import br.com.brunoedubems.bffagendador_tarefas.business.dto.out.TarefasDTOResponse;
import br.com.brunoedubems.bffagendador_tarefas.infrastructure.client.EmailClient;
import br.com.brunoedubems.bffagendador_tarefas.infrastructure.client.TarefasClient;
import br.com.brunoedubems.bffagendador_tarefas.infrastructure.enums.StatusNotificacaoEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final EmailClient emailClient;

    public void enviaEmail(TarefasDTOResponse dto) {
        emailClient.enviarEmail(dto);
    }

}
