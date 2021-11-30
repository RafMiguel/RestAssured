#language: pt
  #encoding: utf-8

@validarCEP
Funcionalidade: Validar CEP baseado em parâmetros

  @case1
  Esquema do Cenario: Buscar endereço na API baseado no CEP
    Dado que eu entre na URL "https://viacep.com.br/ws/"
    Quando eu consultar o CEP '<cep>'
    Entao retornar o logradouro '<logradouro>'

    Exemplos:
      | cep      | logradouro           |
      | 49000188 | Rua César Macieira   |
      | 07402160 | Rua Acre             |
      | 40020010 | Praça Thomé de Souza |
      | 50010010 | Rua Siqueira Campos  |
      | 68908465 | Rua A                |

  @case2
  Esquema do Cenario: Buscar endereço na API com CEP errado
    Dado que eu entre na URL "https://viacep.com.br/ws/"
    Quando eu consultar o CEP '<cep>'
    Entao retornar o logradouro incorreto '<logradouro>'

    Exemplos:
      | cep      | logradouro               |
      | 49000188 | Maceió                   |
      | 07402160 | Guarulhos                |
      | 40020010 | Parque Dom Pedro II      |
      | 50010010 | Rua Pedro Alvares Cabral |
      | 68908465 | Rua B                    |

  @case3
  Esquema do Cenario: : Validar todos os campos do endereco
    Dado que eu entre na URL "https://viacep.com.br/ws/"
    Quando eu consultar o CEP "<cep>"
    Entao validar todos os dados do endereco "<cep>" "<logradouro>" "<complemento>" "<bairro>" "<localidade>" "<uf>" "<ibge>" "<gia>" "<ddd>" "<siafi>"

    Exemplos:
      | cep      | logradouro           | complemento | bairro          | localidade | uf | ibge    | gia  | ddd | siafi |
      | 49000-188 | Rua César Macieira   |             | Aruana          | Aracaju    | SE | 2800308 |      | 79  | 3105  |
      | 07402-160 | Rua Acre             |             | Jardim Planalto | Arujá      | SP | 3503901 | 1880 | 11  | 6177  |
      | 40020-010 | Praça Thomé de Souza |             | Centro          | Salvador   | BA | 2927408 |      | 71  | 3849  |
      | 50010-010 | Rua Siqueira Campos  |             | Santo Antônio   | Recife     | PE | 2611606 |      | 81  | 2531  |
      | 68908-465 | Rua A                |             | São Lázaro      | Macapá     | AP | 1600303 |      | 96  | 0605  |