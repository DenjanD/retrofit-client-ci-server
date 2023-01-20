package com.denjand.retrofitclient.email;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.denjand.retrofitclient.email.EmailActivity;
import com.denjand.retrofitclient.R;
import com.denjand.retrofitclient.email.Model.PostPutDelEmail;
import com.denjand.retrofitclient.email.Rest.ApiClient;
import com.denjand.retrofitclient.email.Rest.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InsertActivity extends AppCompatActivity {
    EditText edtNama, edtEmail;
    Button btInsert, btBack;
    ApiInterface mApiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_email);
        edtNama = (EditText) findViewById(R.id.edtNama);
        edtEmail = (EditText) findViewById(R.id.edtEmail);
        mApiInterface = ApiClient.getClient().create(ApiInterface.class);
        btInsert = (Button) findViewById(R.id.btInserting);
        btInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Call<PostPutDelEmail> postEmailCall = mApiInterface.postEmail(edtNama.getText().toString(), edtEmail.getText().toString());
                postEmailCall.enqueue(new Callback<PostPutDelEmail>() {
                    @Override
                    public void onResponse(Call<PostPutDelEmail> call, Response<PostPutDelEmail> response) {
                        EmailActivity.ma.refresh();
                        finish();
                    }

                    @Override
                    public void onFailure(Call<PostPutDelEmail> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
                    }
                });
            }
        });

        btBack = (Button) findViewById(R.id.btBackGo);
        btBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EmailActivity.ma.refresh();
                finish();
            }
        });
    }
}