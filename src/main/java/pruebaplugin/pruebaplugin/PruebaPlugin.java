package pruebaplugin.pruebaplugin;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import pruebaplugin.pruebaplugin.comandos.menu;
import pruebaplugin.pruebaplugin.comandos.proteccion;
import pruebaplugin.pruebaplugin.comandos.volar;
import pruebaplugin.pruebaplugin.handlers.AntorchaHandler;
import pruebaplugin.pruebaplugin.handlers.PlayerHandler;
import pruebaplugin.pruebaplugin.util.ConfigUtil;
import pruebaplugin.pruebaplugin.util.DelayedTask;

import java.util.List;

public final class PruebaPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.getLogger().info("Hola mundo");

        saveDefaultConfig();

        List<String> kitItems = (List<String>) getConfig().getList("kit");
        for (String itemName : kitItems) {
            Bukkit.getLogger().info(itemName);
        }


        ConfigUtil.get().add
        ConfigUtil config = new ConfigUtil(this, "test.yml");
        config.getConfig().set("Hello", "World");
        config.save();

        getCommand("volar").setExecutor(new volar());
        getCommand("menu").setExecutor(new menu(this));
        getCommand("proteccion").setExecutor(new proteccion());

        new AntorchaHandler(this);
        new PlayerHandler(this);
        new DelayedTask(this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        Bukkit.getLogger().info("Apagando");
    }
}
