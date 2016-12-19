package rootkit.techsav.com.techrootkit.services;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.IBinder;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;

import rootkit.techsav.com.techrootkit.commands.SRGBCommand;
import rootkit.techsav.com.techrootkit.utils.RootCommandExecutor;

/**
 * Created by sammekleijn on 18/12/2016.
 */

public class BootCompletionService extends Service {

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        SharedPreferences prefs = this.getSharedPreferences(this.getPackageName() + "_preferences", Context.MODE_PRIVATE);
        boolean srgbModeEnabled = prefs.getBoolean("pref_srgb", false);

        RootCommandExecutor commandExecutor = new SRGBCommand();
        String command = srgbModeEnabled ? commandExecutor.activate() : commandExecutor.deactivate();
    }
}
