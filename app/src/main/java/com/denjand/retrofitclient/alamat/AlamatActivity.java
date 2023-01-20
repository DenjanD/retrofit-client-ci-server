package com.denjand.retrofitclient.alamat;

import android.content.Intent;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.denjand.retrofitclient.alamat.Adapter.AlamatAdapter;
import com.denjand.retrofitclient.alamat.Model.GetAlamat;
import com.denjand.retrofitclient.alamat.Rest.ApiClient;
import com.denjand.retrofitclient.alamat.Rest.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import com.denjand.retrofitclient.R;

public class AlamatActivity extends AppCompatActivity {

    Button btIns;
    ApiInterface mApiInterface;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    public static AlamatActivity ma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alamat);

        btIns = (Button) findViewById(R.id.btIns);
        btIns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AlamatActivity.this, InsertActivity.class));
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
        Call<List<GetAlamat>> alamatCall = mApiInterface.getAlamat();
        alamatCall.enqueue(new Callback<List<GetAlamat>>() {
            @Override
            public void onResponse(Call<List<GetAlamat>> call, Response<List<GetAlamat>>
                    response) {
                List<GetAlamat> AlamatList = response.body();
                Log.d("Retrofit Getsss", "Jumlah data Alamat: " +
                        String.valueOf(AlamatList.size()));
                mAdapter = new AlamatAdapter(AlamatList);
                mRecyclerView.setAdapter(mAdapter);
            }

            @Override
            public void onFailure(Call<List<GetAlamat>> call, Throwable t) {
                Log.e("Retrofit Get", t.toString());
            }
        });
    }
}