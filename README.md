# 🎓 Projeto Aluno Online

Este projeto foi desenvolvido por **Anne Izabelle**, como parte da **Primeira Avaliação da disciplina de Tecnologia para Back-End**.

O objetivo foi criar uma **API REST** simples para o gerenciamento de alunos, permitindo **cadastrar, listar todos e buscar por ID**, utilizando **Java com Spring Boot**, integração com banco de dados **PostgreSQL** (acessado via **DBeaver**) e testes realizados no **Insomnia**.

---

## ⚙️ Tecnologias Utilizadas

- **Java 17**
- **Spring Boot**
- **Maven**
- **PostgreSQL**
- **DBeaver**
- **Insomnia**

---

## 🧠 Endpoints da API

| Método | Rota | Descrição |
|:------:|:-----|:----------|
| `POST` | `/alunos` | Cadastra um novo aluno |
| `GET`  | `/alunos` | Retorna todos os alunos cadastrados |
| `GET`  | `/alunos/{id}` | Busca um aluno específico pelo ID |

Esses endpoints foram implementados na classe `AlunoController.java`, com apoio das camadas `Service` e `Repository`.

---

## 💾 Banco de Dados

Banco criado e gerenciado no **DBeaver**, em **PostgreSQL**, com o nome **`aluno_online`**.

**Tabela principal (`alunos`):**

| Campo | Tipo | Descrição |
|:------|:-----|:----------|
| `id`    | `serial`        | Identificador único do aluno |
| `nome`  | `varchar(255)`  | Nome completo do aluno |
| `email` | `varchar(255)`  | E-mail do aluno |
| `curso` | `varchar(255)`  | Curso em que o aluno está matriculado |

**Print da tabela no DBeaver (com dados inseridos):**

![Banco de Dados - DBeaver](./api/src/imagens/dbeaver_tabela.png)

---

## 📬 Testes das Requisições (Insomnia)

### 1) Cadastrar aluno — `POST /alunos`
![POST - Criar aluno](./api/src/imagens/insomnia_post.png)

### 2) Listar todos — `GET /alunos`
![GET - Buscar todos os alunos](./api/src/imagens/insomnia_get_all.png)

### 3) Buscar por ID — `GET /alunos/{id}`
![GET - Buscar aluno por ID](./api/src/imagens/insomnia_get_id.png)

---

## 📁 Estrutura do Projeto

Estrutura principal do código-fonte:

```
📦 api
 ┣ 📂 src
 ┃ ┣ 📂 main
 ┃ ┃ ┣ 📂 java/br/com/alunoonline/api
 ┃ ┃ ┃ ┣ 📂 controller → AlunoController.java
 ┃ ┃ ┃ ┣ 📂 model → Aluno.java
 ┃ ┃ ┃ ┣ 📂 repository → AlunoRepository.java
 ┃ ┃ ┃ ┗ 📂 service → AlunoService.java
 ┃ ┃ ┗ 📂 resources → application.properties
 ┃ ┣ 📂 imagens → prints do DBeaver e Insomnia
 ┗ 📄 pom.xml
```

---

## 🚀 Como Executar o Projeto

1. Clone este repositório:
```
git clone https://github.com/izabellesouza/aluno-online-anneizabelle.git
```

2. Abra o projeto no **IntelliJ IDEA**.

3. Configure o PostgreSQL conforme `application.properties`:
```
spring.datasource.url=jdbc:postgresql://localhost:5432/aluno_online
spring.datasource.username=postgres
spring.datasource.password=admin
spring.jpa.hibernate.ddl-auto=update
```

4. Execute o projeto:
```
mvn spring-boot:run
```

5. Teste as rotas no **Insomnia**.

---

## 🧾 Observações

- O repositório contém as rotas `POST`, `GET` e `GET por ID`;
- O banco foi criado e populado; os prints estão neste README;
- As requisições foram testadas e documentadas;
- Projeto pronto para a **entrevista técnica (14/10)**.

---

🧡 Desenvolvido por **Anne Izabelle**  
📚 Disciplina: *Tecnologia para Back-End*  
👨‍🏫 Professor: *Kelson Almeida*.