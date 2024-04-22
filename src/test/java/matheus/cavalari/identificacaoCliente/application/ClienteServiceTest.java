package matheus.cavalari.identificacaoCliente.application;


import matheus.cavalari.identificacaoCliente.adapter.out.ClienteRepository;
import matheus.cavalari.identificacaoCliente.application.exception.ClienteNaoEncontradoException;
import matheus.cavalari.identificacaoCliente.domain.Cliente;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ClienteServiceTest {

    private ClienteService clienteService;
    private ClienteRepository clienteRepository;

    @BeforeEach
    public void setUp() {
        clienteRepository = mock(ClienteRepository.class);
        clienteService = new ClienteService(clienteRepository);
    }

    @Test
    public void testVerificarCPF() {
        assertTrue(clienteService.verificarCPF("111.111.111-11"));
    }

    @Test
    public void testBuscarClienteExistente() {
        Cliente cliente = new Cliente();
        cliente.setCpf("111.111.111-11");
        cliente.setNome("Michel Jordan");
        when(clienteRepository.findByCpf("111.111.111-11")).thenReturn(cliente);

        Cliente clienteEncontrado = clienteService.getClienteByCpf("111.111.111-11");
        assertNotNull(clienteEncontrado);
        assertEquals("Michel Jordan", clienteEncontrado.getNome());
    }

    @Test
    public void testBuscarClienteNaoExistente() {
        when(clienteRepository.findByCpf("999.999.999-99")).thenReturn(null);

        assertThrows(ClienteNaoEncontradoException.class, () -> clienteService.getClienteByCpf("999.999.999-99"));
    }

}