<div align="center">

# Pós Tech FIAP - Tech Challenge - Grupo 12

![GitHub Release Date](https://img.shields.io/badge/Release%20Date-Outubro%202024-yellowgreen)
![](https://img.shields.io/badge/Status-Em%20Desenvolvimento-yellowgreen)
<br>
![](https://img.shields.io/badge/Version-%20v2.0.0-brightgreen)
</div>

### 👨‍💼👩‍💼‍ Autores

Este é um projeto que está em construção pelos desenvolvedores:

![](https://img.shields.io/badge/RM357321-Alexandre%20Miranda-blue)
<br>
![](https://img.shields.io/badge/RM357437-Diego%20Ceccon-blue)
<br>
![](https://img.shields.io/badge/RM357218-Jéssica%20Rodrigues%20-blue)
<br>
![](https://img.shields.io/badge/RM358002-Rodrigo%20Sartori-blue)
<br>
![](https://img.shields.io/badge/RM357991-Wilton%20Souza%20-blue)


## 💻 Descrição

Este monolito é responsável por gerenciar a entrada de pedidos de um restaurante. Ele lida com o processamento dos
pedidos, gerenciamento de pagamentos e envio dos pedidos para a cozinha após a confirmação do pagamento.

## 🛠 Tecnologias Utilizadas
![Java](https://img.shields.io/badge/java_21-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Maven](https://img.shields.io/badge/Apache%20Maven-C71A36.svg?style=for-the-badge&logo=Apache-Maven&logoColor=white)
![Spring](https://img.shields.io/badge/spring_3-%236DB33F.svg?style=for-the-badge&logo=springboot&logoColor=white)
![Postgres](https://img.shields.io/badge/PostgreSQL-4169E1.svg?style=for-the-badge&logo=PostgreSQL&logoColor=white)
![Docker](https://img.shields.io/badge/Docker-2496ED?style=for-the-badge&logo=docker&logoColor=white)
![Swagger](https://img.shields.io/badge/-Swagger-%23Clojure?style=for-the-badge&logo=swagger&logoColor=white)
![Kubernetes](https://img.shields.io/badge/Kubernetes-3069DE?style=for-the-badge&logo=kubernetes&logoColor=white)
![AWS](https://img.shields.io/badge/Amazon%20EKS-FF9900.svg?style=for-the-badge&logo=Amazon-EKS&logoColor=white)
![Terraform](https://img.shields.io/badge/Terraform-7B42BC?style=for-the-badge&logo=terraform&logoColor=white)
![Helm](https://img.shields.io/badge/Helm-0F1689.svg?style=for-the-badge&logo=Helm&logoColor=white)
![Prometheus](https://img.shields.io/badge/Prometheus-E6522C.svg?style=for-the-badge&logo=Prometheus&logoColor=white)
![Grafana](https://img.shields.io/badge/Grafana-F46800.svg?style=for-the-badge&logo=Grafana&logoColor=white)
![K6](https://img.shields.io/badge/k6-7D64FF.svg?style=for-the-badge&logo=k6&logoColor=white)
![Mercado Pago](https://img.shields.io/badge/Mercado%20Pago-00B1EA.svg?style=for-the-badge&logo=Mercado-Pago&logoColor=white)

## 💫 Arquitetura

O projeto segue a Clean Architecture, permitindo maior flexibilidade e facilidade de manutenção.

## ⚙️ Configuração

### Pré-requisitos

#### Desenvolvimento

- **[Java 21](https://docs.oracle.com/en/java/javase/21/)**: Documentação oficial do Java 21.
- **[Maven 3.6.3+](https://maven.apache.org/)**: Site oficial do Maven.
- **[Docker](https://www.docker.com/)**: Site oficial do Docker.
- **[Docker Compose](https://docs.docker.com/compose/)**: Documentação oficial do Docker Compose.
- **[Kubernetes](https://kubernetes.io/pt-br/docs/home/)**: Documentação oficial do Kubernetes.
- **[Terraform](https://www.terraform.io/)**: Site oficial do Terraform.
- **[Mercado Pago](https://www.mercadopago.com.br/developers/pt/docs/qr-code/integration-configuration/qr-dynamic/integration)**: Documentação oficial do Mercado Pago.

### 🐳 Imagem Docker

A imagem docker desse projeto foi buildada através do arquivo `Dockerfile` presente neste repositório, e enviada a um
container registry (Docker HUB). Para visualizá-la, basta acessar o
link: https://hub.docker.com/r/willosouza/fiap-soat-tech-challenge

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

<details>
 <summary style="background-color: #086dd7b0; border-radius: 5px; font-size: 15px; padding-left: 6px; font-weight: bold;">Subindo aplicação em Cluster Kubernetes local (Ex: Docker Desktop ou Minikube)</summary>
 <br>
  
  1. Certificar que o Cluster local esteja executando;
  2. Certificar que o Terraform esteja instalado;
  3. Entrar na pasta `infra/terraform`;
  4. Inicializar o Terraform no projeto `terraform init`;
  5. Verificar que o script do Terraform é valido rodando o comando `terraform validate`;
  6. Executar o comando `terraform plan` para executar o planejamento da execução/implementação;
  7. Executar o comando `terraform apply` para criar a infra dentro do cluster;

  Para acessar a aplicação, será necessário acessar a rota através do IP Público do service do ingress. Esse passo é muda de acordo com o Cluster local que você estiver utilizando:
  Caso esteja utilizando Docker Desktop:
  1. Executar o comando `kubectl get svc -n nginx -ingress`;
  2. Verificar //todo;

  Caso esteja utilizando MiniKube:
  1. Executar o comando `minikube tunnel`;
  2. Executar o comando `kubectl get svc -n nginx -ingress`;
  3. Verificar o IP Externo do service e acessar a aplicação utilizando o mesmo;

</details>

<details>
  <summary style="background-color: #086dd7b0; border-radius: 5px; font-size: 15px; padding-left: 6px; font-weight: bold;">Subindo aplicação em Cluster EKS</summary>
  <br>
  
  1. Certificar que o Terraform esteja instalado;
  2. Certificar que o `aws cli` está instalado e configurado com as credenciais da sua conta AWS;
  3. Acessar a pasta `infra/eks/cluster` que contém os arquivos que irão criar um Cluster EKS e Work Nodes na AWS;
  4. Inicializar o Terraform no projeto `terraform init`;
  5. Verificar que o script do Terraform é valido rodando o comando `terraform validate`;
  6. Executar o comando `terraform plan` para executar o planejamento da execução/implementação;
  7. Executar o comando `terraform apply` para criar a infra dentro do cluster;
  8. Após a execução do Terraform finalizar, verificar se o cluster e os nodes foram inicializados na AWS;
  9. Acessar a pasta `infra/eks/infra` que contém os arquivos que irão criar os Pods da aplicação e do Banco de Dados, os services e os recursos relacionados à monitoração na AWS;
  10. Inicializar o Terraform no projeto `terraform init`;
  11. Verificar que o script do Terraform é valido rodando o comando `terraform validate`;
  12. Executar o comando `terraform plan` para executar o planejamento da execução/implementação;
  13. Executar o comando `terraform apply` para criar a infra dentro do cluster;

  Para acessar a aplicação, basta acessar o serviço Load Balancer na AWS, copiar o DNS do load balancer que foi criado e acessar as rotas da aplicação utilizando o DNS gerado.
</details>

### 🛒 Integração Checkout (Mercado Pago)

Nessa fase do projeto, integramos o Checkout com a API do Mercado Pago possibilitando o pagamento com o QR Code dinâmico.

Para que possa seja criado o QR Code, deverá ser criado um pedido (POST) `v1/orders`. //todo

### 📄 Documentação da API

Link para acessar ao swagger após subir a aplicação:

```bash
# Ambiente Local
http://localhost:8357/api/swagger-ui/index.html

# Ambiente EKS
rota-do-load-balancer/api/swagger-ui/index.html
```

### Adicionar Desenhos

### Adicionar Diagramas

### 🎲 Seeds

Para facilitar o consumo e os testes da aplicação, seeds de dados foram criadas e gerenciadas utilizando o `Flyway`. 
Essas seeds são aplicadas automaticamente ao iniciar a aplicação, garantindo um ambiente consistente e pronto para uso.

### 📚 MIRO - Event Storming

![Event Storming](./assets/event_storming.png)

Acesso ao MIRO com o Event Storming:
[Event Storming](https://miro.com/app/board/uXjVK1ekBDM=/)
