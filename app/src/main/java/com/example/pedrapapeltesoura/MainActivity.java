package com.example.pedrapapeltesoura;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void selecionarPedra(View view){
        verificarGanhador("pedra");
    }
    public void selecionarPapel(View view){
        verificarGanhador("papel");
    }
    public void selecionarTesoura(View view){
        verificarGanhador("pedra");
    }

    private void verificarGanhador(String escolhaUsuario){
        String escolhaApp = gerarEscolhaAleatoriaApp();
        TextView txtResultado = findViewById(R.id.txtResultado);

        String resultado ="";

        if(
            (escolhaApp == "pedra" && escolhaUsuario == "tesoura") ||
            (escolhaApp == "papel" && escolhaUsuario == "pedra") ||
            (escolhaApp == "tesoura" && escolhaUsuario == "papel")
        ){ //App ganhador
            txtResultado.setText("Você perdeu :(");
        }else if(
                (escolhaUsuario == "pedra" && escolhaApp == "tesoura") ||
                (escolhaUsuario == "papel" && escolhaApp == "pedra") ||
                (escolhaUsuario == "tesoura" && escolhaApp == "papel")
        ){ //Usuário ganhador
            txtResultado.setText("Você ganhou :)");
        }else{ //Empatou
            txtResultado.setText("Empatou! ;)");
        }

    }

    private String gerarEscolhaAleatoriaApp() {
        String[] opcoes = {"papel", "pedra", "tesoura"};
        int numeroAleatorio = new Random().nextInt(3);

        String escolhaApp = opcoes[numeroAleatorio];
        ImageView imagemApp = findViewById(R.id.imgApp);

        switch (escolhaApp){
            case "pedra" : imagemApp.setImageResource(R.drawable.pedra);
                break;
            case "papel" : imagemApp.setImageResource(R.drawable.papel);
                break;
            case "tesoura": imagemApp.setImageResource(R.drawable.tesoura);
        }
        return escolhaApp;
    }


}