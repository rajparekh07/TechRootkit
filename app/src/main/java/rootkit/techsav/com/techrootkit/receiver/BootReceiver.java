package rootkit.techsav.com.techrootkit.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import rootkit.techsav.com.techrootkit.services.BootCompletionService;

public class BootReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if (Intent.ACTION_BOOT_COMPLETED.equals(intent.getAction())) {
            Log.i("ROOT", "Starting SRGB service");
            Intent serviceIntent = new Intent(context, BootCompletionService.class);
            context.startService(serviceIntent);
        }
    }
}