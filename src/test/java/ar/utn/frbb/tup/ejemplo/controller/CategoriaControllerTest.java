package ar.utn.frbb.tup.ejemplo.controller;

import ar.utn.frbb.tup.ejemplo.model.Categoria;
import ar.utn.frbb.tup.ejemplo.service.CategoriaService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
public class CategoriaControllerTest {

    @InjectMocks
    CategoriaController categoriaController;

    @Mock
    CategoriaService categoriaService;

    MockMvc mockMvc;

    private static ObjectMapper mapper = new ObjectMapper();

    @BeforeEach
    public void setup(){
        this.mockMvc = MockMvcBuilders.standaloneSetup(categoriaController).build();
    }

    @Test
    public void testCrearCategoria() throws Exception {
        Categoria categoria = new Categoria(1, "cate", "Una Categoria");
        when(categoriaService.crearCategoria(any(CategoriaDto.class))).thenReturn(categoria);
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/categoria")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"nombre\": \"cate\", \"descripcion\": \"Una Categoria\"}")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful())
                .andReturn();

        assertEquals(categoria, mapper.readValue(result.getResponse().getContentAsString(), Categoria.class));
    }

}