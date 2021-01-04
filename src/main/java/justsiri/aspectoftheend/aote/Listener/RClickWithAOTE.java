package justsiri.aspectoftheend.aote.Listener;

import justsiri.aspectoftheend.aote.Commands.AspectOfTheEnd;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Set;

public class RClickWithAOTE implements Listener {

    @EventHandler
    public void onClick(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        ItemStack item = p.getInventory().getItemInMainHand();
        if (item.getItemMeta().getDisplayName().equals(ChatColor.WHITE + "끝의 조각")) {
            if ((e.getAction() == Action.RIGHT_CLICK_AIR) || (e.getAction() == Action.RIGHT_CLICK_BLOCK)) {
                ArrayList<Block> Blocks = (ArrayList<Block>) e.getPlayer().getLineOfSight((Set) null, 6);

                Block block = Blocks.get(Blocks.size() - 2);

                Location playerLoc = p.getLocation();
                Location loc = block.getLocation();

                loc.setYaw(playerLoc.getYaw());
                loc.setPitch(playerLoc.getPitch());
                p.teleport(loc);
                p.playSound(p.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 1, 1);
            } else {

            }
        }

    }

    @EventHandler
    private void onDamage(EntityDamageByEntityEvent e) {
        Entity damager = e.getDamager();
        if (damager instanceof Player) {
            Player p = (Player) damager;
            ItemStack item = p.getInventory().getItemInMainHand();
            if (item.getItemMeta().getDisplayName().equals(ChatColor.WHITE + "끝의 조각")) {
                e.setDamage(e.getDamage() + 20);
            }
        }

    }
}
