package com.alma.methoda;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TransactionAdapter extends RecyclerView.Adapter<TransactionAdapter.MyViewHolder> {

        Context context;
        List<TransactionDataModel> transactionDataModelList;

    public TransactionAdapter(Context context, List<TransactionDataModel> transactionDataModelList) {
            this.context = context;
            this.transactionDataModelList = transactionDataModelList;
        }

        public void setTransactionDataModelList(List<TransactionDataModel> transactionDataModelList) {
            this.transactionDataModelList = transactionDataModelList;
            notifyDataSetChanged();
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(context).inflate(R.layout.transaction_item,parent,false);
            return new MyViewHolder(view);
        }

        @Override
        public void onBindViewHolder(final MyViewHolder holder, final int position) {
            final TransactionDataModel transactionDataModel = transactionDataModelList.get(position);
            if (transactionDataModel != null) {
                holder.labelName_t.setText(transactionDataModel.getName_t());
                holder.label_from.setText(transactionDataModel.getFrom_s());
                holder.label_to.setText(transactionDataModel.getTo_s());
            }
        }

        @Override
        public int getItemCount() {

            if(transactionDataModelList != null)
                return transactionDataModelList.size();
            else return 0;
        }

        public class MyViewHolder extends RecyclerView.ViewHolder {
            TextView labelName_t, label_from,label_to;

            public MyViewHolder(View itemView) {
                super(itemView);
                labelName_t = itemView.findViewById(R.id.labelName_t);
                label_from = itemView.findViewById(R.id.label_from);
                label_to = itemView.findViewById(R.id.label_to);
            }
        }
    }