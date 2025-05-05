# 🐾 Blackclaw

Blackclaw é um projeto completo que consiste em uma aplicação web front-end construída com React e uma API back-end desenvolvida com Spring Boot, projetada para gerenciar dados relacionados a uma equipe de e-sports.

## 📚 Conteúdo

- [Visão Geral](#visão-geral)
- [Front-end](#-front-end)
  - [Tecnologias Principais](#-tecnologias-principais)
  - [Estrutura do Projeto Front-end](#️-estrutura-do-projeto-front-end)
  - [Instalação e Execução Front-end](#-instalação-e-execução-front-end)
- [API Back-end](#-api-back-end)
  - [Tecnologias Back-end](#tecnologias-utilizadas)
  - [Endpoints da API](#endpoints-da-api)
  - [Estrutura do Projeto API](#estrutura-do-projeto)
  - [Configuração da API](#configuração)
- [Documentação](#documentação-da-api)
- [Licença](#licença)

## Visão Geral

O Blackclaw é um sistema para equipes de e-sports que oferece funcionalidades para gerenciar jogadores, partidas, eventos e outros dados relevantes. O sistema também inclui uma integração com ChatGPT para responder perguntas contextualizadas com os dados do sistema.

---

## 🖥 Front-end

A aplicação front-end é construída com React 19 e Vite 6, projetada para oferecer alta performance, modularidade e uma base sólida para projetos escaláveis.

### 🚀 Tecnologias Principais

| Categoria   | Tecnologias           |
|-------------|------------------------|
| Front-end   | React 19, Vite 6      |
| UI & Ícones | FontAwesome, React Icons |
| Qualidade   | ESLint                |
| Gerenciador | Node.js (npm)         |
| Linguagens  | JavaScript            |

### 🗂️ Estrutura do Projeto Front-end

```
Furia/
└── FrontEnd/
    ├── public/              # Assets públicos (imagens, GIFs, ícones, etc.)
    ├── src/                 # Código-fonte do React
    │   ├── components/      # Componentes reutilizáveis
    │   ├── pages/           # Páginas ou telas
    │   └── App.jsx          # Componente raiz
    ├── index.html           # HTML base
    ├── package.json         # Configurações e scripts
    └── vite.config.js       # Configuração do Vite
```

### 📦 Instalação e Execução Front-end

#### 🔧 Pré-requisitos

- Node.js (v18 ou superior)
- npm ou yarn

#### 💻 Rodando o projeto localmente

```bash
# Clone o repositório
git clone https://github.com/seu-usuario/blackclaw.git
cd Furia/FrontEnd

# Instale as dependências
npm install

# Inicie o servidor de desenvolvimento
npm run dev
```

Acesse a aplicação em: http://localhost:5173

#### 🛠 Scripts Disponíveis

| Script | Ação |
|--------|------|
| `npm run dev` | Inicia o modo de desenvolvimento |
| `npm run build` | Gera a versão de produção |
| `npm run preview` | Pré-visualiza a build |
| `npm run lint` | Executa o ESLint no projeto |

---

## 🔄 API Back-end

### Tecnologias Utilizadas

- Java 17
- Spring Boot 3
  - Spring Web
  - Spring Data JPA
  - Spring WebFlux (para integração com ChatGPT)
- Lombok
- Swagger/OpenAPI (documentação de API)
- Banco de dados relacional (PostgreSQL/MySQL)

### Endpoints da API

#### Chat Integrado

- `POST /api/chat/pergunta` - Envia uma pergunta para ser respondida pelo ChatGPT com base nos dados do sistema

#### Endpoints de Consulta

Todos os endpoints seguem o padrão `GET /contexto/{entidade}`:

| Endpoint | Descrição |
|----------|-----------|
| `/contexto/eventos` | Lista todos os eventos cadastrados |
| `/contexto/faq` | Lista perguntas frequentes |
| `/contexto/jogadores` | Lista todos os jogadores da equipe |
| `/contexto/mapas` | Lista os mapas do jogo |
| `/contexto/partidas` | Lista as partidas realizadas |
| `/contexto/proximosjogos` | Lista os próximos jogos agendados |
| `/contexto/resultados` | Lista resultados das partidas |

### Estrutura do Projeto

O projeto segue a estrutura padrão do Spring Boot com as seguintes camadas principais:

1. **Controller**: Lida com as requisições HTTP
   - Exemplo: `ResultadosController`, `JogadoresController`

2. **Service**: Contém a lógica de negócio
   - Exemplo: `ResultadosService`, `JogadoresService`

3. **Repository**: Interface com o banco de dados
   - Exemplo: `ResultadosRepository`, `JogadoresRepository`

4. **Entity**: Representa as tabelas do banco de dados
   - Exemplo: `Resultados`, `Jogadores`

5. **DTO (Data Transfer Objects)**:
   - Request: Objetos de entrada da API
   - Response: Objetos de saída da API
   - Exemplo: `ResultadosResponse`, `JogadoresResponse`

6. **Mapper**: Converte entre Entities e DTOs
   - Exemplo: `MapasMapper`, `PartidasMapper`

### Configuração

#### Pré-requisitos

- JDK 17
- Maven
- Banco de dados configurado
- Chave da API OpenAI (para o endpoint de chat)

#### Passos para configuração

1. Clone o repositório:
   ```bash
   git clone https://github.com/seu-usuario/blackclaw-api.git
   ```

2. Configure o arquivo `application.yml`:
   ```yaml
   spring:
     datasource:
       url: jdbc:postgresql://localhost:5432/blackclaw
       username: seu-usuario
       password: sua-senha
   openai:
     api-key: sua-chave-openai
   ```

3. Execute a aplicação:
   ```bash
   mvn spring-boot:run
   ```

## Documentação da API

A API está documentada usando Swagger/OpenAPI. Acesse a interface interativa em:

```
http://localhost:8080/swagger-ui.html
```

## Licença

Este projeto está licenciado sob a licença MIT. Consulte o arquivo LICENSE para mais detalhes.
