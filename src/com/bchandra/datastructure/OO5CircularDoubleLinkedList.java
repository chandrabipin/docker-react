package com.bchandra.datastructure;

public class OO5CircularDoubleLinkedList {

	public static void main(String[] args) {
		OO5CircularDoubleLinkedList linkedList = new OO5CircularDoubleLinkedList();
		linkedList.createFirstNodeInLinkedList(10);
		linkedList.travelCircularDoubleLinkedList();
		linkedList.insert(20, 0);
		linkedList.insert(30, 0);
		linkedList.insert(40, 0);
		System.out.println("-------------------------");
		linkedList.travelCircularDoubleLinkedList();
		linkedList.insert(50, linkedList.last);
		System.out.println("-------------------------");
		linkedList.travelCircularDoubleLinkedList();
		linkedList.insert(60, 2);
		System.out.println("-------------------------");
		linkedList.travelCircularDoubleLinkedList();
		System.out.println("-------------------------");
		linkedList.traverseReverseDoubleLinkedList();
		System.out.println("OO5CircularDoubleLinkedList.main(): LAST:"+linkedList.last);
		System.out.println("-----DELETE 1--------------------");
		linkedList.deleteNode(0);
		linkedList.travelCircularDoubleLinkedList();
		System.out.println("OO5CircularDoubleLinkedList.main(): LAST:"+linkedList.last);
		System.out.println("-----DELETE 2--------------------");
		linkedList.deleteNode(linkedList.last);
		linkedList.travelCircularDoubleLinkedList();
		System.out.println("OO5CircularDoubleLinkedList.main(): LAST:"+linkedList.last);
		System.out.println("-----DELETE 3--------------------");
		linkedList.deleteNode(2);
		linkedList.travelCircularDoubleLinkedList();
		System.out.println("OO5CircularDoubleLinkedList.main(): LAST:"+linkedList.last);
		System.out.println("-----DELETE 4--------------------");
		linkedList.deleteEntireLinkedList();
		linkedList.travelCircularDoubleLinkedList();
		System.out.println("----------LL Deleted---------------");

	}
	
	//Create a blank Double linked list
	OO5CircularDoubleLinkedListNode head = null;
	OO5CircularDoubleLinkedListNode tail = null;
	int last = -1;
	/**
	 * create a blank node and set its value.
	 * update its reference
	 */
	private void createFirstNodeInLinkedList(int nodeValue) {
		OO5CircularDoubleLinkedListNode node = new OO5CircularDoubleLinkedListNode();
		node.setValue(nodeValue);
		node.setNext(node);//null
		node.setPrevious(node);//null
		
		head = node;
		tail = node;
		last++;
	}
	/**
	 * 01 insert at starting pos
	 */

	/**
	 * 02 insert at last pos
	 */

	/**
	 * 03 insert in between pos
	 */
	private void insert(int nodeValue, int location) {
		if(location == 0) {
			OO5CircularDoubleLinkedListNode node1 = new OO5CircularDoubleLinkedListNode();
			node1.setValue(nodeValue);
			node1.setNext(head);
			node1.setPrevious(tail);

			head.setPrevious(node1);
			head = node1;
			tail.setNext(head);//new head
			last++;
		} else if (location == last) {
			OO5CircularDoubleLinkedListNode node2 = new OO5CircularDoubleLinkedListNode();
			node2.setValue(nodeValue);
			node2.setNext(head);
			node2.setPrevious(tail);

			tail.setNext(node2);
			tail = node2;	
			head.setPrevious(tail);//new tail
			last++;
		} else {
			OO5CircularDoubleLinkedListNode currNode = null;
			for(int i=0;i<location;i++) {//stop a node before
				if (i==0)
					currNode = head;
				else
					currNode = currNode.getNext();
			}
			OO5CircularDoubleLinkedListNode node3 = new OO5CircularDoubleLinkedListNode();
			node3.setValue(nodeValue);
			node3.setNext(currNode.getNext());
			node3.setPrevious(currNode);

			currNode.getNext().setPrevious(node3);
			currNode.setNext(node3);
			
			last++;
		}
	}
	
	private void travelCircularDoubleLinkedList() {
		if(head==null || tail ==null) {
			System.out.println("OO5CircularDoubleLinkedList.travelCircularDoubleLinkedList(): LL is empty.");
			return;
		}
		OO5CircularDoubleLinkedListNode currNode = head;//startingnode
		//System.out.println("OO5CircularDoubleLinkedList.travelDoubleLinkedList(): 1:" + currNode.getValue());
		while(currNode!=tail) {
			System.out.println("OO5CircularDoubleLinkedList.traverseDoubleLinkedList(): " + currNode.getValue());
			currNode = currNode.getNext();
			//if(currNode==null) break;
		}
		//Print if currNode=tail
		System.out.println("OO5CircularDoubleLinkedList.traverseDoubleLinkedList(): " + currNode.getValue());
		System.out.println("OO5CircularDoubleLinkedList.traverseDoubleLinkedList(): tail.next.value: " + currNode.getNext().getValue());
	}
	private void traverseReverseDoubleLinkedList() {
		OO5CircularDoubleLinkedListNode currNode = tail;//startingnode
		//System.out.println("OO5CircularDoubleLinkedList.travelDoubleLinkedList(): 1:" + currNode.getValue());
		while(currNode!=head) {
			System.out.println("OO5CircularDoubleLinkedList.traverseReverseDoubleLinkedList(): " + currNode.getValue());
			currNode = currNode.getPrevious();
			//if(currNode==null) break;
		}
		//Print if currNode=tail
		System.out.println("OO5CircularDoubleLinkedList.traverseReverseDoubleLinkedList(): " + currNode.getValue());
		System.out.println("OO5CircularDoubleLinkedList.traverseReverseDoubleLinkedList(): head.previous.value: " + currNode.getPrevious().getValue());
	}

	private void deleteNode(int location) {
		if(location == 0) {
			if(last==0) {//only one node
				head.setNext(null);
				head.setPrevious(null);;
				
				head = null;
				tail = null;
			} else {
				head.getNext().setPrevious(tail);
				head=head.getNext();
				tail.setNext(head);//new head
			}
			last--;
		} else if (location == last) {
			OO5CircularDoubleLinkedListNode currNode =null;
			for (int i = 0; i < last; i++) {//navigate to last but 2 i.e. last-2. Since then you will get next node of it which will be (last-1)the node.
				if (i==0)
					currNode = head;
				else 
					currNode = currNode.getNext();
			}
			currNode.setNext(head);
			tail = currNode;
			last--;
		} else {
			OO5CircularDoubleLinkedListNode currNode = null;
			for (int i = 0; i < location; i++) {//navigate to last but two
				if (i==0)
					currNode = head;
				else 
					currNode = currNode.getNext();
			}
			currNode.setNext(currNode.getNext().getNext());
			currNode.getNext().setPrevious(currNode);
			last--;
		}
	}
	
	private void deleteEntireLinkedList() {
		head = null;
		tail = null;
		last=-1;
	}
}
