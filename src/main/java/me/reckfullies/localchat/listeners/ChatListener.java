package me.reckfullies.localchat.listeners;

import me.reckfullies.localchat.LocalChat;
import me.reckfullies.localchat.config.ConfigCommand;
import org.apache.commons.lang.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import java.util.List;

public class ChatListener implements Listener
{
    private List<ConfigCommand> possibleCommands;
    private String normalChatFormat;

    @SuppressWarnings("unchecked")
    public ChatListener(LocalChat pluginInstance)
    {
        this.possibleCommands = (List<ConfigCommand>) pluginInstance.getConfig().getList("commands");
        this.normalChatFormat = pluginInstance.getConfig().getString("normal-chat.format");
    }

    @EventHandler
    public void OnPlayerCommand(PlayerCommandPreprocessEvent event)
    {
        for (ConfigCommand command : possibleCommands)
        {
            for (String alias : command.aliases)
            {
                String[] args = event.getMessage().split("\\s+");

                if (args[0].equalsIgnoreCase(alias))
                {
                    String joinedMessage = StringUtils.join(args, " ").replace(args[0], "").trim();

                    if (!joinedMessage.isEmpty())
                    {
                        String formattedMessage = formatMessage(event.getPlayer().getDisplayName(), joinedMessage, command.format);
                        SendMessage(formattedMessage, event.getPlayer().getLocation(), command.radius);
                    }

                    event.setCancelled(true);
                }
            }
        }
    }

    @EventHandler
    public void OnPlayerChat(AsyncPlayerChatEvent event)
    {
        String formattedMessage = formatMessage(event.getPlayer().getDisplayName(), event.getMessage(), normalChatFormat);
        event.setFormat(formattedMessage);
    }

    private String formatMessage(String name, String message, String format)
    {
        String formattedMessage = format;

        formattedMessage = formattedMessage.replace("<name>", name);
        formattedMessage = formattedMessage.replace("<message>", message);
        formattedMessage = ChatColor.translateAlternateColorCodes('&', formattedMessage);

        return formattedMessage;
    }

    private void SendMessage(String message, Location location, int radius)
    {
        for (Player player : Bukkit.getOnlinePlayers())
        {
            if (radius <= 0)
            {
                player.sendMessage(message);
            }
            else
            {
                double distance = location.distanceSquared(player.getLocation());
                if (distance <= Math.pow(radius, 2))
                {
                    player.sendMessage(message);
                }
            }
        }
    }
}
