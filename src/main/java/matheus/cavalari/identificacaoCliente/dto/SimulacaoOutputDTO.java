package matheus.cavalari.identificacaoCliente.dto;

import lombok.Data;
import matheus.cavalari.identificacaoCliente.enums.Convenio;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class SimulacaoOutputDTO {
    private Long id;
    private LocalDate dataSimulacao;
    private String cpfCliente;
    private Convenio convenioCliente;
    private BigDecimal valorSolicitado;
    private BigDecimal taxaAplicada;
    private int quantidadeParcelas;
    private BigDecimal valorTotal;
    private BigDecimal valorParcela;
}

