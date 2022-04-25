package domain;

import java.util.ArrayList;

public class BinaryTree<E> {
	private E data;
	private BinaryTree<E> leftTree, rightTree;
	public static ArrayList<String>  leaves  ;

	public BinaryTree(E data){
		this(data,null,null);
	}
	
	public BinaryTree(E data, BinaryTree<E> leftTree, BinaryTree<E> rightTree){
		if (data == null) {
			throw new IllegalArgumentException();
		}
		this.data= data;
		this.leftTree = leftTree;
		this.rightTree= rightTree;
		leaves = new ArrayList<>();
	}
	
	public void printPreorder(){
			System.out.print(this.data + " ");
			if (this.leftTree != null) this.leftTree.printPreorder();
			if (this.rightTree != null) this.rightTree.printPreorder();
	}
	public void printInOrder()
	{
		if(this.leftTree != null)
		{
			this.leftTree.printInOrder();
		}
		System.out.print(this.data + " ");
		if(this.rightTree != null)
			this.rightTree.printInOrder();
	}
	public void printPostOrder()
	{
		if(this.leftTree!= null)
			this.leftTree.printPostOrder();
		if(this.rightTree != null)
			this.rightTree.printPostOrder();
		System.out.print(data + " ");
	}
	public int aantalKnopen()
	{
		if(this.rightTree != null && this.leftTree != null)
		{
			return 1+ this.leftTree.aantalKnopen() + this.rightTree.aantalKnopen();
		}
		else if (this.leftTree != null)
			return 1+ this.leftTree.aantalKnopen();
		else if(this.rightTree != null )
			return 1 + this.rightTree.aantalKnopen();
		else
			return 1;
	}
	public int diepte()
	{
		if(this.leftTree != null && this.rightTree != null)
			return 1+ Math.max(this.leftTree.diepte(), this.rightTree.diepte());
		else if(this.leftTree != null )
			return 1 + this.leftTree.diepte();
		else if (this.rightTree != null)
			return 1+this.rightTree.diepte();
		else
			return 0;
	}
	public boolean isLeaf()
	{
		return this.leftTree == null && this.rightTree == null;
	}
	public int aantalLeaves()

	{
		if(this.aantalKnopen() == 1)
			return 1;
		else if (this.leftTree != null && this.rightTree != null)
			return this.leftTree.aantalLeaves() + this.rightTree.aantalLeaves();
		else if (this.leftTree != null )
			return this.leftTree.aantalLeaves();
		else
			return this.rightTree.aantalLeaves();
	}
	public void getLeaves()
	{
		if(this.rightTree == null && this.leftTree == null)
		{System.out.println(this.data);
			leaves.add((String) this.data);}
		else
			if(this.leftTree != null && this.rightTree != null) {
				this.leftTree.getLeaves();
				this.rightTree.getLeaves();
			}
			else
			{
				if(this.leftTree != null )
					this.leftTree.getLeaves();
				else
					this.rightTree.getLeaves();
			}
	}

	public E getData() {
		return data;
	}

	public BinaryTree<E> getLeftTree() {
		return leftTree;
	}

	public BinaryTree<E> getRightTree() {
		return rightTree;
	}
	public boolean equals(BinaryTree<String>node)
	{
		return this.data.equals(node.getData())&& this.leftTree == node.getLeftTree() && this.rightTree == node.rightTree;
	}

	public boolean isSame(BinaryTree<String>node)
	{

		if(node == null)
			return false;
		if(this.getData().equals(node.getData()))
			return true;
		if(this.leftTree!= null) {
			boolean node1 = this.leftTree.isSame(node);
			if (node1)
				return true;
		}
		if(this.rightTree!=null) {
			boolean node2 = this.rightTree.isSame(node);
			if (node2)
				return true;
		}

			return false;

	}
}
