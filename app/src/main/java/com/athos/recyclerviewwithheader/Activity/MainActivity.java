package com.athos.recyclerviewwithheader.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import com.athos.recyclerviewwithheader.Helper.Dados;
import com.athos.recyclerviewwithheader.Model.DeserializeModel;
import com.athos.recyclerviewwithheader.R;
import com.athos.recyclerviewwithheader.Adapter.RecyclerAdapter;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    RecyclerView.LayoutManager layoutManager;
    List<DeserializeModel> mDados;
    String strings = "[ { \"posicao\":\"GOLEIROS\", \"jogadores\":[ { \"nome\":\"Alisson\", \"time\":\"Roma-ITA\", \"idade\":25 }, { \"nome\":\"Cássio\", \"time\":\"Corinthians-BRA\", \"idade\":31 }, { \"nome\":\"Ederson\", \"time\":\"Manchester City-ING\", \"idade\":24 } ] }, { \"posicao\":\"ZAGUEIROS\", \"jogadores\":[ { \"nome\":\"Thiago Silva\", \"time\":\"Paris Saint-Germain-FRA\", \"idade\":33 }, { \"nome\":\"Miranda\", \"time\":\"Internazionale-ITA\", \"idade\":33 }, { \"nome\":\"Geromel\", \"time\":\"Grêmio-BRA\", \"idade\":32 }, { \"nome\":\"Miranda\", \"time\":\"Internazionale-ITA\", \"idade\":33 }, { \"nome\":\"Marquinhos\", \"time\":\"Paris Saint-Germain-FRA\", \"idade\":24 } ] }, { \"posicao\":\"LATERAIS ESQUERDOS\", \"jogadores\":[ { \"nome\":\"Filipe Luís\", \"time\":\"Atlético de Madri-ESP\", \"idade\":32 }, { \"nome\":\"Marcelo\", \"time\":\"Real Madrid-ESP\", \"idade\":20 } ] }, { \"posicao\":\"LATERAIS DIREITOS\", \"jogadores\":[ { \"nome\":\"Danilo\", \"time\":\"Manchester City-ING\", \"idade\":27 }, { \"nome\":\"Fágner\", \"time\":\"Corinthians-BRA\", \"idade\":28 } ] }, { \"posicao\":\"VOLANTES\", \"jogadores\":[ { \"nome\":\"Casemiro\", \"time\":\"Real Madrid-ESP\", \"idade\":26 }, { \"nome\":\"Paulinho\", \"time\":\"Barcelona-ESP\", \"idade\":29 }, { \"nome\":\"Fernandinho\", \"time\":\"Manchester City-ING\", \"idade\":33 }, { \"nome\":\"Fred\", \"time\":\"Manchester United-ING\", \"idade\":25 } ] }, { \"posicao\":\"MEIO-CAMPO\", \"jogadores\":[ { \"nome\":\"Renato Augusto\", \"time\":\"Beijing Guoan-CHN\", \"idade\":30 }, { \"nome\":\"Philippe Coutinho\", \"time\":\"Barcelona-ESP\", \"idade\":25 }, { \"nome\":\"Willian\", \"time\":\"Chelsea-ING\", \"idade\":29 }, { \"nome\":\"Philippe Coutinho\", \"time\":\"Barcelona-ESP\", \"idade\":25 } ] }, { \"posicao\":\"ATACANTES\", \"jogadores\":[ { \"nome\":\"Douglas Costa\", \"time\":\"Juventus-ITA\", \"idade\":27 }, { \"nome\":\"Gabriel Jesus\", \"time\":\"Manchester City-ING\", \"idade\":21 }, { \"nome\":\"Neymar\", \"time\":\"Paris Saint-Germain-FRA\", \"idade\":26 }, { \"nome\":\"Roberto Firmino\", \"time\":\"Liverpool-ING\", \"idade\":26 }, { \"nome\":\"Taison\", \"time\":\"Shakhtar Donetsk-UCR \", \"idade\":30 } ] } ]";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();

        deserialize();

        RecyclerAdapter adapter = new RecyclerAdapter(Dados.getData(mDados));

        layoutManager = new LinearLayoutManager(this, OrientationHelper.VERTICAL, false);
        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(adapter);
    }

    private void deserialize() {
        Type mTypeList = new TypeToken<ArrayList<DeserializeModel>>() {
        }.getType();
        mDados = new Gson().fromJson(strings, mTypeList);
    }
}
