import java.util.*;

class SortingByPriority{

    static void Cal_and_Sort_PW(double PW[][], int M){
        double price_in_pack = 0;
        double X[];
        double Answer[] = new double[PW.length];
        double Answer_Temp[] = new double[PW.length];
        int Position_in_Array[] = new int[PW.length];

        // Add Value
        for(int i = 0; i < PW.length; i++){
            double P = PW[i][0];
            double W = PW[i][1];
            Answer[i] = (P/W);
            Answer_Temp[i] = Answer[i]; // Record Location
        }

        //Sort
        Arrays.sort(Answer);

        //Swap
        for (int i = 0; i < Answer.length; i++) {
            double temp = Answer[i];
                   Answer[i] = Answer[Answer.length-(++i)];
                   Answer[Answer.length-(i++)] = temp;
        }

        //Set Position
        for (int i = 0; i < Answer.length; i++) {
            for(int j = 0; j < Answer.length; j++){
                if(Answer[i] == Answer_Temp[j]) Position_in_Array[i] = ++j;
            }
        }

        System.out.println("\nNo. of Input : "+Arrays.toString(Position_in_Array));
        X = Calculate_X(PW, Position_in_Array, M);
        System.out.println("X            : "+Arrays.toString(X));

        for(int i = 0; i < X.length; i++){
            price_in_pack += (X[i]*PW[Position_in_Array[i]-1][0]);
        }

        System.out.printf("All price in pack = %.2f\n\n",price_in_pack);

    }

    static double[] Calculate_X(double A[][], int B[], int M){
        int Count = 0;
        double Answer[] = new double[B.length];
        String Sol[] = new String[B.length];

        for(int i = 0; i < B.length; i++){
            int now = B[i]-1;
            if((M - A[now][1]) > 0){
                Sol[i] = "("+String.valueOf(M)+" - "+String.valueOf(A[now][1]);
                M -= A[now][1];
                Sol[i] += " = "+String.valueOf(M)+") ";
                Answer[i]++;
            }
            else {
                if(A[now][1] != 0 && Count < 1) {
                                Sol[i] = "("+String.valueOf(M)+" - "+String.valueOf(A[now][1])+" <= 0)";
                                Answer[i] = (M/A[now][1]);
                                if(Answer[i] < 1) Count++;
                                   }
                else {
                    Sol[i] = " - ";
                    Answer[i] = 0;
                     }
            }
        }
        System.out.println("M - W        : "+Arrays.toString(Sol));
        return Answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int Amount, Weight, Price, M;

        System.out.print("Please input Amount of Object ==> ");
        Amount = sc.nextInt();

        double Info_Array[][] = new double[Amount][2];

        for(int i = 0; i < Info_Array.length; i++){
            System.out.println("\nObject : "+(i+1));
            System.out.print("  input Weight ==> "); Weight = sc.nextInt();
            System.out.print("  input Price ==> "); Price = sc.nextInt();

            Info_Array[i][0] = Price;
            Info_Array[i][1] = Weight;
        }

        System.out.print("\nPlease input Size of Backpack ==> "); M = sc.nextInt();

        Cal_and_Sort_PW(Info_Array,M);

    }
}