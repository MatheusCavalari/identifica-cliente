package matheus.cavalari.identificacaoCliente.adapter.out;

import matheus.cavalari.identificacaoCliente.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Optional<Cliente> findById(Long id);
    Cliente findByCpf(String cpf);
}


