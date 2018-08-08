package com.athos.recyclerviewwithheader.Model;

public class ModelDados {

    private String mName;

    private String mDescription;

    private int mType;

    public ModelDados(String name, String description, int type) {
        this.mName = name;
        this.mDescription = description;
        this.mType = type;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        this.mName = name;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        this.mDescription = description;
    }

    public int getType() {
        return mType;
    }

    public void setType(int type) {
        this.mType = type;
    }
}