package br.com.brunoedubems.bffagendador_tarefas.business;

import br.com.brunoedubems.bffagendador_tarefas.business.dto.in.EnderecoDTORequest;
import br.com.brunoedubems.bffagendador_tarefas.business.dto.in.TelefoneDTORequest;
import br.com.brunoedubems.bffagendador_tarefas.business.dto.in.UsuarioDTORequest;
import br.com.brunoedubems.bffagendador_tarefas.infrastructure.client.UsuarioClient;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private final UsuarioClient usuarioClient;

    public UsuarioService(UsuarioClient usuarioClient) {
        this.usuarioClient = usuarioClient;
    }

    public UsuarioDTORequest salvaUsuario(UsuarioDTORequest usuarioDTORequest) {

        return usuarioClient.salvaUsuario(usuarioDTORequest);
    }

    public String loginUsuario(UsuarioDTORequest usuarioDTORequest) {
        return usuarioClient.login(usuarioDTORequest);
    }

    public UsuarioDTORequest buscarUsuarioPorEmail(String email, String token) {
        return usuarioClient.buscaUsuarioPorEmail(email, token);
    }

    public void deletaUsuarioPorEmail(String email, String token) {
        usuarioClient.deletaUsuarioPorEmail(email, token);
    }

    public UsuarioDTORequest atualizaDadosUsuario(UsuarioDTORequest usuarioDTORequest, String token) {
        return usuarioClient.atualizaDadosUsuario(usuarioDTORequest, token);
    }

    public EnderecoDTORequest atualizaEndereco(Long idEndereco, EnderecoDTORequest enderecoDTORequest, String token) {
       return  usuarioClient.atualizarEndereco(idEndereco, enderecoDTORequest, token);
    }

    public TelefoneDTORequest atualizaTelefone(Long idTelefone, TelefoneDTORequest telefoneDTORequest, String token) {
        return usuarioClient.atualizarTelefone(idTelefone, telefoneDTORequest, token);
    }

}
