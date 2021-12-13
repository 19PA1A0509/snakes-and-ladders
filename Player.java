package snakeandladders;

public class Player {
    private String pName;
    private int id;

    Player(String pName, int id) {
        this.pName = pName;
        this.id = id;
    }

    public String getPName() {
        return pName;
    }

    public int getId() {
        return id;
    }
}
