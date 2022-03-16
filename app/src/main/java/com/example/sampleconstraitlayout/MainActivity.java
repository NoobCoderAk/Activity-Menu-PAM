package com.example.sampleconstraitlayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //Deklarasi variable untuk button
    Button btnLogin;

    //Deklarasi variable untuk EditText
    EditText edemail, edpassword;

    //Deklarasi variable untk menyimpan email dan password
    String nama, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Menghubungkan variable btnLogin dengan componen button pada layout
        btnLogin=findViewById(R.id.btSignin);

        //Menghubungkan variable edemail dengan componen button pada Layout
        edemail=findViewById(R.id.edEmail);

        //Menghubungkan variable edpassword dengan componen button pada layout
        edpassword=findViewById(R.id.edPassword);

        //Membuat fungsi onClick pada buton btnLogin
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Menyimpan input user di edittext email kedalam variable nama
                nama = edemail.getText().toString();

                //Menyimpan input user di edittext password kedalam variable password
                password = edpassword.getText().toString();

                //Mengset email yang benar
                String email= "admin@mail.com";

                //mengset password yang benar
                String pass = "123";

                //mengecek apakah edittext email dan password terdapat isi atau tidak
                if (nama.isEmpty() || password.isEmpty()){
                    //membuat variable toast dan menampilkan pesan "edittexty tidak boleh kosong"
                    Toast t = Toast.makeText(getApplicationContext(),
                            "email dan password Wajib di isi !!!", Toast.LENGTH_LONG);

                    //menampilkan toast
                    t.show();
                }

                else {

                    //mengecek apakah isi dari email dana password sudah sama dengan email dan
                    //passwod yang sudah diset
                    if (nama.equals(email) && password.equals(pass)){
                        //membuatr variable toast dan menampilkan pesan "login sukses"
                        Toast t = Toast.makeText(getApplicationContext(), "Login Sukses", Toast.LENGTH_LONG);

                        //menampilkan Toast
                        t.show();

                        //membuat objek bundle
                        Bundle b = new Bundle();

                        //masukkan value dari variable nama dengan kunci "a"
                        //dan dimasukan kedalam bundle
                        b.putString("a", nama.trim());

                        //masukkan value dari variable password dengan kunci "b"
                        //dan dimasukkan kedalam bundle
                        b.putString("b", password.trim());

                        //membuat objek intent berpindah activity dari mainactivity ke activityHasil
                        Intent i = new Intent(getApplicationContext(), ActivityHasil.class);

                        //memasukkan bundle kedalam intent untuk dikirim ke ActivityHasil
                        i.putExtras(b);

                        //berpindah ke ActivityHasil
                        startActivity(i);
                    }

                    else {
                        //membuat variable toast dan membuat toast dan menampilkan pesan
                        // "login gagal"
                        Toast t = Toast.makeText(getApplicationContext(),
                                "Login Gagal",Toast.LENGTH_LONG);

                        ////menampilkan toast
                        t.show();
                    }
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //method utnuk menampilkan menu.
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        //membuat kondisi jiks yang dipilih adalah id mnDaftar
        if (item.getItemId() == R.id.mnDaftar){

            //Method untuk memanggil activity "DaftarActivity"
            Intent i = new Intent(MainActivity.this,DaftarActivity.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }
}