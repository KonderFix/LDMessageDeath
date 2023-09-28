package me.leddev.ldmessagedeath;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class Events implements Listener {

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
        Player player = event.getEntity();

        if (player.getKiller() instanceof Player) {
            Player killer = (Player) player.getKiller();

            String killerName = killer.getName();
            String message = Main.getInstance().getConfig().getString("message-death")
                    .replace("{killer}", killerName);
            ChatTools.sendMsg(player, message);
        }
    }
}
