package com.example.hellotoasthmw;


import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private int count =0;
    private TextView displayCount;
    private Button countBtn;
    private Button zeroBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            displayCount = findViewById(R.id.display_count);
            countBtn = findViewById(R.id.count_btn);
            zeroBtn = findViewById(R.id.zero_btn);


            return insets;
        });
    }

    public void showToast(View view){
        Toast.makeText(this,"Hello Toast",Toast.LENGTH_SHORT).show();

    }

    public void showCount(View view){
        count++;

        if(displayCount != null){
            displayCount.setText(count+"");
        }
        zeroBtn.setBackgroundColor(Color.MAGENTA);

        if(count %2 == 0){
            view.setBackgroundColor(Color.BLUE);
        }else{
            view.setBackgroundColor(Color.GREEN);
        }

    }

    public void showZero(View view){
        count = 0;

        displayCount.setText(count+"");
        view.setBackgroundColor(Color.GRAY);
        countBtn.setBackgroundColor(Color.parseColor("#ff6750a4"));
    }
}