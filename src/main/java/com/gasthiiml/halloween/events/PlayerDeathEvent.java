package com.gasthiiml.halloween.events;

import com.gasthiiml.halloween.Halloween;
import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Random;
import java.util.UUID;

@SuppressWarnings("ALL")
public class PlayerDeathEvent implements Listener {

    private Halloween plugin;

    public PlayerDeathEvent(Halloween plg) {
        plugin = plg;
    }

    @EventHandler
    public void onDeath(org.bukkit.event.entity.PlayerDeathEvent e) {
        Player p = e.getEntity().getPlayer();
        Player killer = e.getEntity().getKiller();

        if(killer != null) {
            if(plugin.config.getBoolean("Random-Skull-On-Kill.Enabled").equals(true)) {
                if (plugin.config.getBoolean("Pumpkin.Enabled").equals(true)
                        && plugin.config.getBoolean("Candy.Enabled").equals(true)) {
                    Random random = new Random();
                    int randomSkull = random.nextInt(2);

                    if (randomSkull == 0) {
                        ItemStack item = new ItemStack(Material.SKULL_ITEM, 1, (byte) 3);
                        SkullMeta meta = (SkullMeta) item.getItemMeta();
                        ArrayList<String> lore = new ArrayList<>();

                        for (String s : plugin.config.getStringList("Pumpkin.Lore")) {
                            lore.add(ChatColor
                                    .translateAlternateColorCodes('&', s));
                        }

                        GameProfile profile = new GameProfile(UUID
                                .fromString(plugin.config.getString("Pumpkin.Skull-UUID")), null);
                        profile.getProperties().put("textures", new Property("textures",
                                plugin.config.getString("Pumpkin.Skull-Value")));
                        Field profileField;
                        try {
                            profileField = meta.getClass().getDeclaredField("profile");
                            profileField.setAccessible(true);
                            profileField.set(meta, profile);
                        } catch (NoSuchFieldException
                                 | IllegalArgumentException
                                 | IllegalAccessException ex) {
                            ex.printStackTrace();
                        }

                        meta.setDisplayName(ChatColor
                                .translateAlternateColorCodes('&',
                                        plugin.config.getString("Pumpkin.Display-Name")));
                        meta.setLore(lore);
                        item.setItemMeta(meta);

                        killer.getInventory().addItem(item);

                        if(plugin.config
                                .getBoolean(
                                        "Random-Skull-On-Kill.Messages.Pumpkin.Enabled").equals(true)) {
                            killer.sendMessage(ChatColor
                                    .translateAlternateColorCodes('&',
                                            plugin.config.getString(
                                                            "Random-Skull-On-Kill.Messages.Pumpkin.Message")
                                                    .replaceAll("%player%", p.getName())));
                        }
                    }
                    else if (randomSkull == 1) {
                        ItemStack item = new ItemStack(Material.SKULL_ITEM, 1, (byte) 3);
                        SkullMeta meta = (SkullMeta) item.getItemMeta();
                        ArrayList<String> lore = new ArrayList<>();

                        for (String s : plugin.config.getStringList("Pumpkin.Lore")) {
                            lore.add(ChatColor
                                    .translateAlternateColorCodes('&', s));
                        }

                        GameProfile profile = new GameProfile(UUID
                                .fromString(plugin.config.getString("Pumpkin.Skull-UUID")), null);
                        profile.getProperties().put("textures", new Property("textures",
                                plugin.config.getString("Pumpkin.Skull-Value")));
                        Field profileField;
                        try {
                            profileField = meta.getClass().getDeclaredField("profile");
                            profileField.setAccessible(true);
                            profileField.set(meta, profile);
                        } catch (NoSuchFieldException
                                 | IllegalArgumentException
                                 | IllegalAccessException ex) {
                            ex.printStackTrace();
                        }

                        meta.setDisplayName(ChatColor
                                .translateAlternateColorCodes('&',
                                        plugin.config.getString("Pumpkin.Display-Name")));
                        meta.setLore(lore);
                        item.setItemMeta(meta);

                        killer.getInventory().addItem(item);

                        if(plugin.config
                                .getBoolean(
                                        "Random-Skull-On-Kill.Messages.Pumpkin.Enabled").equals(true)) {
                            killer.sendMessage(ChatColor
                                    .translateAlternateColorCodes('&',
                                            plugin.config.getString(
                                                    "Random-Skull-On-Kill.Messages.Pumpkin.Message")
                                                    .replaceAll("%player%", p.getName())));
                        }
                    }
                    else if (randomSkull == 2) {
                        ItemStack item = new ItemStack(Material.SKULL_ITEM, 1, (byte) 3);
                        SkullMeta meta = (SkullMeta) item.getItemMeta();
                        ArrayList<String> lore = new ArrayList<>();

                        for (String s : plugin.config.getStringList("Candy.Lore")) {
                            lore.add(ChatColor
                                    .translateAlternateColorCodes('&', s));
                        }

                        GameProfile profile = new GameProfile(UUID
                                .fromString(plugin.config.getString("Candy.Skull-UUID")), null);
                        profile.getProperties().put("textures", new Property("textures",
                                plugin.config.getString("Candy.Skull-Value")));
                        Field profileField;
                        try {
                            profileField = meta.getClass().getDeclaredField("profile");
                            profileField.setAccessible(true);
                            profileField.set(meta, profile);
                        } catch (NoSuchFieldException
                                 | IllegalArgumentException
                                 | IllegalAccessException ex) {
                            ex.printStackTrace();
                        }

                        meta.setDisplayName(ChatColor
                                .translateAlternateColorCodes('&',
                                        plugin.config.getString("Candy.Display-Name")));
                        meta.setLore(lore);
                        item.setItemMeta(meta);

                        killer.getInventory().addItem(item);

                        if(plugin.config
                                .getBoolean(
                                        "Random-Skull-On-Kill.Messages.Candy.Enabled").equals(true)) {
                            killer.sendMessage(ChatColor
                                    .translateAlternateColorCodes('&',
                                            plugin.config.getString(
                                                            "Random-Skull-On-Kill.Messages.Candy.Message")
                                                    .replaceAll("%player%", p.getName())));
                        }
                    }
                }
            }
            if(plugin.config.getBoolean("Messages.On-Kill-Player.Enabled").equals(true)) {
                killer.sendMessage(ChatColor
                        .translateAlternateColorCodes('&',
                                plugin.config.getString("Messages.On-Kill-Player.Message")
                                        .replaceAll("%player%", p.getName())));
            }
            if(plugin.config.getBoolean("Messages.On-Death-By-Player.Enabled").equals(true)) {
                p.sendMessage(ChatColor
                        .translateAlternateColorCodes('&',
                                plugin.config.getString("Messages.On-Death-By-Player.Message")
                                        .replaceAll("%player%", killer.getName())));
            }
            if(plugin.config.getBoolean("Commands.On-Kill-Player.As-Console.Enabled").equals(true)) {
                ArrayList<String> commands = new ArrayList<>();

                for(String s : plugin.config.getStringList("Commands.On-Kill-Player.As-Console.List")) {
                    commands.add(s
                            .replaceAll("%player%", killer.getName()));
                }
                for(String s : commands) {
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), s);
                }
            }
            if(plugin.config.getBoolean("Commands.On-Kill-Player.As-Player.Enabled").equals(true)) {
                ArrayList<String> commands = new ArrayList<>();

                for(String s : plugin.config.getStringList("Commands.On-Kill-Player.As-Player.List")) {
                    commands.add(s
                            .replaceAll("%player%", killer.getName()));
                }
                for(String s : commands) {
                    Bukkit.dispatchCommand(killer, s);
                }
            }
            if(plugin.config.getBoolean("Commands.On-Death-By-Player.As-Console.Enabled").equals(true)) {
                ArrayList<String> commands = new ArrayList<>();

                for(String s : plugin.config.getStringList("Commands.On-Death-By-Player.As-Console.List")) {
                    commands.add(s
                            .replaceAll("%player%", p.getName()));
                }
                for(String s : commands) {
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), s);
                }
            }
            if(plugin.config.getBoolean("Commands.On-Death-By-Player.As-Player.Enabled").equals(true)) {
                ArrayList<String> commands = new ArrayList<>();

                for(String s : plugin.config.getStringList("Commands.On-Death-By-Player.As-Player.List")) {
                    commands.add(s
                            .replaceAll("%player%", p.getName()));
                }
                for(String s : commands) {
                    Bukkit.dispatchCommand(p, s);
                }
            }
        }
        else return;
    }
}
