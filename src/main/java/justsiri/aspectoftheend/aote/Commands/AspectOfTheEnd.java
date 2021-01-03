package justsiri.aspectoftheend.aote.Commands;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class AspectOfTheEnd implements CommandExecutor {

    public ItemStack item;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (p.isOp()) {
                item = new ItemStack(Material.DIAMOND_SWORD);
                ItemMeta item_meta = item.getItemMeta();
                item_meta.setDisplayName(ChatColor.GOLD + "Aspect Of The End");
                ArrayList<String> item_lore = new ArrayList<>();
                item_lore.add(" ");
                item_lore.add(ChatColor.DARK_GRAY + "우클릭을 할 경우");
                item_lore.add(ChatColor.DARK_GRAY + "바라보고 있는 곳으로");
                item_lore.add(ChatColor.DARK_GRAY + "텔레포트 됩니다.");
                item_lore.add(" ");
                item_lore.add(ChatColor.WHITE + "흔함");
                item_meta.setLore(item_lore);
                item.setItemMeta(item_meta);
                p.getInventory().addItem(item);
                p.sendMessage(ChatColor.YELLOW + "끝의 조각을 받았습니다.");
            } else {
                p.sendMessage(ChatColor.RED +  "이 명령어를 쓸 권한이 없습니다!");
            }
        }

        return true;
    }
}
