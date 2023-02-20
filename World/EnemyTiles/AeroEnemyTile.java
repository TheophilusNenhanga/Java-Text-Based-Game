package World.EnemyTiles;

import Enemy.*;
import World.MapTile;

public class AeroEnemyTile extends MapTile {
    float r;

    public AeroEnemyTile(int x, int y) {
        super(x, y);
        r = random.nextFloat();
        if (r < 0.33) {
            this.enemy = new ThunderBird();
        } else if (r < 0.66) {
            this.enemy = new Harpy();
        } else {
            this.enemy = new Manticore();
        }
    }

    public void introText() {
        if (this.enemy.isAlive()) {
            this.enemy.aliveText();
        } else {
            this.enemy.deadText();
        }
    }
}
