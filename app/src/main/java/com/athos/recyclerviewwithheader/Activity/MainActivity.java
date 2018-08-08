package com.athos.recyclerviewwithheader.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;

import com.athos.recyclerviewwithheader.Helper.Dados;
import com.athos.recyclerviewwithheader.Model.ModelDeserializeDados;
import com.athos.recyclerviewwithheader.R;
import com.athos.recyclerviewwithheader.Adapter.RecyclerAdapter;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<ModelDeserializeDados> mDadosReferencia;
    String strings = "[ { \"familia\": \"OUTROS\", \"patrimonios\": [ { \"descricao\": \"ABAJOUR / ABAJUR\", \"controle\": \"controle1\", \"quantidade\": 2 }, { \"descricao\": \"ASSENTO SANITÁRIO\", \"controle\": \"controle1\", \"quantidade\": 0 } ] }, { \"familia\": \"ÁREA INFANTIL\", \"patrimonios\": [ { \"descricao\": \"BRINQUEDO : BALANÇA\", \"controle\": \"controle1\", \"quantidade\": 0 }, { \"descricao\": \"BRINQUEDO : ESCORREGADOR\", \"controle\": \"controle1\", \"quantidade\": 0 } ] }, { \"familia\": \"BATERIA\", \"patrimonios\": [ { \"descricao\": \"BATERIA DA ILUMINAÇÃO DE EMERGÊNCIA\", \"controle\": \"controle1\", \"quantidade\": 0 } ] }, { \"familia\": \"BEBEDOURO\", \"patrimonios\": [ { \"descricao\": \"BEBEDOURO\", \"controle\": \"controle1\", \"quantidade\": 0 } ] }, { \"familia\": \"CHAVES\", \"patrimonios\": [ { \"descricao\": \"QUADRO DE CHAVES ( CLAVICULÁRIO )\", \"controle\": \"controle1\", \"quantidade\": 0 } ] }, { \"familia\": \"DETECTOR\", \"patrimonios\": [ { \"descricao\": \"DETECTOR DE FUMAÇA\", \"controle\": \"controle1\", \"quantidade\": 0 } ] }, { \"familia\": \"ILUMINAÇÃO\", \"patrimonios\": [ { \"descricao\": \"LUMINÁRIA DE EMERGÊNCIA\", \"controle\": \"controle1\", \"quantidade\": 0 } ] }, { \"familia\": \"LIXEIRA\", \"patrimonios\": [ { \"descricao\": \"LIXEIRA\", \"controle\": \"controle1\", \"quantidade\": 0 } ] }, { \"familia\": \"ORNAMENTO\", \"patrimonios\": [ { \"descricao\": \"QUADRO DECORATIVO\", \"controle\": \"controle1\", \"quantidade\": 0 } ] }, { \"familia\": \"QUADRO DE COMANDO\", \"patrimonios\": [ { \"descricao\": \"QUADRO DO DETECTOR DE FUMAÇA\", \"controle\": \"controle1\", \"quantidade\": 0 } ] }, { \"familia\": \"SENSOR\", \"patrimonios\": [ { \"descricao\": \"SENSOR DE INFRAVERMELHO\", \"controle\": \"controle1\", \"quantidade\": 0 } ] } ]";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();

        //Se o titulo do header vier pela API
        deserialize();

        RecyclerAdapter adapter = new RecyclerAdapter(Dados.getData(mDadosReferencia));

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, OrientationHelper.VERTICAL, false);
        RecyclerView mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(adapter);
    }

    private void deserialize() {
        Type mTypeList = new TypeToken<ArrayList<ModelDeserializeDados>>() {
        }.getType();
        mDadosReferencia = new Gson().fromJson(strings, mTypeList);
    }
}
