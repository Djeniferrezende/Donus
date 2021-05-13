# Donus

*Conta Bancaria*

Esse projeto ilustra a estrutura de uma conta bancaria gerada através da utilização do SpringBoot.

🚀 Começando

Para executar o projeto, será necessário os seguintes programas:

1. Eclipse ou intellij
2. JDK 11
3. STS
4. Postman
5. Postgresql 12 e pgAdmin (o projeto foi desenvolvido em teste usando o banco de dados h2, em dev no prostgress).

#####Para iniciar o desenvolvimento, é necessário clonar o projeto do GitHub num diretório de sua preferência:

cd "diretorio de sua preferencia"
git clone https://github.com/condessalovelace/Donus

Para utilizar via banco h2 o application.properties precisa estar com a nomenclatura de test

![image](https://user-images.githubusercontent.com/47535167/118131362-d4d37a80-b3d4-11eb-8935-1104b37f209f.png)

Na configuração para utilizar o h2 que esta no application-test.properties tem como padrao o username:sa e senha:"", caso na sua maquina esteja com a configuração diferente favor alterar no codico com seus acessos.

![image](https://user-images.githubusercontent.com/47535167/118134994-e4ed5900-b3d8-11eb-9836-611317481992.png)

Para acessar o H2 basta executar o projeto e colocar na URL http://localhost:8080/h2-console como consta no detalhamento da imagem.
Acesse com o usuario e senha.


![image](https://user-images.githubusercontent.com/47535167/118135401-5b8a5680-b3d9-11eb-9788-cb577e2737a3.png)

** não há necessidade de criação de tabelas visto que o spring faz de maneira automatica.




Ja para usar via dev no postgress o application.properties deve ser alterado para:

![image](https://user-images.githubusercontent.com/47535167/118131474-f0d71c00-b3d4-11eb-949f-11d76ce4c1b6.png)

Na configuração para utilizar o postgress que esta no application-dev.properties tem como padrao o username:postgress e senha:1234567, caso na sua maquina esteja com a configuração diferente favor alterar no codico com seus acessos.
![image](https://user-images.githubusercontent.com/47535167/118132345-f8e38b80-b3d5-11eb-886c-af45b3f3183b.png)

No pgAdmin foi utilizado o postgreSQL 12 e foi criado um banco de dados com o nome de contaBancaria ( para criar a dataBase basta clicar em postgreSql > databases> create database)

Para gerar o arquivo de "create.sql" para ser utilizado no postgress basca descomentar as 4 primeiras linhas do application-dev.properties e executar novamente.

![image](https://user-images.githubusercontent.com/47535167/118133239-fa618380-b3d6-11eb-8d68-e74903dd6cf8.png)

. dentro da pasta do projeto sera criado um arquivo chamado "create.sql", enconstraremos a criação das tabelas de maneira automatica.
![image](https://user-images.githubusercontent.com/47535167/118133655-75c33500-b3d7-11eb-8fbb-a7d2c3080d9e.png)

Copie a informação que vem dentro do arquivo e execute no pgadmin.
 1. va dentro do banco criado
 2. Schemas
 3. tables
 4. query tool
 5. colocar as informações que vieram do create.sql
 
 Pronto as tabelas já estao criadas. 

###Importante 

Lembre-se de comentar novamente as 4 linhas para nao gerar duplicidade no arquivo.







#####Para listar todas as contas(GET)

http://localhost:8080/conta/

![image](https://user-images.githubusercontent.com/47535167/118136170-32b69100-b3da-11eb-82fc-507df7655287.png)


#####Para trazer uma conta com seu respectivo id(GET)

1- digite o id

http://localhost:8080/conta/3

![image](https://user-images.githubusercontent.com/47535167/118136228-4235da00-b3da-11eb-83d4-88c2bd2d78ce.png)



#####Para realizar um deposito passe na url(POST)

1- id para receber o deposito
2- novo-deposito

http://localhost:8080/conta/1/novo-deposito(POST)

![image](https://user-images.githubusercontent.com/47535167/118136344-642f5c80-b3da-11eb-9bf7-7f52756a7545.png)


##### Para realizar uma transferencia passe na url 
 1- primeiro id de Origem
 2- nova-transferencia
 3- id de destino
http://localhost:8080/conta/2/nova-transferencia/3

![image](https://user-images.githubusercontent.com/47535167/118136490-8d4fed00-b3da-11eb-9a27-ed41b60ebbf4.png)



