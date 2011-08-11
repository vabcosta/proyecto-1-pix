/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Luisa Portillo
 */
public class Sorting {
    public int[] answer;
    /**
     * 
     * @param matrix
     * @param which 
     */
    public Sorting(int[] matrix, boolean which){
        int numUnsorted = matrix.length;
        int index;
        int max;
        if(which){
            while(numUnsorted>0){
                //Determine maximum Value in array
                max=0;
                for(index =1;index < numUnsorted ;index++){
                    if(matrix[max]< matrix[index])
                        max=index;
                }
                swap(matrix,max,numUnsorted-1);
                numUnsorted--;
            }
        }
        else{
              matrix=quickSort(matrix,matrix.length);        
        }
        answer=matrix;
    }
    
    /**
     * 
     * @param data
     * @param i
     * @param j 
     */
    public static void swap(int[] data,int i , int j){
        //this method create the interchange
        int temp;
        temp = data[i];
        data[i]= data[j];
        data[j] = temp;
    }/**
     * 
     * @return 
     */
    public int[] getMatrix(){
        return answer;
    }
    
    /**
     * 
     * @param data
     * @param left
     * @param right
     * @return 
     */
    private static int partition(int data[], int left, int right){
        // pre: left <= right 
        // post: data[left] placed in the correct (returned) location
    
        while (true) {
            // move right "pointer" toward left 
            while (left < right && data[left] < data[right]) right--; 
                if (left < right) 
                    swap(data,left++,right); 
                else return left; 
            // move left pointer toward right 
            while (left < right && data[left] < data[right]) left++; 
                if (left < right) 
                    swap(data,left,right--); 
                else return right;
        }
    }/**
     * 
     * @param data
     * @param n
     * @return 
     */
    public static int[] quickSort(int[] data, int n){
        quickSortRecursive(data,0,n-1);
        return data;
    }/**
     * 
     * @param data
     * @param left
     * @param right 
     */public static void selectionSort(int data[], int n)
        // pre: 0 <= n <= data.length
        // post: values in data[0..n-1] are in ascending order
        {
        int numUnsorted = n;
        int index; // general index
        int max; // index of largest value
        while (numUnsorted > 0)
        {
            // determine maximum value in array
            max = 0;
            for (index = 1; index < numUnsorted; index++)
            {
                if (data[max] < data[index]) max = index;
            }
            swap(data,max,numUnsorted-1);
            numUnsorted--;
        }
        }
    
    
    private static void quickSortRecursive(int[] data,int left,int right){
        // pre: left <= right 
        // post: data[left..right] in ascending order 
    int pivot;	
    // the final location of the 
    if (left >= right) return; 
    pivot = partition(data,left,right);	/* 1- place pivot*/
    quickSortRecursive(data,left,pivot-1); /*2.- sprt small*/
    quickSortRecursive(data,pivot+1,right);/* 3.- sort Large*/
    /* done! */
    }
    
}
