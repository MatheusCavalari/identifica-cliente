## Identificação Cliente

O microserviço Identificação Cliente é responsável por gerenciar e armazenar informações dos clientes, garantindo a integridade e disponibilidade dos dados.

### Como Utilizar

1. **Clonar o Repositório**:
   ```sh
   git clone https://github.com/MatheusCavalari/identifica-cliente.git

2. **Executar a Aplicação:**:
- **Porta do Servidor: 8080**
- **Banco de Dados: H2 em memória**
   ```sh
    mvn spring-boot:run

### Endpoints

1. **Criar Cliente**: Endpoint para criar um novo cliente.
- **URL**: `/v1/cliente`
- **Método**: `POST`
- **Corpo da Requisição**:
  ```json
  {
  "nome": "Nome do Cliente",
  "cpf": "111.111.111-11",
  "dataNascimento": "yyyy-MM-dd"
  }
  ```
- **Resposta de Sucesso**:
    - Código: `201 CREATED`
    - Corpo: Cliente  criado

2. **Listar Clientes**: Endpoint para listar todos os clientes.
- **URL**: `/v1/cliente`
- **Método**: `GET`
- **Resposta de Sucesso**:
    - Código: `200 OK`
    - Corpo: Lista de clientes

3. **Buscar Cliente  por ID**: Endpoint para buscar um cliente pelo ID.
- **URL**: `/v1/cliente/{id}`
- **Método**: `GET`
- **Parâmetros de URL**: `{id}` - ID do cliente a ser buscado
- **Resposta de Sucesso**:
    - Código: `200 OK`
    - Corpo: Cliente encontrado

### Dependências

- Spring Boot Web
- Spring Boot DevTools
- Spring Boot Starter Test
- Spring Boot Starter Data JPA
- H2 Database
- Lombok
- Springdoc OpenAPI
- JUnit

### Arquitetura Hexagonal

O microserviço Identificação Cliente segue a arquitetura hexagonal (ou ports and adapters), que separa a lógica de negócios da implementação técnica. Nessa arquitetura, as camadas são organizadas da seguinte forma:
- **Domínio**: Contém as entidades de negócio, os serviços e as interfaces que definem as operações do domínio.
- **Aplicação**: Implementa a lógica de negócios usando os serviços do domínio.
- **Adaptadores**: São responsáveis por conectar o domínio à infraestrutura externa, como bancos de dados e serviços externos.

### Versão do Java

O microserviço foi desenvolvido utilizando Java 17, aproveitando as últimas funcionalidades e melhorias da linguagem.

Framework para desenvolvimento: Spring Boot 3.0.12.

### Gerenciamento de Dependências

O Maven foi utilizado como gerenciador de dependências e para realizar o build da aplicação. Ele simplifica o processo de compilação e gerenciamento de dependências, facilitando o desenvolvimento e a manutenção do projeto.

## Autor

Matheus Cavalari Barbosa
