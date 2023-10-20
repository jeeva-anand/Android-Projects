package com.example.optionmenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_items,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int duration = Toast.LENGTH_SHORT;
        Toast toast;
        if (item.getItemId() == R.id.user_share) {
            toast = Toast.makeText(this, "Share Integration in-progress....", duration);
            toast.show();
        }else if(item.getItemId() == R.id.item_profile){
            toast = Toast.makeText(this, "Profile Integration in-progress....", duration);
            toast.show();
        }else if(item.getItemId() == R.id.logout){
            toast = Toast.makeText(this, "Log out Integration in-progress....", duration);
            toast.show();
        }
        return super.onOptionsItemSelected(item);
    }
} 
