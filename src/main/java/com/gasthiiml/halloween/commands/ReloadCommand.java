package com.gasthiiml.halloween.commands;

import com.gasthiiml.halloween.Halloween;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import java.io.IOException;

@SuppressWarnings("ALL")
public class ReloadCommand implements CommandExecutor {

    private Halloween plugin;

    public ReloadCommand(Halloween plg) {
        plugin = plg;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player) {
            Player p = (Player) commandSender;

            if (p.hasPermission("minelatino.halloween.reload")) {
                try {
                    plugin.config.reload();
                    p.sendMessage(ChatColor
                            .translateAlternateColorCodes('&',
                                    plugin.config.getString("Messages.Reloaded")));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            } else {
                p.sendMessage(ChatColor
                        .translateAlternateColorCodes('&',
                                plugin.config.getString("Messages.No-Permission")));
            }
        }
        if (commandSender instanceof ConsoleCommandSender) {
            try {
                plugin.config.reload();
                plugin.getLogger().info("Reloaded config!");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        return true;
    }
}
