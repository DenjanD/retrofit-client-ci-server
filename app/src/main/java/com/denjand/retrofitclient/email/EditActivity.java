package com.denjand.retrofitclient.email;

import android.content.Intent;
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

public class EditActivity extends AppCompatActivity {
    EditText edtId, edtNama, edtEmail;
    Button btUpdate, btDelete, btBack;
    ApiInterface mApiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_email);
        edtId = (EditText) findViewById(R.id.edtId);
        edtNama = (EditText) findViewById(R.id.edtNama);
        edtEmail = (EditText) findViewById(R.id.edtEmail);
        Intent mIntent = getIntent();
        edtId.setText(mIntent.getStringExtra("Id"));
        edtId.setTag(edtId.getKeyListener());
        edtId.setKeyListener(null);
        edtNama.setText(mIntent.getStringExtra("Nama"));
        edtEmail.setText(mIntent.getStringExtra("Email"));
        mApiInterface = ApiClient.getClient().create(ApiInterface.class);
        btUpdate = (Button) findViewById(R.id.btUpdate2);
        btUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Call<PostPutDelEmail> updateEmailCall = mApiInterface.putEmail(
                        edtId.getText().toString(),
                        edtNama.getText().toString(),
                        edtEmail.getText().toString());
                updateEmailCall.enqueue(new Callback<PostPutDelEmail>() {
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
        btDelete = (Button) findViewById(R.id.btDelete2);
        btDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edtId.getText().toString().trim().isEmpty()==false){
                    Call<PostPutDelEmail> deleteEmail = mApiInterface.deleteEmail(edtId.getText().toString());
                    deleteEmail.enqueue(new Callback<PostPutDelEmail>() {
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
                }else{
                    Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
                }
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