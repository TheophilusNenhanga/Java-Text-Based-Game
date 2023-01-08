package Actions;

public class Action {

    public String name;
    public String hotkey;


    public static class details extends Action{
        public details(){
            this.name = "Print Player Details";
            this.hotkey = "d";
        }
    }

    public static class inventory extends Action{
        public inventory(){
            this.name = "Print Player Inventory";
            this.hotkey = "i";
        }
    }

    public static class talk extends Action{
        public talk(){
            this.name = "Talk";
            this.hotkey = "t";
        }
    }

    public static class trade extends Action{
        public trade(){
            this.name = "Trade";
            this.hotkey = "t";
        }
    }

    public static class enchant extends Action{
        public enchant(){
            this.name = "Enchant";
            this.hotkey = "en";
        }
    }

    public static class attack extends Action{
        public attack(){
            this.name = "Attack";
            this.hotkey = "a";
        }
    }

    public static class north extends Action{
        public north(){
            this.name = "Go North";
            this.hotkey = "n";
        }
    }

    public static class east extends Action{
        public east(){
            this.name = "Go East";
            this.hotkey = "e";
        }
    }

    public static class south extends Action{
        public south(){
            this.name = "Go South";
            this.hotkey = "s";
        }
    }

    public static class west extends Action{
        public west(){
            this.name = "Go West";
            this.hotkey = "w";
        }
    }
}
