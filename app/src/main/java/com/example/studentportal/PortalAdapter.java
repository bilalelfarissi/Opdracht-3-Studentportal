package com.example.studentportal;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class PortalAdapter extends RecyclerView.Adapter<PortalAdapter.ViewHolder> {

    private List<Portal> mPortals;
    final private PortalClickListener mPortalClickListener;

    public PortalAdapter(List<Portal> mPortals, PortalClickListener mPortalClickListener) {
        this.mPortals = mPortals;
        this.mPortalClickListener = mPortalClickListener;
    }

    /**
     *  Viewholder is created by using item_portal.xml
     */
    @NonNull
    @Override
    public PortalAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater= LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_portal, null);

        // Return a new holder instance
        return new PortalAdapter.ViewHolder(view);
    }

    /**
     *  By binding the viewholder, the title of the chosen list item gets set in the textview
     */
    @Override
    public void onBindViewHolder(@NonNull PortalAdapter.ViewHolder holder, int position) {
        Portal portal = mPortals.get(position);
        holder.textView.setText(portal.getTitel());
    }

    /**
     * The length of the recyclerview
     */
    @Override
    public int getItemCount() {
        return mPortals.size();
    }

    /**
     *  This is the viewholder class that the adapter is using.
     */
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView textView;
        public View view;


        public ViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.portalTextView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int clickedPosition = getAdapterPosition();
            mPortalClickListener.portalOnClick(clickedPosition);

        }
    }

    public interface PortalClickListener{
        void portalOnClick (int i);
    }
}
