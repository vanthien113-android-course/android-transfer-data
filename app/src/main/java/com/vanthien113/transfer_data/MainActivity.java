package com.vanthien113.transfer_data;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements TestClickListener {
    private EditText etInput;
    private Button btOK;
    private LinearLayout llParent;
    private TextView tvResponse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etInput = findViewById(R.id.etInput);
        btOK = findViewById(R.id.btOK);
        llParent = findViewById(R.id.llParent);
        tvResponse = findViewById(R.id.tvResponse);

        btOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.llParent, TestFragment.newInstance(etInput.getText().toString()), "testFragment")
                        .commit();

            }
        });
    }

    @Override
    public void onSendClick(String message) {
        tvResponse.setText(message);
    }
}

interface TestClickListener {
    void onSendClick(String message);
}
