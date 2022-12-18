package pruebaplugin.pruebaplugin.handlers;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import pruebaplugin.pruebaplugin.PruebaPlugin;

public class AntorchaHandler implements Listener {
    public AntorchaHandler (PruebaPlugin plugin){
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    /**
     * lowest
     * low
     * Normal
     * high
     * Highest
     * ------
     * Monitor
     */

    @EventHandler(priority = EventPriority.LOW)
    public void onTorchPlace(BlockPlaceEvent event) {
        if (event.getBlock().getType() != Material.TORCH) {
            return;
      //       event.setCancelled(true);
        }

        if (!event.getPlayer().hasPermission("plugin.antorcha.diamante")){
            return;
        }

        event.getBlock().setType(Material.DIAMOND_BLOCK);

    }

    // Parte donde sale un mensaje en la consola cuando se pone un objeto
    /**
    @EventHandler // (ignoreCancelled = true)
    public void anTorchPlace(BlockPlaceEvent event) {

        // if (event.isCancelled()) return;

        Block block = event.getBlock();

        if (block.getType() != Material.TORCH) {
            return;
        }

            Bukkit.getLogger().info("Una bloque fue puesto");

    }
    */
}
