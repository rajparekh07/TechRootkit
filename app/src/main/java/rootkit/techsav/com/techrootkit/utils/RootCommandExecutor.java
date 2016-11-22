package rootkit.techsav.com.techrootkit.utils;

import android.util.Log;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Raj on 22-11-2016.
 */

public abstract class RootCommandExecutor
{
    public final String execute()
    {
        boolean retval = false;
        String returnMessage = "";
        try
        {
            ArrayList<String> commands = getCommandsToExecute();
            if (null != commands && commands.size() > 0)
            {
                Process suProcess = Runtime.getRuntime().exec("su");
                DataOutputStream os = new DataOutputStream(suProcess.getOutputStream());
                // Execute commands that require root access
                for (String currCommand : commands)
                {
                    os.writeBytes(currCommand + "\n");
                    os.flush();
                }
                os.writeBytes("exit\n");
                os.flush();
            }
        }
        catch (IOException ex)
        {
            Log.d("ROOT", "Can't get root access");
        }
        catch (Exception ex)
        {
            Log.d("ROOT", "Error executing internal operation");
        }
        return retval ? returnMessage : "Failed to get root";
    }
    protected abstract ArrayList<String> getCommandsToExecute();
}