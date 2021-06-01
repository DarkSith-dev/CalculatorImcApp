package com.example.imc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText etAltura;
    EditText etPeso;
    Button btCalcular;
    TextView tvImc;
    TextView tvSituacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etAltura = findViewById(R.id.etAltura);
        etPeso = findViewById(R.id.etPeso);
        btCalcular = findViewById(R.id.btCalcular);
        tvImc = findViewById(R.id.tvImc);
        tvSituacao = findViewById(R.id.tvSituacao);
    }

    public void calcularImc (View view){

        double imc, peso, altura;

        peso = Double.parseDouble( etPeso.getText().toString() );
        altura = Double.parseDouble( etAltura.getText().toString() );

        imc = peso / (altura * altura);

        tvImc.setText("IMC:" + imc);
        tvSituacao.setText(apontarSituacao(imc));

        etAltura.setText("");
        etPeso.setText("");

        minizaTeclado(btCalcular);

    }//fim do calculo

    public String apontarSituacao (double imc) {

         String situacao = "Situação: ";


        //logica id e else encadeada


        if (imc < 18.5) {
            situacao += "Abaixo do peso";
        } else {
            if (imc < 25) {
                situacao += "Peso normal";
            } else {
                if (imc < 30) {
                    situacao += "Sobrepeso";
                } else {
                    if (imc < 35) {
                        situacao += "Obesidade grau 1";
                    } else {
                        if (imc < 40) {
                            situacao += "Obesidade grau 2";
                        } else {
                            situacao += "Obesidade grau 3";

                        }

                    }

                }

            }

        }
        return situacao;

    }//fim do apontarSituação

    public void minizaTeclado(Button button){
        InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(button.getWindowToken(),0 );
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
    }//FIM DO MINItECLADO

}