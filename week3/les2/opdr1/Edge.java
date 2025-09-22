package opdr1;

public class Edge {
    private String destination;
    private int cost;

    public Edge(String destination, int cost) {
        this.destination = destination;
        this.cost = cost;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
