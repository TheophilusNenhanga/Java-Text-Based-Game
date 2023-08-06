package World.EnemyTiles;

import Enemy.AeroMancer;

public class AeroBossTile extends EnemyTile {

    public AeroBossTile(int x, int y, int level) {
        super(x, y, level);
        this.enemy = new AeroMancer();
    }

    @Override
    public void introText() {
        if (this.enemy.isAlive()) {
            this.enemy.aliveText();
        } else {
            this.enemy.deadText();
        }
    }

}