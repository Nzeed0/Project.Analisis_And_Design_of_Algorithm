import java.util.Scanner;

public class Tree_Traversals {
    static String Answer = "Flip/Change Number  ==> ";

    Node root;

    void addNode(int Sequence, int CurrentNum){
        Node BuildNode = new Node(Sequence, CurrentNum);

        if(root == null){
            root = BuildNode;
        }
        else {
            Node CurrentNode = root;
            Node parent;

            while(true){
                parent = CurrentNode;

                if(Sequence <= CurrentNode.Sequence){
                    CurrentNode = CurrentNode.Childleft;

                    if(CurrentNode == null){
                        parent.Childleft = BuildNode;
                        return;
                    }
                }
                else {
                    CurrentNode = CurrentNode.Childright;

                    if(CurrentNode == null){
                        parent.Childright = BuildNode;
                        return;
                    }
                }
            }
        }
    }

    void InOrder(Node CurrentNode){
        if(CurrentNode != null){
            InOrder(CurrentNode.Childleft);

            Answer += CurrentNode;

            InOrder(CurrentNode.Childright);
        }
    }

    void PreOrder(Node CurrentNode){
        if(CurrentNode != null){
            Answer += CurrentNode;

            PreOrder(CurrentNode.Childleft);

            PreOrder(CurrentNode.Childright);
        }
    }

    void PostOrder(Node CurrentNode){
        if(CurrentNode != null){
            PostOrder(CurrentNode.Childleft);

            PostOrder(CurrentNode.Childright);

            Answer += CurrentNode;
        }
    }

    static void Input(){
        Scanner sc = new Scanner(System.in);
        Tree_Traversals Tree = new Tree_Traversals();
        System.out.print("Please input Number ==> ");
        int Num = sc.nextInt(), Current;
        int NumLength = String.valueOf(Num).length();

        for(int i = 0; i < NumLength; i++){
            Current = Num % 10 == 0 ? 5 : Num % 10;
            Answer += Current+" ";
            Tree.addNode(Current, Current);
            Num /= 10;
        }
        sc.close();
        System.out.println(Answer+"\n");

        Answer = "InOrder   = ";
        Tree.InOrder(Tree.root);
        System.out.println(Answer);

        Answer = "PreOrder  = ";
        Tree.PreOrder(Tree.root);
        System.out.println(Answer);

        Answer = "PostOrder = ";
        Tree.PostOrder(Tree.root);
        System.out.println(Answer);
    }

    public static void main(String[] args) {
        Input();
    }
}

class Node{
    int Sequence;
    int Num;

    Node Childleft;
    Node Childright;

    Node(int Sequence, int Num){
        this.Sequence = Sequence;
        this.Num = Num;
    }

    public String toString(){
        return String.valueOf(Num);
    }
}
