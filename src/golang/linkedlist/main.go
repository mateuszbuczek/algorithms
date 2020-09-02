package main

import "fmt"

func main() {
	list := LinkedList{}
	list.AddLast(0)
	list.AddLast(4)
	list.AddFirst(1)
	list.AddFirst(1)
	list.Display()
	fmt.Println()
	list.Reverse()
	list.Display()
}
