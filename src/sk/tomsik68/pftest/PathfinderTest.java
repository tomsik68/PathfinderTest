package sk.tomsik68.pftest;

import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class PathfinderTest extends JavaPlugin implements Listener{
    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
        super.onEnable();
    }
    @EventHandler
    public void onPlayerInteract(PlayerInteractEntityEvent event){
        if(event.getRightClicked().getType().isAlive()){
            ((LivingEntity) event.getRightClicked()).clearPathfinders();
            ((LivingEntity) event.getRightClicked()).attachPathfinder(new ExamplePathfinder());
            event.getPlayer().sendMessage(event.getRightClicked().getType().name()+"Following you! I guess...");
        }
    }
}
