package br.com.brunoedubems.bffagendador_tarefas.controller;


import br.com.brunoedubems.bffagendador_tarefas.business.TarefasService;
import br.com.brunoedubems.bffagendador_tarefas.business.dto.in.TarefasDTORequest;
import br.com.brunoedubems.bffagendador_tarefas.business.dto.out.TarefasDTOResponse;
import br.com.brunoedubems.bffagendador_tarefas.infrastructure.enums.StatusNotificacaoEnum;
import br.com.brunoedubems.bffagendador_tarefas.infrastructure.security.SecurityConfig;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/tarefas")
@RequiredArgsConstructor
@Tag(name = "tarefas", description = "Cadastra tarefas usuarios")
@SecurityRequirement(name = SecurityConfig.SECURITY_SCHEME)
public class TarefasController {

    private final TarefasService tarefasService;

    @PostMapping
    @Operation(summary = "Salva tarefas", description = "Cria uma nova tarefas")
    @ApiResponse(responseCode = "200", description = "Tarefa salva com sucesso")
    @ApiResponse(responseCode = "500", description = "Erro do servidor")
    public ResponseEntity<TarefasDTOResponse> gravarTarefas(@RequestHeader(value = "Authorization", required = false) String token,
                                                            @RequestBody TarefasDTORequest dto) {
        return ResponseEntity.ok(tarefasService.gravarTarefa(token, dto));
    }


    @GetMapping("/eventos")
    @Operation(summary = "busca tarefas por período", description = "busca tarefas cadastradas por período")
    @ApiResponse(responseCode = "200", description = "Tarefa encontradas")
    @ApiResponse(responseCode = "500", description = "Erro do servidor")
    public ResponseEntity<List<TarefasDTOResponse>> buscaListaDeTarefasPorPeriodo(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataInicial,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataFinal,
             @RequestHeader(value = "Authorization", required = false) String token) {

        return ResponseEntity.ok(tarefasService.buscaTarefasAgendadasPorPeriodo(dataInicial, dataFinal, token));
    }

    @GetMapping()
    @Operation(summary = "busca lista de tarefas por email de usuário", description = "busca lista de tarefas cadastradas por usuários")
    @ApiResponse(responseCode = "200", description = "Tarefas encontradas")
    @ApiResponse(responseCode = "500", description = "Erro do servidor")
    public ResponseEntity<List<TarefasDTOResponse>> buscaTarefasPorEmail(
             @RequestHeader(value = "Authorization", required = false) String token) {

        return ResponseEntity.ok(tarefasService.buscaTarefasPorEmail(token));
    }

    @DeleteMapping
    @Operation(summary = "deleta tarefas por id", description = "deleta tarefas cadastradas por id")
    @ApiResponse(responseCode = "200", description = "Tarefas encontradas")
    @ApiResponse(responseCode = "500", description = "Erro do servidor")
    public ResponseEntity<Void> deletaTarefaPorId(String id,
                                                   @RequestHeader(value = "Authorization", required = false) String token) {

        tarefasService.deletaTarefaPorId(id, token);
        return ResponseEntity.ok().build();
    }

    @PatchMapping
    @Operation(summary = "Altera status de tarefas", description = "Altera status de tarefas das tarefas cadastradas")
    @ApiResponse(responseCode = "200", description = "status da tarefa alterado")
    @ApiResponse(responseCode = "500", description = "Erro do servidor")
    public ResponseEntity<TarefasDTOResponse> alteraStatusNotificacao(@RequestParam("status") StatusNotificacaoEnum status,
                                                                      @RequestParam("id") String id,
                                                                      @RequestHeader(value = "Authorization", required = false) String token) {
        return ResponseEntity.ok(tarefasService.alteraStatus(status, id, token));
    }

    @PutMapping
    @Operation(summary = "Altera dados de tarefas", description = "Altera dados de tarefas das tarefas cadastradas")
    @ApiResponse(responseCode = "200", description = "Tarefas alteradas")
    @ApiResponse(responseCode = "500", description = "Erro do servidor")
    public ResponseEntity<TarefasDTOResponse> updateTarefas(@RequestBody TarefasDTORequest dto,
                                                            @RequestParam("id") String id,
                                                            @RequestHeader(value = "Authorization", required = false) String token) {
        return ResponseEntity.ok(tarefasService.updateDeTarefas(dto, id, token));
    }
}
