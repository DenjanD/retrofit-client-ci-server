package com.denjand.retrofitclient.kontak;

import android.content.Intent;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.denjand.retrofitclient.MainActivity;
import com.denjand.retrofitclient.kontak.Adapter.KontakAdapter;
import com.denjand.retrofitclient.kontak.InsertActivity;
import com.denjand.retrofitclient.kontak.Model.GetKontak;
import com.denjand.retrofitclient.kontak.Model.Kontak;
import com.denjand.retrofitclient.kontak.Rest.ApiClient;
import com.denjand.retrofitclient.kontak.Rest.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import com.denjand.retrofitclient.R;

public class KontakActivity extends AppCompatActivity {

    Button btIns;
    ApiInterface mApiInterface;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    public static KontakActivity ma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kontak);

        btIns = (Button) findViewById(R.id.btIns);
        btIns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(KontakActivity.this, InsertActivity.class));
            }
        });
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mApiInterface = ApiClient.getClient().create(ApiInterface.class);
        ma=this;
        refresh();
    }

    public void refresh() {
        Call<List<GetKontak>> kontakCall = mApiInterface.getKontak();
        kontakCall.enqueue(new Callback<List<GetKontak>>() {
            @Override
            public void onResponse(Call<List<GetKontak>> call, Response<List<GetKontak>>
                    response) {
                List<GetKontak> KontakList = response.body();
                Log.d("Retrofit Getsss", "Jumlah data Kontak: " +
                        String.valueOf(KontakList.size()));
                mAdapter = new KontakAdapter(KontakList);
                mRecyclerView.setAdapter(mAdapter);
            }

            @Override
            public void onFailure(Call<List<GetKontak>> call, Throwable t) {
                Log.e("Retrofit Get", t.toString());
            }
        });
    }
}