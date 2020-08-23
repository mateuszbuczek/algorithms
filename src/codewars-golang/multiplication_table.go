package main

import "fmt"

/** https://www.codewars.com/kata/534d2f5b5371ecf8d2000a08/train/go */

func main() {
	MultiplicationTable(3)
}

func MultiplicationTable(size int) [][]int {
	result := make([][]int, size)

	for i := 0; i < size; i++ {
		for j := 1; j < size+1; j++ {
			fmt.Println(result[i])
			result[i] = append(result[i], (i+1)*j)
		}
	}

	return result
}
