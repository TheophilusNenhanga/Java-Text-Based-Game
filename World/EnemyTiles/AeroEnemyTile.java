package World.EnemyTiles;

import Enemy.*;

public class AeroEnemyTile extends EnemyTile {
    float r;

    public AeroEnemyTile(int x, int y, int level) {
        super(x, y, level);
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
