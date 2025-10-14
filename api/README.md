# 🎓 Projeto Aluno Online

Este projeto foi desenvolvido por Anne Izabelle, como parte da **Primeira Avaliação da disciplina de Tecnologia para Back-End**, com o objetivo de criar uma API simples para cadastro e consulta de alunos.

A aplicação foi feita em **Java com Spring Boot**, utilizando o **DBeaver** como banco de dados e o **Insomnia** para testar as requisições.

---

## 🚀 Tecnologias Utilizadas
- Java 17
- Spring Boot
- DBeaver
- Insomnia
- Maven

---

## 🗂️ Banco de Dados
O banco de dados utilizado foi nomeado como **`aluno_online`**, contendo a tabela **`aluno`**.



---

## 📡 Endpoints da API

| Método | Endpoint | Descrição |
|--------|-----------|-----------|
| **POST** | `http://localhost:8080/alunos` | Cria um novo aluno |
| **GET** | `http://localhost:8080/alunos` | Retorna todos os alunos |
| **GET** | `http://localhost:8080/alunos/{id}` | Busca um aluno específico pelo ID |

---

## 🧰 Exemplo de Requisições (Insomnia)

### ➕ Criar Aluno (POST)
**URL:** `http://localhost:8080/alunos`  
**Body (JSON):**
```json
{
  "nomeCompleto": "Izabelle",
  "email": "izabellesouzaa@gmail.com",
  "cpf": "123.123.123-12"
}
