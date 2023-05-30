package Leaderboard;

import Game.Game;

public class Leader implements Comparable<Leader>{
    final protected String leaderName;
    final protected int leaderScore;

    public Leader(String name, int score){
        this.leaderName = name;
        this.leaderScore = score;
    }

    public String getLeaderName() {
        return leaderName;
    }

    public int getLeaderScore() {
        return leaderScore;
    }

    @Override
    public String toString() {
        try {
            return "-----" + this.getLeaderName() + "-----" + "\t\t\t" + "-----" + this.getLeaderScore() + "-----" + "\t\t" + "-----" + Game.world.chosenMap + "-----";
        } catch (RuntimeException ignored){
            return "-----" + this.getLeaderName() + "-----" + "\t\t\t" + "-----" + this.getLeaderScore() + "-----";
        }
    }

    @Override
    public int compareTo(Leader otherLeader) {
        if (otherLeader.leaderScore > this.getLeaderScore()){
            return -1;
        }else if (otherLeader.leaderScore == this.leaderScore) {
            return 0;
        }else{
            return 1;
        }
    }
}
