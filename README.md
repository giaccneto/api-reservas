# ⚽ API de Reservas de Quadras Esportivas (`api-reservas`)

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























