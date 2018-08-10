package com.athos.recyclerviewwithheader.Helper;

import com.athos.recyclerviewwithheader.Model.DeserializeModel;
import com.athos.recyclerviewwithheader.Model.JogadoresModel;

import java.util.ArrayList;
import java.util.List;

public final class Dados {

    public static List<JogadoresModel> getData(List<DeserializeModel> mDados) {
        List<JogadoresModel> list = new ArrayList<>();

        for (int posPai = 0; posPai < mDados.size(); posPai++) {
            String posicaoJogador = mDados.get(posPai).getPosicao();
            list.add(new JogadoresModel(posicaoJogador, null, 0, DeserializeModel.PAI));

            for (int posFilho = 0; posFilho < mDados.get(posPai).getJogadores().size(); posFilho++) {
                String nomeJogador = mDados.get(posPai).getJogadores().get(posFilho).getNome();
                String timeJogador = mDados.get(posPai).getJogadores().get(posFilho).getTime();
                int idadeJogador = mDados.get(posPai).getJogadores().get(posFilho).getIdade();
                list.add(new JogadoresModel(nomeJogador, timeJogador, idadeJogador, DeserializeModel.FILHO));
            }
        }
        return list;
    }
}
