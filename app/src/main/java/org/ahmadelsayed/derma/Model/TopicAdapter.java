package org.ahmadelsayed.derma.Model;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.ahmadelsayed.derma.Data;
import org.ahmadelsayed.derma.R;
import org.ahmadelsayed.derma.Vtiligo;

import java.util.List;

public class TopicAdapter extends RecyclerView.Adapter<TopicAdapter.TopicHolder> {
    private Context mContext;
    private List<Topic> topicList;

    public class TopicHolder extends RecyclerView.ViewHolder {
        public TextView name;
        public ImageView thumbnail;
        TopicHolder(View view) {
            super(view);
            name = view.findViewById(R.id.topic_name);
            thumbnail = view.findViewById(R.id.topic_image);
        }
    }

    public TopicAdapter(Context mContext, List<Topic> topicList) {
        this.mContext = mContext;
        this.topicList = topicList;
    }


    @NonNull
    @Override
    public TopicHolder onCreateViewHolder(@NonNull final ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_topic_card, parent, false);
        return new TopicHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final TopicHolder holder, int position) {
        final Topic topic = topicList.get(position);
        holder.name.setText(topic.getName());
        holder.thumbnail.setImageResource(topic.getImage());

        View.OnClickListener clickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(mContext, Data.class);
                i.putExtra("TopicName", topic.getName());
                i.putExtra("DiseaseName", topic.getDisease());
                mContext.startActivity(i);
            }
        };

        holder.itemView.setOnClickListener(clickListener);
        holder.thumbnail.setOnClickListener(clickListener);
    }

    @Override
    public int getItemCount() {
        return topicList.size();
    }
}
