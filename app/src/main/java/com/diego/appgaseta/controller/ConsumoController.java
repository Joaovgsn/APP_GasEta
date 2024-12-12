package com.diego.appgaseta.controller;



import android.content.SharedPreferences;
import android.util.Log;
import android.widget.EditText;

import com.diego.appgaseta.model.Combustivel;
import com.diego.appgaseta.view.MainActivity;


public class ConsumoController {

    SharedPreferences preferences;

    public static final String NONE_PREFERENCES = "pref_combustivel";

    SharedPreferences.Editor combTop;


    public void consumoController(MainActivity mainActivity){
        preferences = mainActivity.getSharedPreferences(NONE_PREFERENCES, 0);
        combTop = preferences.edit();

    }

    public void salvar(Combustivel combustivel) {
        Log.d("MVC_Controller", "Salvo: " + combustivel.toString());

        combTop.putString("Etanol", String.valueOf(combustivel.getEtanol()));
        combTop.putString("Gasolina", String.valueOf(combustivel.getGasolina()));
        combTop.putString("Resultado", combustivel.getResultado());
        combTop.apply();
    }

    public void limpar() {
        combTop.clear();
        combTop.apply();
    }

    public Combustivel buscar(Combustivel combustivel) {
        combustivel.setEtanol(Double.valueOf(preferences.getString("Etanol", "0.0")));
        combustivel.setGasolina(Double.valueOf(preferences.getString("Gasolina", "0.0")));
        combustivel.setResultado(preferences.getString("Resultado", ""));
        return combustivel;
    }

    public void calCombustivel(Combustivel combustivel, EditText edit_resultado) {
        try {
            double gasolina = combustivel.getGasolina();
            double etanol = combustivel.getEtanol();

            if (gasolina <= 0 || etanol <= 0) {
                edit_resultado.setText("Valores inválidos.");
                return;
            }

            Log.d("ConsumoController", "Gasolina: " + gasolina + ", Etanol: " + etanol);

            double limiteEtanol = gasolina * 0.7;

            if (etanol <= limiteEtanol) {
                combustivel.setResultado("Etanol é mais vantajoso");
            } else {
                combustivel.setResultado("Gasolina é mais vantajosa");
            }

            edit_resultado.setText(combustivel.getResultado());

        } catch (Exception e) {
            Log.e("ConsumoController", "Erro ao calcular: ", e);
            edit_resultado.setText("Erro ao calcular.");
        }
    }
}
