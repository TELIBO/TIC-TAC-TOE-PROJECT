import java.util.Scanner;

public class human extends player
{
    Scanner sc=new Scanner(System.in);
    public human(String name,char mark)
    {
        this.name=name;
        this.mark=mark;
    }
    public void makemove()
    {
        int row;int col;
        do {
            System.out.println("Enter row and column");
            row = sc.nextInt();
            col = sc.nextInt();
        } while (!isvalidmove(row, col));
        tictactoe.place(row, col, mark);
    }
    
}
