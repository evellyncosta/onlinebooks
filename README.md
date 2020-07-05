# onlinebooks API 

> Esta API tem como objetivo simular o empréstimo de livros de uma biblioteca. Ela foi construída em JAVA EE 8, usando a versão 11 do Java. Os dados são salvos em um banco de dados MySQL na versão 8. Além disso, para a melhor manutenibilidade do projeto, utilizou-se o Flyaway e o Apache DeltaSpike, sendo o primeiro responsável pelos scripts de migração do banco de dados e o segundo, visa simplificar o padrão Repository em projetos Java.

### Iniciando
> Para rodar a API, primeiramente você deve ter o Docker e o Docker Compose instalado. Caso não tenha, pode usar os seguintes links para instalação: </br>
[Docker](https://docs.docker.com/get-docker/) </br>
[Docker Compose](https://docs.docker.com/compose/install/) </br>  
Após baixar o projeto, no diretório do projeto, execute o seguinte comando:
```
docker-compose build
```
e depois: 

```
docker-compose up
```
### Importante
> O projeto utiliza o JBOSS Wildfly, e por isso é importante que a porta 8080 do seu computador não esteja em uso, e a porta 3306 também deve estar desocupada, pois o MySQL utiliza esta porta. Para verificar as portas, pode seguir o seguinte tutorial:
[Verificando as portas do computador](https://desenvolvedorinteroperavel.wordpress.com/2013/12/25/como-encerrar-processos-em-uma-porta-especifica/)

### Endpoints
>A API possui alguns endpoints para serem utilizados:


