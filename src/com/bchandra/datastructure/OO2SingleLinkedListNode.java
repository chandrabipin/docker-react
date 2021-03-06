package com.bchandra.datastructure;

public class OO2SingleLinkedListNode {

	private OO2SingleLinkedListNode next = null;
	private Integer value = null;
	/**
	 * @return the next
	 */
	public OO2SingleLinkedListNode getNext() {
		return next;
	}
	/**
	 * @param next the next to set
	 */
	public void setNext(OO2SingleLinkedListNode next) {
		this.next = next;
	}
	/**
	 * @return the value
	 */
	public Integer getValue() {
		return value;
	}
	/**
	 * @param value the value to set
	 */
	public void setValue(Integer value) {
		this.value = value;
	}
}
