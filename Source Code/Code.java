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
		int[][] adjMatrix;
		
		public CTG(int nodes)
		{
			V = 2*nodes+2;
			E = 0;
			adjMatrix = new int[V][V];
			
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
				addEdge(0,x);    // edge from START vertex to all other vertices
				
				/*for(int y=x+1;y<(arr.length)/2;y++)
				{
					addEdge(x,y);
				}*/
				
				for(int m=1;m<(arr.length-1);m++)    // create edge between all vertices except including START and END
				{
					if(arr[x].substring(0,1)!=arr[m].substring(0,1)&&Integer.parseInt(arr[x].substring(0,1))<Integer.parseInt(arr[m].substring(0,1)))
					{
						addEdge(x,m);
					}
				}
				
				addEdge(0,arr.length-1);    // edge from START vertex to END vertex
				addEdge(x,arr.length-1);    // edge from all other vertices to END vertex
			}
			
			toString(arr);
		}
		
		public void addEdge(int arr, int arr2)
		{
			adjMatrix[arr][arr2] = 1;
			E++;
		}
		
		public void toString(String arr[])
		{
			System.out.println("\n\nCTG : ");
			System.out.println("\n" + V + " vertices, "+ E + " edges "+"\n");
			System.out.print("        ");
			for(int j=0;j<arr.length;j++)
			{
				System.out.print(arr[j] + "  ");
			}
			System.out.print("\n");
			for(int j=0;j<arr.length;j++)
			{
				System.out.print(arr[j] + " :   ");
				for(int w:adjMatrix[j])
				{
					System.out.print(w+"      ");
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
