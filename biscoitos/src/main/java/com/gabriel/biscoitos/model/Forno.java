package com.gabriel.biscoitos.model;

import com.gabriel.biscoitos.exception.FornoVazioException;
import com.gabriel.biscoitos.model.enums.Categoria;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Forno implements Runnable {

    List<Biscoito> historico;
    Biscoito biscoitoEmPreparo;

    public Forno() {
        historico = new ArrayList<>();
        biscoitoEmPreparo = null;
    }

    public boolean estaVazio() {
        return biscoitoEmPreparo == null;
    }

    public void adicionarBiscoito(Biscoito biscoito){

    }

    public void prepararBiscoito() throws FornoVazioException {
        if( this.estaVazio() )
            throw new FornoVazioException();

//        biscoitoEmPreparo.start();

    }

    public void limparForno() throws FornoVazioException {
        if( this.estaVazio() )
            throw new FornoVazioException();

        historico.add(biscoitoEmPreparo);
        biscoitoEmPreparo = null;
    }

    @Override
    public void run() {

    }
}
