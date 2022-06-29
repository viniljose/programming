package graph;


import java.util.Stack;

public class GraphDFS {
    private final int maxVertices = 20;
    private Vertex[] vertexList;
    private int[][] adjMatrix;
    private int vertexCount;
    private Stack<Integer> stack;

    public GraphDFS(){
        vertexList = new Vertex[maxVertices];
        adjMatrix = new int[maxVertices][maxVertices];
        vertexCount = 0;
        for (int i = 0; i < maxVertices; i++) {
            for (int j = 0; j < maxVertices; j++) {
                adjMatrix[i][j]=0;
            }
        }
        stack = new Stack();
    }

    public void addVertex(char label){
        vertexList[vertexCount++]=new Vertex(label);
    }

    public void addEdge(int start,int end){
        adjMatrix[start][end]=1;
        adjMatrix[start][end]=1;
    }

    public void display(int v){
        System.out.println(vertexList[v].label);
    }

    public void dfs(){
        vertexList[0].visited=true;
        display(0);
        stack.push(0);
        while (!stack.isEmpty()){
            int v= getAdjUnvisitedVertex(stack.peek());
            if(v==-1)
                stack.pop();
            else {
                vertexList[v].visited=true;
                display(v);
                stack.push(v);
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
