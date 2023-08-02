package Leaderboard;

import Game.Game;

public class Leader implements Comparable<Leader> {
    final protected String leaderName;
    final protected int leaderScore;

    public Leader(String name, int score) {
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
        String leaderName = this.getLeaderName();
        int leaderScore = this.getLeaderScore();
        String chosenMap;
        try {
            chosenMap = Game.world.chosenMap;
        } catch (NullPointerException ignored) {
            chosenMap = null;
        }


        String formatString;
        if (chosenMap != null) {
            formatString = "| %-20s | %-10d | %-15s |";
            return String.format(formatString, leaderName, leaderScore, chosenMap);
        } else {
            formatString = "| %-20s | %-10s |";
            return String.format(formatString, leaderName, leaderScore);
        }
    }

    @Override
    public int compareTo(Leader otherLeader) {
        if (otherLeader.leaderScore > this.getLeaderScore()) {
            return -1;
        } else if (otherLeader.leaderScore == this.leaderScore) {
            return 0;
        } else {
            return 1;
        }
    }
}
