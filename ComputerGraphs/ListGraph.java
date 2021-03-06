/*	ListGraph.java
*
*	Implements an Adjacency List version of a Graph
*	Implements the abstract class Graph
*
*	You must submit this file
* TODO: VIHAR PATEL
* TODO: P17 (12/2/2016)
* TODO: references: Princeton library
*/



import java.util.Scanner;

public class ListGraph extends Graph
{

	private LinkedList<Integer>[] adjLists;

	@SuppressWarnings("unchecked")
	public ListGraph(Scanner input)
	{
		super(input);

		adjLists = new LinkedList[numVertices];

		for(int i = 0; i < numVertices; i++)
		{
			adjLists[i] = new LinkedList<Integer>();
		}

		for(int i = 0; i < numVertices; i++)
		{
			String line = input.nextLine();
			if(line.equals(""))
			{
				i--;
				continue;
			}
			String[] edges = line.split(" ");
			for(int j = 1; j < edges.length; j++)
			{
				this.addEdge(i,Integer.parseInt(edges[j]));
			}
		}
	}

	public LinkedList<Integer>[] adj()
	{
		return adjLists;
	}
	public void addEdge(int u, int v)
	{
		adjLists[u].add(v);
	}

	public boolean hasEdge(int u, int v)
	{
		return adjLists[u].contains(v);
	}

	public void removeEdge(int u, int v)
	{
		adjLists[u].remove(v);
	}


	LinkedList<Integer> getAdjacentVertices(int v) {
		return adjLists[v];
	}

	public int degree(int v)
	{
		return getAdjacentVertices(v).size();
	}

}
