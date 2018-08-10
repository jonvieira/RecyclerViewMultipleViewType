package com.athos.recyclerviewwithheader.Model;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DeserializeModel {

    public static final int PAI = 0;
    public static final int FILHO = 1;

    @SerializedName("posicao")
    @Expose
    private String posicao;
    @SerializedName("jogadores")
    @Expose
    private List<Jogadores> jogadores = null;

    public String getPosicao() {
        return posicao;
    }

    public void setPosicao(String posicao) {
        this.posicao = posicao;
    }

    public List<Jogadores> getJogadores() {
        return jogadores;
    }

    public void setJogadores(List<Jogadores> jogadores) {
        this.jogadores = jogadores;
    }

    public class Jogadores {

        @SerializedName("nome")
        @Expose
        private String nome;
        @SerializedName("time")
        @Expose
        private String time;
        @SerializedName("idade")
        @Expose
        private Integer idade;

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public Integer getIdade() {
            return idade;
        }

        public void setIdade(Integer idade) {
            this.idade = idade;
        }
    }
}
