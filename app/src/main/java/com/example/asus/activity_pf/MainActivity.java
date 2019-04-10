package com.example.asus.activity_pf;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.res.Resources;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private static final int menu_setting = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        FragmentPreferences fragmentPreferences = new FragmentPreferences();

        transaction.replace(android.R.id.content, fragmentPreferences).addToBackStack(null);
        transaction.commit();

    }
   /* @Override
    public boolean onCreateOptionsMenu(final Menu menu){
        menu.add(0,menu_setting,1,"设置");
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(final MenuItem item) {
        return true;
    }
*/
}
