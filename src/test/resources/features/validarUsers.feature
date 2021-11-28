#encoding: utf-8
#language: pt


Funcionalidade: Validar informações de uma API simples

  Esquema do Cenário: Verificar usuário cadastrado na API

    Dado que eu entre na API "https://restapi.wcaquino.me/users/"
    Quando eu pesquisar por um cliente na API <id>
    E eu verificar a existencia do cliente na base de dados <id> <name> <age>
    Entao o cliente esta cadastrado

    Exemplos:
      | id | name             | age |
      | 1  | "João da Silva"  | 30  |
      | 2  | "Maria Joaquina" | 25  |
      | 3  | "Ana Júlia"      | 20  |