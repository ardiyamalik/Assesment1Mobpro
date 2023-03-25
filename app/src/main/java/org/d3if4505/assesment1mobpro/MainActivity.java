package org.d3if4505.assesment1mobpro;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //MAKANAN
        final CheckBox makanan1 = findViewById(R.id.kentanggoreng);
        final CheckBox makanan2 = findViewById(R.id.cordonbleu);
        final CheckBox makanan3 = findViewById(R.id.chickenkatsu);

        //MINUMAN
        final CheckBox minuman1 = findViewById(R.id.kopisusu);
        final CheckBox minuman2 = findViewById(R.id.matchalatte);
        final CheckBox minuman3 = findViewById(R.id.vsixty);

        //JUMLAH MAKANAN
        final EditText jml_mkn1 = findViewById(R.id.jumlahkentanggoreng);
        final EditText jml_mkn2 = findViewById(R.id.jumlahcordonbleu);
        final EditText jml_mkn3 = findViewById(R.id.jumlahchickenkatsu);

        //JUMLAH MINUMAN
        final EditText jml_min1 = findViewById(R.id.jumlahkopisusu);
        final EditText jml_min2 = findViewById(R.id.jumlahmatchalatte);
        final EditText jml_min3 = findViewById(R.id.jumlahvsixty);
        Button btn = findViewById(R.id.submit);

        //HARGA MAKANAN
        final int harga_kentanggoreng = 25000;
        final int harga_cordonbleu = 40000;
        final int harga_chickenkatsu = 35000;

        //HARGA MINUMAN
        final int harga_kopisusu = 10000;
        final int harga_matchalatte = 10000;
        final int harga_vsixty = 15000;

        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);

                if (!makanan1.isChecked() && !makanan2.isChecked() && !makanan3.isChecked() && !minuman1.isChecked() && !minuman2.isChecked() && !minuman3.isChecked()) {
                    Toast.makeText(getApplicationContext(), "Silahkan Pilih Makanan dan Minuman", Toast.LENGTH_SHORT).show();
                } else {
                    String text = "";
                    int totOrder = 0;
                    int discount = 0;
                    if (makanan1.isChecked()) {
                        String hasil = "Kentang Goreng";
                        int jml = Integer.parseInt(String.valueOf(jml_mkn1.getText()));
                        int cal = jml * harga_kentanggoreng;
                        text += jml + "\t\t" + hasil + "\t\t\t\t\t\t\t\t\t" + "Rp. " + cal + "\n\n";
                        totOrder = totOrder + cal;

                    }
                    if (makanan2.isChecked()) {
                        String hasil = "Cordon Bleu";
                        int jml = Integer.parseInt(String.valueOf(jml_mkn2.getText()));
                        int cal = jml * harga_cordonbleu;
                        text += jml + "\t\t" + hasil + "\t\t\t\t\t\t\t\t\t" + "Rp. " + cal + "\n\n";
                        totOrder = totOrder + cal;
                    }
                    if (makanan3.isChecked()) {
                        String hasil = "Cichken Katsu ";
                        int jml = Integer.parseInt(String.valueOf(jml_mkn3.getText()));
                        int cal = jml * harga_chickenkatsu;
                        text += jml + "\t\t" + hasil + "\t\t\t\t\t\t\t\t\t" + "Rp. " + cal + "\n\n";
                        totOrder = totOrder + cal;
                    }

                    //MINUMAN

                    if (minuman1.isChecked()) {
                        String hasil = "Kopi Susu ";
                        int jml = Integer.parseInt(String.valueOf(jml_min1.getText()));
                        int cal = jml * harga_kopisusu;
                        text += jml + "\t\t" + hasil + "\t\t\t\t\t\t\t\t\t" + "Rp. " + cal + "\n\n";
                        totOrder = totOrder + cal;
                    }
                    if (minuman2.isChecked()) {
                        String hasil = "Matcha Latte ";
                        int jml = Integer.parseInt(String.valueOf(jml_min2.getText()));
                        int cal = jml * harga_matchalatte;
                        text += jml + "\t\t" + hasil + "\t\t\t\t\t\t\t\t\t" + "Rp. " + cal + "\n\n";
                        totOrder = totOrder + cal;
                    }
                    if (minuman3.isChecked()) {
                        String hasil = "V60 ";
                        int jml = Integer.parseInt(String.valueOf(jml_min3.getText()));
                        int cal = jml * harga_vsixty;
                        text += jml + "\t\t" + hasil + "\t\t\t\t\t\t\t\t\t" + "Rp. " + cal + "\n\n";
                        totOrder = totOrder + cal;
                    }
                    if (totOrder > 100000) {
                        discount = 10000;
                    }
                    intent.putExtra("Coba", text);
                    intent.putExtra("Bayar", totOrder);
                    intent.putExtra("Discout", discount);
                    startActivity(intent);
                }
            }

        });

    }


}