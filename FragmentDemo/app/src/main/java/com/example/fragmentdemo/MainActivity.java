package com.example.fragmentdemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private String profileName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.main_toolbar);
        setSupportActionBar(toolbar);

        loadFragment(new HomeFragment(),"home", false);
    }

    private void loadFragment(Fragment fragment, String tag, boolean addToBackStack) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, fragment, tag);
        if(addToBackStack) {
            transaction.addToBackStack(tag);
        }
        transaction.commit();
    }

    //Ez a menü megjelenítésére szolgál.
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    //Ez a függvény meg a menü sikeres kijelölésére.
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_home:
                //showMessage("Főoldal");
                loadFragment(new HomeFragment(), "home", true);
                break;
            case R.id.action_profile:
                //showMessage("Profil");
                loadFragment(new ProfilFragment(), "profil", true);
                break;
            case R.id.action_settings:
                //showMessage("Beállítások");
                Intent intent = new Intent(getApplicationContext(), SettingsActivity.class);
                startActivity(intent);
                break;
        }
        return true;
    }

    private void showMessage(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    public void navigateToHome() {
        loadFragment(new HomeFragment(),"home", true);
    }

    public void saveAndNavigateToHome(String profileName) {
        this.profileName = this.profileName;
        navigateToHome();
    }

    // home fragment hívja
    public String getProfileName() {
        return profileName;
    }

    // profile frament hívja
    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }
}