# Bot de Previsão do Tempo e Alertas de Emergência

Este é um projeto de bot para Telegram desenvolvido em Java com Spring Boot. O bot fornece informações meteorológicas e alertas de emergência para diferentes cidades.

## Como usar

### 1. Configuração do ambiente de desenvolvimento

- Certifique-se de ter o Java JDK instalado em sua máquina.
- Instale o Maven para gerenciamento de dependências.
- Clone este repositório Git em sua máquina local.

### 2. Configuração do bot no Telegram

- Crie um novo bot no Telegram conversando com o BotFather.
- Obtenha o token do bot fornecido pelo BotFather.
- Substitua o token no arquivo `BotTelegram.java` na linha `getBotToken()`.

### 3. Executando o projeto

- Abra o terminal na raiz do projeto.
- Execute o comando `mvn spring-boot:run` para iniciar o aplicativo.

### 4. Interagindo com o bot

- No Telegram, encontre o bot pesquisando pelo nome de usuário definido (`SOSClimaRS_bot`).
- Envie o comando `/start` para receber instruções sobre como usar o bot.
- Use os comandos `/clima {cidade}` e `/alerta {cidade}` para obter informações meteorológicas e alertas de emergência, respectivamente.

## Estrutura do projeto

O projeto está estruturado da seguinte forma:

- **model:** Contém a classe `RespostaClima`, que representa a resposta da API de previsão do tempo.
- **service:** Contém as classes `ServicoClima` e `ServicoAlerta`, responsáveis por fazer chamadas às APIs de previsão do tempo e alerta de emergência, respectivamente.
- **bot:** Contém a classe `BotTelegram`, que implementa o bot do Telegram e processa as mensagens recebidas.
- **main:** Contém a classe principal `AplicacaoBot`, responsável por iniciar a aplicação Spring Boot.

## Tecnologias utilizadas

- Java
- Spring Boot
- TelegramBots
- Jackson

## Contribuindo

Contribuições são bem-vindas! Sinta-se à vontade para abrir problemas (issues) ou enviar solicitações de recebimento (pull requests) para melhorar o projeto.
