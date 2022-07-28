package CodingQuestions;

import java.util.*;

class ProgramTest1 {

  public static void main(String[] args) {
    TestCase1();
  }
  public static void TestCase1() {
    int[][] matrix = new int[][]
            {{0, -1, -3, 2, 0},
            {1, -2, -5, -1, -3},
            {3, 0, 0, -4, -1}};

    int expected = 3;
    int actual = new Program5().minimumPassesOfMatrix(matrix);
    assert (expected == actual);
  }
}

class Program5 {

  public int minimumPassesOfMatrix(int[][] m) {
    // Write your code here.
    int rows = m.length;
    int cols = m[0].length;
    List<int[]> currQueue = new ArrayList<>();
    for ( int i =0; i < m.length;i++)
    {for ( int j =0; j < m[0].length;j++)
    {
      if ( m[i][j] >=0)
        currQueue.add( new int[]{i,j});
    }
    }
    int pass=0;
    boolean passUsed=false;
    while (!currQueue.isEmpty())
    {
      passUsed=false;
      List<int[]> nextPass = new ArrayList<>();
      for ( int[] pos : currQueue)
      {
        List<int[]> all = getAdNeighbours(pos[0] , pos[1],rows,cols);

        for ( int[] n : all)
        {
          int k = n[0];
          int l = n[1];

          if(m[k][l] < 0)
          {
            System.out.println(" making this negative to positive k " + k + " l " + l + " because current pos is positive i " + pos[0] + " j " + pos[1]);
            m[k][l] *=-1;
            nextPass.add(new int[]{k,l});
          }
        }
      }
      if (nextPass.size() >0 )
        pass++;
      currQueue  =   nextPass;

    }
    return pass ;
  }


  List<int[]> getAdNeighbours( int i , int j, int rSize, int cSize)
  {
    List<int[]> op = new ArrayList<>();

    if ( j >0)
      op.add( new int[]{i,j-1});

    if ( j < cSize -1)
      op.add( new int[]{i,j+1});

    if ( i >0)
      op.add( new int[]{i-1,j});

    if ( i < rSize-1)
      op.add( new int[]{i+1,j});

    return op;

  }
}
