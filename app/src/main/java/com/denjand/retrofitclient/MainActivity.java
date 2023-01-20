package com.denjand.retrofitclient;

import android.content.Intent;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.denjand.retrofitclient.alamat.AlamatActivity;
import com.denjand.retrofitclient.email.EmailActivity;
import com.denjand.retrofitclient.kontak.Adapter.KontakAdapter;
import com.denjand.retrofitclient.kontak.InsertActivity;
import com.denjand.retrofitclient.kontak.KontakActivity;
import com.denjand.retrofitclient.kontak.Model.GetKontak;
import com.denjand.retrofitclient.kontak.Rest.ApiClient;
import com.denjand.retrofitclient.kontak.Rest.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    Button btKontak, btAlamat, btEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btKontak = (Button) findViewById(R.id.btn_kontak);
        btKontak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, KontakActivity.class));
            }
        });

        btAlamat = (Button) findViewById(R.id.btn_alamat);
        btAlamat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, AlamatActivity.class));
            }
        });

        btEmail = (Button) findViewById(R.id.btn_email);
        btEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, EmailActivity.class));
            }
        });
    }
}