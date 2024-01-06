public class HardAI extends player
{
    public HardAI(String name)
    {
        this.name=name;
        this.mark='o';
    }
    void makemove()
    {
        int bestScore = Integer.MIN_VALUE; 
        int bestmove=Integer.MIN_VALUE;int sum=0;
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                if(isvalidmove(i, j))
                {
                    tictactoe.arr[i][j]='o';
                    int score=minimax(tictactoe.arr,false);
                    tictactoe.arr[i][j]=' ';
                
                if(score>bestScore)
                {
                    bestScore=score;
                    bestmove=sum;
                }
            }
        sum++;
    } 
            }
        tictactoe.place(bestmove/3,bestmove%3, 'o');
    }
    int minimax(char [][] ww,boolean maximizing)
    {
        int bestscore;
        if(tictactoe.checkwin())
        {
            int sum=0;
            for(int i=0;i<3;i++)
            {
                for(int j=0;j<3;j++)
                {
                    if(tictactoe.arr[i][j]==' ')
                    {
                        sum++;
                    }
                }
            }
            if(tictactoe.whowon=='x')
            {
                return -1*(sum+1);
            }
            else if(tictactoe.whowon=='o')
            {
                return 1*(sum+1);
            }
        }
        if(tictactoe.checkdraw())
        {
            return 0;
        }
        if(maximizing)
        {
             bestscore = Integer.MIN_VALUE; 
             for(int i=0;i<3;i++)
            {
            for(int j=0;j<3;j++)
            {
             if(!tictactoe.checkwin())
              {  if(isvalidmove(i, j))
                {
                    tictactoe.arr[i][j]='o';
                    int score=minimax(tictactoe.arr,false);
                    tictactoe.arr[i][j]=' ';
                    bestscore = Math.max(score, bestscore);
                 }}
        }}}
        else{
            bestscore=Integer.MAX_VALUE;
             for(int i=0;i<3;i++)
            {
            for(int j=0;j<3;j++)
            {
             if(!tictactoe.checkwin())
              {  if(isvalidmove(i, j))
                {
                    tictactoe.arr[i][j]='x';
                    int score=minimax(tictactoe.arr,false);
                    tictactoe.arr[i][j]=' ';
                    bestscore = Math.min(score, bestscore);
                 }}
        }}
        }
        return bestscore;

}}