package com.example.styledmap;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

public class CrimeListAdapter extends RecyclerView.Adapter<CrimeListAdapter.CrimeViewHolder> {

    class CrimeViewHolder extends RecyclerView.ViewHolder {
        private final TextView crimeItemView;

        private CrimeViewHolder(View itemView) {
            super(itemView);
            crimeItemView = itemView.findViewById(R.id.textView);
        }
    }

    private final LayoutInflater mInflater;
    private List<Crime> mCrimeId; // Cached copy of words

    CrimeListAdapter(Context context) { mInflater = LayoutInflater.from(context); }

    @Override
    public CrimeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.recyclerview_item, parent, false);
        return new CrimeViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CrimeViewHolder holder, int position) {
        if (mCrimeId != null) {
            Crime current = mCrimeId.get(position);
            holder.crimeItemView.setText(current.getCrimeId());
        } else {
            // Covers the case of data not being ready yet.
            holder.crimeItemView.setText("No Crime");
        }
    }

    void setCrimes(List<Crime> crimes){
        mCrimeId = crimes;
        notifyDataSetChanged();
    }

    // getItemCount() is called many times, and when it is first called,
    // mWords has not been updated (means initially, it's null, and we can't return null).
    @Override
    public int getItemCount() {
        if (mCrimeId != null)
            return mCrimeId.size();
        else return 0;
    }
}
