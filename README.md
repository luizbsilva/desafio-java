# Introduction 
TODO: Projeto para Avalição para a vaga de Dev SR na NT Consult. 

# Getting Started
1. Installation process
   1. apos clonar o projeto navegar a te a pasta desafio-java
      1. e no terminar executar o seguinte comando `./gradlew build`
2. Software dependencies
   1. Navegar a Pasta desafio-java/devops/docker-compose e executar o seguinte comando
      1. `docker-compose up `
3. Config RabbitMR
   1. ir na URL: - [RabbitMQ](http://localhost:15672/)
      1. acessar usando a seguinte credencial
            - usuario: guest
            - passwor: guest
      2. configurar a queues com o seguinte nome:
         - `desafio-globo`
      3. Configurar a exchanges com o seguinte nome:
         - `desafio-java`
      4. Fazer o bindings da exchanges com a queues
         - ir em exchanges selecionar a exchanges : `desafio-java`
         - ir em Bindings
           - em TO queue colocar: `desafio-globo`
           - em Routing key: adicionar `routing-desafio-globo`

4. Executando a aplicação
   1. no terminar acessar {CANMINHO_DO_PROJETO}/desafio-java/devops
      1. `docker build -t desafio_java .` para gerar o container doker da aplicação
      2. `docker run desafio_java` para executar o container docker
