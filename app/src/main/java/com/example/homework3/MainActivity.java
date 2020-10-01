package com.example.homework3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.homework3.model.WordId;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // สร้าง Layout manager
        LinearLayoutManager lm = new LinearLayoutManager(MainActivity.this);

        // สร้าง Adapter object
        MyAdapter adapter = new MyAdapter();

        // เข้าถึง  RecyclerView ใน layout
        RecyclerView rv = findViewById(R.id.word_list_recycler_view);
        rv.setLayoutManager(lm); // กำหนด layout manager ให้กับ RecyclerView
        rv.setAdapter(adapter); // กำหนด adapter ให้กับ RecyclerView
    }
}

    class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{
        private WordId[] items = {
                new WordId(R.drawable.Thai,"Thailand","ประเทศไทย"),
                new WordId(R.drawable.singapore,"Singapore","ประเทศสิงคโป"),
                new WordId(R.drawable.american, "America","ประเทศอเมริกา"),
                new WordId(R.drawable.union, "England","ประเทศอังกฤษ"),
                new WordId(R.drawable.italy, "Italy","ประเทศอิตาลี"),
                new WordId(R.drawable.julia, "Korea","ประเทศเกาหลี"),
                new WordId(R.drawable.france, "France","ประเทศฝรั่งเศส"),
                new WordId(R.drawable.australia, "Australia","ประเทศออสเตรเลีย"),
                new WordId(R.drawable.jamaica, "Jamaica","ประเทศจาเมก้า"),
                new WordId(R.drawable.flag, "Chaina","ประเทศจีน")
    };
        MyAdapter() {

        }

        @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.word, parent, false);
            MyViewHolder vh = new MyViewHolder(v);
            return vh;
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
            holder.imageView.setImageResource(items[position].imageResId);
            holder.wordTextView.setText(items[position].word);
            holder.wordTextView2.setText(items[position].word2);
        }

        @Override
        public int getItemCount() {
            return 10;
        }

        static class MyViewHolder extends RecyclerView.ViewHolder {
            ImageView imageView;
            TextView wordTextView;
            TextView wordTextView2;

            MyViewHolder(@NonNull View itemView) {
                super(itemView);
                imageView = itemView.findViewById(R.id.image_view);
                wordTextView = itemView.findViewById(R.id.word_text_view);
                wordTextView2 = itemView.findViewById(R.id.word_text_view2);
            }
        }
    }
