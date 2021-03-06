Donus Conta Bancaria
---


Esse projeto ilustra a estrutura de uma conta bancaria gerada através da utilização do SpringBoot.

🚀 Começando

Para executar o projeto, será necessário os seguintes programas:

1. Eclipse ou intellij
2. JDK 11
3. STS
4. Postman
5. Postgresql 12 e pgAdmin (o projeto foi desenvolvido em teste usando o banco de dados h2, em dev no prostgress).

##### Para iniciar o desenvolvimento, é necessário clonar o projeto do GitHub num diretório de sua preferência:

```sh
cd "diretorio de sua preferencia"
git clone https://github.com/condessalovelace/Donus
```

Para utilizar via banco h2 o application.properties precisa estar com a nomenclatura de test
```
spring.profiles.active=test
spring.jpa.open-in-view=false
```
Na configuração para utilizar o h2 que esta no application-test.properties tem como padrao o username:sa e senha:"", caso na sua maquina esteja com a configuração diferente favor alterar no codico com seus acessos.

```
spring.jpa.open-in-view=false

spring.datasource.url=jdbc:h2:mem:contaBancaria
spring.datasource.username=sa
spring.datasource.password=

spring.h2.console.enabled=true
spring.h2.console.path=/h2-console

spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```

Para acessar o H2 basta executar o projeto e colocar na URL http://localhost:8080/h2-console como consta no detalhamento da imagem.
Acesse com o usuario e senha.


![image](https://user-images.githubusercontent.com/47535167/118135401-5b8a5680-b3d9-11eb-9788-cb577e2737a3.png)

** não há necessidade de criação de tabelas visto que o spring faz de maneira automatica. **




Ja para usar via no postgress o application.properties deve ser alterado para:

```
spring.profiles.active=dev
spring.jpa.open-in-view=false
```

Na configuração para utilizar o postgress que esta no application-dev.properties tem como padrao o username:postgress e senha:1234567, caso na sua maquina esteja com a configuração diferente favor alterar no codico com seus acessos.
```
#spring.jpa.properties.javax.persistence.schema-generation.create-source=metadata
#spring.jpa.properties.javax.persistence.schema-generation.scripts.action=create
#spring.jpa.properties.javax.persistence.schema-generation.scripts.create-target=create.sql
#spring.jpa.properties.hibernate.hbm2ddl.delimiter=;

spring.datasource.url=jdbc:postgresql://localhost:5432/contaBancaria
spring.datasource.username=postgres
spring.datasource.password=1234567

spring.jpa.properties.hibernate.jdbc.lob.non_contextual_creation=true
spring.jpa.hibernate.ddl-auto=none
```

No pgAdmin foi utilizado o postgreSQL 12 e foi criado um banco de dados com o nome de contaBancaria ( para criar a dataBase basta clicar em postgreSql > databases> create database)

Para gerar o arquivo de "create.sql" para ser utilizado no postgress basta des-comentar as 4 primeiras linhas do application-dev.properties e executar novamente.
```
spring.jpa.properties.javax.persistence.schema-generation.create-source=metadata
spring.jpa.properties.javax.persistence.schema-generation.scripts.action=create
spring.jpa.properties.javax.persistence.schema-generation.scripts.create-target=create.sql
spring.jpa.properties.hibernate.hbm2ddl.delimiter=;

spring.datasource.url=jdbc:postgresql://localhost:5432/contaBancaria
spring.datasource.username=postgres
spring.datasource.password=1234567

spring.jpa.properties.hibernate.jdbc.lob.non_contextual_creation=true
spring.jpa.hibernate.ddl-auto=none
```



 Dentro da pasta do projeto sera criado um arquivo chamado "create.sql", encontraremos a criação das tabelas de maneira automatica.
 ```sql
create table tb_conta (id int8 generated by default as identity, cpf varchar(255), nome varchar(255), numero_conta int4, saldo float8, primary key (id));
create table tb_deposito (id int8 generated by default as identity, valor float8, conta_id int8, primary key (id));
create table tb_transferencia (id int8 generated by default as identity, valor float8, conta_destino_id int8, conta_origem_id int8, primary key (id));
alter table if exists tb_deposito add constraint FKp79rbahkkjr4fidl2falisarm foreign key (conta_id) references tb_conta;
alter table if exists tb_transferencia add constraint FKfv09gvc2w62lyuvg6rjma5yn0 foreign key (conta_destino_id) references tb_conta;
alter table if exists tb_transferencia add constraint FKsyh9uqqixdusq53nvd4muqylv foreign key (conta_origem_id) references tb_conta;
```

Copie a informação que vem dentro do arquivo e execute no pgadmin.
 1. Va dentro do banco criado
 2. Schemas
 3. Tables
 4. Query tool
 5. Colocar as informações que vieram do create.sql
 
 Pronto as tabelas já estao criadas. 

### Importante 

Lembre-se de comentar novamente as 4 linhas para nao gerar duplicidade no arquivo.


Collection postman: [https://www.getpostman.com/collections/55ef2817ad3babdc20b0](https://www.getpostman.com/collections/55ef2817ad3babdc20b0)

A documentação foi feia no swagger e pode ser acessado com [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)






