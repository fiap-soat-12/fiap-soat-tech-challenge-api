<div align="center">

# Tech Challenge - API

![GitHub Release Date](https://img.shields.io/badge/Release%20Date-Dezembro%202024-yellowgreen)
![](https://img.shields.io/badge/Status-Em%20Desenvolvimento-yellowgreen)
<br>
![](https://img.shields.io/badge/Version-%20v3.0.0-brightgreen)
</div>

## 💻 Descrição

Este monolito é responsável por gerenciar a entrada de pedidos de um restaurante. Ele lida com o processamento dos
pedidos, gerenciamento de pagamentos e envio dos pedidos para a cozinha após a confirmação do pagamento.

## 🛠 Tecnologias Utilizadas

<div align="center">

![Java](https://img.shields.io/badge/java_21-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/spring_3-%236DB33F.svg?style=for-the-badge&logo=springboot&logoColor=white)
![Maven](https://img.shields.io/badge/Apache%20Maven-C71A36.svg?style=for-the-badge&logo=Apache-Maven&logoColor=white)
![Postgres](https://img.shields.io/badge/PostgreSQL-4169E1.svg?style=for-the-badge&logo=PostgreSQL&logoColor=white)
![Swagger](https://img.shields.io/badge/-Swagger-%23Clojure?style=for-the-badge&logo=swagger&logoColor=white)
![Docker](https://img.shields.io/badge/Docker-2496ED?style=for-the-badge&logo=docker&logoColor=white)
![Mercado Pago](https://img.shields.io/badge/Mercado%20Pago-00B1EA.svg?style=for-the-badge&logo=Mercado-Pago&logoColor=white)


</div>

## 💫 Arquitetura

O projeto segue a Clean Architecture, permitindo maior flexibilidade e facilidade de manutenção.

### Desenho da arquitetura

![Desenho de Arquitetura](./assets/diagrams/DiagramaDeArquitetura.drawio.png)

### Diagramas sequenciais

<details style="cursor: pointer;">
 <summary style="background-color: #086dd7b0; border-radius: 5px; font-size: 15px; padding-left: 6px; font-weight: bold;">Diagrama sequencial de customers </summary>
 <br>
 
 ![Cadastro do Customer](./assets/diagrams/DiagramaDeSequenciaCustomers.drawio.png)

</details>

<details style="cursor: pointer;">
 <summary style="background-color: #086dd7b0; border-radius: 5px; font-size: 15px; padding-left: 6px; font-weight: bold;">Diagrama sequencial de products </summary>
 <br>
 
 ![Cadastro e listagem de produtos](./assets/diagrams/DiagramaDeSequenciaProdutos.drawio.png)

</details>

<details style="cursor: pointer;">
 <summary style="background-color: #086dd7b0; border-radius: 5px; font-size: 15px; padding-left: 6px; font-weight: bold;">Diagrama sequencial de orders </summary>
 <br>
 
 ![Criação de pedidos](./assets/diagrams/DiagramaDeSequenciaCriacaoPedido.drawio.png)
 ![Listagem de pedidos](./assets/diagrams/DiagramaDeSequenciaConsultarPedidos.drawio.png)

</details>

## ⚙️ Configuração

### Pré-requisitos

#### Desenvolvimento

- **[Java 21](https://docs.oracle.com/en/java/javase/21/)**: Documentação oficial do Java 21.
- **[Maven 3.6.3+](https://maven.apache.org/)**: Site oficial do Maven.
- **[Docker](https://www.docker.com/)**: Site oficial do Docker.
- **[Docker Compose](https://docs.docker.com/compose/)**: Documentação oficial do Docker Compose.
- **[Mercado Pago](https://www.mercadopago.com.br/developers/pt/docs/qr-code/integration-configuration/qr-dynamic/integration)**: Documentação oficial do Mercado Pago.

### 🐳 Imagem Docker

A imagem docker desse projeto foi buildada através do arquivo `Dockerfile` presente neste repositório.

### 🚀 Execução

<details style="cursor: pointer;">
 <summary style="background-color: #086dd7b0; border-radius: 5px; font-size: 15px; padding-left: 6px; font-weight: bold;">Subindo aplicação via Docker Compose</summary>
<br>
Este projeto conta com um arquivo `docker-compose.yml` que pode ser utilizado para subir o container da aplicação e suas
respectivas dependências (banco de dados).

Para subir as aplicações, primeiro se faz necessária a existência de um arquivo `.env` na raiz do projeto, para que as
variáveis de ambiente sejam definidas. Esse projeto já conta com um arquivo versionado nesse repositório, para que a
definição das variáveis não precise ser feita. Abaixo segue a estrutura desse arquivo:

```sh
POSTGRES_URL=<url_do_banco_de_dados>
POSTGRES_DB=<nome_do_banco_de_dados>
POSTGRES_USERNAME=<usuário_do_banco_de_dados>
POSTGRES_PASSWORD=<senha_do_usuário_no_banco_de_dados>
```

Após se certificar que o arquivo `.env` existe e está definindo as variáveis citadas acima, basta executar o
comando `docker compose up` para iniciar o build da imagem da aplicação (Definida no arquivo `Dockerfile`) e realizar a
inicialização do container do banco de dados (Postgres) seguido pelo container da aplicação.

Caso tudo dê certo, as seguintes linhas de log devem ter sido exibidas no terminal cujo comando foi executado:

- Pull da imagem do postgres:

![Pull da imagem do Postgres](./assets/pull_postgress_image.png)

- Build da imagem da aplicação utilizando o conteúdo do Dockerfile:

![Build da aplicação via Dockerfile](./assets/build_app_docker_image.png)

- Criando volume e containers:

![Criando volumes e containers](./assets/creating_volume_and_containers.png)

- Container do postgres de pé e rodando com sucesso

![Container do postgres de pé](./assets/postgress_container_up.png)

- Container da aplicação de pé e rodando com sucesso

![Container da aplicação de pé](./assets/application_started.png)

Após todos esses passos, basta rodar o comando `docker container ls` para verificar quais containers estão sendo
executados. Caso tudo tenha corrido com sucesso, o comando deve ter o seguinte resultado:

![Listagem de containers em execução](./assets/docker_container_ls.png)

Por fim, o serviço estará disponível em `http://localhost:8357` com contextPath `/api`

Obs: Caso queira subir os containers no modo `detached`(Sem travar o terminal em que o comando for executado), basta
rodar o seguinte comando: `docker compose up -d`

![Docker compose detached mode](./assets/compose_detached_mode.png)
</details>

### 🛒 Integração Checkout (Mercado Pago)

Nesta fase do projeto, integramos o Checkout com a API do Mercado Pago, possibilitando o pagamento via QR Code dinâmico.

Para que o QR Code seja criado, deve-se primeiro criar um pedido (POST) no endpoint `/api/v1/orders`. Após a execução desse endpoint, uma chamada interna será feita para a API do Mercado Pago (POST) no endpoint `https://api.mercadopago.com/instore/orders/qr/seller/collectors/{user_id}/pos/{external_pos_id}/qrs` para gerar o QR Code. Com a string do QR gerada, o pagamento poderá ser realizado. Após a confirmação do pagamento ou a ocorrência de uma falha, receberemos uma requisição no nosso webhook (POST) `/api/v1/webhook-payment`.

Exemplo do recebimento do webhook mandado pelo Mercado Pago: 
```bash
{
  "action": "payment.updated",
  "api_version": "v1",
  "data": {
    "id": "123456"
  },
  "date_created": "2021-11-01T02:02:02Z",
  "id": "123456",
  "live_mode": false,
  "type": "payment",
  "user_id": 1986357239
}
```
Em seguida, uma requisição será feita internamente para o endpoint (GET) `https://api.mercadopago.com/v1/payments/{id}` do Mercado Pago para verificar o status do pagamento. Se o status for `approved`, alteraremos o status do pedido na nossa aplicação para `PREPARING`.

Caso ocorram falhas e o pagamento não seja efetivado dentro do intervalo de meia hora desde a criação do pedido, o pagamento não poderá ser realizado devido ao tempo de expiração, e o pedido será atualizado automaticamente para `FINISHED`. Isso será feito pelo nosso `Scheduled`, que buscará todos os pedidos com status `RECEIVED` criados há mais de meia hora e os atualizará para o status `FINISHED`.

Observação: Deve-se considerar que nossa integração está sendo feita com o uso das contas de teste criadas no Mercado Pago.

### 📄 Documentação da API

Link para acessar ao swagger após subir a aplicação:

```bash
# Ambiente Local via docker compose
http://localhost:8357/api/swagger-ui/index.html
```

🔗 Ou acesse https://fiap-soat-12.github.io/fiap-soat-tech-challenge-api/

### 🔃 Ordem de execução das APIs

1. O primeiro passo, que é opcional, seria realizar a criação de um novo usuário (cadasto de usuário) utilizando o endpoint (POST) `/api/v1/customers`
2. Após o cadastro do usuário, o próximo passo, que também é opcional (pois nossa aplicação já fornece `seeds` no banco de dados, com produtos pré-cadastrados), seria realizar o cadastro de um novo produto através do endpoint (POST) `/api/v1/products`
3. O próximo passo é realizar a listagem de todos os produtos por categoria através do endpoint (GET) `/api/v1/products`, para saber quais estão disponíveis
4. Com os produtos escolhidos em mãos, o próximo passo é realizar a criação de um pedido através do endpoint (POST) `/api/v1/orders`, e salvar o código do QRCode retornado no response, para realizar o pagamento do mesmo posteriormente
5. Após realizar a criação do pedido, é possível verificar se o mesmo foi criado através do endpoint (GET) `/api/v1/orders`. O mesmo deve estar listado no response dentro do status `received`
6. O próximo passo será realizar o pagamento do pedido criado. Para realizar o pagamento do pedido, basta ler o QRCode gerado no passo 4 (Para realizar a leitura do mesmo, é necessário utilizar um site que transforma a string Pix em uma imagem QRCode, como por exemplo o [https://www.qrcode-monkey.com/](https://www.qrcode-monkey.com/)) e realizar o pagamento através do aplicativo do mercado pago (Pois a aplicação está integrada ao gateway de pagamentos do mercado pago)
7. Após ter efetuado o pagamento do pedido, é possível verificar se o mesmo foi realmente pago realizando uma chamada ao endpoint (GET) `/api/v1/orders/{id}/paid-status`.
8. Também é possível verificar que o status do pedido foi atualizado para `preparing` chamando novamente o endpoint (GET) `/api/v1/orders`;
9. Para simular que a preparação do pedido foi finalizada pela cozinha, e que o pedido está pronto para ser retirado pelo cliente, basta chamar o endpoint (PATCH) `/api/v1/orders/{id}`
10. Após isso, é possível verificar que o status do pedido foi atualizado para `ready` chamando novamente o endpoint (GET) `/api/v1/orders`;
11. Finalizando a esteira de entrega do pedido, é possível simular o ato de retirada do mesmo pelo cliente, realizando uma nova chamada ao endpoint (PATCH) `/api/v1/orders/{id}`
12. E como último passo, é possível verificar novamente o status do pedido utilizando o endpoint (GET) `/api/v1/orders`. Neste caso, como o pedido foi atualizado para o status `finished`, o mesmo não deve mais estar sendo exibido no retorno do endpoint chamado.

Além dos endpoints listados acima, existem outros que não fazem parte do fluxo padrão da aplicação, mas que podem ser utilizados:
1. É possível realizar uma chamada ao endpoint (PUT) `/api/v1/products/{id}` para realizar a atualização de um produto qualquer (Que já tenha sido criado)
2. É possível realizar uma chamada ao endpoint (DELETE) `/api/v1/products/{id}` para realizar a exclusão de um produto qualquer (Que exista)
3. Existe um endpoint que não é chamado diretamente pelo cliente, que é o `/api/v1/webhook-payment`. Este endpoint é responsável por receber a resposta do gateway de pagamentos, relacioada a ação de pagamento do pedido (Pagamento realizado, ou falha no pagamento)
4. Caso queira, é possível verificar se o usuário foi cadastrado e também ver o detalhamento das informações do usuário através do endpoint (GET) `/api/v1/customers/{document}`

### 🎲 Seeds

Para facilitar o consumo e os testes da aplicação, seeds de dados foram criadas e gerenciadas utilizando o `Flyway`. 
Essas seeds são aplicadas automaticamente ao iniciar a aplicação, garantindo um ambiente consistente e pronto para uso.

### 📚 MIRO - Event Storming

![Event Storming](./assets/event_storming.png)

Acesso ao MIRO com o Event Storming:
[Event Storming](https://miro.com/app/board/uXjVK1ekBDM=/)
