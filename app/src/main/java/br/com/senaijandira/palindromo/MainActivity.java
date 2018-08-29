package br.com.senaijandira.palindromo;

import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    EditText txtPalavra;
    TextView txtResultado;

    TextToSpeech speaker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtPalavra = findViewById(R.id.txtPalavra);
        txtResultado = findViewById(R.id.txtResultado);

        speaker = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {

                if(status != TextToSpeech.ERROR){

                    speaker.setLanguage(new Locale("pt", "br"));
                }
            }
        });
    }

    public void verificarPalindromo(View view) {

        //pegar o conteudo digitado pelo usuário
        String palavra = txtPalavra.getText().toString();

        String invertida = "";

        for(int i= palavra.length(); i > 0 ; i--){

            System.out.print("Valor de i+" + i);

            String letra = palavra.substring(i-1, i);

            invertida += letra;
        }

       if (palavra.equals(invertida)){

            txtResultado.setText("È um palíndromo");

            speaker.speak(palavra+"é um palíndromo.", TextToSpeech.QUEUE_FLUSH, null);

       }else {
            txtResultado.setText(("Não é um palíndromo"));

           speaker.speak(palavra+"não é um palíndromo.", TextToSpeech.QUEUE_FLUSH, null);
       }
    }
}
