public class tictactoe 
{
    static char[][] arr;
    public  tictactoe()
    {
        arr=new char[3][3];
        in();
    }
    void in()
    {
        for(int i=0;i<arr.length;i++)
        {
            for(int j=0;j<arr[0].length;j++)
            {
                arr[i][j]=' ';
            }
        }
    }
     void display()
    {
        System.out.println("---------------");
        for(int i=0;i<arr.length;i++)
        {
            for(int j=0;j<arr[i].length;j++)
            {
               System.out.print( "| "+arr[i][j]+" |");
            }
            System.out.println(" ");
            System.out.println("---------------");
        }
    }
    public static void place(int row,int column,char x)
    {
        if(row<3&&column<3&&row>=0&&column>=0)
        {
            arr[row][column]=x;
        }
        else{
            System.out.println("invalid move");
        }
    }
    boolean cw()
    {
        for(int j=0;j<=2;j++)
        {
            if(arr[0][j]!=' '&&arr[0][j]==arr[1][j]&&arr[1][j]==arr[2][j])
            {
                return true;
            }
        }
        return false;
    }
    boolean rw()
    {
        for(int j=0;j<=2;j++)
        {
            if(arr[j][0]!=' '&&arr[j][0]==arr[j][1]&&arr[j][1]==arr[j][2])
            {
                return true;
            }
        }
        return false;
    }
    boolean dw()
    {
        if(arr[0][0]!=' '&&arr[0][0]==arr[1][1]&&arr[1][1]==arr[2][2]||arr[0][2]!=' '&&arr[0][2]==arr[1][1]&&arr[1][1]==arr[2][0])
        {
            return true;
        }
        return false;
    }
    boolean checkwin()
    {
        if(cw()||rw()||dw())
        {
          System.out.println("winner!winner!");
            return true;
        }
        return false;
    }
    boolean checkdraw()
    {
        int sum=0;
        for(int i=0;i<arr.length;i++)
        {
            for(int j=0;j<arr.length;j++)
            {
                if(arr[i][j]!=' ')
                {
                    sum++;
                }
            }
        }
        if(sum==9)
        {
            return true;
        }
        return false;
    }
    
}
