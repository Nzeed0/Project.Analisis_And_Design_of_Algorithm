import java.util.*;

// หาตัวเลขที่บวกกันแล้วได้คำตอบตามที่กำหนด โดยใช้ Queue และ Stack
class Sum_of_Subset {
    static int Data[] = {98, 11, 13, 24, 7, 19};
    static int M = 55, Answer = 0;

    static void Array_to_Queue(){
        Queue<Integer> Q = new LinkedList<>();
        for(int i = 0; i < Data.length; i++){
            if(Data[i] < M) Q.add(Data[i]);
        }
        Find_Sum_of_Correct_Answer(Q);
    }

    static void Find_Sum_of_Correct_Answer(Queue<Integer> Q){
        Stack<Integer> Process = new Stack<>();
        Stack<Integer> temp = new Stack<>();
        ArrayList<Integer> Arr = new ArrayList<>();
        temp.push(0);
        int Data = 0, tempData = 0, DataProcess = 0;

        while(!Q.isEmpty()){
            Data = Q.poll();

            for(int i = 20 - temp.size(); i > 0; i--){
                System.out.print(" ");
            }

            while(!temp.isEmpty()){
                tempData = temp.pop(); System.out.print(tempData+ " ");
                Arr.add(tempData);
                Process.push(tempData);
                DataProcess = tempData+Data;
                if(DataProcess <= M)
                Process.push(DataProcess);
                //if(DataProcess == M) System.out.println(DataProcess);
            }
            System.out.println();
            while(!Process.isEmpty()) temp.push(Process.pop());
        }

        int Data1 = Arr.indexOf(55);
        int Data2 = 0;

        System.out.print("Sum of Number = ");
            while(Data1 >= 0){
                if(Data2 != 0)
                System.out.print(" " + (Data2-Arr.get(Data1)) + " ");
                Data2 = Arr.get(Data1);
                Data1 = (int)Math.floor((double)(Data1-1)/2);
            }
    }

    public static void main(String[] args) {
        Array_to_Queue();
    }
}
