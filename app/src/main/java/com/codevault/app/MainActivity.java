package com.codevault.app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.util.Base64;

public class MainActivity extends AppCompatActivity {

    private EditText code;
    private EditText text1;
    private TextView text2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        code = findViewById(R.id.codeEditText);
        text1 = findViewById(R.id.text1EditText);
        text2 = findViewById(R.id.text2TextView);

        Button encryptButton = findViewById(R.id.encryptButton);
        encryptButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                encrypt();
            }
        });

        Button decryptButton = findViewById(R.id.decryptButton);
        decryptButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                decrypt();
            }
        });

        Button resetButton = findViewById(R.id.resetButton);
        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reset();
            }
        });
    }

    public void encrypt() {
        String password = code.getText().toString();
        if (password.equals("1234")) {
            String message = text1.getText().toString();
            byte[] encodeMessage = message.getBytes();
            byte[] base64Bytes = Base64.encode(encodeMessage, Base64.DEFAULT);
            String encrypt = new String(base64Bytes);

            text2.setText(encrypt);

        } else if (password.isEmpty()) {
            Toast.makeText(this, "Enter The Secret Key", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Invalid Secret Key", Toast.LENGTH_SHORT).show();
        }
    }

    public void decrypt() {
        String password = code.getText().toString();
        if (password.equals("1234")) {
            String message = text1.getText().toString();
            byte[] decodeMessage = message.getBytes();
            byte[] base64Bytes = Base64.decode(decodeMessage, Base64.DEFAULT);
            String decrypt = new String(base64Bytes);

            text2.setText(decrypt);

        } else if (password.isEmpty()) {
            Toast.makeText(this, "Enter The Secret Key", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Invalid Secret Key", Toast.LENGTH_SHORT).show();
        }
    }

    public void reset() {
        code.setText("");
        text1.setText("");
        text2.setText("");
    }
}
