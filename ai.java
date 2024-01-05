import java.util.Random;

public class ai extends player
{  
    public ai(String name,char mark)
    {
        this.name=name;
        this.mark=mark;
    }
    public void makemove()
    {
        int row;int col;
        do {
            Random r=new Random();
            row = r.nextInt(3);
            col = r.nextInt(3);
        } while (!isvalidmove(row, col));
        tictactoe.place(row, col, mark);
    }
    
}
