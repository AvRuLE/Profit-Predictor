import java.io.*;
public class Predictor extends LinReg
{
	
	double [][] load(String filename)throws IOException, NumberFormatException
	{
		File file = new File(filename);
		FileReader fr = new FileReader(file);
		int m = 0;int c;
		while((c=fr.read())!=-1)
		{
			if(c==',')
				m++;
		}
		fr.close();
		double [][] X = new double[m][2];
		fr= new FileReader(file);
		int i = 0;
		String st ="";
		while((c=fr.read())!=-1)
		{
			if(c==',')
			{
				X[i][0]=1;
				X[i][1]=Double.parseDouble(st);
				st = "";
				i++;
			}
			else
			{
				st=st + (char)c;
			}
		}
		fr.close();
		return X;
	}
	
	double [] load2(String filename)throws IOException, NumberFormatException
	{
		File file = new File(filename);
		FileReader fr = new FileReader(file);
		int m = 0;int c;
		while((c=fr.read())!=-1)
		{
			if(c==',')
				m++;
		}
		fr.close();
		double [] X = new double[m];
		fr= new FileReader(file);
		int i = 0;
		String st ="";
		while((c=fr.read())!=-1)
		{
			if(c==',')
			{
				X[i]=Double.parseDouble(st);
				st = "";
				i++;
			}
			else
			{
				st=st + (char)c;
			}
		}
		fr.close();
		return X;
	}
	
	public static void main(String[]args)throws IOException, NumberFormatException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Predictor ob = new Predictor();
		System.out.println("\t\t\t\t\tWelcome to the PROFIT PREDICTOR\n\t\t\t     Technique Used::LINEAR REGRESSION USING ONE VARIABLE");
		System.out.println("\t\t\t\t    Project By ::\t ABINASH ANKIT RAUT \n\t\t\t\t  HP Summer Training Program 2015 : Core Java\n\n\n\n");

		System.out.println("\t\t\t\t  Enter the filename of your Population dataset");
		
		double [][]X;
		for(int k=0;k==0;)
		{	
			try
			{
				String Xdata=br.readLine();
				X = ob.load(Xdata);
				
				
		
				double []y;
				
				for( k=0;k==0;)
				{
					System.out.println("\t\t\t\t     Enter the filename of your Profit dataset");
					try
					{
						String Ydata=br.readLine();
						y = ob.load2(Ydata);
						
						if(X.length==y.length)
						{
								double[][]theta=new double[2][1];
								theta[0][0]=0;theta[1][0]=0;
								double alpha=0.01;
								int iterations=1500;
								
									
								
								try
								{
										theta= ob.gradientDescent(X,y,theta,alpha,iterations);
								}
								catch(ArrayIndexOutOfBoundsException ex)
								{
									ex.printStackTrace();
								}

								for(int i=0;i>=0;)
								{	
									double population;
									for( k=0;k==0;)
									{
										try{
											System.out.println("Enter the Population of the place");
											population = Double.parseDouble(br.readLine());
											double guess = theta[0][0]+theta[1][0]*(population/10000);
											System.out.println("Predicted Profit is : Rs "+guess*10000);
											break;
									
										}
										catch(NumberFormatException ne)
										{
											System.out.println("Enter the size correctly");
											continue;
										}
									}
									
									System.out.println("\t Do you want to continue ?\n\t 1-Yes \nPress any other key to exit");
									try
									{
										if((Integer.parseInt(br.readLine()))==1)
										{
											for(int j=0;j<500;j++)
												System.out.println("\b");
											continue;
										}
										else
										{
											System.out.println("Thank you for using the Profit predictor\n\t\tHope you liked it");
											break;
										}
									}
									catch(NumberFormatException e)
									{
										break;
									}
								}
								break;
						}
						else
						{
							System.out.println("The number of entries of population and profit do not match please try again");
							continue;
						}
					}
					catch(FileNotFoundException fne)
					{
						System.out.println("File not found. Enter the file name correctly ");
						continue;
					}
				}
				break;	
			}
			catch(FileNotFoundException fe)
			{
				System.out.println("File not found. Enter the file name correctly ");
				continue;
			}
		}
		
		
	}
}
