package com.denjand.retrofitclient.email.Adapter;

import android.annotation.SuppressLint;
import android.content.Intent;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.denjand.retrofitclient.email.EditActivity;
import com.denjand.retrofitclient.email.Model.GetEmail;
import com.denjand.retrofitclient.R;

import java.util.List;

/**
 * Created by root on 2/3/17.
 */

public class EmailAdapter extends RecyclerView.Adapter<EmailAdapter.MyViewHolder>{
    List<GetEmail> mEmailList;

    public EmailAdapter(List<GetEmail> EmailList) {
        mEmailList = EmailList;
    }

    @Override
    public MyViewHolder onCreateViewHolder (ViewGroup parent,int viewType){
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.email_list, parent, false);
        MyViewHolder mViewHolder = new MyViewHolder(mView);
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder (MyViewHolder holder, @SuppressLint("RecyclerView") final int position){
        holder.mTextViewId.setText("Id = " + mEmailList.get(position).getId());
        holder.mTextViewNama.setText("Nama = " + mEmailList.get(position).getNama());
        holder.mTextViewEmail.setText("Email = " + mEmailList.get(position).getEmail());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntent = new Intent(view.getContext(), EditActivity.class);
                mIntent.putExtra("Id", mEmailList.get(position).getId());
                mIntent.putExtra("Nama", mEmailList.get(position).getNama());
                mIntent.putExtra("Email", mEmailList.get(position).getEmail());
                view.getContext().startActivity(mIntent);
            }
        });
    }

    @Override
    public int getItemCount () {
        return mEmailList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextViewId, mTextViewNama, mTextViewEmail;

        public MyViewHolder(View itemView) {
            super(itemView);
            mTextViewId = (TextView) itemView.findViewById(R.id.tvId);
            mTextViewNama = (TextView) itemView.findViewById(R.id.tvNama);
            mTextViewEmail = (TextView) itemView.findViewById(R.id.tvEmail);
        }
    }
}