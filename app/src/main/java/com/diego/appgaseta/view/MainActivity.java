package com.diego.appgaseta.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.diego.appgaseta.R;
import com.diego.appgaseta.controller.ConsumoController;
import com.diego.appgaseta.model.Combustivel;

public class MainActivity extends AppCompatActivity {


    ConsumoController consumoController;
    Combustivel combustivel;
    EditText edit_gasolina;
    EditText edit_etanol;
    EditText edit_resultado;

    Button btn_limpar;
    Button btn_finalizar;
    Button btn_salvar;
    Button btn_calcular;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gaseta);


        combustivel = new Combustivel();

        consumoController = new ConsumoController();

        consumoController.consumoController(this);

        combustivel = consumoController.buscar(combustivel);

        edit_gasolina = findViewById(R.id.edit_gasolina);
        edit_etanol= findViewById(R.id.edit_etanol);
        edit_resultado = findViewById(R.id.edit_resultado);

        edit_gasolina.setText(String.valueOf(combustivel.getGasolina()));
        edit_etanol.setText(String.valueOf(combustivel.getEtanol()));
        edit_resultado.setText(combustivel.getResultado());

        btn_limpar = findViewById(R.id.btn_limpar);
        btn_salvar = findViewById(R.id.btn_salvar);
        btn_finalizar = findViewById(R.id.btn_finalizar);
        btn_calcular = findViewById(R.id.btn_calcular);


        btn_calcular.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                consumoController.calCombustivel(combustivel, edit_resultado);
            }
        }));

        btn_limpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edit_etanol.setText("");
                edit_gasolina.setText("");
                edit_resultado.setText("");

                consumoController.limpar();
            }
        });

        btn_finalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,
                        "Volte Sempre",
                        Toast.LENGTH_LONG).show();
                finish();
            }
        });

        btn_salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Double etanol = Double.valueOf(edit_etanol.getText().toString());
                    Double gasolina = Double.valueOf(edit_gasolina.getText().toString());

                    combustivel.setEtanol(etanol);
                    combustivel.setGasolina(gasolina);
                    combustivel.setResultado(edit_resultado.getText().toString());

                    Toast.makeText(MainActivity.this, "Salvo: " + combustivel.toString(), Toast.LENGTH_LONG).show();
                    consumoController.salvar(combustivel);
                } catch (NumberFormatException e) {
                    Toast.makeText(MainActivity.this, "Por favor, insira valores válidos", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

}