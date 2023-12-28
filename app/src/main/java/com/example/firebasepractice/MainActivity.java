package com.example.firebasepractice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.firebasepractice.databinding.ActivityMainBinding;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {


    ActivityMainBinding binding;
    
    
    // because we want the object of the firebase Database
    FirebaseDatabase db;
    // reference means child nodes ,
    DatabaseReference root ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        
        
        binding.btnDatabase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
                // first we need to create object of the database 
                // this step create object of the database
                db = FirebaseDatabase.getInstance();
                
                // now we have objet now we want to reference of the node 
                // if we want to reference of the child node so we pass the name into get reference
                root = db.getReference();
                
                // now we want to insert values 
                root.setValue(binding.etName.getText().toString().trim());
                Toast.makeText(MainActivity.this, "VALUE ARE INSERTED ", Toast.LENGTH_SHORT).show();
                
            }
        });
    }
}