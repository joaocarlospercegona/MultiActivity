package com.example.multi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent it = getIntent();
        if(it != null){
            Bundle params = it.getExtras();
            if(params != null){
                String nome = params.getString("nome");
                Double nota1 = params.getDouble("nota1");
                Double nota2 = params.getDouble("nota2");
                int freq = params.getInt("freq");
                Double notaF = (nota1 + nota2)/2;
                String retorno = recebe(notaF, freq);
                TextView outputName = findViewById(R.id.outName);
                TextView outputMedia = findViewById(R.id.outMedia);
                TextView outputStatus = findViewById(R.id.outStatus);
                outputMedia.setText(notaF.toString());
                outputName.setText(nome);
                outputStatus.setText(retorno);
            }
        }
    }

    public String recebe(Double notaF, int freq){
        String ret = "";
        if(freq < 75){
            ret = "Reprovado por Frequência independente da nota";
        }

        else if(notaF < 4){
            ret = "Reprovado por Nota independente da Frequência";
        }
        else if(freq >= 75){
            if(notaF >= 4 && notaF < 7){
                ret = "Aluno em Final";
            }
            else if(notaF >= 7){
                ret = "Aprovado";
            }
            else{
                ret = "Reprovado por Nota";
            }
        }
        return ret;
    }
}