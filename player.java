abstract class player 
{
    String name;
    char mark;
    abstract void makemove();
    public boolean isvalidmove(int row,int col)
    {
        if(row>=0&&row<3&&col>=0&&col<3)
        {
            if(tictactoe.arr[row][col]==' ')
            return true;
        }
        return false;
    }
}
