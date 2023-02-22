package World.EnemyTiles;

import Enemy.*;

public class HydroEnemyTile extends EnemyTile {
    float r;

    public HydroEnemyTile(int x, int y, int level) {
        super(x, y, level);
        r = random.nextFloat();
        if (r < 0.33) {
            this.enemy = new Hydra();
        } else if (r < 0.66) {
            this.enemy = new WaterNymph();
        } else {
            this.enemy = new SeaSerpent();
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