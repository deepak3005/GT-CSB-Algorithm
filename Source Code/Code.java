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
				addEdgeStartToAllDataset(0,x,arr);    // edge from START vertex to all other vertices except END
				
				for(int m=1;m<(arr.length-1);m++)    // create edge between all vertices except including START and END
				{
					if(arr[x].substring(0,1)!=arr[m].substring(0,1)&&Integer.parseInt(arr[x].substring(0,1))<Integer.parseInt(arr[m].substring(0,1)))
					{
						addEdge(x,m,arr);
					}
				}
				
				addEdgeStartToEndWithWeight(0,arr.length-1,arr);    // edge from START vertex to END vertex
				addEdgeFromAllDatasetToEndWithWeight(x,arr.length-1,arr);    // edge from all other vertices to END vertex
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
			
			String firstvertex = array[a];
			String secondvertex = array[b];
			int ax = Integer.parseInt(firstvertex.substring(firstvertex.length()-1, firstvertex.length()));    // CSP of first vertex
			int bx = Integer.parseInt(secondvertex.substring(secondvertex.length()-1, secondvertex.length()));    // CSP of second vertex
			int ay = Integer.parseInt(firstvertex.substring(0,1));    // Dataset in first vertex
			int by = Integer.parseInt(secondvertex.substring(0,1));    // Dataset in second vertex
			
			try 
            {
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/minor2", "root", "");
                
                String query1 = null;
                
                if(bx==1)
                {
                	query1 = "SELECT Storage_Cost from cloud1 WHERE File_Number='"+by+"'";
                }
                if(bx==2)
                {
                	query1 = "SELECT Storage_Cost from cloud2 WHERE File_Number='"+by+"'";
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
			
			if((by-ay)>1)
			{
				for(int i = ay+1 ; i < by ; i++) 
				{
					try 
		            {
		                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/minor2", "root", "");
		                
		                String query2 = "SELECT CC_and_BC from cloud1 WHERE File_Number='"+i+"'";
		                Statement sta2 = connection.createStatement();
		                ResultSet rs2 = sta2.executeQuery(query2); 
		                rs2.next();
		                double valueInFirstCloud = rs2.getDouble(1);
		                
		                String query3 = "SELECT Access_Frequency from cloud1 WHERE File_Number='"+i+"'";
		                Statement sta3 = connection.createStatement();
		                ResultSet rs3 = sta2.executeQuery(query3); 
		                rs3.next();
		                double AFvalueInFirstCloud = rs3.getDouble(1);
		                
		                String query4 = "SELECT CC_and_BC from cloud2 WHERE File_Number='"+i+"'";
		                Statement sta4 = connection.createStatement();
		                ResultSet rs4 = sta4.executeQuery(query4);
		                rs4.next();
		                double valueInSecondCloud = rs4.getDouble(1);
		                
		                String query5 = "SELECT Access_Frequency from cloud1 WHERE File_Number='"+i+"'";
		                Statement sta5 = connection.createStatement();
		                ResultSet rs5 = sta5.executeQuery(query5); 
		                rs5.next();
		                double AFvalueInSecondCloud = rs5.getDouble(1);
		                
		                if(valueInFirstCloud>=valueInSecondCloud)
		                {
		                	WeightOfEdge = WeightOfEdge + (valueInSecondCloud*AFvalueInSecondCloud);
		                }
		                
		                if(valueInSecondCloud>=valueInFirstCloud)
		                {
		                	WeightOfEdge = WeightOfEdge + (valueInFirstCloud*AFvalueInFirstCloud);
		                }
		                
		                connection.close();
		            }
		            catch (Exception exception) 
		            {
		            	exception.printStackTrace();
		            }
				}
			}
			
			adjMatrix[a][b] = WeightOfEdge;
		}
		
		public void addEdgeStartToEndWithWeight(int fromVertex, int toVertex, String[] array)
		{
			adjMatrix[fromVertex][toVertex] = 1;
			E++;
			
			double WeightOfEdge = 0 ;
			
			String StartVertex = array[fromVertex];
			String EndVertex = array[toVertex];
			
			for(int i=1;i<(array.length)/2;i++)
			{
				try 
	            {
	                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/minor2", "root", "");
	                
	                String query2 = "SELECT CC_and_BC from cloud1 WHERE File_Number='"+i+"'";
	                Statement sta2 = connection.createStatement();
	                ResultSet rs2 = sta2.executeQuery(query2); 
	                rs2.next();
	                double valueInFirstCloud = rs2.getDouble(1);
	                
	                String query3 = "SELECT Access_Frequency from cloud1 WHERE File_Number='"+i+"'";
	                Statement sta3 = connection.createStatement();
	                ResultSet rs3 = sta2.executeQuery(query3); 
	                rs3.next();
	                double AFvalueInFirstCloud = rs3.getDouble(1);
	                
	                String query4 = "SELECT CC_and_BC from cloud2 WHERE File_Number='"+i+"'";
	                Statement sta4 = connection.createStatement();
	                ResultSet rs4 = sta4.executeQuery(query4);
	                rs4.next();
	                double valueInSecondCloud = rs4.getDouble(1);
	                
	                String query5 = "SELECT Access_Frequency from cloud1 WHERE File_Number='"+i+"'";
	                Statement sta5 = connection.createStatement();
	                ResultSet rs5 = sta5.executeQuery(query5); 
	                rs5.next();
	                double AFvalueInSecondCloud = rs5.getDouble(1);
	                
	                if(valueInFirstCloud>=valueInSecondCloud)
	                {
	                	WeightOfEdge = WeightOfEdge + (valueInSecondCloud*AFvalueInSecondCloud);
	                }
	                
	                if(valueInSecondCloud>=valueInFirstCloud)
	                {
	                	WeightOfEdge = WeightOfEdge + (valueInFirstCloud*AFvalueInFirstCloud);
	                }
	                
	                connection.close();
	            }
	            catch (Exception exception) 
	            {
	            	exception.printStackTrace();
	            }
				
			}
			
			adjMatrix[fromVertex][toVertex] = WeightOfEdge;
		}
		
		public void addEdgeStartToAllDataset(int fromVertex, int toVertex, String[] array)
		{
			adjMatrix[fromVertex][toVertex] = 1;
			E++;
			
			double WeightOfEdge = 0 ;
			
			String StartVertex = array[fromVertex];
			String ToVertex = array[toVertex];
			
			int x = Integer.parseInt(ToVertex.substring(ToVertex.length()-1, ToVertex.length()));    // CSP 
			int y = Integer.parseInt(ToVertex.substring(0,1));    // Dataset 
			
			
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
			
			
			for(int i=1;i<y;i++)
			{
				try 
	            {
	                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/minor2", "root", "");
	                
	                String query2 = "SELECT CC_and_BC from cloud1 WHERE File_Number='"+i+"'";
	                Statement sta2 = connection.createStatement();
	                ResultSet rs2 = sta2.executeQuery(query2); 
	                rs2.next();
	                double valueInFirstCloud = rs2.getDouble(1);
	                
	                String query3 = "SELECT Access_Frequency from cloud1 WHERE File_Number='"+i+"'";
	                Statement sta3 = connection.createStatement();
	                ResultSet rs3 = sta2.executeQuery(query3); 
	                rs3.next();
	                double AFvalueInFirstCloud = rs3.getDouble(1);
	                
	                String query4 = "SELECT CC_and_BC from cloud2 WHERE File_Number='"+i+"'";
	                Statement sta4 = connection.createStatement();
	                ResultSet rs4 = sta4.executeQuery(query4);
	                rs4.next();
	                double valueInSecondCloud = rs4.getDouble(1);
	                
	                String query5 = "SELECT Access_Frequency from cloud2 WHERE File_Number='"+i+"'";
	                Statement sta5 = connection.createStatement();
	                ResultSet rs5 = sta5.executeQuery(query5); 
	                rs5.next();
	                double AFvalueInSecondCloud = rs5.getDouble(1);
	                
	                if(valueInFirstCloud>=valueInSecondCloud)
	                {
	                	WeightOfEdge = WeightOfEdge + (valueInSecondCloud*AFvalueInSecondCloud);
	                }
	                
	                if(valueInSecondCloud>=valueInFirstCloud)
	                {
	                	WeightOfEdge = WeightOfEdge + (valueInFirstCloud*AFvalueInFirstCloud);
	                }
	                
	                connection.close();
	            }
	            catch (Exception exception) 
	            {
	            	exception.printStackTrace();
	            }
				
			}
			
			adjMatrix[fromVertex][toVertex] = WeightOfEdge;
		}
		
		public void addEdgeFromAllDatasetToEndWithWeight(int fromVertex, int toVertex, String[] array)
		{
			adjMatrix[fromVertex][toVertex] = 1;
			E++;
			
			double WeightOfEdge = 0 ;
			
			String FromVertex = array[fromVertex];
			String EndVertex = array[toVertex];
			
			int y = Integer.parseInt(FromVertex.substring(0,1));    // Dataset 
			
			for(int i=y+1;i<(array.length)/2;i++)
			{
				try 
	            {
	                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/minor2", "root", "");
	                
	                String query2 = "SELECT CC_and_BC from cloud1 WHERE File_Number='"+i+"'";
	                Statement sta2 = connection.createStatement();
	                ResultSet rs2 = sta2.executeQuery(query2); 
	                rs2.next();
	                double valueInFirstCloud = rs2.getDouble(1);
	                
	                String query3 = "SELECT Access_Frequency from cloud1 WHERE File_Number='"+i+"'";
	                Statement sta3 = connection.createStatement();
	                ResultSet rs3 = sta2.executeQuery(query3); 
	                rs3.next();
	                double AFvalueInFirstCloud = rs3.getDouble(1);
	                
	                String query4 = "SELECT CC_and_BC from cloud2 WHERE File_Number='"+i+"'";
	                Statement sta4 = connection.createStatement();
	                ResultSet rs4 = sta4.executeQuery(query4);
	                rs4.next();
	                double valueInSecondCloud = rs4.getDouble(1);
	                
	                String query5 = "SELECT Access_Frequency from cloud2 WHERE File_Number='"+i+"'";
	                Statement sta5 = connection.createStatement();
	                ResultSet rs5 = sta5.executeQuery(query5); 
	                rs5.next();
	                double AFvalueInSecondCloud = rs5.getDouble(1);
	                
	                if(valueInFirstCloud>valueInSecondCloud)
	                {
	                	WeightOfEdge = WeightOfEdge + (valueInSecondCloud*AFvalueInSecondCloud);
	                }
	                
	                if(valueInSecondCloud>=valueInFirstCloud)
	                {
	                	WeightOfEdge = WeightOfEdge + (valueInFirstCloud*AFvalueInFirstCloud);
	                }
	                
	                connection.close();
	            }
	            catch (Exception exception) 
	            {
	            	exception.printStackTrace();
	            }
				
			}
			
			adjMatrix[fromVertex][toVertex] = WeightOfEdge;
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
			
			ShortestPathUsingDijkstra abc = new ShortestPathUsingDijkstra();
			abc.Dijkstra(adjMatrix,0,arr);
			
		}
	}
	
	class ShortestPathUsingDijkstra
	{
		private static final int NO_PARENT = -1;

		// Function that implements Dijkstra's
	    // single source shortest path
	    // algorithm for a graph represented 
	    // using adjacency matrix
	    // representation
	    private void Dijkstra(double[][] adjacencyMatrix,int startVertex, String[] array)
	    {
	        int nVertices = adjacencyMatrix[0].length;
	  
	        // shortestDistances[i] will hold the
	        // shortest distance from src to i
	        int[] shortestDistances = new int[nVertices];
	  
	        // added[i] will true if vertex i is
	        // included / in shortest path tree
	        // or shortest distance from src to 
	        // i is finalized
	        boolean[] added = new boolean[nVertices];
	  
	        // Initialize all distances as 
	        // INFINITE and added[] as false
	        for (int vertexIndex = 0; vertexIndex < nVertices; vertexIndex++)
	        {
	            shortestDistances[vertexIndex] = Integer.MAX_VALUE;
	            added[vertexIndex] = false;
	        }
	        
	        // Distance of source vertex from
	        // itself is always 0
	        shortestDistances[startVertex] = 0;
	  
	        // Parent array to store shortest
	        // path tree
	        int[] parents = new int[nVertices];
	  
	        // The starting vertex does not 
	        // have a parent
	        parents[startVertex] = NO_PARENT;
	  
	        // Find shortest path for all 
	        // vertices
	        for (int i = 1; i < nVertices; i++)
	        {
	  
	            // Pick the minimum distance vertex
	            // from the set of vertices not yet
	            // processed. nearestVertex is 
	            // always equal to startNode in 
	            // first iteration.
	            int nearestVertex = -1;
	            int shortestDistance = Integer.MAX_VALUE;
	            for (int vertexIndex = 0;
	                     vertexIndex < nVertices; 
	                     vertexIndex++)
	            {
	                if (!added[vertexIndex] &&
	                    shortestDistances[vertexIndex] < 
	                    shortestDistance) 
	                {
	                    nearestVertex = vertexIndex;
	                    shortestDistance = shortestDistances[vertexIndex];
	                }
	            }
	  
	            // Mark the picked vertex as
	            // processed
	            added[nearestVertex] = true;
	  
	            // Update dist value of the
	            // adjacent vertices of the
	            // picked vertex.
	            for (int vertexIndex = 0;
	                     vertexIndex < nVertices; 
	                     vertexIndex++) 
	            {
	                double edgeDistance = adjacencyMatrix[nearestVertex][vertexIndex];
	                  
	                if (edgeDistance > 0
	                    && ((shortestDistance + edgeDistance) < 
	                        shortestDistances[vertexIndex])) 
	                {
	                    parents[vertexIndex] = nearestVertex;
	                    shortestDistances[vertexIndex] = (int) (shortestDistance + 
	                                                       edgeDistance);
	                }
	            }
	        }
	  
	        printSolution(startVertex, shortestDistances, parents, array);
	    }
	  
	    // A utility function to print 
	    // the constructed distances
	    // array and shortest paths
	    private void printSolution(int startVertex,int[] distances,int[] parents, String[] array)
	    {
	        int nVertices = distances.length;
	        /*System.out.print("Vertex\t Distance\tPath");
	          
	        for (int vertexIndex = 0; vertexIndex < nVertices; vertexIndex++) 
	        {
	            if (vertexIndex != startVertex) 
	            {
	                System.out.print("\n" + startVertex + " -> ");
	                System.out.print(vertexIndex + " \t\t ");
	                System.out.print(distances[vertexIndex] + "\t\t");
	                printPath(vertexIndex, parents);
	            }
	        }*/
	        
	        System.out.print("\n\n\nApplying Dijkstra's Algorithm on CTG : \n\nShortest path from START to END :  ");
	          
	        for (int vertexIndex = 9; vertexIndex < nVertices; vertexIndex++) 
	        {
	            if (vertexIndex != startVertex) 
	            {
	                //System.out.print("\n" + startVertex + " -> ");
	                //System.out.print(vertexIndex + " \t\t ");
	                //System.out.print(distances[vertexIndex] + "\t\t");
	                printPath(vertexIndex, parents, array);
	            }
	        }
	        
	        String DijkstraOutput = path;
	        FindVertexNotIncluded(array,DijkstraOutput);
	    }
	    
	    // Function to print shortest path
	    // from source to currentVertex
	    // using parents array
	    
	    String path = "";
	    
	    private void printPath(int currentVertex,int[] parents,String[] array)
	    {
	        // Base case : Source node has
	        // been processed
	        if (currentVertex == NO_PARENT)
	        {
	            return;
	        }
	        printPath(parents[currentVertex], parents,array);
	        System.out.print(array[currentVertex]);
	        path = path + array[currentVertex];
	        //FindVertexNotIncluded(array[currentVertex],array);
	        if(currentVertex!=(array.length-1))
	        {
	        	System.out.print(" -> ");
	        }
	        if(currentVertex==(array.length-1))
	        {
	        	System.out.print("\n\n");
	        }
	    }
	    
	    public void FindVertexNotIncluded(String[] array, String s2)
	    {
	    	int x = 0;
	    	for(x=0;x<array.length;x++)
	    	{
	    		if(strstr(s2,array[x])==(-1))
	    		{
	    			String VertexFound = array[x];
	    			int FileNumberFound = Integer.parseInt(VertexFound.substring(0, 1));
	    			int CloudNumberFound = Integer.parseInt(VertexFound.substring(VertexFound.length()-1, VertexFound.length()));
	    			
	    			GTCSB gt = new GTCSB();
	    			gt.WantToDeleteFile(FileNumberFound, CloudNumberFound);
	    			
	    			break;
	    		}
	    	}
	    }
	    
	    public int strstr(String str, String target)
	    {
	 
	        int t = 0;
	        int len = str.length();
	        int i;
	        for (i = 0; i < len; i++) {
	            if (t == target.length())
	                break;
	            if (str.charAt(i) == target.charAt(t))
	                t++;
	            else
	                t = 0;
	        }
	        return t < target.length() ? -1 : i - t;
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
