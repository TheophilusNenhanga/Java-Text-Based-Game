package World.EnemyTiles;

import Enemy.PyroMancer;

public class PyroBossTile extends EnemyTile {

    public PyroBossTile(int x, int y, int level) {
        super(x, y, level);
        this.enemy = new PyroMancer();
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