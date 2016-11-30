package rootkit.techsav.com.techrootkit.commands;

import java.util.ArrayList;

import rootkit.techsav.com.techrootkit.utils.RootCommandExecutor;

/**
 * Created by Raj on 30-11-2016.
 */

public class SRGBCommand extends RootCommandExecutor {
    private final static String commandToActivate="echo 1 > /sys/class/graphics/fb0/srgb",commandToDeactivate="echo 0 > /sys/class/graphics/fb0/srgb";
    public String activate(){
        clearListAndAdd(commandToActivate);
        return execute();
    }

    public String deactivate(){
        clearListAndAdd(commandToDeactivate);
        return execute();
    }
}
