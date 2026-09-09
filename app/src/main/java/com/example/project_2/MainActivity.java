package com.example.project_2;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText editTextText;
    private RadioGroup radioGroup;
    private Button button;

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

        editTextText = findViewById(R.id.editTextText);
        radioGroup = findViewById(R.id.radioGroup);
        button = findViewById(R.id.button);

        button.setOnClickListener(v -> handleSubmit());
    }

    private void handleSubmit() {
        String name = editTextText.getText().toString().trim();
        int selectedRadioId = radioGroup.getCheckedRadioButtonId();

        if (name.isEmpty()) {
            Toast.makeText(this, "Harap masukkan nama!", Toast.LENGTH_SHORT).show();
            return;
        }

        if (selectedRadioId == -1) {
            Toast.makeText(this, "Harap pilih jenis telepon!", Toast.LENGTH_SHORT).show();
            return;
        }

        RadioButton selectedRadioButton = findViewById(selectedRadioId);
        String phoneType = selectedRadioButton.getText().toString();

        String resultMessage = "Nama: " + name + "\nJenis: " + phoneType;
        Toast.makeText(this, resultMessage, Toast.LENGTH_LONG).show();
    }
}