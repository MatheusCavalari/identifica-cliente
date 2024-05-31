package matheus.cavalari.clienteApi.adapter.in;

import matheus.cavalari.clienteApi.application.IClienteService;
import matheus.cavalari.clienteApi.application.exception.ClienteNaoEncontradoException;
import matheus.cavalari.clienteApi.domain.Cliente;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public ResponseEntity<?> criarCliente(@RequestBody Cliente clienteDto) {
        try {
            Cliente cliente = clienteService.armazenarCliente(clienteDto);
            return ResponseEntity.status(HttpStatus.CREATED).body(cliente);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao salvar o cliente");
        }
    }

}
