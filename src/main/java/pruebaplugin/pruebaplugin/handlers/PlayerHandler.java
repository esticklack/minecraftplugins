package pruebaplugin.pruebaplugin.handlers;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import pruebaplugin.pruebaplugin.PruebaPlugin;
import pruebaplugin.pruebaplugin.util.DelayedTask;

public class PlayerHandler implements Listener {
    public PlayerHandler(PruebaPlugin plugin) {
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        ItemStack item = new ItemStack(Material.GRASS, 16);
        Inventory inv = player.getInventory();

        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("Testing");
        item.setItemMeta(meta);

        inv.addItem(item);
        inv.setItem(8, item);

    }

    @EventHandler
    public void onEntityDamage(EntityDamageEvent event) {
        if (!(event.getEntity() instanceof  Player && event.getCause() == EntityDamageEvent.DamageCause.FALL)) {
            return;
        }

        Player player = (Player) event.getEntity();
        DelayedTask task = new DelayedTask(() -> {
            player.getInventory().addItem(new ItemStack(Material.DIAMOND));
        }, 20 * 5);

        Bukkit.getScheduler().cancelTask(task.getId());

    }

}
