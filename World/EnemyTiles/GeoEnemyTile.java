package World.EnemyTiles;

import Enemy.Gargoyle;
import Enemy.Golem;
import Enemy.Ogre;

public class GeoEnemyTile extends EnemyTile {
        float r;
        public GeoEnemyTile(int x, int y, int level) {
            super(x, y, level);
            r = random.nextFloat();
            if (r < 0.33){
                this.enemy = new Ogre();
            } else if (r < 0.66) {
                this.enemy = new Golem();
            }else{
                this.enemy = new Gargoyle();
            }
        }

        public void introText(){
            if (this.enemy.isAlive()){
                this.enemy.aliveText();
            }else{
                this.enemy.deadText();
            }
        }
}