package graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AdjacencyMatrixGraph implements Graph{
    private int[][] adjMatrix;
    private GraphType graphType = GraphType.DIRECTED;
    private int noOfVertices;

    public AdjacencyMatrixGraph(int noOfVertices ,GraphType graphType){
        this.graphType=graphType;
        this.noOfVertices=noOfVertices;
        adjMatrix = new int[noOfVertices][noOfVertices];
        for (int i = 0; i < noOfVertices; i++) {
            for (int j = 0; j < noOfVertices; j++) {
                adjMatrix[i][j]=0;
            }
        }
    }

    @Override
    public void addEdge(int v1, int v2) {
        if(v1<0 || v1>= noOfVertices || v2<0 || v2>=noOfVertices)
            throw new IllegalArgumentException("vertices are not valid");
        adjMatrix[v1][v2]=1;
        if(graphType==GraphType.UNDIRECTED){
            adjMatrix[v2][v1]=1;
        }
    }

    @Override
    public List<Integer> getAdjacentVertices(int v) {
        if(v <0 || v>= noOfVertices)
            throw new IllegalArgumentException("Invalid Vertex");
        List<Integer> vertices = new ArrayList<>();
        for (int i = 0; i < noOfVertices; i++) {
            if(adjMatrix[v][i]==1)
            vertices.add(i);
        }
        Collections.sort(vertices);
        return vertices;
    }
}
