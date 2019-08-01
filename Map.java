package shortestPath;

import java.util.ArrayList;

public class Map  {
	
	int[] lattice;
	boolean[] visited;
	Node[] map; 
	ArrayList<Integer> a2Nodes = new ArrayList<Integer>(); //list of nodes based on #neighbors
	ArrayList<Integer> a3Nodes = new ArrayList<Integer>();
	ArrayList<Integer> a4Nodes = new ArrayList<Integer>();
	ArrayList<Integer> a5Nodes = new ArrayList<Integer>();
	ArrayList<Integer> a6Nodes = new ArrayList<Integer>();
	
	//set of rules defining each arrayList, each node type is unique
	public Map(int[] lattice){
		this.lattice = lattice;
		visited = new boolean[lattice.length];
		
		//unique case [end/start]
		if(lattice[6] != -1)
			a2Nodes.add(6);
		visited[6] = true;
		if(lattice[224] != -1)
			a2Nodes.add(224);
		visited[224] = true;
		
		
		for(int i = 0; i < 6;i++){ //top cases A3NODES
			if(lattice[i] != -1)
				a3Nodes.add(i);
			visited[i] = true;
		}
		if(lattice[14] != -1) // unique case due to corner cut[CC]
			a3Nodes.add(14);
		visited[14] = true;
		
		for(int i = 225; i < 231;i++){//bottom cases A3NODES
			if(lattice[i] != -1)
				a3Nodes.add(i);
			visited[i] = true;
		}
		if(lattice[216] != -1) //index 218, accounts for CC
			a3Nodes.add(216);
		visited[216] = true;
		
		for(int i = 29; i < 210; i+=15){ //side cases A4NODES
			if(lattice[i] != -1)
				a4Nodes.add(i);
			visited[i] = true;
		}
		
		for(int i = 21; i < 202; i+=15){
			if(lattice[i] != -1)
				a4Nodes.add(i);
			visited[i] = true;
		}
		if(lattice[7] != -1) //unique side cases due to CC
			a4Nodes.add(7);
		visited[7] = true;
		if(lattice[223] != -1)
			a4Nodes.add(223);
		visited[223] = true;
		
		
		for(int i = 8; i < 14; i++){ //Bottom-top cases A5NODES
			if(lattice[i] != -1)
				a5Nodes.add(i);
			visited[i] = true;
		}
		
		for(int i = 217; i < 223; i++){
			if(lattice[i] != -1)
				a5Nodes.add(i);
			visited[i] = true;
		}
		
		for(int i = 0; i < lattice.length; i++){ //All A6Nodes
			if(visited[i])
				continue;
			if(lattice[i] != -1)
				a6Nodes.add(i);
		}
		
		createNodes();
	}
	
	private void createNodes(){
	    map = new Node[a2Nodes.size() + a3Nodes.size() + a4Nodes.size() + a5Nodes.size() + a6Nodes.size()];
		int i = 0;
	
	    for(i = 0; i < a2Nodes.size(); i++)
			map[i] = new Node(a2Nodes.get(i),2,lattice);
	    
	    for(int j = 0;j < a3Nodes.size();j++)
	    	map[i++] = new Node(a3Nodes.get(j),3,lattice);
	    
	    for(int j = 0; j < a4Nodes.size();j++)
	    	map[i++] = new Node(a4Nodes.get(j),4,lattice);
	    
	    for(int j = 0; j < a5Nodes.size();j++)
	    	map[i++] = new Node(a5Nodes.get(j),5,lattice);
	   
	    for(int j = 0; j < a6Nodes.size();j++)
	    	map[i++] = new Node(a6Nodes.get(j),6,lattice);
	}

}