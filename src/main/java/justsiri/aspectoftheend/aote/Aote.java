package justsiri.aspectoftheend.aote;

import justsiri.aspectoftheend.aote.Commands.AspectOfTheEnd;
import justsiri.aspectoftheend.aote.Listener.RClickWithAOTE;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Aote extends JavaPlugin {

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(new RClickWithAOTE(), this);
        getCommand("aote").setExecutor(new AspectOfTheEnd());
    }

}
