import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Code
{
	class DDG
	{
		int V;
		int E;
		int[][] adjMatrix;
		
		public DDG(int nodes)
		{
			V = nodes;
			E = 0;
			adjMatrix = new int[nodes][nodes];
			
			int n = nodes;
			int[] arr = new int[n];
			for(int i=0;i<n;i++)
			{
				arr[i] = i+1;
			}
			
			for(int j=0;j<n-1;j++)
			{
				addEdge(arr[j]-1, arr[j+1]-1);
			}
		}
		
		public void addEdge(int u, int v)
		{
			adjMatrix[u][v] = 1;
			E++;
		}
		
		public String toString()
		{
			StringBuilder sb = new StringBuilder();
			System.out.println("\nDDG : ");
			System.out.println("\n" + V + " vertices, "+ E + " edges "+"\n");
			System.out.print("   ");
			for(int v=0;v<V;v++)
			{
				int v_new = v+1;
				System.out.print(v_new + "  ");
			}
			System.out.print("\n");
			for(int v=0;v<V;v++)
			{
				int v_new = v+1;
				sb.append(v_new + ": ");
				for(int w:adjMatrix[v])
				{
					sb.append(w+"  ");
				}
				sb.append("\n");
			}
			return sb.toString();
		}
	}
	
	class CTG
	{
		int V;
		int E;
		double[][] adjMatrix;
		
		public CTG(int nodes)
		{
			V = 2*nodes+2;
			E = 0;
			adjMatrix = new double[V][V];
			
			int n = nodes;
			String[] arr = new String[2*n+2];
			
			arr[0] = "Start";
			arr[2*n+1] = "End  ";
			
			for(int i=1;i<=n;i++)
			{
				arr[i] = String.valueOf(i)+"ver1";
			}
			int k = 1;
			for(int i=n+1;i<=2*n;i++)
			{
					arr[i] = String.valueOf(k++)+"ver2";
			}
			
			for(int x=1;x<(arr.length-1);x++)
			{
				addEdge(0,x,arr);    // edge from START vertex to all other vertices except END
				
				/*for(int y=x+1;y<(arr.length)/2;y++)
				{
					addEdge(x,y);
				}*/
				
				for(int m=1;m<(arr.length-1);m++)    // create edge between all vertices except including START and END
				{
					if(arr[x].substring(0,1)!=arr[m].substring(0,1)&&Integer.parseInt(arr[x].substring(0,1))<Integer.parseInt(arr[m].substring(0,1)))
					{
						addEdge(x,m,arr);
					}
				}
				
				//addEdge(0,arr.length-1,arr);    // edge from START vertex to END vertex
				//addEdge(x,arr.length-1,arr);    // edge from all other vertices to END vertex
			}
			
			toString(arr);
		}
		
		public void addEdge(int fromVertex, int toVertex, String[] array)
		{
			adjMatrix[fromVertex][toVertex] = 1;
			E++;
			CalculateWeight(fromVertex,toVertex, array);
		}
		
		public void CalculateWeight(int a, int b, String[] array)
		{
			double WeightOfEdge = 0 ;
			
			// WeightOfEdge = Storage cost of "b" + regeneration cost of all vertices between "a" and "b"
			
			String s = array[b];   // 3ver2   ///   x = 2 y=3
			int x = Integer.parseInt(s.substring(s.length()-1, s.length()));
			int y = Integer.parseInt(s.substring(0,1));
			
			try 
            {
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/minor2", "root", "");
                
                String query1 = null;
                
                if(x==1)
                {
                	query1 = "SELECT Storage_Cost from cloud1 WHERE File_Number='"+y+"'";
                }
                if(x==2)
                {
                	query1 = "SELECT Storage_Cost from cloud2 WHERE File_Number='"+y+"'";
                }
                //String query1 = "SELECT Storage_Cost from cloud'"+x+"' WHERE File_Number='"+y+"'";
                Statement sta1 = connection.createStatement();
                ResultSet rs = sta1.executeQuery(query1); 
                
                rs.next();
                WeightOfEdge = rs.getDouble(1);//Double.parseDouble(rs.toString());
                
                connection.close();
            }
            catch (Exception exception) 
            {
            	exception.printStackTrace();
            }
			
			
			// Now calculating regeneration cost of vertices in between
			
			
			
			
			
			
			adjMatrix[a][b] = WeightOfEdge;
		}
		
		public void toString(String arr[])
		{
			System.out.println("\n\nCTG : ");
			System.out.println("\n" + V + " vertices, "+ E + " edges "+"\n");
			System.out.print("------|--");
			for(int p=1;p<=10;p++)
			{
				System.out.print("-----------|");
			}
			System.out.print("\n");
			System.out.print("      |  ");
			for(int j=0;j<arr.length;j++)
			{
				System.out.print("  ");
				System.out.print(arr[j] + "    |");
			}
			System.out.print("\n");
			System.out.print("------|--");
			for(int p=1;p<=10;p++)
			{
				System.out.print("-----------|");
			}
			System.out.print("\n");
			for(int j=0;j<arr.length;j++)
			{
				System.out.print(arr[j] + " |  ");
				for(double w:adjMatrix[j])
				{
					System.out.print(w);
					String space = String.valueOf(w);
					int x = 11 - space.length();
					for(int i = 1;i<=x;i++)
					{
						System.out.print(" ");
					}
					System.out.print("|");
				}
				System.out.print("\n");
				System.out.print("------|--");
				for(int p=1;p<=10;p++)
				{
					System.out.print("-----------|");
				}
				System.out.print("\n");
			}
		}
	}
	
	public static void main(int no_of_files)
	{
		Code obj = new Code();
		
		// DDG
		Code.DDG d = new Code().new DDG(no_of_files);
		System.out.println(d);
		
		//CTG
		Code.CTG c = new Code().new CTG(no_of_files);
	}
}
