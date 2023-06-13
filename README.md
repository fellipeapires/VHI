
# SPRINGFRAMEWORK VERSION 2.7.13 SNAPSHOT

# JAVA VERSION 11

# SGBD SQL SERVER 

# DEPENDENCIAS VIA MAVEN

# DOCUMENTAÇÃO VIA SWAGGER:
- http://localhost:8080/swagger-ui.html

# UTILIZAR O POSTMAN PARA CONSULTA DO ENDPOINT PARA UTILIZAR PAGINAÇÃO

# AUTENTIÇÃO COM BASIC AUTH:
- ADICIONAR USUARIO E SENHA NO HEADER DA REQUISIÇÃO (cartorio & selodigital)
- NA ABA AUTHORIZATION SELECIONAR BASIC AUTH E INFORMAR USUARIO E SENHA, SERÁ ADICIONADO NO HEDAER DA REQUISIÇÃO ENCODER(Basic Y2FydG9yaW86c2Vsb2RpZ2l0YWw=)

-----------------------------------------------

* ENDPOINT PESQUISAR:

# PESQUISAR COM PAGINAÇÃO:
- PAGE INDICANDO A PAGINA DA PESQUISA
- SIZE A QUANTIDADE DE REGISTROS PARA RETORNAR

- COM FILTRO
http://localhost:8080/certidao/pesquisar?folhasExcedentes=5&numeroVia=2&localArquivamento=LOCAL%20A

- SEM FILTRO
http://localhost:8080/certidao/pesquisar?page=1&size=2  

- OBJETO DE RETORNO:
 {
    "content": [
        {
            "id": 3,
            "localArquivamento": "LOCAL C",
            "folhasExcedentes": 20,
            "numeroVia": 3,
            "dataValidade": "2023-04-01T00:00:00"
        },
        {
            "id": 4,
            "localArquivamento": "LOCAL D",
            "folhasExcedentes": 15,
            "numeroVia": 2,
            "dataValidade": "2023-05-01T00:00:00"
        }
    ],
    "pageable": {
        "sort": {
            "sorted": false,
            "unsorted": true,
            "empty": true
        },
        "pageNumber": 1,
        "pageSize": 2,
        "offset": 2,
        "paged": true,
        "unpaged": false
    },
    "totalPages": 5,
    "totalElements": 10,
    "last": false,
    "numberOfElements": 2,
    "first": false,
    "size": 2,
    "number": 1,
    "sort": {
        "sorted": false,
        "unsorted": true,
        "empty": true
    },
    "empty": false
}

-----------------------------------------------

* ENDPOINT BUSCAR POR ID:

http://localhost:8080/certidao/buscarporid/1

- OBJETO DE RETORNO: 
{
  "id": 1,
  "localArquivamento": "string",
  "folhasExcedentes": 0,
  "numeroVia": 0,
  "dataValidade": "2023-06-12T00:00:00"
}

-----------------------------------------------

* ENDPOINT INCLUIR: 

http://localhost:8080/certidao/incluir

- OBJETO NO BODY DA REQUISIÇÃO:
{
  "dataValidade": "2023-06-12T22:20:09.119Z",
  "folhasExcedentes": 0,
  "localArquivamento": "string",
  "numeroVia": 0
}

- OBJETO DE RESPOSTA:
{
  "id": 11,
  "localArquivamento": "string",
  "folhasExcedentes": 0,
  "numeroVia": 0,
  "dataValidade": "2023-06-12T22:20:09.119"
}

-----------------------------------------------

* ENDPOINT ALTERAR: 

- OBJETO NO BODY DA REQUISIÇÃO:
{
  "dataValidade": "2023-06-12T22:20:09.110Z",
  "folhasExcedentes": 0,
  "id": 1,
  "localArquivamento": "string",
  "numeroVia": 0
}

- OBJETO DE RESPOSTA:
{
  "id": 1,
  "localArquivamento": "string",
  "folhasExcedentes": 0,
  "numeroVia": 0,
  "dataValidade": "2023-06-12T22:20:09.11"
}
