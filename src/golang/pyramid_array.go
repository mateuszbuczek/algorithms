package main

/** https://www.codewars.com/kata/515f51d438015969f7000013/train/go */

func main() {

}

func Pyramid(n int) [][]int {
	var row [][]int
	var cell []int

	for i := 0; i < n; i++ {
		cell = append(cell, 1)
		row = append(row, cell)
	}

	return row
}
