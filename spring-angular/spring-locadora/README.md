# spring-locadora
API REST simples feita em Java Spring Boot e Maven.
Projeto: Aplicação Web para simular um sistema de cadastro de vídeos em uma video-locadora.

## requisitos:

Criar uma Rest API "Video Locadora" utilizando os contâiners:

    Controllers
    Dtos
    Models
    Repositories
    Services

Abstrair o conceito de uma locação de filme e permitir: 
post, get, delete e put. Utilize as dependências:

    JpaRepository
    Validation
    PostgreSql
    SpringWeb

# requisitos (parte 2):

Adcionar um micro-serviço de email no sistema de locadora.
Ele deve enviar um email para o cliente no momento da locação do vídeo.

Assunto do email:
    Locação do vídeo "nome do vídeo"

Conteúdo do email: 
    Ola, dono(a) do email "email da pessoa", o vídeo "nome do vídeo" foi alugado no dia "data e hora da locação".