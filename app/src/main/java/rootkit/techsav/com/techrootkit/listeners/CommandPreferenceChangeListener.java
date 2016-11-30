package rootkit.techsav.com.techrootkit.listeners;

import android.preference.Preference;

import rootkit.techsav.com.techrootkit.utils.RootCommandExecutor;

/**
 * Created by Raj on 30-11-2016.
 */

public class CommandPreferenceChangeListener implements Preference.OnPreferenceChangeListener {
    private RootCommandExecutor commandExecutor;

    public CommandPreferenceChangeListener(RootCommandExecutor commandExecutor) {
        this.commandExecutor = commandExecutor;
    }

    @Override
    public boolean onPreferenceChange(Preference preference, Object o) {
        boolean srgbModeEnabled = (boolean) o;
        String command = srgbModeEnabled ? commandExecutor.activate() : commandExecutor.deactivate();
        return command.equals("");
    }
}
