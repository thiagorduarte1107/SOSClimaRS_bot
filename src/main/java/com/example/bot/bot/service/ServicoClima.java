package com.example.bot.bot.service;

import com.example.bot.bot.model.RespostaClima;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ServicoClima {

    private static final String URL_API_CLIMA = "https://goweather.herokuapp.com/weather/";

    public String obterClima(String cidade) {
        String url = URL_API_CLIMA + cidade;
        RestTemplate restTemplate = new RestTemplate();
        RespostaClima respostaClima = restTemplate.getForObject(url, RespostaClima.class);

        if (respostaClima != null) {
            return "Previsão do tempo para " + cidade + ":\n" +
                    "Temperatura: " + respostaClima.getTemperatura() + "\n" +
                    "Descrição: " + respostaClima.getDescricao() + "\n" +
                    "Vento: " + respostaClima.getVento();
        } else {
            return "Não foi possível obter dados meteorológicos.";
        }
    }
}
