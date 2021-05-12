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

Para iniciar o desenvolvimento, é necessário clonar o projeto do GitHub num diretório de sua preferência:

cd "diretorio de sua preferencia"
git clone https://github.com/condessalovelace/Donus


para realizar uma transferencia passe na url 
 1- primeiro id de Origem
 2- nova-transferencia
 3- id de destino
http://localhost:8080/conta/2/nova-transferencia/3

via json passamos 

{
   "valor":10000.00    
}
