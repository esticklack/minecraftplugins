package pruebaplugin.pruebaplugin.comandos;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class volar implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String [] args){
        if (!(sender instanceof Player)) {
            sender.sendMessage("Solo los jugadores pueden ocupar este comando.");
            return true;
        }

        Player player = (Player) sender;

        if (player.getAllowFlight()) {
            player.setAllowFlight(false);
            player.sendMessage("Ya no puedes volar");
        } else {
            player.setAllowFlight(true);
            player.sendMessage("Ahora puedes volar");
        }

        return  true;
    }
}
