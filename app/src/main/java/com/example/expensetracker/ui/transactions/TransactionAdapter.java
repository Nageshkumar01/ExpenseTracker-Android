package com.example.expensetracker.ui.transactions;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.content.Intent;
import com.example.expensetracker.ui.add.AddTransactionActivity;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.expensetracker.R;
import com.example.expensetracker.data.local.TransactionEntity;
import com.example.expensetracker.utils.CurrencyUtils;
import java.util.ArrayList;
import java.util.List;

public class TransactionAdapter extends RecyclerView.Adapter<TransactionAdapter.TransactionHolder> {
    public interface OnDeleteClickListener {
        void onDelete(TransactionEntity transaction);
    }

    private final List<TransactionEntity> items = new ArrayList<>();
    private final OnDeleteClickListener deleteListener;

    public TransactionAdapter(List<TransactionEntity> initialItems, OnDeleteClickListener listener) {
        if (initialItems != null) items.addAll(initialItems);
        deleteListener = listener;
    }

    public void setItems(List<TransactionEntity> newItems) {
        items.clear();
        if (newItems != null) items.addAll(newItems);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public TransactionHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_transaction, parent, false);
        return new TransactionHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TransactionHolder holder, int position) {
        TransactionEntity item = items.get(position);
        holder.title.setText(item.title);
        holder.meta.setText(item.category + " • " + item.date);
        boolean isIncome = "INCOME".equals(item.type);
        holder.amount.setText((isIncome ? "+" : "−") + CurrencyUtils.format(item.amount));
        holder.amount.setTextColor(holder.itemView.getContext().getColor(
                isIncome ? android.R.color.holo_green_dark : android.R.color.holo_red_dark));
        holder.delete.setOnClickListener(v -> deleteListener.onDelete(item));
        holder.itemView.setOnClickListener(v -> { Intent intent = new Intent(v.getContext(), AddTransactionActivity.class); intent.putExtra("transaction_id", item.id); v.getContext().startActivity(intent); });
    }

    @Override
    public int getItemCount() { return items.size(); }

    static class TransactionHolder extends RecyclerView.ViewHolder {
        TextView title, meta, amount;
        ImageButton delete;

        TransactionHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.tvTitle);
            meta = itemView.findViewById(R.id.tvMeta);
            amount = itemView.findViewById(R.id.tvAmount);
            delete = itemView.findViewById(R.id.btnDelete);
        }
    }
}
