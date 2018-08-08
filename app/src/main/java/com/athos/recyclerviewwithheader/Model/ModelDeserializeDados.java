package com.athos.recyclerviewwithheader.Model;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ModelDeserializeDados {

    public static final int PAI = 0;
    public static final int FILHO = 1;


    @SerializedName("familia")
    @Expose
    private String familia;
    @SerializedName("patrimonios")
    @Expose
    private List<Patrimonio> patrimonios = null;

    public ModelDeserializeDados(String familia, List<Patrimonio> patrimonios, int Type) {
        this.familia = familia;
        this.patrimonios = patrimonios;

    }

    public String getFamilia() {
        return familia;
    }

    public void setFamilia(String familia) {
        this.familia = familia;
    }

    public List<Patrimonio> getPatrimonios() {
        return patrimonios;
    }

    public void setPatrimonios(List<Patrimonio> patrimonios) {
        this.patrimonios = patrimonios;
    }


    public class Patrimonio {

        @SerializedName("descricao")
        @Expose
        private String descricao;
        @SerializedName("controle")
        @Expose
        private String controle;
        @SerializedName("quantidade")
        @Expose
        private Integer quantidade;

        public String getDescricao() {
            return descricao;
        }

        public void setDescricao(String descricao) {
            this.descricao = descricao;
        }

        public String getControle() {
            return controle;
        }

        public void setControle(String controle) {
            this.controle = controle;
        }

        public Integer getQuantidade() {
            return quantidade;
        }

        public void setQuantidade(Integer quantidade) {
            this.quantidade = quantidade;
        }
    }
}