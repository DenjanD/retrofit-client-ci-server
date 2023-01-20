package com.denjand.retrofitclient.alamat;

import android.content.Intent;
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

public class EditActivity extends AppCompatActivity {
    EditText edtId, edtLokasi, edtAlamat;
    Button btUpdate, btDelete, btBack;
    ApiInterface mApiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_alamat);
        edtId = (EditText) findViewById(R.id.edtId);
        edtLokasi = (EditText) findViewById(R.id.edtLokasi);
        edtAlamat = (EditText) findViewById(R.id.edtAlamat);
        Intent mIntent = getIntent();
        edtId.setText(mIntent.getStringExtra("Id"));
        edtId.setTag(edtId.getKeyListener());
        edtId.setKeyListener(null);
        edtLokasi.setText(mIntent.getStringExtra("Lokasi"));
        edtAlamat.setText(mIntent.getStringExtra("Alamat"));
        mApiInterface = ApiClient.getClient().create(ApiInterface.class);
        btUpdate = (Button) findViewById(R.id.btUpdate2);
        btUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Call<PostPutDelAlamat> updateAlamatCall = mApiInterface.putAlamat(
                        edtId.getText().toString(),
                        edtLokasi.getText().toString(),
                        edtAlamat.getText().toString());
                updateAlamatCall.enqueue(new Callback<PostPutDelAlamat>() {
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
        btDelete = (Button) findViewById(R.id.btDelete2);
        btDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edtId.getText().toString().trim().isEmpty()==false){
                    Call<PostPutDelAlamat> deleteAlamat = mApiInterface.deleteAlamat(edtId.getText().toString());
                    deleteAlamat.enqueue(new Callback<PostPutDelAlamat>() {
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
                }else{
                    Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
                }
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