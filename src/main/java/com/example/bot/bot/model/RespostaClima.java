package com.example.bot.bot.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RespostaClima {

    private String temperatura;
    private String descricao;
    private String vento;

    public String getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(String temperatura) {
        this.temperatura = temperatura;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getVento() {
        return vento;
    }

    public void setVento(String vento) {
        this.vento = vento;
    }
}