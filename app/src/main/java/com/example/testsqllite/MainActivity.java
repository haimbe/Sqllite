package com.example.testsqllite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView scoresView;
    private DatabaseManager databaseManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scoresView = (TextView) findViewById(R.id.scoresView);
        databaseManager = new DatabaseManager( this);

        databaseManager.insertScore("Bruno",1000);

        databaseManager.close();
    }
}
