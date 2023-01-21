package World;

import Enemy.*;
import Player.Player;

public class EnemyTile extends MapTile{
    public Enemy enemy;

    public EnemyTile(int x, int y, int level){
        super(x, y);
        this.completed = false;

        int r = random.nextInt(0, 10);
        if (r < 1){
            this.enemy = new BatSwarm(level);
        } else if (r < 3) {
            this.enemy = new OvergrownInsect(level);
        } else if (r < 5) {
            this.enemy = new SkeletalWarrior(level);
        } else if (r < 7) {
            this.enemy = new GiantSpider(level);
        } else if (r < 9) {
            this.enemy = new Undead(level);
        }else{
            this.enemy = new Lamia(level);
        }
    }

    public void introText(){
        if (this.enemy.isAlive()){
            this.enemy.aliveText();
        }else{
            this.enemy.deadText();
        }
    }

    @Override
    public void modifyPlayer(Player player) {
        if (this.enemy.isAlive()){
            try{
                float defenceMultiplier = (float) (0.1 * player.mostDefence().defence);
                float damageDealt = this.enemy.damage - this.enemy.damage * defenceMultiplier;
                player.hp = (float) (player.hp - damageDealt);
                System.out.printf("%s does %f damage. You have %.1f HP remaining.", this.enemy.name, damageDealt, player.hp);
            }catch (RuntimeException e){
                player.hp = player.hp - this.enemy.damage;
                System.out.printf("%s does %d damage. You have %.1f HP remaining.", this.enemy.name, this.enemy.damage, player.hp);
            }

        }else{
            this.completed = true;
        }
    }
}
