package matheus.cavalari.identificacaoCliente.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
        info = @Info(
                contact = @Contact(
                        name = "Matheus",
                        email = "matheuscav@hotmail.com"
                ),
                description = "O microserviço Identificação Cliente gerencia informações dos clientes, como busca por CPF e listagem de clientes.",
                title = "Identificação Cliente",
                version = "1.0"
        )
)
public class OpenApiConfig {
}
