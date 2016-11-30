package rootkit.techsav.com.techrootkit;

import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.SwitchPreference;
import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;

import rootkit.techsav.com.techrootkit.commands.SRGBCommand;
import rootkit.techsav.com.techrootkit.listeners.CommandPreferenceChangeListener;
import rootkit.techsav.com.techrootkit.utils.RootCommandExecutor;

/**
 * Created by Raj on 22-11-2016.
 */

public class SettingsMainFragment extends PreferenceFragment
{
    private SwitchPreference sRGBSwitch;
    private SRGBCommand sRGBCommand;
    @Override
    public void onCreate(final Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preference);
        sRGBCommand = new SRGBCommand();
        sRGBSwitch = (SwitchPreference) findPreference("pref_srgb");
        setListenersForPrefereneces();
    }
    private boolean setListenersForPrefereneces(){
        sRGBSwitch.setOnPreferenceChangeListener(new CommandPreferenceChangeListener(sRGBCommand));
        return true;
    }
}