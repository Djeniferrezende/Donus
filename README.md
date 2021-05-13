# Donus

*Conta Bancaria*

Esse projeto ilustra a estrutura de uma conta bancaria gerada através da utilização do SpringBoot.

##🚀 Começando

Para executar o projeto, será necessário os seguintes programas:

1. Eclipse ou intellij
2. JDK 11
3. STS
4. Postman
5. Postgresql 12 e pgAdmin (o projeto foi desenvolvido em teste usando o banco de dados h2, em dev no prostgress).

#####Para iniciar o desenvolvimento, é necessário clonar o projeto do GitHub num diretório de sua preferência:

cd "diretorio de sua preferencia"
git clone https://github.com/condessalovelace/Donus

#####Para listar todas as contas(GET)

http://localhost:8080/conta/

#####Para trazer uma conta com seu respectivo id(GET)

1- digite o id

http://localhost:8080/conta/3

ele retornara assim:

{
    "id": 3,
    "nome": "Debora",
    "cpf": "26002880828",
    "numeroConta": 10002,
    "saldo": 8000.0
}

#####Para realizar um deposito passe na url(POST)

1- id para receber o deposito
2- novo-deposito

http://localhost:8080/conta/1/novo-deposito(POST)

como json: 

{
   "valor":2000.00 
    
}


##### Para realizar uma transferencia passe na url 
 1- primeiro id de Origem
 2- nova-transferencia
 3- id de destino
http://localhost:8080/conta/2/nova-transferencia/3

via json passamos 

{
   "valor":10000.00    
}
