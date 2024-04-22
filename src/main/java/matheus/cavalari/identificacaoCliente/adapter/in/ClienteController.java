package matheus.cavalari.identificacaoCliente.adapter.in;

import matheus.cavalari.identificacaoCliente.application.IClienteService;
import matheus.cavalari.identificacaoCliente.application.exception.ClienteNaoEncontradoException;
import matheus.cavalari.identificacaoCliente.domain.Cliente;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/cliente")
public class ClienteController {

    private static final Logger logger = LoggerFactory.getLogger(ClienteController.class);
    private final IClienteService clienteService;

    @Autowired
    public ClienteController(IClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping("/cpf/{cpf}")
    public ResponseEntity<?> getClienteByCpf(@PathVariable String cpf) {
        try {
            Cliente cliente = clienteService.getClienteByCpf(cpf);
            if (cliente != null) {
                return ResponseEntity.ok(cliente);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado para o CPF informado");
            }
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("CPF inválido: " + e.getMessage());
        } catch (ClienteNaoEncontradoException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado para o CPF informado");
        } catch (Exception e) {
            logger.error("Erro ao obter o cliente pelo CPF", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao obter o cliente pelo CPF");
        }
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> listarClientes() {
        List<Cliente> clientes = clienteService.listarClientes();
        if (clientes.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(clientes);
    }
}