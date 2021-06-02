package com.alma.methoda;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class StatusAdapter extends RecyclerView.Adapter<StatusAdapter.MyViewHolder> {

        Context context;
        List<StatusDataModel> statusDataModelList;

    public StatusAdapter(Context context, List<StatusDataModel> statusDataModelList) {
            this.context = context;
            this.statusDataModelList = statusDataModelList;
        }

        public void setStatusDataModelList(List<StatusDataModel> statusDataModelList) {
            this.statusDataModelList = statusDataModelList;
            notifyDataSetChanged();
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(context).inflate(R.layout.status_item,parent,false);
            return new MyViewHolder(view);
        }

        @Override
        public void onBindViewHolder(final MyViewHolder holder, final int position) {
            final StatusDataModel statusDataModel = statusDataModelList.get(position);
            if (statusDataModel != null) {
                holder.labelName_s.setText(statusDataModel.getName_s());
                holder.labelLabel_s.setText(statusDataModel.getLabel_s());
            }
        }

        @Override
        public int getItemCount() {

            if(statusDataModelList != null)
                return statusDataModelList.size();
            else return 0;
        }

        public class MyViewHolder extends RecyclerView.ViewHolder {
            TextView labelName_s, labelLabel_s;

            public MyViewHolder(View itemView) {
                super(itemView);
                labelName_s = itemView.findViewById(R.id.labelName_s);
                labelLabel_s = itemView.findViewById(R.id.labelLabel_s);
            }
        }
    }