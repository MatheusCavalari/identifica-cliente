package matheus.cavalari.identificacaoCliente.application;

import matheus.cavalari.identificacaoCliente.adapter.out.ClienteRepository;
import matheus.cavalari.identificacaoCliente.application.exception.ClienteNaoEncontradoException;
import matheus.cavalari.identificacaoCliente.domain.Cliente;
import matheus.cavalari.identificacaoCliente.enums.Convenio;
import matheus.cavalari.identificacaoCliente.enums.SegmentoCliente;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ClienteService implements IClienteService {

    private Map<String, Cliente> clientes;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clientes = new HashMap<>();
        List<Cliente> clienteList = clienteRepository.findAll();
        for (Cliente cliente : clienteList) {
            clientes.put(cliente.getCpf(), cliente);
        }
        // Adicionar clientes de exemplo
        clientes.put("111.111.111-11", Cliente.builder()
                .id(1L)
                .cpf("111.111.111-11")
                .nome("Michel Jordan")
                .correntista(true)
                .segmento(SegmentoCliente.VAREJO)
                .convenio(Convenio.EMPRESA_PRIVADA)
                .build());
        clientes.put("222.222.222-22", Cliente.builder()
                .id(2L)
                .cpf("222.222.222-22")
                .nome("Lebron James")
                .correntista(true)
                .segmento(SegmentoCliente.UNICLASS)
                .convenio(Convenio.ORGAO_PUBLICO)
                .build());
        clientes.put("333.333.333-33", Cliente.builder()
                .id(3L)
                .cpf("333.333.333-33")
                .nome("Maradonna")
                .correntista(true)
                .segmento(SegmentoCliente.PERSON)
                .convenio(Convenio.INSS)
                .build());
        clientes.put("444.444.444-44", Cliente.builder()
                .id(4L)
                .cpf("444.444.444-44")
                .nome("Marta Vieira da Silva")
                .correntista(false)
                .convenio(Convenio.EMPRESA_PRIVADA)
                .build());
        clientes.put("555.555.555-55", Cliente.builder()
                .id(5L)
                .cpf("555.555.555-55")
                .nome("Messi")
                .correntista(false)
                .convenio(Convenio.INSS)
                .build());
        clientes.put("666.666.666-66", Cliente.builder()
                .id(6L)
                .cpf("666.666.666-66")
                .nome("Cassio Ramos")
                .correntista(true)
                .segmento(SegmentoCliente.PERSON)
                .convenio(Convenio.INSS)
                .build());

    }

    @Override
    public boolean verificarCPF(String cpf) {
        return cpf.matches("\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}");
    }

    @Override
    public Cliente buscarCliente(String cpf) {
        return clientes.get(cpf);
    }

    @Override
    public Cliente  getClienteByCpf(String cpf) {
        if (!verificarCPF(cpf)) {
            throw new IllegalArgumentException("O formato válido é  DDD.DDD.DDD-DD");
        }
        Cliente cliente = buscarCliente(cpf);
        if (cliente == null) {
            throw new ClienteNaoEncontradoException("Cliente não encontrado para o CPF informado");
        }

        return cliente;
    }

    @Override
    public List<Cliente> listarClientes() {
        List<Cliente> clientesOrdenados = new ArrayList<>(clientes.values());
        clientesOrdenados.sort(Comparator.comparing(Cliente::getId));
        return clientesOrdenados;
    }
}
