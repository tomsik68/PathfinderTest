package sk.tomsik68.pftest;

import java.util.List;

import org.bukkit.Material;
import org.bukkit.ai.Pathfinder;
import org.bukkit.ai.PathfinderType;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityTargetEvent.TargetReason;

public class ExamplePathfinder implements Pathfinder {
    private LivingEntity entity;
    private Player player;
    @Override
    public boolean canStart() {
        List<Entity> entities = entity.getNearbyEntities(5, 5, 5);
        for(Entity en : entities){
            if(en instanceof Player){
                player = (Player) en;
                return true;
            }
        }
        return false;
    }

    @Override
    public LivingEntity getEntity() {
        return entity;
    }

    @Override
    public int getPriority() {
        return 0;
    }

    @Override
    public PathfinderType getType() {
        return PathfinderType.Goal;
    }

    @Override
    public void setEntity(LivingEntity arg0) {
        entity = arg0;
    }
    @Override
    public void update() {
        if(entity.getNearbyEntities(5, 5, 5).isEmpty())
            entity.jump();
        else{
            entity.lookAt(player, 1.0f, 1.0f);
            entity.moveTo(player.getLocation().getX(), player.getLocation().getY(), player.getLocation().getZ(), 0.3f);
        }
        if(entity.getLocation().getBlock().getRelative(BlockFace.UP).getType().isSolid()){
            entity.jump();
        }
    }

    @Override
    public boolean canContinue() {
        return !entity.isDead();
    }

    @Override
    public void onStop() {
        
    }

}
