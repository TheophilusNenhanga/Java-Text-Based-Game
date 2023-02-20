package World.EnemyTiles;

import Enemy.Gargoyle;
import Enemy.Golem;
import Enemy.Ogre;
import World.MapTile;

public class GeoEnemyTile extends MapTile {
        float r;
        public GeoEnemyTile(int x, int y) {
            super(x, y);
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