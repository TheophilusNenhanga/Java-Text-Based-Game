package World.EnemyTiles;

import Enemy.*;
import World.MapTile;

public class HydroEnemyTile extends MapTile {
    float r;

    public HydroEnemyTile(int x, int y) {
        super(x, y);
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