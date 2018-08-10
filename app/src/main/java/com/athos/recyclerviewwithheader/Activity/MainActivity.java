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
    String strings = "[ { \"posicao\": \"GOLEIROS\", \"jogadores\": [ { \"nome\": \"Roberto dos Anjos\", \"time\": \"São Paulo F.C\", \"idade\": 28 }, { \"nome\": \"Roberto dos Anjos\", \"time\": \"São Paulo F.C\", \"idade\": 28 } ] }, { \"posicao\": \"ZAGUEIROS\", \"jogadores\": [ { \"nome\": \"Roberto dos Anjos\", \"time\": \"São Paulo F.C\", \"idade\": 28 }, { \"nome\": \"Roberto dos Anjos\", \"time\": \"São Paulo F.C\", \"idade\": 28 } ] }, { \"posicao\": \"LATERAIS ESQUERDOS\", \"jogadores\": [ { \"nome\": \"Roberto dos Anjos\", \"time\": \"São Paulo F.C\", \"idade\": 28 }, { \"nome\": \"Roberto dos Anjos\", \"time\": \"São Paulo F.C\", \"idade\": 28 } ] }, { \"posicao\": \"LATERAIS DIREITOS\", \"jogadores\": [ { \"nome\": \"Roberto dos Anjos\", \"time\": \"São Paulo F.C\", \"idade\": 28 }, { \"nome\": \"Roberto dos Anjos\", \"time\": \"São Paulo F.C\", \"idade\": 28 } ] }, { \"posicao\": \"VOLANTES\", \"jogadores\": [ { \"nome\": \"Roberto dos Anjos\", \"time\": \"São Paulo F.C\", \"idade\": 28 }, { \"nome\": \"Roberto dos Anjos\", \"time\": \"São Paulo F.C\", \"idade\": 28 } ] }, { \"posicao\": \"MEIO-CAMPO\", \"jogadores\": [ { \"nome\": \"Roberto dos Anjos\", \"time\": \"São Paulo F.C\", \"idade\": 28 }, { \"nome\": \"Roberto dos Anjos\", \"time\": \"São Paulo F.C\", \"idade\": 28 } ] }, { \"posicao\": \"ATACANTES\", \"jogadores\": [ { \"nome\": \"Roberto dos Anjos\", \"time\": \"São Paulo F.C\", \"idade\": 28 }, { \"nome\": \"Roberto dos Anjos\", \"time\": \"São Paulo F.C\", \"idade\": 28 } ] } ]";

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
