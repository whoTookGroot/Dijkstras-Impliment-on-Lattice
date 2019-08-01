package shortestPath;
import java.util.ArrayList;

public class Node {
	
	ArrayList<Integer> nodes = new ArrayList<Integer>();
	int value;
	int index;
	
	public Node(int index, int type, int[] lattice){
		this.value = lattice[index];
		this.index = index;
		
		switch(type){
		case 2:
			if(index == 6){
				if(lattice[index+15] != -1)
					nodes.add(index+15);
				if(lattice[index+7] != -1)
					nodes.add(index+7);
			}
			if(index == 224){
				if(lattice[index-15] != -1)
					nodes.add(index-15);
				if(lattice[index-7] != -1)
					nodes.add(index-7);
			}
			break;
		
		case 3: 
			if(index < 10){
				if(lattice[index+8] != -1)
					nodes.add(index+8);
				if(lattice[index+7] != -1)
					nodes.add(index+7);
				if(lattice[index+15] != -1)
					nodes.add(index+15);
			}
			else if(index == 14){
				if(lattice[index+8] != -1)
					nodes.add(index+8);
				if(lattice[index-7] != -1)
					nodes.add(index-7);
				if(lattice[index+15] != -1)
					nodes.add(index+15);
			}
			else if(index == 216){
				if(lattice[index-8] != -1)
					nodes.add(index-8);
				if(lattice[index+7] != -1)
					nodes.add(index+7);
				if(lattice[index-15] != -1)
					nodes.add(index-15);
			}
			else {
				if(lattice[index-8] != -1)
					nodes.add(index-8);
				if(lattice[index-7] != -1)
					nodes.add(index-7);
				if(lattice[index-15] != -1)
					nodes.add(index-15);
			}
			break;
		
		case 4:
			if(index % 15 == 14){
				if(lattice[index+8] != -1)
					nodes.add(index+8);
				if(lattice[index-7] != -1)
					nodes.add(index-7);
				if(lattice[index-15] != -1)
					nodes.add(index-15);
				if(lattice[index+15] != -1)
					nodes.add(index+15);
			}
			else if(index == 7){
				if(lattice[index+8] != -1)
					nodes.add(index+8);
				if(lattice[index-7] != -1)
					nodes.add(index-7);
				if(lattice[index+7] != -1)
					nodes.add(index+7);
				if(lattice[index+15] != -1)
					nodes.add(index+15);
			}
			else if(index == 223){
				if(lattice[index+7] != -1)
					nodes.add(index+7);
				if(lattice[index-7] != -1)
					nodes.add(index-7);
				if(lattice[index-15] != -1)
					nodes.add(index-15);
				if(lattice[index-8] != -1)
					nodes.add(index-8);
			}else{
				if(lattice[index-8] != -1)
					nodes.add(index-8);
				if(lattice[index+7] != -1)
					nodes.add(index+7);
				if(lattice[index-15] != -1)
					nodes.add(index-15);
				if(lattice[index+15] != -1)
					nodes.add(index+15);
			}
			break;
		
		case 5:
			if(index < 20){
				if(lattice[index+8] != -1)
					nodes.add(index+8);
				if(lattice[index-7] != -1)
					nodes.add(index-7);
				if(lattice[index+7] != -1)
					nodes.add(index+7);
				if(lattice[index-8] != -1)
					nodes.add(index-8);
				if(lattice[index+15] != -1)
					nodes.add(index+15);
			}else{
				if(lattice[index+8] != -1)
					nodes.add(index+8);
				if(lattice[index-7] != -1)
					nodes.add(index-7);
				if(lattice[index+7] != -1)
					nodes.add(index+7);
				if(lattice[index-8] != -1)
					nodes.add(index-8);
				if(lattice[index-15] != -1)
					nodes.add(index-15);
			}
			break;
		
		case 6:
			if(lattice[index+8] != -1)
				nodes.add(index+8);
			if(lattice[index-7] != -1)
				nodes.add(index-7);
			if(lattice[index+7] != -1)
				nodes.add(index+7);
			if(lattice[index-8] != -1)
				nodes.add(index-8);
			if(lattice[index-15] != -1)
				nodes.add(index-15);
			if(lattice[index+15] != -1)
				nodes.add(index+15);
			
			break;
			
		}
		nodes.trimToSize();
	}

}
