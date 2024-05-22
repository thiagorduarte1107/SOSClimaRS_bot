package com.example.bot.bot.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ServicoAlerta {

    private static final String URL_API_INMET = "https://apiprevmet3.inmet.gov.br/alerta/";

    public String obterAlertas(String cidade) {
        RestTemplate restTemplate = new RestTemplate();
        String url = URL_API_INMET + cidade;
        String resposta = restTemplate.getForObject(url, String.class);

        String alertasFormatados = parseAndFormatAlerts(resposta);

        return alertasFormatados;
    }

    private String parseAndFormatAlerts(String resposta) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(resposta);
            StringBuilder alertas = new StringBuilder("Alertas de emergência:\n");

            for (JsonNode alertaNode : rootNode.path("data")) {
                String tipo = alertaNode.path("codalerta").asText();
                String descricao = alertaNode.path("descricao").asText();
                String data = alertaNode.path("dataevento").asText();

                alertas.append("Tipo: ").append(tipo).append("\n")
                        .append("Descrição: ").append(descricao).append("\n")
                        .append("Data: ").append(data).append("\n\n");
            }

            return alertas.toString();

        } catch (Exception e) {
            e.printStackTrace();
            return "Não foi possível obter os alertas de emergência.";
        }
    }
}
