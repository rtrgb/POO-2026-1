# Documentação da API - Sistema de Academia

**Trabalho M3 - Implementação de API REST com Quarkus e PostgreSQL**
**Aluno:** Gabriel Buzzi
**Entidade:** Plano

## Visão geral

API REST desenvolvida em Java com Quarkus, com persistência em PostgreSQL, para gerenciar os planos de uma academia. A aplicação segue arquitetura em camadas (Model, Service, Resource), com uso de DTOs para entrada e saída de dados.

**URL base:** `http://localhost:8080`

## Endpoints implementados

| Método HTTP | Endpoint | Descrição |
|---|---|---|
| GET | `/planos` | Lista todos os planos cadastrados |
| GET | `/planos/{id}` | Busca um plano específico pelo id |
| POST | `/planos` | Cria um novo plano |
| PUT | `/planos/{id}` | Atualiza um plano existente (todos os campos) |
| DELETE | `/planos/{id}` | Remove um plano pelo id |

> O método PUT realiza atualização completa do recurso — todos os campos devem ser enviados na requisição, mesmo que apenas um precise ser alterado. Não foi implementado o método PATCH (atualização parcial).

---

## 1. GET /planos — Listar todos os planos

Retorna a lista completa de planos cadastrados.

**Requisição**

```
GET /planos
```

**Resposta — 200 OK**

```json
[
  {
    "id": 3,
    "nome": "Plano Mensal",
    "descricao": "Acesso completo a academia por 1 mes.",
    "valor": 159.99,
    "duracao": 1
  },
  {
    "id": 4,
    "nome": "Plano Trimestral",
    "descricao": "Acesso completo a academia por 3 meses.",
    "valor": 399.99,
    "duracao": 3
  }
]
```

---

## 2. GET /planos/{id} — Buscar plano por id

Retorna os dados de um único plano.

**Requisição**

```
GET /planos/3
```

**Resposta — 200 OK**

```json
{
  "id": 3,
  "nome": "Plano Mensal",
  "descricao": "Acesso completo a academia por 1 mes.",
  "valor": 159.99,
  "duracao": 1
}
```

**Resposta — 404 Not Found**

Retornada quando não existe nenhum plano com o id informado. Corpo da resposta vazio.

---

## 3. POST /planos — Criar plano

Cria um novo plano. O campo `id` não é enviado pelo cliente — ele é gerado automaticamente pelo banco de dados.

**Requisição**

```
POST /planos
Content-Type: application/json
```

```json
{
  "nome": "Teste Trabalho m3",
  "descricao": "Ola seres humanos",
  "valor": 99.90,
  "duracao": 1
}
```

**Resposta — 201 Created**

```json
{
  "id": 2,
  "nome": "Teste Trabalho m3",
  "descricao": "Ola seres humanos",
  "valor": 99.9,
  "duracao": 1
}
```

---

## 4. PUT /planos/{id} — Atualizar plano

Atualiza todos os campos de um plano existente. Os dados enviados substituem completamente os valores atuais.

**Requisição**

```
PUT /planos/2
Content-Type: application/json
```

```json
{
  "nome": "Teste M3",
  "descricao": "M3 Testando",
  "valor": 99.90,
  "duracao": 1
}
```

**Resposta — 200 OK**

```json
{
  "id": 2,
  "nome": "Teste M3",
  "descricao": "M3 Testando",
  "valor": 99.9,
  "duracao": 1
}
```

**Resposta — 404 Not Found**

Retornada quando não existe nenhum plano com o id informado. Corpo da resposta vazio.

---

## 5. DELETE /planos/{id} — Remover plano

Remove um plano do banco de dados pelo id.

**Requisição**

```
DELETE /planos/2
```

**Resposta — 204 No Content**

Sem corpo de resposta — indica que a remoção foi bem-sucedida.

**Resposta — 404 Not Found**

Retornada quando não existe nenhum plano com o id informado. Corpo da resposta vazio.

---

## Arquitetura da aplicação

```
Cliente (Bruno/Postman)
        |
        v
PlanoResource   -> recebe as requisicoes HTTP, mapeia os verbos GET/POST/PUT/DELETE
        |
        v
PlanoService    -> regras de negocio, usa Panache para acessar o banco
        |
        v
Plano (Model)   -> entidade JPA, mapeada para a tabela "plano" no PostgreSQL
```

- **DTOs** (`PlanoRequestDTO` e `PlanoResponseDTO`) garantem que a entidade `Plano` nunca é exposta diretamente na API.
- **PlanoRequestDTO**: usado para receber dados em POST e PUT (sem o campo `id`).
- **PlanoResponseDTO**: usado para devolver dados ao cliente (com o campo `id`).

## Tecnologias utilizadas

- Java 17
- Quarkus 3.36.2
- Hibernate ORM com Panache
- PostgreSQL
- Maven