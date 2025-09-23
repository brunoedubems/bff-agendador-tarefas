package br.com.brunoedubems.bffagendador_tarefas.infrastructure.client;

import br.com.brunoedubems.bffagendador_tarefas.business.dto.in.EnderecoDTORequest;
import br.com.brunoedubems.bffagendador_tarefas.business.dto.in.TelefoneDTORequest;
import br.com.brunoedubems.bffagendador_tarefas.business.dto.in.UsuarioDTORequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "usuario", url = "${usuario.url}")
public interface UsuarioClient {

    @GetMapping("/usuario")
    UsuarioDTORequest buscaUsuarioPorEmail(@RequestParam("email") String email,
                                           @RequestHeader("Authorization") String token);

    @PostMapping
    UsuarioDTORequest salvaUsuario(@RequestBody UsuarioDTORequest usuarioDTORequest);

    @PostMapping("/login")
    String login(@RequestBody UsuarioDTORequest usuarioDTORequest);

    @DeleteMapping("/{email}")
    void deletaUsuarioPorEmail(@PathVariable String email,
                               @RequestHeader("Authorization") String token);

    @PutMapping
    UsuarioDTORequest atualizaDadosUsuario(@RequestBody UsuarioDTORequest usuarioDTORequest,
                                           @RequestHeader("Authorization") String token);

    @PutMapping("/endereco")
    EnderecoDTORequest atualizarEndereco(@RequestParam("id") Long id, @RequestBody EnderecoDTORequest dto,
                                         @RequestHeader("Authorization") String token);


    @PutMapping("/telefone")
    TelefoneDTORequest atualizarTelefone(@RequestParam("id") Long id, @RequestBody TelefoneDTORequest dto,
                                         @RequestHeader("Authorization") String token);

}
