package com.denjand.retrofitclient.alamat.Adapter;

import android.annotation.SuppressLint;
import android.content.Intent;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.denjand.retrofitclient.alamat.EditActivity;
import com.denjand.retrofitclient.alamat.Model.GetAlamat;
import com.denjand.retrofitclient.R;

import java.util.List;

/**
 * Created by root on 2/3/17.
 */

public class AlamatAdapter extends RecyclerView.Adapter<AlamatAdapter.MyViewHolder>{
    List<GetAlamat> mAlamatList;

    public AlamatAdapter(List<GetAlamat> AlamatList) {
        mAlamatList = AlamatList;
    }

    @Override
    public MyViewHolder onCreateViewHolder (ViewGroup parent,int viewType){
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.alamat_list, parent, false);
        MyViewHolder mViewHolder = new MyViewHolder(mView);
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder (MyViewHolder holder, @SuppressLint("RecyclerView") final int position){
        holder.mTextViewId.setText("Id = " + mAlamatList.get(position).getId());
        holder.mTextViewLokasi.setText("Lokasi = " + mAlamatList.get(position).getLokasi());
        holder.mTextViewAlamat.setText("Alamat = " + mAlamatList.get(position).getAlamat());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntent = new Intent(view.getContext(), EditActivity.class);
                mIntent.putExtra("Id", mAlamatList.get(position).getId());
                mIntent.putExtra("Lokasi", mAlamatList.get(position).getLokasi());
                mIntent.putExtra("Alamat", mAlamatList.get(position).getAlamat());
                view.getContext().startActivity(mIntent);
            }
        });
    }

    @Override
    public int getItemCount () {
        return mAlamatList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextViewId, mTextViewLokasi, mTextViewAlamat;

        public MyViewHolder(View itemView) {
            super(itemView);
            mTextViewId = (TextView) itemView.findViewById(R.id.tvId);
            mTextViewLokasi = (TextView) itemView.findViewById(R.id.tvLokasi);
            mTextViewAlamat = (TextView) itemView.findViewById(R.id.tvAlamat);
        }
    }
}