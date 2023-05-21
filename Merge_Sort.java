import java.util.*;

public class Merge_Sort{

    static int[] MergeSort(int A[]){

    if(A.length <= 1) return A;

    int Mid = A.length/2;
    int Sub_Left[] = new int[Mid];
    int Sub_Right[] = new int[A.length-Mid]; 
    int Answer[] = new int[A.length];

    for(int i = 0; i < Mid; i++){
        Sub_Left[i] = A[i];    
    }
    for(int j = 0; j < Sub_Right.length; j++){
        Sub_Right[j] = A[Mid+j];
    }

    Sub_Left = MergeSort(Sub_Left);
    Sub_Right = MergeSort(Sub_Right);

    Answer = Merge(Sub_Left, Sub_Right);
    
    return Answer;

    } 

    static int[] Merge(int Low[],int Hight[]){
        int Answer[] = new int[Low.length+Hight.length];
        int Low_P, Hight_P, Answer_P;
            Low_P = Hight_P = Answer_P = 0;
            
        while(Low_P < Low.length || Hight_P < Hight.length){
            if(Low_P < Low.length && Hight_P < Hight.length){
                if(Low[Low_P] <= Hight[Hight_P]){
                    Answer[Answer_P] = Low[Low_P];
                    Low_P++;
                }
                else {
                    Answer[Answer_P] = Hight[Hight_P];
                    Hight_P++;
                }
            }
            else if(Low_P < Low.length){
                Answer[Answer_P] = Low[Low_P];
                Low_P++;
            }
            else if(Hight_P < Hight.length){
                Answer[Answer_P] = Hight[Hight_P];
                Hight_P++;
            }
            Answer_P++;
        }

        return Answer;
    }

   static int partition(int a[], int left, int right) 
    { 
        int pivot = a[right];  
        int i = (left-1); 
        for (int j = left; j < right; j++) 
        { 
            if (a[j] < pivot) 
            { 
                i++; 
                int temp = a[i]; 
                a[i] = a[j]; 
                a[j] = temp; 
            } 
        } 
  
        int temp = a[i+1]; 
        a[i+1] = a[right]; 
        a[right] = temp; 
  
        return i+1; 
    } 
  
    static void Quick_sort(int a[], int left, int right) 
    { 
        if (left < right) 
        { 
            int mid = partition(a, left, right); 
            Quick_sort(a, left, mid-1); 
            Quick_sort(a, mid+1, right); 
        } 
    }
    
    public static void main(String[] args) {
        int Rand_Array[] = new int[100];
        Rand_Array[0] = 9; Rand_Array[99] = 8;

        for(int i = 1; i < Rand_Array.length-1; i++){
            Rand_Array[i] = (int)(Math.random()*51);
        }

        System.out.println("Main Array : "+Arrays.toString(Rand_Array)+"\n");

        int Merge_Answer[] = MergeSort(Rand_Array);
        System.out.println("Merge Sort : "+Arrays.toString(Merge_Answer)+"\n");

        int End_point = Rand_Array.length-1;
        Quick_sort(Rand_Array, 0, End_point);

        System.out.println("Quick Sort : "+Arrays.toString(Rand_Array));
    }
}