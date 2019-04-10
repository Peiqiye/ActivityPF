package com.example.asus.activity_pf;
import android.os.Bundle;
import android.preference.PreferenceFragment;



public class FragmentPreferences extends PreferenceFragment{
    public void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.lnline);
    }

}
