package org.ahmadelsayed.derma.Model;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.ahmadelsayed.derma.R;
import org.ahmadelsayed.derma.Vtiligo;

import java.util.List;

public class DiseasesAdapter extends RecyclerView.Adapter<DiseasesAdapter.DiseaseHolder> {
    private Context mContext;
    private List<Disease> diseaseList;

    public class DiseaseHolder extends RecyclerView.ViewHolder {
        public TextView name, description;
        public ImageView thumbnail;

        DiseaseHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.name);
            description = (TextView) view.findViewById(R.id.description);
            thumbnail = (ImageView) view.findViewById(R.id.thumbnail);
        }
    }

    public DiseasesAdapter(Context mContext, List<Disease> diseaseList) {
        this.mContext = mContext;
        this.diseaseList = diseaseList;
    }

    @NonNull
    @Override
    public DiseaseHolder onCreateViewHolder(@NonNull final ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_disease_card, parent, false);
        return  new DiseaseHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final DiseaseHolder holder, int position) {
        Disease disease = diseaseList.get(position);
        holder.name.setText(disease.getName());
        holder.description.setText(disease.getDescription());
        holder.thumbnail.setImageResource(disease.getImage());

        View.OnClickListener nav1 = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(mContext, Vtiligo.class);
                i.putExtra("DiseaseName", "Psoriasis");
                mContext.startActivity(i);
            }
        };
        View.OnClickListener nav2 = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(mContext, Vtiligo.class);
                i.putExtra("DiseaseName", "Vitiligo");
                mContext.startActivity(i);
            }
        };
        View.OnClickListener rest = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(holder.itemView, "Not Available Now! Please Check Later for Updates", Snackbar.LENGTH_SHORT).show();
                //Toast.makeText(mContext, "Not Available Now! Please Check Later for Updates", Toast.LENGTH_SHORT).show();
            }
        };

        if(position == 0) {
            holder.itemView.setOnClickListener(nav1);
            holder.thumbnail.setOnClickListener(nav1);
        } else if(position == 1) {
            holder.itemView.setOnClickListener(nav2);
            holder.thumbnail.setOnClickListener(nav2);
        } else {
            holder.itemView.setOnClickListener(rest);
            holder.thumbnail.setOnClickListener(rest);
        }

    }

    @Override
    public int getItemCount() {
        return diseaseList.size();
    }
}
