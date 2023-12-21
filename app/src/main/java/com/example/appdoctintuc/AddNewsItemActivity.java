package com.example.appdoctintuc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class AddNewsItemActivity extends AppCompatActivity {

    private EditText titleEditText, imageUrlEditText, contentUrlEditText;
    private Button addButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_news_item2);

        titleEditText = findViewById(R.id.title_input);
        imageUrlEditText = findViewById(R.id.image_url_input);
        contentUrlEditText = findViewById(R.id.content_url_input);
        addButton = findViewById(R.id.add_news_button);

        addButton.setOnClickListener(view -> {
            // Create a new NewsItem from user input
            String title = titleEditText.getText().toString().trim();
            String imageUrl = imageUrlEditText.getText().toString().trim();
            String contentUrl = contentUrlEditText.getText().toString().trim();

            NewsItem newsItem = new NewsItem(imageUrl, title, contentUrl);

            // Return the result to MainActivity
            Intent resultIntent = new Intent();
            resultIntent.putExtra("NEW_NEWS_ITEM", newsItem);
            setResult(RESULT_OK, resultIntent);
            finish(); // Close the activity
        });
    }
}
