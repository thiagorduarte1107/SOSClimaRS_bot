package com.example.bot.bot;

import com.example.bot.bot.service.ServicoAlerta;
import com.example.bot.bot.service.ServicoClima;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class BotTelegram extends TelegramLongPollingBot {

    private static final Logger logger = LoggerFactory.getLogger(BotTelegram.class);

    @Autowired
    private ServicoClima servicoClima;

    @Autowired
    private ServicoAlerta servicoAlerta;

    @Override
    public String getBotUsername() {
        return "SOSClimaRS_bot";
    }

    @Override
    public String getBotToken() {
        return "7097948903:AAEdfBEaJjbCiPAU-V_sTbsGktK0NTrggVc";
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String mensagemTexto = update.getMessage().getText();
            String chatId = update.getMessage().getChatId().toString();

            logger.info("Mensagem recebida: {}", mensagemTexto);

            String resposta;
            if (mensagemTexto.equals("/start")) {
                resposta = "Olá! Eu sou um bot de previsão do tempo e alertas de emergência.\n" +
                        "Você pode usar os seguintes comandos:\n" +
                        "/clima {cidade} - Para obter informações meteorológicas de uma cidade.\n" +
                        "/alerta {cidade} - Para receber alertas de emergência de uma cidade.";
            } else if (mensagemTexto.startsWith("/clima")) {
                String cidade = mensagemTexto.replace("/clima", "").trim();
                resposta = servicoClima.obterClima(cidade);
            } else if (mensagemTexto.startsWith("/alerta")) {
                String cidade = mensagemTexto.replace("/alerta", "").trim();
                resposta = servicoAlerta.obterAlertas(cidade);
            } else {
                resposta = "Comando não reconhecido. Use /clima {cidade} para obter informações meteorológicas ou /alerta {cidade} para alertas de emergência.";
            }

            SendMessage mensagem = new SendMessage();
            mensagem.setChatId(chatId);
            mensagem.setText(resposta);

            try {
                execute(mensagem);
            } catch (TelegramApiException e) {
                logger.error("Erro ao enviar mensagem: {}", e.getMessage());
                e.printStackTrace();
            }
        }
    }
}
