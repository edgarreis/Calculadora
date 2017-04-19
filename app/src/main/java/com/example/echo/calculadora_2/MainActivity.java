package com.example.echo.calculadora_2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    float res;
    int flagOperacao = 0;
    int flagResultado = 0;
    int flagNumero = 0;
    float valor1 = 0;
    float valor2 = 0;
    float valorResultado = 0;
    int flagVirgula = 0;

    TextView resultado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // when run in first time
        setContentView(R.layout.activity_main);
    }


    public void onClickNumeros(View view) {

        // Get textView resultado
        resultado = ((TextView) findViewById(R.id.resultado));

        // Get textView and convert to string
        String numero = ((TextView) view).getText().toString();

        if (flagResultado == 1) {

            resultado.setText("");
            //valor2 = valorResultado;
            //valor1 = 0;

        }

        // Add to resultado a new number
        resultado.setText(resultado.getText() + numero);

        // Get resultado to valor1
        valor1 = Float.parseFloat(resultado.getText().toString());

        // Flags
        flagResultado = 0;
        flagNumero = 1;


    }

    public void onClickOperacao(View view) {
        //EditText etValor1 = (EditText) findViewById(R.id.etValor1);
        //EditText etValor2 = (EditText) findViewById(R.id.etValor2);
        //EditText resultado = (EditText) findViewById(R.id.resultado);

        //float valor1 = Float.parseFloat(etValor1.getText().toString());
        //float valor2 = Float.parseFloat(etValor2.getText().toString());

        // New number pressed
        String numero = ((TextView) view).getText().toString();
        // Get textView and convert to string
        resultado = ((TextView) findViewById(R.id.resultado));
        // concatenate resultado and numero
        //resultado.setText(resultado.getText() + numero);

        switch (view.getId()) {
            case R.id.bSoma:

                valor2 = valor1;
                flagOperacao = 1;
                flagResultado = 1;
                //resultado.setText("");
                break;

            case R.id.bSubtracao:

                valor2 = valor1;
                flagOperacao = 2;
                flagResultado = 1;
                //resultado.setText("");
                break;

            case R.id.bMultiplicacao:

                valor2 = valor1;
                flagOperacao = 3;
                flagResultado = 1;
                //resultado.setText("");
                break;

            case R.id.bDivisao:

                valor2 = valor1;
                flagOperacao = 4;
                flagResultado = 1;
                //resultado.setText("");
                break;

            case R.id.bDelet:

                resultado.setText("");
                valor1 = 0;
                break;

            case R.id.bClear:

                resultado.setText("");
                valor2 = 0;
                valor1 = 0;
                valorResultado = 0;
                break;

            case R.id.bSinal:

                valor1 = -valor1;
                resultado.setText(String.valueOf(valor1));
                break;

            case R.id.bVirgula:

                //resultado.setText(resultado.getText());
                if (flagVirgula!=1) {
                    resultado.setText(resultado.getText() + numero);
                }
                break;

            case R.id.bResultado:

                Resolver();
                flagResultado = 1;
        }

        // Put comma only once on number
        if (view.getId() == R.id.bVirgula) {
            flagVirgula = 1;
        }else{
            flagVirgula = 0;
        }


    }

    public void Resolver() {

        switch (flagOperacao) {
            case 1:

                valorResultado = valor2 + valor1;
                resultado.setText(String.valueOf(valorResultado));

                break;
            case 2:

                valorResultado = valor2 - valor1;
                resultado.setText(String.valueOf(valorResultado));

                break;
            case 3:

                valorResultado = valor2 * valor1;
                resultado.setText(String.valueOf(valorResultado));

                break;
            case 4:

                valorResultado = valor2 / valor1;
                resultado.setText(String.valueOf(valorResultado));

                break;
        }

        valor1 = valorResultado;

    }

}