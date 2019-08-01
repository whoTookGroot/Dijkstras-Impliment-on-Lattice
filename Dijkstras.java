package shortestPath;

import java.util.ArrayList;

public class Dijkstras {
	
	public ArrayList dijkstra (Node[] map, int source, int end){
		int[] dist = new int[map.length]; //distance from source
		int[] pred = new int[map.length]; //previous node traversed
		boolean[] visited = new boolean[map.length];
		
		for (int i=0; i<dist.length; i++) {
			dist[i] = Integer.MAX_VALUE;
		}
		
		dist[indexOf(source,map)] = 0;
			  
		for (int i=0; i<dist.length; i++) {
			final int next = minVertex (dist, visited);
			if(next == -1){break;}
			visited[next] = true;
			// The shortest distance to next is dist[next] and via pred[next].
			  
			final int [] n =  convert(map[next].nodes,map,visited);
			for (int j=0; j<n.length; j++) {
				final int v = indexOf(n[j],map);
			    final int d =  dist[next]+map[v].value;
			    if (dist[v] > d) {
			    	dist[v] = d;
			        //pred stores indices to map
			    	pred[v] = next;
			    }
			}
		}		
			        return printPrep(map,pred,source,end); 
	}
	
	private int minVertex(int[] dist, boolean[] v){
		int x = Integer.MAX_VALUE;
		int y = -1;   // graph not connected, or no unvisited vertices
		for (int i=0; i<dist.length; i++) {
			if (!v[i] && dist[i]<x) {
				y=i; x=dist[i];}
			}
	       return y;
	}
	//converts node into array of neighbors
	private int[] convert(ArrayList<Integer> nodes, Node[] map, boolean[] visited){
		for(int i = 0; i < nodes.size();i++)
			if(visited[indexOf(nodes.get(i),map)])
			  nodes.remove(i);
		
		int[] n = new int[nodes.size()];
		for(int i = 0; i < n.length;i++)
			n[i] = (int) nodes.get(i);
		return n;
	}
	//two separate indexOfs as pred is the key to map
	private int indexOf(int v, Node[] map){
		int i = 0;
		while(i < map.length && map[i].index != v)
			i++;
		return i;
	}
	private int indexOf(int v, int[] pred){
		int i = 0;
		while(i < pred.length && pred[i] != v)
			i++;
			return i;
	}
	
	public ArrayList printPrep(Node[] map, int[] pred, int s, int e){
		ArrayList<Integer> path = new ArrayList<Integer>();
		//set end
		int x = indexOf(indexOf(e,map),pred);
		int sum = 0;
		//set source
		s = indexOf(indexOf(s,map),pred);
		while(x!=s){
			path.add(0,map[pred[x]].index);
			sum += map[pred[x]].value;
			x = pred[x];
		}
		//add source
		path.add(0,map[pred[s]].index);
		path.trimToSize();
		
		return path;
	}
}
