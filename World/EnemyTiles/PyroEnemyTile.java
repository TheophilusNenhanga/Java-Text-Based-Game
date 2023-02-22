package World.EnemyTiles;

import Enemy.*;

public class PyroEnemyTile extends EnemyTile {
    float r;

    public PyroEnemyTile(int x, int y, int level) {
        super(x, y, level);
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