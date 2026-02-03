# Projeto Integrador - SENAI

Sistema de gerenciamento de produtos desenvolvido com Spring Boot e MySQL.

## Tecnologias Utilizadas

- Java 17
- Spring Boot 3.2
- Spring Data JPA
- Thymeleaf
- MySQL
- Bootstrap 5

## Configuração do Banco de Dados

1. Instale o MySQL (XAMPP, WAMP ou instalação direta)
2. Crie o banco de dados (ou deixe o Spring criar automaticamente):

```sql
CREATE DATABASE databasepi;
```

3. Configure as credenciais em `src/main/resources/application.properties`:

```properties
spring.datasource.username=root
spring.datasource.password=sua_senha_aqui
```

## Como Executar

1. Clone o repositório
2. Certifique-se que o MySQL está rodando
3. Execute o projeto:

```bash
mvn spring-boot:run
```

4. Acesse no navegador: http://localhost:8080

## Funcionalidades

- ✅ Cadastrar produtos
- ✅ Listar todos os produtos
- ✅ Editar produtos
- ✅ Excluir produtos
- ✅ Pesquisar produtos por nome

## Estrutura do Projeto (MVC)

```
src/main/java/com/senai/projetointegrador/
├── ProjetoIntegradorApplication.java  (Main)
├── controller/
│   ├── HomeController.java
│   └── ProdutoController.java
├── model/
│   └── Produto.java
├── repository/
│   └── ProdutoRepository.java
└── service/
    └── ProdutoService.java

src/main/resources/
├── application.properties
└── templates/produtos/
    ├── lista.html
    └── form.html
```

## Autor

Projeto desenvolvido para o Curso Técnico - SENAI
