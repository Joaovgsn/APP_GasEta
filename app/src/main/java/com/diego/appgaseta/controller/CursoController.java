package com.diego.appgaseta.controller;

import com.diego.appgaseta.model.Curso;

import java.util.ArrayList;
import java.util.List;

public class CursoController {

    private List listCursos;

    public List getListCursos() {
        listCursos = new ArrayList<Curso>();
        listCursos.add(new Curso("JAVA"));
        listCursos.add(new Curso("PYTHON"));
        listCursos.add(new Curso("C#"));
        listCursos.add(new Curso("C"));
        listCursos.add(new Curso("KOTLIN"));

        return listCursos;
    }

    public ArrayList<String> dadosSpinner() {
        ArrayList<String> dados = new ArrayList<>();

        for (int i = 0; i < getListCursos().size(); i++){
            Curso objeto = (Curso) getListCursos().get(i);
            dados.add(objeto.getCursoDesejado());

    }
    return dados;
    }
}
