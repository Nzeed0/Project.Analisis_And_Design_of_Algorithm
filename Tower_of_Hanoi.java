import java.util.*;

public class Tower_of_Hanoi {
    static int Round = 0;
    static int Count_Of_Move[] = new int[0];
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Number of disk : ");
        int Amount_of_disk = sc.nextInt();
        Count_Of_Move = new int[Amount_of_disk+1];

        System.out.print("Enter Start rod (A , B , C) : ");
        char Start_rod = sc.next().charAt(0);

        System.out.print("Enter To rod (A , B , C) : ");
        char To_rod = sc.next().charAt(0);

        char Start_rod_Up = Character.toUpperCase(Start_rod);
        char To_rod_Up = Character.toUpperCase(To_rod);
        char inter_rod = ' ';

        switch(Start_rod_Up)
        {
        case 'A' : if(To_rod_Up == 'B'){
                    inter_rod = 'C';
                   } else if(To_rod_Up == 'C'){
                    inter_rod = 'B';
                   }
                 break;
        case 'B' : if(To_rod_Up == 'A'){
                    inter_rod = 'C';
                   } else if(To_rod_Up == 'C'){
                    inter_rod = 'A';
                   }
                 break;
        case 'C' : if(To_rod_Up == 'A'){
                   inter_rod = 'B';
                   } else if(To_rod_Up == 'B'){
                   inter_rod = 'A';
                   }
                 break;
        default : System.out.println("please try again!!");
                 break;
        }

        Swap(Amount_of_disk, Start_rod, inter_rod, To_rod);
        System.out.println("\nAll Round = "+Round);

        for (int i = 1; i < Count_Of_Move.length; i++) {
          System.out.printf("Disk %d Move : %d\n",i,Count_Of_Move[i]);
        }
    }

    public static void Swap(int n,char start_rod,char inter_rod,char to_rod){
        Round++;
        if(n == 1)
        { System.out.println("Move disk 1 : "+ start_rod +" --> "+ to_rod);
          Count_Of_Move[1]++;
          return;
        }
        else {
                Swap(n - 1, start_rod, to_rod, inter_rod);
                System.out.println("Move disk "+ n + " : " + start_rod +" --> " + to_rod); Count_Of_Move[n]++;
                Swap((n - 1), inter_rod, start_rod, to_rod);
             }
    }
}
