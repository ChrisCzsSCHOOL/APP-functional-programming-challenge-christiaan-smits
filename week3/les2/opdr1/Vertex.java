package opdr1;

import java.util.ArrayList;
import java.util.List;

public class Vertex {

    private String name;
    private List<Edge> adj;

    public Vertex(String name) {
        this.name = name;
        this.adj = new ArrayList<>();

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Edge> getAdj() {
        return adj;
    }

    public void setAdj(List<Edge> adj) {
        this.adj = adj;
    }
}
