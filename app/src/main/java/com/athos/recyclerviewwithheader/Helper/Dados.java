package com.athos.recyclerviewwithheader.Helper;

import com.athos.recyclerviewwithheader.Model.ModelDados;
import com.athos.recyclerviewwithheader.Model.ModelDeserializeDados;

import java.util.ArrayList;
import java.util.List;

public final class Dados {

    public static List<ModelDados> getData(List<ModelDeserializeDados> mDadosReferencia) {
        List<ModelDados> list = new ArrayList<>();

        for (int posPai = 0; posPai < mDadosReferencia.size(); posPai++) {
            String pai = mDadosReferencia.get(posPai).getFamilia();
            list.add(new ModelDados(pai, null, ModelDeserializeDados.PAI));

            for (int posFilho = 0; posFilho < mDadosReferencia.get(posPai).getPatrimonios().size(); posFilho++) {
                String filho = mDadosReferencia.get(posPai).getPatrimonios().get(posFilho).getDescricao();
                list.add(new ModelDados(filho, null, ModelDeserializeDados.FILHO));
            }
        }
        return list;
    }
}
