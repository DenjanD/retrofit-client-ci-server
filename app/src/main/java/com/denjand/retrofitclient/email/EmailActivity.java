package com.denjand.retrofitclient.email;

import android.content.Intent;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.denjand.retrofitclient.email.Adapter.EmailAdapter;
import com.denjand.retrofitclient.email.Model.GetEmail;
import com.denjand.retrofitclient.email.Rest.ApiClient;
import com.denjand.retrofitclient.email.Rest.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import com.denjand.retrofitclient.R;

public class EmailActivity extends AppCompatActivity {

    Button btIns;
    ApiInterface mApiInterface;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    public static EmailActivity ma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);

        btIns = (Button) findViewById(R.id.btIns);
        btIns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(EmailActivity.this, InsertActivity.class));
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
        Call<List<GetEmail>> emailCall = mApiInterface.getEmail();
        emailCall.enqueue(new Callback<List<GetEmail>>() {
            @Override
            public void onResponse(Call<List<GetEmail>> call, Response<List<GetEmail>>
                    response) {
                List<GetEmail> EmailList = response.body();
                Log.d("Retrofit Getsss", "Jumlah data Email: " +
                        String.valueOf(EmailList.size()));
                mAdapter = new EmailAdapter(EmailList);
                mRecyclerView.setAdapter(mAdapter);
            }

            @Override
            public void onFailure(Call<List<GetEmail>> call, Throwable t) {
                Log.e("Retrofit Get", t.toString());
            }
        });
    }
}