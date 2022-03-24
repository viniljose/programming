package graph;

public class GraphAdjMartrix {
    private boolean[][] adjMatrix;
    private int vertices;

    public GraphAdjMartrix(int vertices){
        this.vertices=vertices;
        adjMatrix = new boolean[vertices][vertices];
    }

    public void addEdge(int i,int j){
        if(i>=0 && i<vertices && j>=0 && j<vertices){
            adjMatrix[i][j]=true;
            adjMatrix[j][i]=true;
        }
    }

    public void removeEdge(int i,int j){
        if(i>=0 && i<vertices && j>=0 && j<vertices){
            adjMatrix[i][j]=false;
            adjMatrix[j][i]=false;
        }
    }

    public boolean isEdge(int i,int j){
        if(i>=0 && i<vertices && j>=0 && j<vertices){
            return adjMatrix[i][j];
        } else {
            return false;
        }
    }

}
