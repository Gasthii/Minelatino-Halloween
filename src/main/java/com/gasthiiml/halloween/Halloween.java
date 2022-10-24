package com.gasthiiml.halloween;

import com.gasthiiml.halloween.commands.GiveCommand;
import com.gasthiiml.halloween.commands.ReloadCommand;
import com.gasthiiml.halloween.events.BlockPlaceEvent;
import com.gasthiiml.halloween.events.PlayerDeathEvent;
import com.gasthiiml.halloween.events.PlayerInteractEvent;
import dev.dejvokep.boostedyaml.YamlDocument;
import dev.dejvokep.boostedyaml.dvs.versioning.BasicVersioning;
import dev.dejvokep.boostedyaml.settings.dumper.DumperSettings;
import dev.dejvokep.boostedyaml.settings.general.GeneralSettings;
import dev.dejvokep.boostedyaml.settings.loader.LoaderSettings;
import dev.dejvokep.boostedyaml.settings.updater.UpdaterSettings;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

@SuppressWarnings("ALL")
public class Halloween extends JavaPlugin {

    public YamlDocument config;

    public void onEnable() {
        try {
            config = YamlDocument.create(new File(getDataFolder(), "config.yml"), getResource("config.yml"),
                    GeneralSettings.DEFAULT, LoaderSettings.builder().setAutoUpdate(true).build(),
                    DumperSettings.DEFAULT, UpdaterSettings.builder().setVersioning(new BasicVersioning("config-version")).build());
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        Bukkit.getPluginManager().registerEvents(new PlayerInteractEvent(this), this);
        Bukkit.getPluginManager().registerEvents(new BlockPlaceEvent(this), this);
        Bukkit.getPluginManager().registerEvents(new PlayerDeathEvent(this), this);
        this.getCommand("mlhr").setExecutor(new ReloadCommand(this));
        this.getCommand("mlhg").setExecutor(new GiveCommand(this));
    }
}
