package com.company;

public class KonbelaFactory {

    private int type;

    public int rand() {
        return (int) (Math.random() * 2 + 1);
    }

    public Konbela getKonbela() {
        type = rand();
        if (rand()==2)
            return new KonbelaBOM();
        else
            return new KonbelaBOMBOM();
    }

}
