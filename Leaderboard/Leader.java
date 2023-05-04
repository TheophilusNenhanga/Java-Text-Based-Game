package Leaderboard;

public class Leader {
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
        return "-----" + this.getLeaderName() + "-----" + "\t\t" + "-----" + this.getLeaderScore() + "-----";
    }
}
