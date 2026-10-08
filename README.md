# :soccer: API de Reservas de Quadras Esportivas (`api-reservas`)

Uma API RESTful desenvolvida em **Java 17** e **Spring Boot 3** para gestão e agendamento de reservas de quadras desportivas. O projeto foi construído com foco em boas práticas de arquitetura de software, separação clara de responsabilidades por camadas e um tratamento robusto e polimórfico de exceções HTTP.

---

## 🚀 Tecnologias Utilizadas

- **Linguagem:** Java 17+
- **Framework Principal:** Spring Boot 3
- **Persistência de Dados:** Spring Data JPA / Hibernate
- **Banco de Dados:** PostgreSQL
- **Validação de Dados:** Jakarta Validation (`@Valid`, `@NotNull`, `@FutureOrPresent`)
- **Produtividade:** Lombok & Java Records (DTOs)
- **Gestão de Dependências:** Maven

---

## 🏗️ Arquitetura do Sistema

O projeto segue a arquitetura em camadas padrão do Spring Boot (**Controller-Service-Repository-Entity**), garantindo um fluxo de dados previsível, testável e de fácil manutenção:

```text
[ Cliente HTTP ]
       │
       ▼
[ ReservaController ]  ──────► Transfere DTOs (ReservaRequest / ReservaResponse) e valida contratos HTTP
       │
       ▼
[ ReservaService ]     ──────► Processa regras de negócio (ex: verificação de horário duplicado)
       │
       ▼
[ ReservaRepository ]  ──────► Comunica com o banco de dados via Spring Data JPA
       │
       ▼
[ PostgreSQL ]         ──────► Tabela: reserva_da_quadra
```

# Respostas HTTP Padronizadas

##  Código Status HTTP        |         Cenário de Ocorrência                      |                Descrição / Solução
_________________________________________________________________________________________________________________________________________________________________________________
201 Created                 |      Criação de reserva com sucesso                |            Retorna o JSON da reserva criada com o ID gerado.
_________________________________________________________________________________________________________________________________________________________________________________
200 OK                      |      Consulta de reserva por ID com sucesso        |            Retorna os detalhes da reserva localizada.
_________________________________________________________________________________________________________________________________________________________________________________
400 Bad Request             |      Dados inválidos ou choque de horário          |            Disparado por falhas no @Valid ou por DiaOuHoraIndisponivelException.
_________________________________________________________________________________________________________________________________________________________________________________
404 Not Found               |      Recurso não localizado                        |            Disparado pela ReservaNaoEncontradaException.
_________________________________________________________________________________________________________________________________________________________________________________
500 Internal Server Error   |      Falha inesperada no servidor/banco            |            Capturado genericamente para oculta a stack trace do utilizador.
_________________________________________________________________________________________________________________________________________________________________________________


# Endpoints da API
1. Criar uma Reserva
URL: POST /reservas

Status de Sucesso: 201 Created

Exemplo de Requisição (JSON Payload):
```
{
  "quadraId": 1,
  "dataReserva": "2026-10-15",
  "horaReserva": "18:00:00"
}

```
## Exemplo de Resposta de Sucesso:


```
JSON

{
  "id": 1,
  "quadraId": 1,
  "dataReserva": "2026-10-15",
  "horaReserva": "18:00:00"
}

```
## Exemplo de Resposta de Erro (400 Bad Request - Horário Ocupado):
```
{
  "mensagem": "A quadra 1 já está reservada neste dia e horário."
}
```
2. Buscar Reserva por ID
URL: GET /reservas/{id}

Status de Sucesso: 200 OK

Exemplo de Resposta de Sucesso (GET /reservas/1):

```
{
  "id": 1,
  "quadraId": 1,
  "dataReserva": "2026-10-15",
  "horaReserva": "18:00:00"
}
```
## Exemplo de Resposta de Erro (404 Not Found - ID Inexistente):
```

{
  "mensagem": "Reserva não encontrada: 999"
}
```


# ⚙️ Como Executar o Projeto Localmente

## Pré-requisitos

🔹Java 17 ou superior instalado
🔹 PostgreSQL em execução
🔹 Maven instalado

# Passos para Configuração

Clonar o repositório:
```
Bash


git clone [https://github.com/SEU_USUARIO/api-reservas.git](https://github.com/SEU_USUARIO/api-reservas.git)
cd api-reservas
Configurar o banco de dados PostgreSQL:
Crie uma base de dados no PostgreSQL (ex: postgres) e ajuste o ficheiro src/main/resources/application.properties com as tuas credenciais:
```
Properties

```
spring.datasource.url=jdbc:postgresql://localhost:5432/postgres
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
Executar a aplicação:
```
```
Bash


./mvnw spring-boot:run
```

A aplicação estará disponível em http://localhost:8080.

# ✒️ Autor

Desenvolvido por Giacomo Accardi Neto.<div align="left">
  <a href="https://www.linkedin.com/in/giacomo-accardi-neto" target="_blank">
    <img src="https://img.shields.io/static/v1?message=LinkedIn&logo=linkedin&label=&color=0077B5&logoColor=white&labelColor=&style=for-the-badge" height="35" alt="linkedin logo"  />
  </a>
</div>



###

<div align="left">
  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/java/java-original.svg" height="30" alt="java logo"  />
  <img width="12" />
  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/spring/spring-original.svg" height="30" alt="spring logo"  />
  <img width="12" />
  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/postgresql/postgresql-original.svg" height="30" alt="postgresql logo"  />
  <img width="12" />
  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/intellij/intellij-original.svg" height="30" alt="intellij logo"  />
</div>

###
