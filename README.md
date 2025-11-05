# 📚 Projeto Aluno Online (Classe Aluno + Professor)

Este projeto foi desenvolvido por **Anne Izabelle**, como parte da **Primeira Avaliação da disciplina de Tecnologia para Back-End**.

Foram implementadas APIs REST completas para **Alunos** e **Professores**, permitindo:

- ✅ Criar
- ✅ Listar todos
- ✅ Buscar por ID
- ✅ Atualizar
- ✅ Deletar

Utilizando **Java com Spring Boot**, **PostgreSQL**, **DBeaver** e testes no **Insomnia**.

---

## ⚙️ Tecnologias Utilizadas

- Java 17
- Spring Boot
- Maven
- PostgreSQL
- DBeaver
- Insomnia

---

## 🧠 Endpoints — Alunos

| Método | Rota | Descrição |
|---|---|---|
| `POST` | `/alunos` | Cadastrar aluno |
| `GET` | `/alunos` | Listar todos os alunos |
| `GET` | `/alunos/{id}` | Buscar aluno por ID |
| `PUT` | `/alunos/{id}` | Atualizar aluno |
| `DELETE` | `/alunos/{id}` | Deletar aluno |

### 🧪 Testes no Insomnia — Aluno

#### ✅ Criar aluno — `POST /alunos`
![POST Aluno](./api/src/imagens/insomnia_post.png)

#### ✅ Listar alunos — `GET /alunos`
![GET Alunos](./api/src/imagens/insomnia_get_all.png)

#### ✅ Buscar aluno por ID — `GET /alunos/{id}`
![GET Aluno por ID](./api/src/imagens/insomnia_get_id.png)

#### ✅ Atualizar aluno — `PUT /alunos/{id}`
![PUT Aluno](./api/src/imagens/insomnia_put.png)

#### ✅ Deletar aluno — `DELETE /alunos/{id}`
![DELETE Aluno](./api/src/imagens/insomnia_delete.png)

---

## 👨‍🏫 Endpoints — Professores

| Método | Rota | Descrição |
|---|---|---|
| `POST` | `/professores` | Cadastrar professor |
| `GET` | `/professores` | Listar todos os professores |
| `GET` | `/professores/{id}` | Buscar professor por ID |
| `PUT` | `/professores/{id}` | Atualizar professor |
| `DELETE` | `/professores/{id}` | Deletar professor |

### 🧪 Testes no Insomnia — Professor

#### ✅ Criar professor — `POST /professores`
![POST Professor](./api/src/imagens/insomnia_prof_post.png)

#### ✅ Listar professores — `GET /professores`
![GET Professores](./api/src/imagens/insomnia_prof_get_all.png)

#### ✅ Buscar professor por ID — `GET /professores/{id}`
![GET Professor por ID](./api/src/imagens/insomnia_prof_get_id.png)

#### ✅ Atualizar professor — `PUT /professores/{id}`
![PUT Professor](./api/src/imagens/insomnia_prof_put.png)

#### ✅ Deletar professor — `DELETE /professores/{id}`
![DELETE Professor](./api/src/imagens/insomnia_prof_delete.png)

---

## 🗄 Banco de Dados

Banco gerenciado pelo **DBeaver**, PostgreSQL.

### 📌 TABELA `alunos`

| Campo | Tipo | Descrição |
|---|---|---|
| `id` | serial | ID do aluno |
| `nomeCompleto` | varchar(255) | Nome |
| `email` | varchar(255) | Email |
| `cpf` | varchar(255) | CPF |

### 📌 TABELA `professor`

| Campo | Tipo | Descrição |
|---|---|---|
| `id` | serial | ID do professor |
| `nomeCompleto` | varchar(255) | Nome |
| `email` | varchar(255) | Email |
| `cpf` | varchar(255) | CPF |

### 🖼 Print — DBeaver com tabelas
![DBeaver](./api/src/imagens/tabelaAluno.png)
![DBeaver](./api/src/imagens/tabelaProfessor.png)
---

## 📁 Estrutura do Projeto

```
api
 └── src
     ├── main
     │   ├── java/br/com/alunoonline/api
     │   │   ├── controller
     │   │   ├── model
     │   │   ├── repository
     │   │   └── service
     │   └── resources
     └── imagens  → prints do Insomnia e DBeaver
```

---

## 🚀 Como Executar

```bash
git clone https://github.com/izabellesouza/aluno-online-anneizabelle.git
```

Configurar banco no `application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/aluno_online
spring.datasource.username=postgres
spring.datasource.password=admin
spring.jpa.hibernate.ddl-auto=update
```

Rodar o projeto:

```bash
mvn spring-boot:run
```

Testar no **Insomnia** ✅

---

## 📌 Observações

- ✅ CRUD completo de Aluno e Professor
- ✅ Banco criado e populado
- ✅ Prints anexados
- ✅ Testado no Insomnia
- ✅ Projeto pronto para entrega acadêmica

---

🧡 Desenvolvido por **Anne Izabelle**  
📚 Disciplina: *Tecnologia para Back-End*  
👨‍🏫 Professor: *Kelson Almeida*