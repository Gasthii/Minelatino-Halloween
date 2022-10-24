package com.gasthiiml.halloween.events;

import com.gasthiiml.halloween.Halloween;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;
import java.util.Random;

@SuppressWarnings("ALL")
public class PlayerInteractEvent implements Listener {

    private Halloween plugin;

    public PlayerInteractEvent(Halloween plg) {
        plugin = plg;
    }

    @EventHandler
    public void onInteract(org.bukkit.event.player.PlayerInteractEvent e) {
        try {
            Player p = e.getPlayer();
            ItemStack item = p.getItemInHand();

            if(item.getType().equals(Material.SKULL_ITEM)
                    && item.getItemMeta().hasDisplayName()) {
                if (item.getItemMeta().getDisplayName().equals(ChatColor
                        .translateAlternateColorCodes('&',
                                plugin.config.getString("Pumpkin.Display-Name")))) {
                    if (plugin.config.getBoolean("Pumpkin.Enabled").equals(true)) {
                        if (plugin.config.getBoolean("Sounds.Pumpkin.Enabled").equals(true)) {
                            ArrayList<Sound> sounds = new ArrayList<>();

                            for (String s : plugin.config.getStringList("Sounds.Pumpkin.List")) {
                                sounds.add(Sound.valueOf(s));
                            }
                            Random random = new Random();
                            int randomSound = random.nextInt(sounds.size());
                            Sound sound = sounds.get(randomSound);

                            p.playSound(p.getLocation(), sound, 3.0F, 0.5F);
                        }
                        if (plugin.config.getBoolean("Pumpkin.Potion-Effect.Enabled").equals(true)) {
                            ArrayList<PotionEffectType> potions = new ArrayList<>();
                            ArrayList<Integer> potionDurations = new ArrayList<>();
                            ArrayList<Integer> potionAmplifiers = new ArrayList<>();

                            for (String s : plugin.config.getStringList("Pumpkin.Potion-Effect.List-Potions")) {
                                potions.add(PotionEffectType.getByName(s));
                            }
                            for (Integer i : plugin.config.getIntList("Pumpkin.Potion-Effect.List-Durations")) {
                                potionDurations.add(i);
                            }
                            for (Integer i : plugin.config.getIntList("Pumpkin.Potion-Effect.List-Amplifiers")) {
                                potionAmplifiers.add(i);
                            }

                            Random random = new Random();
                            int randomPotion = random.nextInt(potions.size());

                            PotionEffectType potion = potions.get(randomPotion);
                            int duration = potionDurations.get(randomPotion);
                            int amplifier = potionAmplifiers.get(randomPotion);

                            p.addPotionEffect(new PotionEffect(potion, duration, amplifier));
                        }
                        if (plugin.config.getBoolean("Commands.Pumpkin.As-Console.Enabled").equals(true)) {
                            ArrayList<String> commands = new ArrayList<>();

                            for (String s : plugin.config.getStringList("Commands.Pumpkin.As-Console.List")) {
                                commands.add(s
                                        .replaceAll("%player%", p.getName()));
                            }
                            for (String s : commands) {
                                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), s);
                            }
                        }
                        if (plugin.config.getBoolean("Commands.Pumpkin.As-Player.Enabled").equals(true)) {
                            ArrayList<String> commands = new ArrayList<>();

                            for (String s : plugin.config.getStringList("Commands.Pumpkin.As-Player.List")) {
                                commands.add(s
                                        .replaceAll("%player%", p.getName()));
                            }
                            for (String s : commands) {
                                Bukkit.dispatchCommand(p, s);
                            }
                        }
                        if(plugin.config.getBoolean("Messages.Consumed.Pumpkin.Enabled").equals(true)) {
                            p.sendMessage(ChatColor
                                    .translateAlternateColorCodes('&',
                                            plugin.config
                                                    .getString("Messages.Consumed.Pumpkin.Message")));
                        }
                        p.getInventory().removeItem(item);
                    }
                    else return;
                }
                if(item.getItemMeta().getDisplayName().equals(ChatColor
                        .translateAlternateColorCodes('&',
                                plugin.config.getString("Candy.Display-Name")))) {
                    if(plugin.config.getBoolean("Candy.Enabled").equals(true)) {
                        if(plugin.config.getBoolean("Sounds.Candy.Enabled").equals(true)) {
                            ArrayList<Sound> sounds = new ArrayList<>();

                            for(String s : plugin.config.getStringList("Sounds.Candy.List")) {
                                sounds.add(Sound.valueOf(s));
                            }
                            Random random = new Random();
                            int randomSound = random.nextInt(sounds.size());
                            Sound sound = sounds.get(randomSound);

                            p.playSound(p.getLocation(), sound, 3.0F, 0.5F);
                        }
                        if(plugin.config.getBoolean("Candy.Potion-Effect.Enabled").equals(true)) {
                            ArrayList<PotionEffectType> potions = new ArrayList<>();
                            ArrayList<Integer> potionDurations = new ArrayList<>();
                            ArrayList<Integer> potionAmplifiers = new ArrayList<>();

                            for(String s : plugin.config.getStringList("Candy.Potion-Effect.List-Potions")) {
                                potions.add(PotionEffectType.getByName(s));
                            }
                            for(Integer i : plugin.config.getIntList("Candy.Potion-Effect.List-Durations")) {
                                potionDurations.add(i);
                            }
                            for(Integer i : plugin.config.getIntList("Candy.Potion-Effect.List-Amplifiers")) {
                                potionAmplifiers.add(i);
                            }

                            Random random = new Random();
                            int randomPotion = random.nextInt(potions.size());

                            PotionEffectType potion = potions.get(randomPotion);
                            int duration = potionDurations.get(randomPotion);
                            int amplifier = potionAmplifiers.get(randomPotion);

                            p.addPotionEffect(new PotionEffect(potion, duration, amplifier));
                        }
                        if(plugin.config.getBoolean("Commands.Candy.As-Console.Enabled").equals(true)) {
                            ArrayList<String> commands = new ArrayList<>();

                            for(String s : plugin.config.getStringList("Commands.Candy.As-Console.List")) {
                                commands.add(s
                                        .replaceAll("%player%", p.getName()));
                            }
                            for(String s : commands) {
                                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), s);
                            }
                        }
                        if(plugin.config.getBoolean("Commands.Candy.As-Player.Enabled").equals(true)) {
                            ArrayList<String> commands = new ArrayList<>();

                            for(String s : plugin.config.getStringList("Commands.Candy.As-Player.List")) {
                                commands.add(s
                                        .replaceAll("%player%", p.getName()));
                            }
                            for(String s : commands) {
                                Bukkit.dispatchCommand(p, s);
                            }
                        }
                        if(plugin.config.getBoolean("Messages.Consumed.Candy.Enabled").equals(true)) {
                            p.sendMessage(ChatColor
                                    .translateAlternateColorCodes('&',
                                            plugin.config
                                                    .getString("Messages.Consumed.Candy.Message")));
                        }
                        p.getInventory().removeItem(item);
                    }
                    else return;
                }
            }
        }
        catch (Exception ex) {
            return;
        }
    }
}
