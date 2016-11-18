import java.lang.Math;
public class LinReg
{	
	MatMul obj = new MatMul();
	double prediction(double [][] X, double [][] theta)
	{
		double [][] predict ;
		double[][] thetaT = obj.transpose(theta);
		predict = obj.multiply(thetaT,X);
		return predict[0][0];
	}
	
	
	
	double costFunction(double [][] X, double [] y, double [][]theta)
	{
		int m = X.length;
		int n = X[0].length;
		double cost=0;
		double [] predict = new double[m];
		for(int i=0;i<m;i++)
		{
			double [][]Xi = new double[n][1];
			for(int j=0;j<n;j++)
			{
				Xi[j][0]= X[i][j];
			}
			predict[i] = prediction(Xi,theta);
			
		}
		
		for(int i =0; i<m; i++)
		{
			cost+=Math.pow((predict[i]-y[i]), 2);
		}
		
		cost= cost/(2*m);
		return cost;
		
	}
	
	double[][] gradientDescent(double [][]X, double []y, double [][] theta, double alpha, int iteration)
	{
		int m = X.length;
		int n = X[0].length;
		double [] predict = new double[m];
		
			
			
			
			for(int iter=0;iter<iteration;iter++)
			{	
				for(int i=0;i<m;i++)
				{
					double [][]Xi = new double[n][1];
					for(int j=0;j<n;j++)
					{
						Xi[j][0]= X[i][j];
					}
					predict[i] = prediction(Xi,theta);
				}
			
				for(int j=0;j<n;j++)
				{
					double [][] thetaTemp = new double[n][1];
					for(int i=0;i<n;i++)
					{
						thetaTemp[i][0]=0.0;
					}
					for(int i=0;i<m;i++)
					{
						thetaTemp[j][0]=thetaTemp[j][0] + (alpha/m)*((predict[i]-y[i])*X[i][j]);
					}
					for(int k=0;k<n;k++)
					{
						theta[k][0]= theta[k][0] -(thetaTemp[k][0]);
					}
					
				}
			}
		return theta;	
		
	}
	
	
}
