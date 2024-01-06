import java.util.Scanner;

public class mm
{
    public static void main(String[]args)
    {
    Scanner sc=new Scanner(System.in);
    System.out.print("Enter name of player:");
    String sr=sc.next();
    tictactoe t=new tictactoe();
    player h1=new human(sr, 'x');
    System.out.println("Who Do You Want To Play Against");
    String[][] array = {{"Character","Number"},{"Friend", "0"}, {"AI", "1"},{"HardAI","2"}};
    // Print the 2D array with a more complex design
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
        if(t.checkwin())
        {
            System.out.println(cp.name+" winner");
            break;
        }
        else if(t.checkdraw())
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
        if(t.checkwin())
        {
            System.out.println(cp.name+" winner");
            break;
        }
        else if(t.checkdraw())
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
    HardAI h2=new HardAI("ai");
    player cp;
    cp=h1;
    while(true)
    {
        System.out.println(cp.name + " turn");
        cp.makemove();
        t.display();
        if(t.checkwin())
        {
            System.out.println(cp.name+" winner");
            break;
        }
        else if(t.checkdraw())
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
sc.close();
}
}
