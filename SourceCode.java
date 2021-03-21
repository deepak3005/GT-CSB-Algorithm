import java.io.*;



class Graph1 
{ 
    // number of vertices 
    private int n; 
  
    // adjacency matrix 
    private int[][] g = new int[10][10]; 
  
    // constructor 
    Graph1(int x) 
    { 
        this.n = x+1; 
        int i, j; 
  
        // initializing each element of  
        // the adjacency matrix to zero 
        for (i = 0; i < n; ++i)  
        { 
            for (j = 0; j < n; ++j)  
            { 
                g[i][j] = 0; 
            } 
        } 
    } 
  
    public void displayAdjacencyMatrix() 
    { 
        System.out.print("\n\n Adjacency Matrix:"); 
  
        // displaying the 2D array 
        for (int i = 0; i < n; ++i) 
        { 
            System.out.println(); 
            for (int j = 0; j < n; ++j)  
            { 
                System.out.print("        " + g[i][j]); 
            } 
        } 
    } 
  
    public void addEdge(int x, int y,int z) 
    { 
        // checks if the vertex exists in the graph 
        if ((x >= n) || (y > n)) 
        { 
            System.out.println("Vertex does not exists!"); 
        } 
  
        // checks if the vertex is connecting to itself 
        if (x == y)  
        { 
            System.out.println("Same Vertex!"); 
        }
      /*  if(x==0)
         {
        	g[y][x] = 0; 
            g[x][y] = 0; 
        }
        */
        else 
        { 
            // connecting the vertices 
           // g[y][x] = 1; 
            g[x][y] = z; 
        } 
    } 
  
    public void addVertex() 
    { 
        // increasing the number of vertices 
        n++; 
        int i; 
  
        // initializing the new elements to 0 
        for (i = 0; i < n; ++i) 
        { 
            g[i][n - 1] = 0; 
            g[n - 1][i] = 0; 
        } 
    } 
  
    public void removeVertex(int x) 
    { 
        // checking if the vertex is present 
        if (x > n)  
        { 
            System.out.println("Vertex not present!"); 
            return; 
        } 
        
        else if(x>=1&&x<=n)
    {
    	g[x-1][x] = 0;
    }
        else
        {
        	 System.out.println("Vertices are between 1 to 4"); 
             return; 
        }
    } 
    
    public void check_edge(int x)
    {
    	if(g[x-1][x]==0)
    	{
    		System.out.println("\nVertice"+ x +" is deleted\n");
    	}
    	else
    	{
    		System.out.println("\nVertice " + x + " cost is : " + g[x-1][x]);
    	}
    }
    
    
} 
  
class Graph2 
{ 
    // number of vertices 
    private int n; 
  
    // adjacency matrix 
    private int[][] g = new int[10][10]; 
  
    // constructor 
    Graph2(int x) 
    { 
        this.n = x+1; 
        int i, j; 
  
        // initializing each element of  
        // the adjacency matrix to zero 
        for (i = 0; i < n; ++i)  
        { 
            for (j = 0; j < n; ++j)  
            { 
                g[i][j] = 0; 
            } 
        } 
    } 
  
    public void displayAdjacencyMatrix() 
    { 
        System.out.print("\n\n Adjacency Matrix:"); 
  
        // displaying the 2D array 
        for (int i = 0; i < n; ++i) 
        { 
            System.out.println(); 
            for (int j = 0; j < n; ++j)  
            { 
                System.out.print("        " + g[i][j]); 
            } 
        } 
    } 
  
    public void addEdge(int x, int y,int z) 
    { 
        // checks if the vertex exists in the graph 
        if ((x >= n) || (y > n)) 
        { 
            System.out.println("Vertex does not exists!"); 
        } 
  
        // checks if the vertex is connecting to itself 
        if (x == y)  
        { 
            System.out.println("Same Vertex!"); 
        }
      /*  if(x==0)
         {
        	g[y][x] = 0; 
            g[x][y] = 0; 
        }
        */
        else 
        { 
            // connecting the vertices 
           // g[y][x] = 1; 
            g[x][y] = z; 
        } 
    } 
  
    public void addVertex() 
    { 
        // increasing the number of vertices 
        n++; 
        int i; 
  
        // initializing the new elements to 0 
        for (i = 0; i < n; ++i) 
        { 
            g[i][n - 1] = 0; 
            g[n - 1][i] = 0; 
        } 
    } 
  
    public void removeVertex(int x) 
    { 
        // checking if the vertex is present 
        if (x > n)  
        { 
            System.out.println("Vertex not present!"); 
            return; 
        } 
     
        else if(x>=1&&x<=n)
    {
    	g[x-1][x] = 0;
    }
        else
        {
        	 System.out.println("Vertices are between 1 to 4"); 
             return; 
        }
    } 
    
    
    
    
} 





class Graph3 
{ 
    // number of vertices 
    private int n; 
  
    // adjacency matrix 
    private int[][] g = new int[10][10]; 
  
