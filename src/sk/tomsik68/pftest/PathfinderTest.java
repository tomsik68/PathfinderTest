package sk.tomsik68.pftest;

import org.bukkit.entity.PathfindingEntity;
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
        if(event.getRightClicked().getType().isAlive() && event.getRightClicked() instanceof PathfindingEntity){
            ((PathfindingEntity) event.getRightClicked()).clearPathfinders();
            ((PathfindingEntity) event.getRightClicked()).attachPathfinder(new ExamplePathfinder());
            event.getPlayer().sendMessage("Selected " + event.getRightClicked().getType().name()+" is now following you!");
        }
    }
}
