package soc.pr2.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import soc.pr2.application.Utilities;
import soc.pr2.data.Node;

public class BarabasiAlbert implements Runnable {

	private long m;
	private long t;
	private List<Node> listNodes;
	public static double PROBABILITY = 0;
	public static long TOTAL_DEGREE = 0;

	public BarabasiAlbert(long m, int t) {
		super();
		this.m = m;
		this.t = t;
		listNodes = new ArrayList<Node>();
		initialize();
	}

	public void run() {
		generate();
	}

	private void initialize() {

		for (long i = 0; i < m; i++)
			listNodes.add(new Node());

		for (int i = 0; i < listNodes.size(); i++) {
			Node masterNode = listNodes.get(i);
			for (int j = i + 1; j < listNodes.size(); j++) {
				Node neighboringNode = listNodes.get(j);
				masterNode.addAdjacentNode(neighboringNode);
				neighboringNode.addAdjacentNode(masterNode);
				masterNode.increaseDegree();
				neighboringNode.increaseDegree();
				TOTAL_DEGREE += 2;
			}
		}
	}

	private void generate() {

		for (int i = 0; i < t; i++) {
			long addedEdge = 0;
			Node newNode = new Node();

			while (addedEdge < this.m) {

				for (Node neighboringNode : listNodes) {

					if (newNode.contains(neighboringNode))
						continue;

					Random number = new Random();
					float probability = number.nextFloat();

					if (probability <= neighboringNode.getDegree()
							/ TOTAL_DEGREE) {
						newNode.addAdjacentNode(neighboringNode);
						neighboringNode.addAdjacentNode(newNode);
						newNode.increaseDegree();
						neighboringNode.increaseDegree();

						addedEdge++;
						if (addedEdge == this.m)
							break;
					}
				}
				TOTAL_DEGREE += m * 2;
			}
			listNodes.add(newNode);
			addedEdge = 0;
			float progress = (((float) i + 1) / (float) t) * 100;
			System.out.println(progress + "% completado");
		}
		Utilities.exportCSV(listNodes);
		Node.ID_COUNT = 0; // Reiniciamos el contador de nodos para las
							// siguientes ejecuciones
	}

	public List<Node> getListNodes() {
		return listNodes;
	}
}