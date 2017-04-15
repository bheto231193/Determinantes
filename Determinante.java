public class Determinante
{
	public static void main(String args[])
	{
		
		
		
		int tamanno = 3, i, j;
		int matriz[][] = new int[tamanno][tamanno];
		for (i=0;i<tamanno;i++)
		{
			for (j=0;j<tamanno;j++)
			{
				matriz[i][j] = (int)(Math.random()*10)-5;
			}
		}

		printmat(matriz);

		System.out.println(determin(matriz));
	}

	public static void printmat(int matriz[][])
	{
		int i, j;
		for (i=0;i<matriz.length;i++)
		{
			for (j=0;j<matriz.length;j++)
				System.out.print(String.valueOf(matriz[i][j]) + "\t");
			System.out.println();
		}
		System.out.println();
	}

	public static int[][] submatrize(int matriz[][], int x, int y)
	{
		int submatriz[][] = new int[matriz.length-1][matriz.length-1];
		int i, j, cur_x=0, cur_y=0;
		for (i=0;i<matriz.length;i++)
		{
			if (i != x)
			{
				cur_y=0;
				for (j=0;j<matriz.length;j++)
				{
					if (j != y)
					{
						submatriz[cur_x][cur_y] = matriz[i][j];
						cur_y++;
					}
				}
				cur_x++;
			}
		}
		return submatriz;
	}

	public static int determin(int matriz[][])
	{
		int deter=0;
		int i, mult = 1;
		if (matriz.length > 2)
		{
			for (i=0;i<matriz.length;i++)
			{
				deter += mult * matriz[i][0] * determin(submatrize(matriz,i,0));
				mult *= -1;
			}
			return deter;
		}else
			return matriz[0][0] * matriz[1][1] - matriz[0][1] * matriz[1][0];
	}
}