package ui;

import domain.BinaryTree;

public class BinaryTreeDriver {

	public static void main(String[] args) {
		BinaryTree<String> nodeD = new BinaryTree<>("D");
		BinaryTree<String> nodeF = new BinaryTree<>("F");
		BinaryTree<String> nodeB = new BinaryTree<>("B");
		BinaryTree<String> nodeH = new BinaryTree<>("H");

		// knoop A heeft links D en rechts F
		BinaryTree<String> nodeA = new BinaryTree<>("A",nodeD, nodeF);
		// knoop E heeft links H
		BinaryTree<String> nodeE = new BinaryTree<>("E",nodeH,null);
		// knoop G heeft links E en rechts B
		BinaryTree<String> nodeG = new BinaryTree<>("G",nodeE, nodeB);
		BinaryTree<String> nodeZ = new BinaryTree<>("G",nodeE, nodeB);
		// boom heeft root C en heeft links A en rechts G
		BinaryTree<String> boom = new BinaryTree<>("C",nodeA, nodeG);
		boom.printPreorder();
		System.out.println("\n");
		boom.printInOrder();
		System.out.println("\n");
		boom.printPostOrder();
		System.out.println("\n");

		System.out.println("Het aantal knopen is: " + boom.aantalKnopen());
		System.out.println("\nDe diepte is: "+ boom.diepte());
		System.out.println("\nHet aantal leaves is: "+ boom.aantalLeaves());
		boom.getLeaves();
		System.out.println(boom.leaves.size());

		System.out.println(boom.isSame(nodeH));
		System.out.println(boom.isSame(nodeD));
		BinaryTree<String> nodeQ = new BinaryTree<>("Q",null, null);

		System.out.println(boom.isSame(nodeF));
		System.out.println(boom.isSame(nodeQ));

	}

}