    // constructor 
    Graph3(int x) 
    { 
        this.n = x+1; 
        int i, j; 
  
        // initializing each element of  
        // the adjacency matrix to zero 
        for (i = 0; i < n; ++i)  
        { 
            for (j = 0; j < n; ++j)  
            { 
                g[i][j] = 0; 
            } 
        } 
    } 
  
    public void displayAdjacencyMatrix() 
    { 
        System.out.print("\n\n Adjacency Matrix:"); 
  
        // displaying the 2D array 
        for (int i = 0; i < n; ++i) 
        { 
            System.out.println(); 
            for (int j = 0; j < n; ++j)  
            { 
                System.out.print("        " + g[i][j]); 
            } 
        } 
    } 
  
    public void addEdge(int x, int y,int z) 
    { 
        // checks if the vertex exists in the graph 
        if ((x >= n) || (y > n)) 
        { 
            System.out.println("Vertex does not exists!"); 
        } 
  
        // checks if the vertex is connecting to itself 
        if (x == y)  
        { 
            System.out.println("Same Vertex!"); 
        }
      /*  if(x==0)
         {
        	g[y][x] = 0; 
            g[x][y] = 0; 
        }
        */
        else 
        { 
            // connecting the vertices 
           // g[y][x] = 1; 
            g[x][y] = z; 
        } 
    } 
  
    public void addVertex() 
    { 
        // increasing the number of vertices 
        n++; 
        int i; 
  
        // initializing the new elements to 0 
        for (i = 0; i < n; ++i) 
        { 
            g[i][n - 1] = 0; 
            g[n - 1][i] = 0; 
        } 
    } 
  
    public void removeVertex(int x) 
    { 
        // checking if the vertex is present 
        if (x > n)  
        { 
            System.out.println("Vertex not present!"); 
            return; 
        } 
        /*
        else 
        { 
            int i; 
  
            // removing the vertex 
            while (x < n) 
            { 
  
                // shifting the rows to left side 
                for (i = 0; i < n; ++i)  
                { 
                    g[i][x] = g[i][x + 1]; 
                } 
  
                // shifting the columns upwards 
                for (i = 0; i < n; ++i) 
                { 
                    g[x][i] = g[x + 1][i]; 
                } 
                x++; 
            } 
  
            // decreasing the number of vertices 
            n--; 
        
            } 
    
    */
        else if(x>=1&&x<=n)
    {
    	g[x-1][x] = 0;
    }
        else
        {
        	 System.out.println("Vertices are between 1 to 4"); 
             return; 
        }
    } 
    
    
    
    
} 





class Graph4 
{ 
    // number of vertices 
    private int n; 
  
    // adjacency matrix 
    private int[][] g = new int[10][10]; 
  
    // constructor 
    Graph4(int x) 
    { 
        this.n = x+1; 
        int i, j; 
  
        // initializing each element of  
        // the adjacency matrix to zero 
        for (i = 0; i < n; ++i)  
        { 
            for (j = 0; j < n; ++j)  
            { 
                g[i][j] = 0; 
            } 
        } 
    } 
  
    public void displayAdjacencyMatrix() 
    { 
        System.out.print("\n\n Adjacency Matrix:"); 
  
        // displaying the 2D array 
        for (int i = 0; i < n; ++i) 
        { 
            System.out.println(); 
            for (int j = 0; j < n; ++j)  
            { 
                System.out.print("        " + g[i][j]); 
            } 
        } 
    } 
  
    public void addEdge(int x, int y,int z) 
    { 
        // checks if the vertex exists in the graph 
        if ((x >= n) || (y > n)) 
        { 
            System.out.println("Vertex does not exists!"); 
        } 
  
        // checks if the vertex is connecting to itself 
        if (x == y)  
        { 
            System.out.println("Same Vertex!"); 
        }
      /*  if(x==0)
         {
        	g[y][x] = 0; 
            g[x][y] = 0; 
        }
        */
        else 
        { 
            // connecting the vertices 
           // g[y][x] = 1; 
            g[x][y] = z; 
        } 
    } 
  
    public void addVertex() 
    { 
        // increasing the number of vertices 
        n++; 
        int i; 
  
        // initializing the new elements to 0 
        for (i = 0; i < n; ++i) 
        { 
            g[i][n - 1] = 0; 
            g[n - 1][i] = 0; 
        } 
    } 
  
    public void removeVertex(int x) 
    { 
        // checking if the vertex is present 
        if (x > n)  
        { 
            System.out.println("Vertex not present!"); 
            return; 
        } 
        /*
        else 
        { 
            int i; 
  
            // removing the vertex 
            while (x < n) 
            { 
  
                // shifting the rows to left side 
                for (i = 0; i < n; ++i)  
                { 
                    g[i][x] = g[i][x + 1]; 
                } 
  
                // shifting the columns upwards 
                for (i = 0; i < n; ++i) 
                { 
                    g[x][i] = g[x + 1][i]; 
                } 
                x++; 
            } 
  
            // decreasing the number of vertices 
            n--; 
        
            } 
    
    */
        else if(x>=1&&x<=n)
    {
    	g[x-1][x] = 0;
    }
        else
        {
        	 System.out.println("Vertices are between 1 to 4"); 
             return; 
        }
    } 
    
    
    
    
} 








