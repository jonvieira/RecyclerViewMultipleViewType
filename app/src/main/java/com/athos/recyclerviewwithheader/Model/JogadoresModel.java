package com.athos.recyclerviewwithheader.Model;

public class JogadoresModel {

    private String mNome;
    private String mTime;
    private int mIdade;
    private int mTipo;

    public JogadoresModel(String mNome, String mTime, int mIdade, int mTipo) {
        this.mNome = mNome;
        this.mTime = mTime;
        this.mIdade = mIdade;
        this.mTipo = mTipo;
    }

    public String getmNome() {
        return mNome;
    }

    public void setmNome(String mNome) {
        this.mNome = mNome;
    }

    public String getmTime() {
        return mTime;
    }

    public void setmTime(String mTime) {
        this.mTime = mTime;
    }

    public int getmIdade() {
        return mIdade;
    }

    public void setmIdade(int mIdade) {
        this.mIdade = mIdade;
    }

    public int getmTipo() {
        return mTipo;
    }

    public void setmTipo(int mTipo) {
        this.mTipo = mTipo;
    }
}
