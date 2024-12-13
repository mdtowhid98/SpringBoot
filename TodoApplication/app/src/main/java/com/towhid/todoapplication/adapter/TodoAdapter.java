package com.towhid.todoapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.towhid.todoapplication.R;
import com.towhid.todoapplication.model.TodoModel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class TodoAdapter extends RecyclerView.Adapter<TodoAdapter.ViewHolder> {

    private List<TodoModel> todoList;
    private Context context;

    public TodoAdapter(List<TodoModel> todoList, Context context) {
        this.todoList = todoList;
        this.context = context;
    }

    @NonNull
    @Override
    public TodoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.todo_card, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TodoAdapter.ViewHolder holder, int position) {
        TodoModel todo = todoList.get(position);

        holder.textTitle.setText("Title: " + todo.getTitle());
        holder.textDescription.setText("Description: " + todo.getDescription());

        // Format date to "11 Dec 2024"
        String formattedDate = formatDate(todo.getDate());
        holder.textDate.setText("Date: " + formattedDate);

        holder.textTodotype.setText("Todo Type: " + todo.getTodotype());
        holder.textPriority.setText("Priority: " + todo.getPriority());
    }

    @Override
    public int getItemCount() {
        return todoList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textDate;
        TextView textDescription;
        TextView textTitle;
        TextView textTodotype;
        TextView textPriority;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textDate = itemView.findViewById(R.id.date);
            textDescription = itemView.findViewById(R.id.description);
            textTitle = itemView.findViewById(R.id.title);
            textTodotype = itemView.findViewById(R.id.todoType);
            textPriority = itemView.findViewById(R.id.priority);
        }
    }


    private String formatDate(String inputDate) {
        try {
            // Input date format (change this to match the format of `todo.getDate()`)
            SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());

            // Output format "11 Dec 2024"
            SimpleDateFormat outputFormat = new SimpleDateFormat("dd MMM yyyy", Locale.getDefault());

            Date date = inputFormat.parse(inputDate);
            if (date != null) {
                return outputFormat.format(date);
            } else {
                return inputDate; // Return the original date if parsing fails
            }
        } catch (ParseException e) {
            e.printStackTrace();
            return inputDate; // Return the original date if parsing fails
        }
    }
}
