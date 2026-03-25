<h1 align="center">
  🏫 Salas API
</h1>

Este projeto é uma **API REST** para gerenciamento e reserva de salas, desenvolvida com o objetivo de aprimorar conhecimentos no ecossistema **Java e Spring Boot.**

<h1 align="center">
  🚀 Sobre o Projeto
</h1>

A API permite o cadastro de usuários, salas e a realização de agendamentos.

<h1 align="center">
  🔐 Segurança
</h1>

A API utiliza **JSON Web Token (JWT)** para autenticação e autorização:
- **Stateless:** A sessão não é armazenada no servidor.
- **Roles:** Controle de acesso baseado em perfis (ex: `GESTOR` para operações administrativas).
- **Proteção:** Endpoints sensíveis exigem o envio do token no cabeçalho `Authorization`.

<h1 align="center">
  📖 Documentação
</h1>

A documentação interativa da API foi implementada com **SpringDoc OpenAPI**. Por ela, é possível testar todos os endpoints, inclusive os que exigem autenticação via o botão "Authorize".

<p align="center">
  <img width="1117" alt="Interface do Swagger" src="https://github.com/user-attachments/assets/ad74f182-1914-4c31-b7e4-a3b75b54447d" />
</p>

<h1 align="center">
  🛠️ Tecnologias Utilizadas
</h1>

- **Linguagem:** Java 21
- **Framework:** Spring Boot 4
- **Segurança:** Spring Security + Auth0 Java JWT
- **Banco de Dados:** H2 (Em memória)
- **Documentação:** SpringDoc OpenAPI
