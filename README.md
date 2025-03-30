# Gestão de Pessoas API

Este é um projeto de API para gestão de pessoas, onde é possível criar, listar, atualizar e excluir informações de pessoas. A aplicação foi construída com **Spring Boot** para o back-end e **Angular** para o front-end.

## Tecnologias Utilizadas

### Back-End

- **Spring Boot**: Framework Java para construção de APIs.
- **Spring Data JPA**: Para manipulação de dados no banco de dados.
- **H2 Database** (ou outro banco de dados relacional): Banco de dados em memória utilizado no exemplo (você pode configurar outro, como MySQL).
- **Swagger**: Para documentação da API.
- **Java 17 ou superior**: Para rodar o back-end.

### Front-End

- **Angular**: Framework JavaScript para construção da interface de usuário.
- **HttpClientModule**: Para comunicação com a API back-end.
- **TypeScript**: Linguagem usada no Angular.
- **HTML e CSS**: Para estruturação e estilização do layout da página.

## Funcionalidades

A API permite a execução das seguintes operações:

1. **Criar Pessoa**: Criação de novas pessoas no sistema com os dados nome, CPF e email.
2. **Listar Pessoas**: Exibição de todas as pessoas cadastradas no banco de dados.
3. **Buscar Pessoa por CPF**: Consultar informações de uma pessoa específica pelo seu CPF.
4. **Atualizar Pessoa**: Atualizar dados de uma pessoa existente no sistema (nome, CPF, email).
5. **Deletar Pessoa**: Remover uma pessoa do banco de dados pelo ID.

## Como Rodar o Projeto

### Back-End (API)

1. **Instale o Java 17 ou superior**:

   - Foi utilizado o JDK 21**
   - Você pode fazer o download do Java [aqui](https://adoptopenjdk.net/).
   
2. **Clone este repositório**:
   ```bash
   git clone https://github.com/DennisROliveira/gestao-pessoas-api.git


========================================================================================================================
Para abrir o projeto
Navegue até a pasta do back-end:
  - cd gestao-pessoas-api
Compile o projeto:
  - Se você tiver o Maven instalado, use o comando:
  -mvn clean install
Utilize o comando para rodar o Spring Boot:
  -mvn spring-boot:run


**URL API E DOCUMENTAÇÃO**:
  - URL API: http://localhost:8080
  - SWAGGER: http://localhost:8080/swagger-ui.html
========================================================================================================================
Front-End (Angular)
Instale o Node.js:
Navegue até a pasta do front-end:
  - Você pode fazer o download do Node.js [aqui](https://nodejs.org/pt).
No CMD Instale as dependências do Angular:
  -npm install
Para rodar o front-end, use o comando:
  -ng serve

========================================================================================================================
BANCO - dump-gestao_pessoas-202503301353
db: gestao_pessoas
user/pass: postgres
