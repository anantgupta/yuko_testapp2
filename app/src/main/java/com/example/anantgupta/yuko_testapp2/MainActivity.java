package com.example.anantgupta.yuko_testapp2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private Button msendData;
    private EditText name;
    private FirebaseFirestore mFirestore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mFirestore = FirebaseFirestore.getInstance();
        name = (EditText) findViewById(R.id.name);

        msendData = (Button) findViewById(R.id.sendData);



        msendData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = name.getText().toString();

                HashMap<String, String> userMap = new HashMap<String, String>();
                userMap.put("name", username);

                mFirestore.collection("test_users").add(userMap);
            }
        });




    }
}
