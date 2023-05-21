import java.util.*;

class Fit_Bin_Method{

    static int[] descending_order_sort(int Array[]){
        Arrays.sort(Array);
        int Reverse[] = new int[Array.length];
        for(int i = 0; i < Reverse.length; i++){
            Reverse[i] = Array[Reverse.length-(i+1)];
        }
        return Reverse;
    }

    static int find(int[] Bin_set, int Located, int Max_Capacity) {
        int index = -1;
        for(int i = 0 ; i < Bin_set.length; i++) {
            if(Bin_set[i] - Located < Max_Capacity && Bin_set[i] - Located >= 0) {
                Max_Capacity = Bin_set[i] - Located;
                index = i;
            }
        }
        return index;
    }

    static void print_Array(int Array[]){
        String Arrays = "";

        for(int i = 0; i < Array.length; i++){
            if(Array[i] != 0) Arrays += Array[i]+",";
        }
        Arrays = Arrays.substring(0, Arrays.length()-1);
        System.out.println("    Total of Number Each Bucket ==> "+Arrays);
    }

    static void print_Array(List Array[]){
        String Arrays = "";

        for(int i = 0; i < Array.length; i++){
            if(!Array[i].isEmpty()) Arrays += Array[i]+",";
        }
        Arrays = Arrays.substring(0, Arrays.length()-1);
        System.out.println("    List of Number Each Bucket  ==> "+Arrays);
    }

    static void First_Fit(int Main_Object[], int Max_Capacity, String Name){
        System.out.println("First Fit "+Name+":");

        int Used[] = new int[Main_Object.length],
            bin[] = new int[Main_Object.length],
            Used_Bucket = 0;
        String Warning = "    Not enough space for Object ";
        boolean Space_Check = false;
        List arrOfObjects[] = new List[Main_Object.length];
            for(int i = 0; i < Main_Object.length; i++){
                arrOfObjects[i] = new ArrayList<Integer>();
            }

        for(int i = 0; i < Main_Object.length; i++){
            if(Main_Object[i] > Max_Capacity){
                Warning += (i+1)+",";
                Main_Object[i] = 0;
                Space_Check = true;
            }
            else
                for(int j = 0; j < bin.length; j++){
                    if(Main_Object[i]+Used[j] <= Max_Capacity){
                        bin[i] = j;
                        Used[j] += Main_Object[i];
                        break;
                    }
                }
        }

        for(int i = 0; i < bin.length; i++){
            if(Main_Object[i] != 0)
            arrOfObjects[bin[i]].add(Main_Object[i]);
        }

        for(int i = 0; i < bin.length; i++){
            if(!arrOfObjects[i].isEmpty()) Used_Bucket++;
        }

        if(Used[0] != 0)
        {
            print_Array(Used); print_Array(arrOfObjects);
            System.out.println("    Amount of bucket            ==> "+Used_Bucket);
        }

        if(Space_Check){
            Warning = Warning.substring(0, Warning.length()-1);
            System.out.println(Warning);
        }
        System.out.println();
    }

    static void First_Fit_Decreasing(int Main_Object[],int Max_Capacity){
        Main_Object = descending_order_sort(Main_Object);
        String Name = "Decreasing ";
        First_Fit(Main_Object, Max_Capacity, Name);
    }

    static void Best_Fit_Decreasing(int Main_Array[], int Max_Capacity){
        System.out.println("Best Fit Decreasing :");

        Main_Array = descending_order_sort(Main_Array);
        int Bin_set[] = new int[Main_Array.length],
            Used[] = new int[Main_Array.length],
            Used_Bucket = 0;
        ArrayList<Integer> Order = new ArrayList();
        List arrOfObjects[] = new List[Main_Array.length];
            for(int i = 0; i < Main_Array.length; i++){
                arrOfObjects[i] = new ArrayList<Integer>();
            }

        for(int i = 0; i < Bin_set.length; i++){
            Bin_set[i] = Max_Capacity;
        }

        for(int Located : Main_Array) {
            int Now = find(Bin_set, Located, Max_Capacity);
            Order.add(Now);
            Used[Now] += Located;
            Bin_set[Now] -= Located;
        }

        for(int i = 0; i < Order.size(); i++){
            if(Main_Array[i] != 0)
            arrOfObjects[Order.get(i)].add(Main_Array[i]);
        }

        for(int i = 0; i < Order.size(); i++){
            if(!arrOfObjects[i].isEmpty()) Used_Bucket++;
        }

            print_Array(Used); print_Array(arrOfObjects);
            System.out.println("    Amount of bucket            ==> "+Used_Bucket);
        System.out.println();
    }

    static void Start(){
        Scanner sc = new Scanner(System.in);
        int Set_of_Object[];

        System.out.print("Enter Bin Capacity ==> "); int L = sc.nextInt();
        System.out.print("Enter Amount of Object ==> "); int Size = sc.nextInt();
        Set_of_Object = new int[Size];

        System.out.print("Enter Value/Object ==> ");
        for(int i = 0; i < Size; i++){
            Set_of_Object[i] = sc.nextInt();
        }

        //First_Fit(Set_of_Object, L, "");
        First_Fit_Decreasing(Set_of_Object ,L);
        //Best_Fit_Decreasing(Set_of_Object ,L);
    }

    public static void main(String[] args) {
        Start();
    }
}