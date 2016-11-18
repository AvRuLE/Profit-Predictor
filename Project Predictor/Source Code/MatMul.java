import java.io.*;

class MatMul 
{
	double [][] multiply(double[][] A, double[][] B)
	{
		int m=A.length, n=A[0].length;
		int q=B.length, p=B[0].length;
		
		if(n!=q)
		{
			System.out.println("\t INCOMPATIBLE ORDER OF MATRICES FOR MULTIPLICATION. \n \t \t PROCESS ENDED");
			return null;
		}
		else
		{
			double [][] C = new double[m][p];
			int i=0 , j=0;
			for(i=0;i<m;i++)
			{
				for(j=0;j<p;j++)
				{
					C[i][j]=0;
					for(int k=0;k<n;k++)
					{
						C[i][j]+=A[i][k]*B[k][j];
					}
				
				}
			}
			return C;
		}
		
	}
	
	
		double[][] create(int a, int b)throws IOException
		{	
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			double[][] A= new double[a][b];
			for(int i=0;i<a;i++)
			{
				for(int j=0;j<b;j++)
				{
					System.out.print("element["+(i+1)+"]["+(j+1)+"] = ");
					A[i][j]=Double.parseDouble(br.readLine());
				}
				System.out.println();
			}
			return A;
		}
	
		
		double[][] add(double[][] A,double [][]B)
		{
			int m=A.length, n=A[0].length;
			int q=B.length, p=B[0].length;
			if(m!=q&&n!=p)
			{	
				System.out.println("\t INCOMPATIBLE ORDER OF MATRICES FOR Addition. \n \t \t PROCESS ENDED");
				return null;
			}
			else
			{
				double [][] C= new double[m][n];
				for(int i=0;i<m;i++)
				{
					for(int j=0;j<n;j++)
					{
						C[i][j]=A[i][j]+B[i][j];
					}
				}
				return C;
			}
			
		}
		
		double[][] subtract(double[][] A, double [][]B)
		{
			int m=A.length, n=A[0].length;
			int q=B.length, p=B[0].length;
			if(m!=q&&n!=p)
			{	
				System.out.println("\t INCOMPATIBLE ORDER OF MATRICES FOR Subtraction. \n \t \t PROCESS ENDED");
				return A;
			}
			else
			{
				double [][] C= new double[m][n];
				for(int i=0;i<m;i++)
				{
					for(int j=0;j<n;j++)
					{
						C[i][j]=A[i][j]-B[i][j];
					}
				}
				return C;
			}
			
		}
		
		double[][] transpose(double [][] A)
		{
			int m=A.length, n=A[0].length;
			double [][] Atra= new double[n][m];
			for(int i=0;i<m;i++)
				{
					for(int j=0;j<n;j++)
					{
						Atra[j][i]=A[i][j];
					}
				}
				return Atra;
		}
		
}
