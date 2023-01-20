package com.denjand.retrofitclient.alamat;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.denjand.retrofitclient.alamat.AlamatActivity;
import com.denjand.retrofitclient.R;
import com.denjand.retrofitclient.alamat.Model.PostPutDelAlamat;
import com.denjand.retrofitclient.alamat.Rest.ApiClient;
import com.denjand.retrofitclient.alamat.Rest.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InsertActivity extends AppCompatActivity {
    EditText edtLokasi, edtAlamat;
    Button btInsert, btBack;
    ApiInterface mApiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_alamat);
        edtLokasi = (EditText) findViewById(R.id.edtLokasi);
        edtAlamat = (EditText) findViewById(R.id.edtAlamat);
        mApiInterface = ApiClient.getClient().create(ApiInterface.class);
        btInsert = (Button) findViewById(R.id.btInserting);
        btInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Call<PostPutDelAlamat> postAlamatCall = mApiInterface.postAlamat(edtLokasi.getText().toString(), edtAlamat.getText().toString());
                postAlamatCall.enqueue(new Callback<PostPutDelAlamat>() {
                    @Override
                    public void onResponse(Call<PostPutDelAlamat> call, Response<PostPutDelAlamat> response) {
                        AlamatActivity.ma.refresh();
                        finish();
                    }

                    @Override
                    public void onFailure(Call<PostPutDelAlamat> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
                    }
                });
            }
        });

        btBack = (Button) findViewById(R.id.btBackGo);
        btBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlamatActivity.ma.refresh();
                finish();
            }
        });
    }
}