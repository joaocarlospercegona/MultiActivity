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

        TextView outputName = findViewById(R.id.outName);
        TextView outputMedia = findViewById(R.id.outMedia);
        TextView outputStatus = findViewById(R.id.outStatus);

        Intent it = getIntent();
        if(it != null){
            Bundle params = it.getExtras();
            if(params != null){
                String nome = params.getString("nome");
                Double n1 = params.getDouble("n1");
                Double n2 = params.getDouble("n2");
                int freq = params.getInt("freq");

                Double media = (n1 + n2)/2;
                String status = situacaoFinal(media, freq);

                outputMedia.setText(media.toString());
                outputName.setText(nome);
                outputStatus.setText(status);
            }
        }
    }

    public String situacaoFinal(Double media, int freq){
        String situacao = "";
        if(freq < 75)
            situacao = "Aluno Reprovado por Frequência independente da Nota";
        else if(media < 4)
            situacao = "Aluno Reprovado por Nota independente da Frequência";
        else if(freq >= 75){
            if(media >= 4 && media < 7)
                situacao = "Aluno em Final";
            else if(media >= 7)
                situacao = "Aluno Aprovado";
            else
                situacao = "Aluno Reprovado por Nota";
        }
        return situacao;
    }
}