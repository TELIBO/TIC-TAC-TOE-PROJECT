import java.util.Scanner;

public class mm
{
    public static void main(String[]args)
    {Scanner sc=new Scanner(System.in);
    while(true)
    {
    System.out.println("## Game Rules\r\n" +  //
            "- The game is played on a 3x3 grid.\r\n" + //
            "- Players take turns placing their marks ('X' or 'O') on an empty cell.\r\n" + //
            "- The first player to get three of their marks in a row (horizontally, vertically, or diagonally) wins.\r\n" + //
            "- If the grid is filled and no player has won, the game is a draw.\n");
    System.out.print("Enter name of player:");
    String sr=sc.next();
    tictactoe t=new tictactoe();
    player h1=new human(sr, 'x');
    System.out.println("Who Do You Want To Play Against");
    String[][] array = {{"Character","Number"},{"Friend", "0"}, {"EasyAI", "1"},{"MediumAI","2"},{"HardAI","3"}};
    System.out.println("-------------------");
    for (int i = 0; i < array.length; i++) {
        for (int j = 0; j < array[i].length; j++) {
            System.out.printf("%-9s", array[i][j]);
            System.out.print("|");
        }
        System.out.println();
        if (i < array.length - 1) {
            System.out.println("-------------------");
        }
    }
    System.out.println("-------------------");
    System.out.print("Enter Number:");
    int x=sc.nextInt();
    t.display();
    if(x==0)
    {
    System.out.print("Enter name of player:");
    String r=sc.next();
    System.out.print("Enter your mark:");
    char I = sc.next().charAt(0);
    player h2=new human(r,I);
    player cp;
    cp=h1;
    while(true)
    {
        System.out.println(cp.name + " turn");
        cp.makemove();
        t.display();
        if(tictactoe.checkwin())
        {
            System.out.println(cp.name+" winner");
            break;
        }
        else if(tictactoe.checkdraw())
        {
            System.out.println(" Oops Draw");
            break;
        }
        else
        {
            if(cp==h1)
            {
                cp=h2;
            }
            else{
                cp=h1;
            }
        }
    }

    }
    else if(x==1)
    {
    player h2=new ai("ai",'o');
    player cp;
    cp=h1;
    while(true)
    {
        System.out.println(cp.name + " turn");
        cp.makemove();
        t.display();
        if(tictactoe.checkwin())
        {
            System.out.println(cp.name+" winner");
            break;
        }
        else if(tictactoe.checkdraw())
        {
            System.out.println(" Oops Draw");
            break;
        }
        else
        {
            if(cp==h1)
            {
                cp=h2;
            }
            else{
                cp=h1;
            }
        }
    }
    }
    else if(x==3)
    {
    HardAI h2=new HardAI("Hardai");
    player cp;
    cp=h1;
    while(true)
    {
        System.out.println(cp.name + " turn");
        cp.makemove();
        t.display();
        if(tictactoe.checkwin())
        {
            System.out.println(cp.name+" winner");
            break;
        }
        else if(tictactoe.checkdraw())
        {
            System.out.println(" Oops Draw");
            break;
        }
        else
        {
            if(cp==h1)
            {
                cp=h2;
            }
            else{
                cp=h1;
            }
        }
    }   
    }
else if(x==2)
    {
    mediumai h2=new mediumai("mediumai");
    player cp;
    cp=h1;
    while(true)
    {
        System.out.println(cp.name + " turn");
        cp.makemove();
        t.display();
        if(tictactoe.checkwin())
        {
            System.out.println(cp.name+" winner");
            break;
        }
        else if(tictactoe.checkdraw())
        {
            System.out.println(" Oops Draw");
            break;
        }
        else
        {
            if(cp==h1)
            {
                cp=h2;
            }
            else{
                cp=h1;
            }
        }
    }   
    }
    System.out.println("if you want to play more(type 1 to continue and 2 to exit)");
    int s=sc.nextInt();
    if(s==1)
    {
        continue;
    }
    if(s==2)
    {
        break;
    }
    if(s!=1&&s!=2)
    {
        System.out.println("type right!");
    }
}
    
sc.close();
    }
    }

