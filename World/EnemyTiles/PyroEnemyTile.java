package World.EnemyTiles;

import Enemy.*;
import World.MapTile;

public class PyroEnemyTile extends MapTile {
    float r;

    public PyroEnemyTile(int x, int y) {
        super(x, y);
        r = random.nextFloat();
        if (r < 0.33) {
            this.enemy = new Salamander();
        } else if (r < 0.66) {
            this.enemy = new BabyPhoenix();
        } else {
            this.enemy = new HellHound();
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