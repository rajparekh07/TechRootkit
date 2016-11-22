package rootkit.techsav.com.techrootkit;

import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.SwitchPreference;
import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;

import rootkit.techsav.com.techrootkit.utils.RootCommandExecutor;

/**
 * Created by Raj on 22-11-2016.
 */

public class SettingsMainFragment extends PreferenceFragment
{
    private String sRGBCommandEnabler = "echo 1 > /sys/class/graphics/fb0/srgb";
    private String sRGBCommandDisabler = "echo 0 > /sys/class/graphics/fb0/srgb";
    private String sRGBValueGetter = "cat /sys/class/graphics/fb0/srgb";
    private SwitchPreference srgbSwitch;
    @Override
    public void onCreate(final Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preference);
        srgbSwitch = (SwitchPreference) findPreference("pref_srgb");
        setListenersForPrefereneces();
    }
    private boolean setListenersForPrefereneces(){
        srgbSwitch.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(Preference preference, Object o) {
                boolean srgbModeEnabled = (boolean) o;
                String command = srgbModeEnabled ? sRGBCommandEnabler : sRGBCommandDisabler;
                Log.d("Root",command + " " + srgbModeEnabled);
                executeCommandFor(command);
                return true;
            }
        });
        return true;
    }
    private boolean getValuesCurrently(){
        srgbSwitch.setChecked(
                executeCommandFor(sRGBValueGetter).equals("1")
        );
        return true;
    }
    private String executeCommandFor(final String... preference){
        new Thread(new Runnable() {
            @Override
            public void run() {
                new RootCommandExecutor(
                ) {
                    @Override
                    protected ArrayList<String> getCommandsToExecute() {
                        return new ArrayList<String>(Arrays.asList(preference));
                    }
                }.execute();
            }
        }).start();
        return "0";
    }
}