package World.EnemyTiles;

import Enemy.GeoMancer;

public class GeoBossTile extends EnemyTile {


    public GeoBossTile(int x, int y, int level) {
        super(x, y, level);
        this.enemy = new GeoMancer();
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