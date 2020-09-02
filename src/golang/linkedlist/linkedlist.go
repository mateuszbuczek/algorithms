package main

import "fmt"

type Node struct {
	next *Node
	val  interface{}
}

type LinkedList struct {
	head *Node
	tail *Node
}

func (L *LinkedList) AddFirst(key interface{}) {
	newNode := &Node{
		next: L.head,
		val:  key,
	}
	L.head = newNode

	if L.tail == nil {
		L.tail = newNode
	}
}

func (L *LinkedList) AddLast(key interface{}) {
	newNode := &Node{
		next: nil,
		val:  key,
	}

	if L.head == nil {
		L.head = newNode
	}

	if L.tail != nil {
		L.tail.next = newNode
	}

	L.tail = newNode
}

func (L *LinkedList) Display() {
	curr := L.head
	for curr != nil {
		fmt.Printf("%+v ", curr.val)
		curr = curr.next
	}
}

func (L *LinkedList) Reverse() {
	var previous *Node
	current := L.head
	L.tail = L.head

	for current != nil {
		nextElement := current.next
		current.next = previous

		previous = current
		current = nextElement
	}
	L.head = previous
}
