# Back-end para transações financeiras

## Apresentação:
O presente projeto foi inspirado no [desafio técnico](https://github.com/PicPay/picpay-desafio-backend#materiais-%C3%BAteis) para vaga de desenvolvedor back-end na plataforma de pagamentos PicPay. 
Consistem em um simples sistema de tranferência financeira entre usuários e empresas.

## Tecnologias utilizadas:
- Java 21
- PostgreSQL 17

## Endpoints da API

### 1. users
Endpoints para a operaciozalização do CRUD - criação de novos usuários, atualização de informações de usuários via iD, exclusão de usuários via iD, recuperação de usuários via iD e recuperação dos 
emails presentes no PostreSQL de todos os usuários cadastrado.

#### Criar usuários:
- **URL:** `/users/new_user`
- **Método:** `POST`
- **Corpo da requisição:**
  ```json
  {
    "name": "name",
    "cpf": "000.000.000-00",
    "email": "exemplo@gmail.com",
    "status": "CORPORATE or PERSONAL",
    "password": "#password123"
  }
  
#### Recuperar via iD:
- **URL:** `/users/users/{id}`
- **Método:** `GET`
- **Parâmetro:** `iD` - identificação do usuário que será buscado
- **Resposta:**
  ```json
  {
  "name": "name",
  "email": "exemplo@gmail.com",
  "CPF": "000.000.000-00"
  }

#### Atualizar usuário via iD:
- **URL:** `/users/update/{id}`
- **Método:** `PUT`
- **Parâmetro:** `iD` - identificação do usuário que terá seu perfil atualizado
- **Corpo da Requisição:**
  ```json
  {
    "name": "name",
    "cpf": "000.000.000-00",
    "email": "exemplo@gmail.com",
    "status": "CORPORATE or PERSONAL",
    "password": "#password123"
  }

#### Deletar usuários:
- **URL:** `/users/delete/{id}`
- **Método:** `DELETE`
- **Parâmetro:** `iD` - identificação do usuário que terá seu perfil atualizado

#### Recuperar todos os emails:
- **URL:** `/users/emails`
- **Método:** `GET`

### 2. transfer
Endpoint responsável pela realização de tranferências entre contas.

#### Realizar transferências:
- **URL:** `/transfer`
- **Método:** `PUT`
- **Corpo da requisição:**
  ```json
  {
    "value": "0.0",
    "iD/UUID payer": "",
    "iD/UUID payee": ""
  }

### 3. account
Endpoints responsáveis por recuperar e a alterar o saldo do usário através do iD.

#### Recuperar saldo:
- **URL:** `/account/{id}`
- **Método:** `GET`
- **Parâmetro:** `iD` - identificação do usuário que terá seu perfil atualizado
- **Resposta:**
  ```json
  {
    "balance": 0.0 
  }

#### Atualizar saldo:
- **URL:** `/account/update/{id}`
- **Método:** `PUT`
- **Parâmetro:** `iD` - identificação do usuário que terá seu perfil atualizado
- **Corpo da requisição:**
  ```json
  {
    "balance": "0.0"
  }


# Estrtura do projeto:

# Banco de dados:

