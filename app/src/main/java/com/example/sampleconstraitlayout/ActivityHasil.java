package com.example.sampleconstraitlayout;

import android.os.Bundle;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ActivityHasil extends AppCompatActivity{
    //mendeklarasikan variable dengan tipe data TextView
    TextView txEmail, txPassword;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kedua);

        //Menghubungkan variable txEmail dengan componen TextViev pada layout
        txEmail = findViewById(R.id.tvEmail);

        //menghubungkan variable txPassword dengan componen TextView pada Layout
        txPassword = findViewById(R.id.tvPassword);


        //mendeklarasikan variable bundle yang akan digunakan untuk mengambil
        //pesan yang dikiri  melalui metthod intent
        Bundle bundle = getIntent().getExtras();

        //membuat variable string yang digunakan untuk menyimpan data yang
        //dikirimkan dari activity sebelumnya dengan kunci "a"
        String email = bundle.getString("a");

        //membuat variable string yang digunakan untuk menyimpan data yang
        //dikirimkan dari activity sebelumnya dengan kunci "b"
        String pass = bundle.getString("b");


        //menampilkan value dari variable email dan pass kedalam tx Email
        //dan txPasword
        txEmail.setText(email);
        txPassword.setText(pass);
    }
}
