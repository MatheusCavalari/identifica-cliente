package matheus.cavalari.identificacaoCliente.application;

import matheus.cavalari.identificacaoCliente.domain.Cliente;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IClienteService {
    boolean verificarCPF(String cpf);
    Cliente buscarCliente(String cpf);
    Cliente getClienteByCpf(String cpf);
    List<Cliente> listarClientes();
}
