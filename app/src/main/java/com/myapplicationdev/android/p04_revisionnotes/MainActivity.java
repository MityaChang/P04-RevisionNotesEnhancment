package com.myapplicationdev.android.p04_revisionnotes;

import android.content.Context;
import android.content.Intent;
import android.inputmethodservice.Keyboard;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btnInsert, btnShow;
    EditText editTextNote;
    RadioButton rbtn1, rbtn2, rbtn3, rbtn4, rbtn5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnInsert = findViewById(R.id.buttonInsertNote);
        btnShow = findViewById(R.id.buttonShowList);
        editTextNote = findViewById(R.id.editTextNote);
        rbtn1 = findViewById(R.id.radio1);
        rbtn2 = findViewById(R.id.radio2);
        rbtn3 = findViewById(R.id.radio3);
        rbtn4 = findViewById(R.id.radio4);
        rbtn5 = findViewById(R.id.radio5);
        btnInsert.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0) {
                // Create the DBHelper object, passing in the
                // activity's Context
                DBHelper db = new DBHelper(MainActivity.this);

                String note = editTextNote.getText().toString();


                // Insert a task

                if (rbtn1.isChecked()){
                    db.insertNote(""+note, 1);
                }

                if (rbtn2.isChecked()){
                    db.insertNote(""+note, 2);
                }

                if (rbtn3.isChecked()){
                    db.insertNote(""+note, 3);
                }

                if (rbtn4.isChecked()){
                    db.insertNote(""+note, 4);
                }

                if (rbtn5.isChecked()){
                    db.insertNote(""+note, 5);
                }
                db.close();
                closeKeyboard();
                Toast.makeText(MainActivity.this,"Inserted", Toast.LENGTH_LONG).show();
            }
        });
        btnShow.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("Test", "DONE");
                startActivity(intent);
            }
        });

    }
    private void closeKeyboard() {
        View view =  this.getCurrentFocus();
        if (view != null){
            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(),0);
        }
    }
}
