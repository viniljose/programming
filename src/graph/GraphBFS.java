package graph;


import java.util.LinkedList;
import java.util.Queue;

public class GraphBFS {
    private final int maxVertices=20;
    private Vertex[] vertexList;
    private int[][] adjMatrix;
    private int vertexCount;
    private Queue<Integer> queue;

    public GraphBFS(){
        vertexList = new Vertex[maxVertices];
        adjMatrix = new int[maxVertices][maxVertices];
        vertexCount = 0;
        for (int i = 0; i < maxVertices; i++) {
            for (int j = 0; j < maxVertices; j++) {
                adjMatrix[i][j]=0;
            }
        }
        queue = new LinkedList();
    }
    public void addVertex(char label){
        vertexList[vertexCount++]=new Vertex(label);
    }
    public void addEdge(int start, int end){
        adjMatrix[start][end]=1;
        adjMatrix[start][end]=1;
    }
    public void display(int v){
        System.out.println(vertexList[v].label);
    }

    public void bfs(){
        vertexList[0].visited=true;
        queue.add(0);
        while (!queue.isEmpty()){
            int v1 = queue.remove();
            int v2;
            while((v2=getAdjUnvisitedVertex(v1))!=-1){
                vertexList[v2].visited=true;
                display(v2);
                queue.add(v2);
            }
        }
        for (int i = 0; i < vertexCount; i++) {
            vertexList[i].visited=false;
        }
    }

    private int getAdjUnvisitedVertex(int v){
        for (int i = 0; i < vertexCount; i++) {
            if(adjMatrix[v][i]==1 && vertexList[i].visited==false)
                return i;
        }
        return -1;
    }
}
