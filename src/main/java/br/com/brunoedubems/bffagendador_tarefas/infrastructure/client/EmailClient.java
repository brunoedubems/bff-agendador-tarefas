package br.com.brunoedubems.bffagendador_tarefas.infrastructure.client;

import br.com.brunoedubems.bffagendador_tarefas.business.dto.in.EnderecoDTORequest;
import br.com.brunoedubems.bffagendador_tarefas.business.dto.in.TelefoneDTORequest;
import br.com.brunoedubems.bffagendador_tarefas.business.dto.in.UsuarioDTORequest;
import br.com.brunoedubems.bffagendador_tarefas.business.dto.out.TarefasDTOResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "notificacao", url = "${notificacao.url}")
public interface EmailClient {
   void enviarEmail(@RequestBody TarefasDTOResponse dto) ;
}
