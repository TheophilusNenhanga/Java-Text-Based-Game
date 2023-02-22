package World.EnemyTiles;

import Enemy.HydroMancer;

public class HydroBossTile extends EnemyTile {


    public HydroBossTile(int x, int y, int level) {
        super(x, y, level);
        this.enemy = new HydroMancer();
    }

    @Override
    public void introText() {
        if (this.enemy.isAlive()){
            this.enemy.aliveText();
        }else{
            this.enemy.deadText();
        }
    }
}