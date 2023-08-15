package arrays;

/**
 * https://www.geeksforgeeks.org/how-do-dynamic-arrays-work/
 */
public class DynamicArray {
    private int[] array;
    private int size;

    //No of elements added
    private int count;

    public DynamicArray(){
        array = new int[1];
        size =1;
        count = 1;
    }
    public void add(int data)
    {
        if(count==size){
            growSize();
        }
        array[count]=data;
        count++;
    }
    private void growSize(){
        int[] temp = null;
        if(count==size){
            temp = new int[size*2];
            for (int i = 0; i < size; i++) {
                temp[i]=array[i];
            }
        }
        array=temp;
        size=size*2;
    }
}
