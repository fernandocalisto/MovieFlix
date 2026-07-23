# MovieFlix - Projeto Java Spring Boot

Projeto para prática de conhecimentos em **Java**, utilizando o framework **Spring Boot**. O projeto consiste em uma API REST para o cadastro de filmes e dos serviços de streaming que os exibem. O acesso à aplicação é protegido, exigindo que os usuários sejam autenticados utilizando tokens via JWT.

As dependências utilizadas no projeto e suas respectivas funções são:

* **JPA:** Responsável pela persistência de dados, facilitando a comunicação e as operações com o banco de dados.
* **Validation:** Utilizada para validar os dados e as informações recebidas nas requisições da API.
* **Security:** Adiciona camadas de segurança à aplicação, gerenciando a autenticação e as permissões de acesso.
* **Starter Web:** Fornece os recursos fundamentais para a criação da API REST, como o gerenciamento de requisições e respostas HTTP.
* **Flyway:** Ferramenta para o controle de versão do banco de dados, gerenciando a criação e a alteração das tabelas (migrations).
* **PostgreSQL:** O banco de dados relacional escolhido para armazenar as informações do sistema.
* **Lombok:** Biblioteca que ajuda a reduzir o código repetitivo no Java, gerando automaticamente métodos como getters, setters e construtores.
* **JWT (JSON Web Token):** Utilizado para gerar e validar os tokens de segurança que mantêm os usuários autenticados na aplicação.
* **OpenAPI starter webmvc:** Responsável por gerar a documentação interativa da API de forma automática.
