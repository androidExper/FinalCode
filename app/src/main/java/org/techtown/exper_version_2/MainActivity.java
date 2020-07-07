package org.techtown.exper_version_2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    HomeFragment homeFragment;
    SearchFragment searchFragment;
    AnalysisFragment analysisFragment;
    ArrayList<Food> foodList = new ArrayList<Food>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<Integer> Test = new ArrayList<Integer>(10);

        // 하단 탭 Fragment
        homeFragment = new HomeFragment();
        searchFragment = new SearchFragment();
        analysisFragment = new AnalysisFragment();

        getSupportFragmentManager().beginTransaction().replace(R.id.container,homeFragment).commit();

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch(item.getItemId()){
                            case R.id.tabhome:
                                getSupportFragmentManager().beginTransaction().replace(R.id.container,homeFragment).commit();
                                return true;

                            case R.id.tabsearch:
                                getSupportFragmentManager().beginTransaction().replace(R.id.container,searchFragment).commit();
                                return true;

                            case R.id.tabanlaysis:
                                getSupportFragmentManager().beginTransaction().replace(R.id.container,analysisFragment).commit();
                                return true;

                            case R.id.tabtest:
                                return true;
                        }
                        return false;
                    }
                }
        );
    }

    // ListItem Touch 되었을 경우 , 액티비티 전환
    public void ItemSelected(String itemName){
        Toast.makeText(this,itemName+" Clicked",Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getApplicationContext(),ListItemInfo.class);
        intent.putExtra("itemName",itemName);
        startActivityForResult(intent,101);
    }
}
