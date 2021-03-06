# onlinebooks API 


> Esta API tem como objetivo simular o empréstimo de livros de uma biblioteca. Ela foi construída em JAVA EE 8, usando a versão 11 do Java. Os dados são salvos em um banco de dados MySQL na versão 8. Além disso, para a melhor manutenibilidade do projeto, utilizou-se o Flyaway e o Apache DeltaSpike, sendo o primeiro responsável pelos scripts de migração do banco de dados e o segundo visa simplificar o padrão Repository em projetos Java.

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

>Listagem de livros:
GET http://localhost:8080/onlinebooks/resources/books

>Listagem de clientes:
GET http://localhost:8080/onlinebooks/resources/clients

>Listagem de livros emprestados:
GET http://localhost:8080/onlinebooks/resources/clients/{id}/books

>Reserva de livro:
POST http://localhost:8080/onlinebooks/resources/books/{id}/reserve?clientId={id}


### Informações
>Para o valor da multa foi estabelecido um valor fixo de dez reais para a base de cálculo, e seguindo a seguinte tabela de juros:
<table>
  <tr>
  	<th>Dias em atraso</th>
    <th>Multa</th>
    <th>Juros por dia</th>
  </tr>
  <tr>
  	<td>Sem atraso</td>
    <td>0% </td>
    <td>0% </td>
  </tr>
   <tr>
  	<td>Até 3 dias</td>
    <td>3%</td>
    <td>0.2%</td>
  </tr>
   <tr>
  	<td>Acima de 3 dias</td>
    <td>5%</td>
    <td>0.4%</td>
  </tr>
   <tr>
  	<td>Acima de 5 dias</td>
    <td>7%</td>
    <td>0.6%</td>
  </tr> 
</table>

#### Collection do Postman
>Para facilitar o teste dos endpoints, há a possibilidade de importar a collection no Postman:
[Collection OnlineBooks](https://drive.google.com/drive/folders/1Le__ualTJg_qxyuRD-s7eRTsIN31E8sO?usp=sharing)
