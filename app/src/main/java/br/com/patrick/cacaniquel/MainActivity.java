package br.com.patrick.cacaniquel;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int moeda;
    int pontos;
    private Button bt_1;
    private Button bt_2;
    private Button bt_3;
    private Button apostar;
    private Button novojogo;
    private Button sair;
    private TextView lbl_resultado_moeda;
    private TextView lbl_resultado_pontuacao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt_1 = findViewById(R.id.bt_1);
        bt_2 = findViewById(R.id.bt_2);
        bt_3 = findViewById(R.id.bt_3);
        apostar=findViewById(R.id.apostar);
        novojogo=findViewById(R.id.novojogo);
        sair=findViewById(R.id.sair);
        lbl_resultado_moeda=findViewById(R.id.lbl_resultado_moeda);
        lbl_resultado_pontuacao=findViewById(R.id.lbl_resultado_pontuacao);

        novojogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moeda = 20;
                pontos = 0;
                bt_1.setEnabled(true);
                bt_2.setEnabled(true);
                bt_3.setEnabled(true);
                apostar.setEnabled(true);
                lbl_resultado_moeda.setText("" + moeda);
                lbl_resultado_pontuacao.setText("" + pontos);

            }
        });
        sair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        apostar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int i1, i2, i3;
                Random r1 = new Random();
                Random r2 = new Random();
                Random r3 = new Random();
                i1 = r1.nextInt(10);
                i2 = r2.nextInt(10);
                i3 = r3.nextInt(10);
                bt_1.setText(String.valueOf(i1));
                bt_2.setText(String.valueOf(i2));
                bt_3.setText(String.valueOf(i3));
                checarjogo(i1, i2, i3);
            }
        });
    }

    public void checarjogo(int a, int b, int c) {
        if ((a == 7) && (b == 7) && (c == 7)) {
            moeda = moeda = 100;
            pontos = pontos + 100;
            AlertDialog.Builder alertaVenceu = new AlertDialog.Builder(this);
            alertaVenceu.setTitle("VITÓRIA");
            alertaVenceu.setMessage("Parabéns, você é o vencedor!");
            alertaVenceu.setIcon(android.R.drawable.star_on);
            alertaVenceu.setPositiveButton("ok", null);
            alertaVenceu.create();
            alertaVenceu.show();
            lbl_resultado_moeda.setText(String.valueOf(moeda));
            lbl_resultado_pontuacao.setText(String.valueOf(pontos));
            bt_1.setEnabled(false);
            bt_2.setEnabled(false);
            bt_3.setEnabled(false);

        } else {
            if (((a == 7) && (b == 7)) || (a == 7) && (c == 7) || ((b == 7))) {
                moeda = moeda + 2;
                pontos = pontos + 2;
                lbl_resultado_moeda.setText(String.valueOf(moeda));
                lbl_resultado_pontuacao.setText(String.valueOf(pontos));
            } else {
                if ((a == 7) || (b == 7) || (c == 7)) {
                    moeda = moeda = 1;
                    pontos = pontos = 1;
                    lbl_resultado_moeda.setText(String.valueOf(moeda));
                    lbl_resultado_pontuacao.setText(String.valueOf(pontos));

                } else {
                    if ((a != 7) || (b != 7) || (c != 7)) {
                        moeda = moeda = -1;
                        lbl_resultado_moeda.setText(String.valueOf(moeda));
                        lbl_resultado_pontuacao.setText(String.valueOf(pontos));

                        if (moeda == 0) {
                            AlertDialog.Builder alertaPerdeu = new AlertDialog.Builder(this);
                            alertaPerdeu.setTitle("GAME OVER");
                            alertaPerdeu.setMessage("infelizmente , você perdeu!");
                            alertaPerdeu.setIcon(android.R.drawable.ic_delete);
                            alertaPerdeu.setPositiveButton("ok", null);
                            alertaPerdeu.create();
                            alertaPerdeu.show();
                            bt_1.setEnabled(false);
                            bt_2.setEnabled(false);
                            bt_3.setEnabled(false);
                            apostar.setEnabled(false);

                        }
                    }
                }
            }
        }
    }
}






