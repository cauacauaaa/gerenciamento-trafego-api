package br.com.fiap.GerenciamentoTrafego;

import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import br.com.fiap.GerenciamentoTrafego.dto.UsuarioCadastroDTO;
import br.com.fiap.GerenciamentoTrafego.dto.UsuarioExibicaoDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import br.com.fiap.GerenciamentoTrafego.controller.UsuarioController;
import br.com.fiap.GerenciamentoTrafego.model.Usuario;
import br.com.fiap.GerenciamentoTrafego.service.UsuarioService;


@WebMvcTest(UsuarioController.class)
public class UsuarioControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UsuarioService service;

    private UsuarioCadastroDTO usuarioDto;

    @BeforeEach
    public void setup() {
        usuarioDto = new UsuarioCadastroDTO("teste", "teste@email", "123teste");
    }

    @DisplayName("test create usuario")
    @Test
     void testGivenNewUsuario_whenCreate_thenSavedUsuario() throws Exception {
        Usuario usuarioSalvo = new Usuario();
        usuarioSalvo.setNome(usuarioDto.nome());

        // Cria o DTO de exibição
        UsuarioExibicaoDTO usuarioExibicaoDTO = new UsuarioExibicaoDTO(usuarioSalvo);

        given(service.salvarUsuario(any(UsuarioCadastroDTO.class)))
                .willReturn(usuarioExibicaoDTO);

        String body = "{\"nome\":\"João\",\"email\":\"joao@email.com\",\"senha\":\"teste123\"}";

        ResultActions response = mockMvc.perform(MockMvcRequestBuilders.post("/api/usuarios")
                .contentType(org.springframework.http.MediaType.APPLICATION_JSON)
                .content(body));


        response.andExpect(status().isCreated());
    }

//    @DisplayName("test fail")
//    @Test
//    void testGivenNewUsuario_whenCreate_thenFail() throws Exception {
//        // Simulando uma falha no serviço ao salvar um usuário
//        // Aqui você pode usar `willThrow` para simular uma exceção se desejar
//        given(service.saveOrUpdate(any(Usuario.class))).willThrow(new RuntimeException("Erro ao salvar"));
//
//        String body = "{\"nome\":\"João\",\"email\":\"joao@example.com\"}";
//
//        // Executando a requisição POST que falhará
//        ResultActions response = mockMvc.perform(MockMvcRequestBuilders.post("/api/usuarios")
//                .contentType(org.springframework.http.MediaType.APPLICATION_JSON)
//                .content(body));
//
//        // Verificando que a resposta tem um status de erro (500 Internal Server Error, por exemplo)
//        response.andExpect(status().isInternalServerError());
//    }
}