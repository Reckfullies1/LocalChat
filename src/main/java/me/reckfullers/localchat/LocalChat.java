package me.reckfullers.localchat;

import me.reckfullers.localchat.config.ConfigCommand;
import me.reckfullers.localchat.listeners.ChatListener;
import org.bukkit.configuration.serialization.ConfigurationSerialization;
import org.bukkit.plugin.java.JavaPlugin;

public final class LocalChat extends JavaPlugin
{
    @Override
    public void onEnable()
    {
        // Setup config
        this.saveDefaultConfig();

        // Register configuration classes
        ConfigurationSerialization.registerClass(ConfigCommand.class);

        // Register listener
        this.getServer().getPluginManager().registerEvents(new ChatListener(this), this);
    }

    @Override
    public void onDisable()
    {
        // Plugin shutdown logic
    }
}