class SourceCode
{ 
    public static void main(String[] args) 
    { 
         int psc1= 10,psc2=20,psc3=30,psc4=40;
         
    	String fileName1 = "E:\\\\MessageFile1.txt";
    	File f1 = new File(fileName1);
    	long fileSize1 = f1.length();
    	
    	 System.out.format("The size of the file: %d bytes\n", fileSize1);
    	 
    	 String fileName2 = "E:\\\\MessageFile2.txt";
     	File f2 = new File(fileName2);
     	long fileSize2 = f2.length();
     	
     	 System.out.format("The size of the file: %d bytes\n", fileSize2);
     	 
     	 
     	String fileName3 = "E:\\\\MessageFile3.txt";
    	File f3 = new File(fileName3);
    	long fileSize3 = f3.length();
    	
    	 System.out.format("The size of the file: %d bytes\n", fileSize3);
    	 
    	 
    	 
    	 String fileName4 = "E:\\\\MessageFile4.txt";
     	File f4 = new File(fileName4);
     	long fileSize4 = f4.length();
     	
     	 System.out.format("The size of the file: %d bytes \n", fileSize4);
    	 
    	// creating objects of class Graph 
        Graph1 obj1 = new Graph1(4); 
        Graph2 obj2 = new Graph2(4); 
        Graph3 obj3 = new Graph3(4);
        Graph4 obj4 = new Graph4(4);
  
        
        
       int storage_cost1d1 = (int) ((psc1*fileSize1)/1000);
       int storage_cost2d1 = (int) ((psc2*fileSize1)/1000);
       int storage_cost3d1 = (int) ((psc3*fileSize1)/1000);
       int storage_cost4d1 = (int) ((psc4*fileSize1)/1000);
        // calling methods 
         
        obj1.addEdge(0, 1,storage_cost1d1); 
        obj1.addEdge(1, 2,storage_cost2d1); 
        obj1.addEdge(2, 3,storage_cost3d1); 
        obj1.addEdge(3, 4,storage_cost4d1); 
       // obj1.addVertex() ; 
        // the adjacency matrix created 
       obj1.displayAdjacencyMatrix(); 
     
       obj1.removeVertex(4);
       
       obj1.displayAdjacencyMatrix();
       obj1.check_edge(4);
       obj1.check_edge(2);
   

       int storage_cost1d2 = (int) ((psc1*fileSize2)/1000);
       int storage_cost2d2 = (int) ((psc2*fileSize2)/1000);
       int storage_cost3d2 = (int) ((psc3*fileSize2)/1000);
       int storage_cost4d2 = (int) ((psc4*fileSize2)/1000);
        // calling methods 
         
        obj2.addEdge(0, 1,storage_cost1d2); 
        obj2.addEdge(1, 2,storage_cost2d2); 
        obj2.addEdge(2, 3,storage_cost3d2); 
        obj2.addEdge(3, 4,storage_cost4d2); 
       // obj1.addVertex() ; 
        // the adjacency matrix created 
       obj2.displayAdjacencyMatrix(); 
     
       obj2.removeVertex(4);
       obj2.displayAdjacencyMatrix(); 
      
       int storage_cost1d3 = (int) ((psc1*fileSize3)/1000);
       int storage_cost2d3 = (int) ((psc2*fileSize3)/1000);
       int storage_cost3d3 = (int) ((psc3*fileSize3)/1000);
       int storage_cost4d3 = (int) ((psc4*fileSize3)/1000);
        // calling methods 
         
        obj3.addEdge(0, 1,storage_cost1d3); 
        obj3.addEdge(1, 2,storage_cost2d3); 
        obj3.addEdge(2, 3,storage_cost3d3); 
        obj3.addEdge(3, 4,storage_cost4d3); 
       // obj3.addVertex() ; 
        // the adjacency matrix created 
       obj3.displayAdjacencyMatrix(); 
     
       obj3.removeVertex(4);
       
       obj3.displayAdjacencyMatrix();
       
       
       
       int storage_cost1d4 = (int) ((psc1*fileSize4)/1000);
       int storage_cost2d4 = (int) ((psc2*fileSize4)/1000);
       int storage_cost3d4 = (int) ((psc3*fileSize4)/1000);
       int storage_cost4d4 = (int) ((psc4*fileSize4)/1000);
        // calling methods 
         
        obj4.addEdge(0, 1,storage_cost1d4); 
        obj4.addEdge(1, 2,storage_cost2d4); 
        obj4.addEdge(2, 3,storage_cost3d4); 
        obj4.addEdge(3, 4,storage_cost4d4); 
       // obj4.addVertex() ; 
        // the adjacency matrix created 
       obj4.displayAdjacencyMatrix(); 
     
       obj4.removeVertex(4);
       
       obj4.displayAdjacencyMatrix();
       
    
    
    } 
} 
