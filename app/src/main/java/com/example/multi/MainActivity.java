package com.example.multi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void calcula(View view){
        EditText inputName = findViewById(R.id.Name);
        EditText inputNota1 = findViewById(R.id.nota1);
        EditText inputNota2 = findViewById(R.id.nota2);
        EditText inputFreq = findViewById(R.id.frequencia);


        if(inputName.length() == 0){
            Toast.makeText(this, "Informe o Nome!", Toast.LENGTH_SHORT).show();
        }
        else if(inputNota1.length() == 0){
            Toast.makeText(this, "Informe a Nota 1!", Toast.LENGTH_SHORT).show();
        }
        else if(inputNota2.length() == 0){
            Toast.makeText(this, "Informe a Nota 2!", Toast.LENGTH_SHORT).show();
        }
        else if(inputFreq.length() == 0){
            Toast.makeText(this, "Informe a Frequencia!", Toast.LENGTH_SHORT).show();
        }
        else if(Double.parseDouble(inputNota1.getText().toString()) >= 0 && Double.parseDouble(inputNota1.getText().toString()) <= 10 ){
            Toast.makeText(this, "Informe uma nota entre 0 a 10!", Toast.LENGTH_SHORT).show();
        }
        else if(Double.parseDouble(inputNota2.getText().toString()) >= 0 && Double.parseDouble(inputNota2.getText().toString()) <= 10 ){
            Toast.makeText(this, "Informe uma nota entre 0 a 10!", Toast.LENGTH_SHORT).show();
        }
        else if(Integer.parseInt(inputFreq.getText().toString()) >= 0 && Integer.parseInt(inputFreq.getText().toString()) <= 100 ){
            Toast.makeText(this, "Informe uma frequencia entre 0 a 100!", Toast.LENGTH_SHORT).show();
        }
        else {
            Double nota1 = Double.parseDouble(inputNota1.getText().toString());
            Double nota2 = Double.parseDouble(inputNota2.getText().toString());
            int freq = Integer.parseInt(inputFreq.getText().toString());

            Intent it = new Intent(this, SecondActivity.class);
            Bundle params = new Bundle();
            params.putString("nome", inputName.getText().toString());
            params.putDouble("nota1", nota1);
            params.putDouble("nota2", nota2);
            params.putInt("freq", freq);
            it.putExtras(params);
            startActivity(it);
            finish();
        }
    }
}