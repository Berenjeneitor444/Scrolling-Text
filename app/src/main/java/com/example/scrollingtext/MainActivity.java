package com.example.scrollingtext;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        findViewById(R.id.add_comment).setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    findViewById(R.id.comment_text).setVisibility(View.VISIBLE);
                    findViewById(R.id.submit_comment).setVisibility(View.VISIBLE);
                    findViewById(R.id.add_comment).setVisibility(View.GONE);
                    findViewById(R.id.edit_text).setVisibility(View.GONE);
                }
        });
        findViewById(R.id.submit_comment).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                EditText commentText = findViewById(R.id.comment_text);
                String comment = commentText.getText().toString();
                commentText.setText("");
                TextView commentView = new TextView(MainActivity.this);
                commentView.setText("Anonimous: " + comment);
                ((LinearLayout) findViewById(R.id.content)).addView(commentView);
                commentText.setVisibility(View.GONE);
                findViewById(R.id.submit_comment).setVisibility(View.GONE);
                findViewById(R.id.add_comment).setVisibility(View.VISIBLE);
                findViewById(R.id.edit_text).setVisibility(View.VISIBLE);

            }
        });
        findViewById(R.id.edit_text).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button editButton = findViewById(R.id.edit_text);
                if (editButton.getText().equals("Edit Text")) {
                    EditText article = findViewById(R.id.article);
                    article.setEnabled(true);
                    editButton.setText("Save");
                } else {
                    EditText article = findViewById(R.id.article);
                    article.setEnabled(false);
                    editButton.setText("Edit Text");
                }
            }
        });
    }

}