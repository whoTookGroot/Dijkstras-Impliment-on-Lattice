package shortestPath;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

public class MinimalCostPath {
	
	public static void main(String[] args) throws Exception{
		//does not use base 1 indexing, converts at end, uses -1 indexing 
		final int source = 224;
		final int end = 6;
		//filereader/writer 
		File outputFile = new File("output.txt");
		String inputFile = "/Users/admin/Desktop/test_input_2.txt";
		FileWriter writer = new FileWriter(outputFile);
		FileParser parser = new FileParser();
		//231 Hexagon array
		int[] lattice = parser.parseFile(inputFile);
		
		//array of nodes creating a 'map' of the hexagonal lattice
		Map map = new Map(lattice); //create map of only valid nodes
		Dijkstras shortPath = new Dijkstras();
		
		
		ArrayList<Integer> path = shortPath.dijkstra(map.map, source,end); //sort map
		int sum = 0;
		// + 2 because its base 0 and because its only 231 in length, not 233
		for(int i = 0; i < path.size();i++){
			writer.write((path.get(i).intValue() + 2) + "  Value: " + lattice[path.get(i)] + "\n");
			sum+= lattice[path.get(i)];
		}
		writer.write("MINIMAL-COST PATH COSTS: " + sum);
		writer.close();
		System.out.print("File is located at: " + outputFile.getAbsolutePath());
	}
	
	
}
