# Guia de Inicialização do Projeto

Este documento descreve como iniciar o projeto **website-gamux** em modo de desenvolvimeto usando Docker Compose.

## Pré-requisitos

Antes de começar, certifique-se de que você tem os seguintes programas instalados:

- **Docker** (versão 20.10 ou superior)
- **Docker Compose** (versão 1.29 ou superior)
- **Git** (para clonar o repositório)

## Configuração Inicial

### 1. Clonar o Repositório

```bash
git clone https://github.com/FelipeFernandesAlves/website-gamux.git
cd website
```

### 2. Configurar Variáveis de Ambiente

Para o ambiente de desenvolvimento, você precisa criar um arquivo `.env.dev` na raiz do projeto:

```bash
cp .env.example .env.dev
```

Edite o arquivo `.env.dev` e configure as variáveis necessárias para seu ambiente de desenvolvimento. As variáveis usadas pelo projeto estão em `.env.example`

## Iniciando o Projeto

Para iniciar todos os serviços do projeto em modo de desenvolvimento, execute o seguinte comando na raiz do projeto:

```bash
docker compose -f .\compose.dev.yml --env-file .\.env.dev up --build
```

### Explicação do Comando

- `docker compose`: Ferramenta para orquestrar múltiplos containers
- `-f .\compose.dev.yml`: Especifica o arquivo de composição para desenvolvimento
- `--env-file .\.env.dev`: Carrega as variáveis de ambiente do arquivo `.env.dev`
- `up`: Cria e inicia os containers
- `--build`: Reconstrói as imagens Docker antes de iniciar (garante que as últimas mudanças sejam consideradas)

## Serviços Iniciados

Quando você executa o comando acima, os seguintes serviços são iniciados:

### Backend

- **URL**: `http://localhost:8080`
- **Tecnologia**: Spring Boot
- **Dockerfile**: `Dockerfile.dev` na pasta `backend`
- **Volumes**: O código-fonte está mapeado para recompilação automática
- **Porta**: 8080

### Frontend

- **URL**: `http://localhost:5173`
- **Tecnologia**: Vite
- **Dockerfile**: `Dockerfile.dev` na pasta `frontend`
- **Volumes**: O código-fonte está mapeado para hot-reload automático
- **Porta**: 5173

### Nginx

- **Imagem**: `nginx:alpine`
- **Portas**: 80, 443

### Postgres

- **Imagem**: `postgres:16-alpine`
- **Portas**: 5432

## Volumes

- **pgdata**: Guarda os dados do banco de dados.
- **image-data**: Guarda as imagens salvas pelo backend.

## Acessando os Serviços

Após a execução bem-sucedida do comando, você pode acessar:

- **Frontend**: [http://localhost](http://localhost)
- **Backend (API)**: [http://localhost/api](http://localhost/api)

## Parando os Serviços

Para parar todos os containers, execute:

```bash
docker compose -f .\compose.dev.yml down
```

Para parar e remover todos os volumes (dados persistentes):

```bash
docker compose -f .\compose.dev.yml down -v
```

## Logs dos Serviços

Para visualizar os logs de todos os serviços em tempo real:

```bash
docker compose -f .\compose.dev.yml logs -f
```
