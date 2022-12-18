package pruebaplugin.pruebaplugin.comandos;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import pruebaplugin.pruebaplugin.util.ConfigUtil;

public class proteccion implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String [] args){
        if (!(sender instanceof Player)) {
            sender.sendMessage("Solo los jugadores pueden ocupar este comando.");

            return true;
        } else {
        Player player = (Player) sender;

        (player.sendMessage(ChatColor.translateAlternateColorCodes('&', ));

        return  true;
    }
}
}