package com.example.sampleconstraitlayout;

import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class DaftarActivity extends AppCompatActivity {

    //deklarasi cariable dengan tipe data EditText
    EditText edtNama, edtAlamat, edtEmail, edtPassword, edtrepass;

    //deklarasi variable floating Action Button
    FloatingActionButton fab;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar);

        //Menghubungkan variable yang telah dideklarasi dengan componen yng ada pada layout
        edtAlamat = findViewById(R.id.edAlamat);
        edtEmail = findViewById(R.id.EdEmail);
        edtrepass = findViewById(R.id.edrepass);
        edtNama = findViewById(R.id.edNama);
        edtPassword = findViewById(R.id.edPass);
        fab = findViewById(R.id.fabSimpan);


        //membuat method untuk event dari floating button
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Membuat kondisi untuk apakah EditText kosong atau Tidak
                if (edtNama.getText().toString().isEmpty() || edtAlamat.getText().toString().isEmpty()
                        ||edtEmail.getText().toString().isEmpty()||
                        edtPassword.getText().toString().isEmpty()||
                        edtrepass.getText().toString().isEmpty()){
                    //Menampilkan pesan notifikasi jika seluruh EditText wajib diisi
                    Snackbar.make(view,"wajib isi seluruh data !!!", Snackbar.LENGTH_LONG).show();

                }

                else{
                    //membuat kondisi untuk mengecek EditText password dan repasssword sama atau tidak
                    if(edtPassword.getText().toString().equals(edtrepass.getText().toString())){

                        //menampilkan pesan notifikasi jika pendaftaran berhasil
                        Toast.makeText(getApplicationContext(),"Pendaftaran Berhasil...",Toast.LENGTH_LONG).show();

                        //methos untuk kembali  ke activity Main
                        Intent i = new Intent(getApplicationContext(),MainActivity.class);
                        startActivity(i);
                    }
                    else{

                        //Menampikan pesan bahwa isi dari EditText password dan EditText repassword tidaksama
                        Snackbar.make(view,"Password dan Repassword harus sama !!!", Snackbar.LENGTH_LONG).show();
                    }
                }
            }
        });
    }
}
