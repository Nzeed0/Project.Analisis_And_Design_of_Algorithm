import java.util.*;

public class Backtracking{
    static int Main_Array[], Cal_Array[], Display_Number[];
    static int WantedValue, Array_End;

    static void Start(){
        Scanner sc = new Scanner(System.in);
        int All_Number_Set[];

        System.out.print("Enter n ==> "); int n = sc.nextInt();
        System.out.print("Enter M ==> "); int M = sc.nextInt();

        All_Number_Set = new int[n];
        Cal_Array = new int[n];
        Display_Number = new int[n];
        WantedValue = M;

        System.out.print("Enter Weight/Piece ==> ");
        for(int i = 0; i < n; i++){
            All_Number_Set[i] = sc.nextInt();
        }

        Main_Array = All_Number_Set;
        Array_End = n-1;

        Launch(0);
    }

    static void Launch(int Pointer){
        Cal_Array[Pointer] = -1;

        while(Cal_Array[Pointer] < 1){
            Cal_Array[Pointer]++;
            int Sum = All_Sum(Main_Array, Cal_Array);
            if(Sum == WantedValue && Pointer == Array_End){
                System.out.printf("%s ===> %d\n--------------------------------\n",Arrays.toString(Display_Number),Sum);
            }
            else if (Pointer < Array_End) Launch(Pointer+1);
        }
    }

    static int All_Sum(int Main[], int Cal[]){
        int Answer = 0;
        int Compare = 0;
        for(int i = 0; i < Cal.length; i++){
            Compare = Main[i] * Cal[i];
            Display_Number[i] = Compare;
            Answer += Compare;
        }
        return Answer;
    }

    public static void main(String[] args) {
        Start();
    }
}