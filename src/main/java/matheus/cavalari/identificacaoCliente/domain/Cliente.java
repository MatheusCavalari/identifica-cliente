package matheus.cavalari.identificacaoCliente.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import matheus.cavalari.identificacaoCliente.enums.Convenio;
import matheus.cavalari.identificacaoCliente.enums.SegmentoCliente;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cpf", unique = true)
    private String cpf;

    @Column(name = "nome")
    private String nome;

    @Column(name = "correntista")
    private boolean correntista;

    @Enumerated(EnumType.STRING)
    @Column(name = "segmento")
    private SegmentoCliente segmento;

    @Enumerated(EnumType.STRING)
    @Column(name = "convenio")
    private Convenio convenio;
}