package stack;

import java.util.ArrayList;
import java.util.List;

public class Stack {
    private List<Integer> data;
    public Stack(){
        data = new ArrayList<>();
    }
    public void push(int x){
        data.add(x);
    }
    public boolean isEmpty(){
        return data.isEmpty();
    }
    public boolean pop(){
        if(isEmpty())
            return false;
        data.remove(data.size()-1);
        return true;
    }
}
