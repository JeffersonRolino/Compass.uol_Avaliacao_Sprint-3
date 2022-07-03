# Compass.uol_Avaliacao_Sprint-3
Avaliação do Terceiro Sprint do Programa de Bolsas Compass.UOL.

A avaliação consistia em criar uma REST API simples com os Estados Brasileiros, realizando operações básicas de CRUD e alguns filtros e ordenações.

Segue abaixo a documentação da API e como consumi-la:

## Especificações
JDK 11.0.12

Spring Boot 2.7.1

server.port=8080

### Banco de Dados

jdbc:h2:mem:avaliacao-sprint-3

url: /h2-db

username: sa

password:



## Endpoints
### /api/states
Endpoint principal da aplicação onde é possível realizar as principais requisições, são elas:
#### POST
Cadastra um novo Estado na API. O id não precisa ser especificado, pois é gerado automaticamente pelo banco de dados H2, porém o campo região só aceita cinco valores: Norte, Nordeste, Sul, Sudeste e Centro-Oeste.

Tentar cadastrar outra região ou palavra retornará um erro 400 Bad Request.

Caso seja cadastrado um Estado válido, a API retornará um código 201 Created, sinalizando que o Estado foi inserido.

Exemplo de entrada válida:

    {
        "name": "Bahia",
        "region": "Nordeste",
        "population": 14985284,
        "capital": "Salvador",
        "area": 564760.427
    }

#### GET

Devolve um array com todos os Estados cadastrados. E um status 200 ok.

    [
      {
        "id": 0,
        "name": "string",
        "region": "string",
        "population": 0,
        "capital": "string",
        "area": 0
      }
    ]

Caso a não exista Estados cadastrados, a API simplesmente retorna um array vazio.

#### Parâmetros de Consulta

Este endpoint permite utilizar algumas Parâmetros de Consulta (Query Parameters) para filtrar e ordenar os resultados, são eles:

###### region

Filtra os Estado por Região (Norte, Nordeste, Sul, Sudeste e Centro-Oeste).

Exemplo:

    api/states?region=Norte

###### sortByPopulation

Ordena os Estados por População, da maior para a menor.

Exemplo:

    api/states?sortByPopulation=true

###### sortByArea

Ordena os Estados por Área da maior para a menor.

Exemplo:

    api/states?sortByArea=true


### /api/states/{id}

Este endpoint permite realizar requisições específicas de acordo com o id do Estado cadastrado. Caso o id não esteja cadastrado a requisição retornará 404 Not Found.

#### GET

Recupera um Estado pelo Id.

ex: api/states/42

    {
      "id": 42,
      "name": "string",
      "region": "string",
      "population": 0,
      "capital": "string",
      "area": 0
    }


#### PUT

Atualiza um Estado pelo Id.

ex: api/states/42

    {
      "id": 42,
      "name": "string",
      "region": "string",
      "population": 0,
      "capital": "string",
      "area": 0
    }

#### DELETE

Remove um Estado pelo Id.

ex: api/states/42

Retorna 200 ok.

### /api/states/insert
Endpoint auxiliar que permite cadastrar um Array de Estados de uma só vez:

#### POST
Cadastra um array de Estados na API. O id não precisa ser especificado, pois é gerado automaticamente pelo banco de dados H2, porém o campo região só aceita cinco valores: Norte, Nordeste, Sul, Sudeste e Centro-Oeste.

Exemplo de entrada válida:

    [
      {
        "id": 0,
        "name": "string",
        "region": "string",
        "population": 0,
        "capital": "string",
        "area": 0
      }
    ]

Tentar cadastrar outra região ou palavra retornará um erro 400 Bad Request.

Caso os Estados sejam cadastrados a API retornará um código 200 ok.


## Arquivos Extras

Documentação utilizando Open API 3 e Swagger Editor

    src/main/resources/avaliacao-sprint3-docs.yaml

Coleção de Testes de Requisições e Respostas da API utilizando o Postman.

    src/main/resources/postman/CompassAvaliaçãoSprint3.postman_collection.json


