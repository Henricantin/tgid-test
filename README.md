# 🛒 Loja Online Simples - API Java Spring Boot

Este é um projeto de API REST simples para simular o funcionamento de uma loja online. Foi desenvolvido com **Java 17+** e **Spring Boot**, e permite o cadastro simulado de usuários e produtos, além da realização de vendas.

---

## 📦 Funcionalidades

- Listagem de usuários cadastrados
- Listagem de produtos disponíveis
- Simulação de uma compra com controle de estoque
- Listagem das vendas realizadas

---

## 🚀 Como rodar o projeto

### Pré-requisitos

- [Java JDK 17+ (JDK 24 recomendado)](https://www.oracle.com/java/technologies/javase-downloads.html)
- [Maven](https://maven.apache.org/)

### Passos

1. Clone o repositório:
   ```bash
   git clone https://github.com/Henricantin/tgid-test.git
   ```

2. Rode o projeto:
   ```bash
   ./mvnw spring-boot:run
   ```

3. A aplicação estará disponível em:
   ```
   http://localhost:8080/
   ```

---

## 🔁 Endpoints da API

### 📍 Base URL

```
http://localhost:8080/api
```

---

### ✅ `GET /api/users`

Lista todos os usuários cadastrados no sistema (simulados em memória).

**Exemplo de resposta:**
```json
[
  {
    "id": 1,
    "name": "Lucca",
    "cpf": "123.456.789-00",
    "email": "lucca@email.com"
  }
]
```

---

### ✅ `GET /api/products`

Lista todos os produtos disponíveis, com nome, preço e quantidade em estoque.

**Exemplo de resposta:**
```json
[
  {
    "id": 1,
    "name": "AirPod",
    "price": 2500.00,
    "stockQuantity": 10
  }
]
```

---

### 🛒 `POST /api/purchase?userId={id}`

Realiza uma compra para um usuário com base no ID e nos produtos/quantidades desejadas.

- **Parâmetro de query:** `usuarioId` → ID do usuário que está comprando
- **Body:** mapa de `produtoId: quantidade`

**Exemplo de requisição:**
```http
POST /api/purchase?userId=1
Content-Type: application/json
```

**Body:**
```json
{
  "1": 2,
  "3": 1
}
```

✅ Isso simula o usuário com ID 1 comprando:
- 2 unidades do produto ID 1
- 1 unidade do produto ID 3

**Resposta de sucesso:**
```json
{
  "id": 1,
  "user": {
    "id": 1,
    "name": "Lucca",
    "cpf": "123.456.789-00",
    "email": "lucca@email.com"
  },
  "items": [
    {
      "product": {
        "id": 1,
        "name": "AirPod",
        "price": 2500.00,
        "stockQuantity": 8
      },
      "quantity": 2
    },
    {
      "product": {
        "id": 3,
        "name": "Case iPhone",
        "price": 80.00,
        "stockQuantity": 29
      },
      "quantity": 1
    }
  ],
  "total": 5080.00
}
```

---

### 📄 `GET /api/sales`

Lista todas as vendas realizadas até o momento.

**Exemplo de resposta:**
```json
[
  {
    "id": 1,
    "user": {
      "id": 1,
      "name": "Lucca",
      "cpf": "123.456.789-00",
      "email": "lucca@email.com"
    },
    "items": [...],
    "total": 5080.00
  }
]
```
