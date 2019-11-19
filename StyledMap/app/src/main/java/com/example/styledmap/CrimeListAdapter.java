package com.example.styledmap;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvDate;
import com.opencsv.bean.CsvNumber;
import com.opencsv.bean.CsvToBeanBuilder;

import java.util.Collections;
import java.util.Date;
import java.util.List;

public class CrimeListAdapter extends RecyclerView.Adapter<CrimeListAdapter.CrimeViewHolder> {
/*Edit this code below */
    class CrimeViewHolder extends RecyclerView.ViewHolder {
        private final TextView crimeItemView;

        private CrimeViewHolder(View itemView) {
            super(itemView);
            crimeItemView = itemView.findViewById(R.id.crimeView);
        }
    }

    private final LayoutInflater mInflater;
    private List<CrimeDatabase> rowid; // Cached copy of words
    CrimeListAdapter(Context context) { mInflater = LayoutInflater.from(context); }

    @Override
    public CrimeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.recyclerview_item, parent, false);
        return new CrimeViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CrimeViewHolder holder, int position) {
        if (rowid != null) {
            CrimeDatabase current = rowid.get(position);
            holder.crimeItemView.setText(current.getCrimeType()); // error here
        } else {
            // Covers the case of data not being ready yet.
            holder.crimeItemView.setText("No Crime");
        }
    }

    void setCrimes(List<CrimeDatabase> crimes){
        rowid = crimes;
        notifyDataSetChanged();
    }

    // getItemCount() is called many times, and when it is first called,
    // mWords has not been updated (means initially, it's null, and we can't return null).
    @Override
    public int getItemCount() {
        if (rowid != null)
            return rowid.size();
        else return 0;
    }
}
