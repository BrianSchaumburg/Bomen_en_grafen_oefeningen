package domain;

public class BinarySearchTree<E extends Comparable<E>> extends BinaryTree<E> {

	public BinarySearchTree(E data, BinarySearchTree<E> leftTree, BinarySearchTree<E> rightTree) {
		super(data, leftTree, rightTree);
	}
			
	public BinarySearchTree(E data) {
		super(data);
	}

	public boolean lookup(E data) {

		if (this.data.compareTo(data) == 0)
			return true;
		else {
			if (data.compareTo(this.data) < 0) {
				if (this.leftTree == null)
					return false;
				else
					return this.leftTree.lookup(data);
			} else {
				if (this.rightTree == null)
					return false;
				else
					return this.rightTree.lookup(data);
			}

		}
	}

	public boolean addNode(E data) {
		if(this.data.compareTo(data) == 0 )
			return false;
		else
		{
			if(data.compareTo(this.data)<0)
			{
				if(this.leftTree == null )
				{	this.leftTree = new BinarySearchTree<>(data,null,null);
					return true;
				}
				else
				{
					this.leftTree.addNode(data);
				}

			}
			else
			{
				if(this.rightTree == null)
				{
					this.rightTree = new BinarySearchTree<>(data,null,null);
					return true;
				}
				else
					this.rightTree.addNode(data);

			}

		}
		return false;
	}
	public boolean isLeaf()
	{
		return this.leftTree == null && this.rightTree == null;
	}
	public boolean removeNode(E data){
		if(this.data.compareTo(data) == 0 )
		{
			if(this.isLeaf())
			{
				this.data = null;
					return true;

			}
			else
			{
				if(this.leftTree != null)
				{
					E gl = this.leftTree.searchGreatest();
					this.data = gl ;
					this.leftTree.removeNode(gl);
					return true;
				}
				else
				{
					E kr = this.rightTree.searchSmallest();
					this.data = kr;
					this.rightTree.removeNode(kr);
					return true;
				}
			}
		}
		else
		{
			if(data.compareTo(this.data) <  0 )
			{
				if(this.leftTree == null )
					return false;
				else return this.leftTree.removeNode(data);
			}
			else
			{
				if(this.rightTree == null)
					return false;
				else this.rightTree.removeNode(data);
			}
		}
		return false;
	}

	public E searchSmallest(){
		if(this.leftTree == null)
			return this.data;
		else
			return this.leftTree.searchSmallest();
	}

	public E searchGreatest(){
		if(this.rightTree == null)
			return this.data;
		else
		{
			return this.rightTree.searchGreatest();
		}
	}
}


