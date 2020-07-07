package org.techtown.exper_version_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Button changBtn = findViewById(R.id.changeBtn);
        changBtn.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                finish();
            }
        });
    }
}
