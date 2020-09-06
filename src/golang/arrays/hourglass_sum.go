package main

import "fmt"

/** https://www.hackerrank.com/challenges/2d-array/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=arrays*/

func main() {
	sum := hourglassSum([][]int32{
		{-1, -1, 0, -9, -2, -2},
		{-2, -1, -6, -8, -2, -5},
		{-1, -1, -1, -2, -3, -4},
		{-1, -9, -2, -4, -4, -5},
		{-7, -3, -3, -2, -9, -9},
		{-1, -3, -1, -2, -4, -5},
	})

	fmt.Println(sum)
}

// Complete the hourglassSum function below.
func hourglassSum(arr [][]int32) int32 {
	hourglassSize := 3
	x := len(arr[0])
	y := len(arr)

	result := int32(-99999)
	for i := 0; i < y-(hourglassSize-1); i++ {
		for j := 0; j < x-(hourglassSize-1); j++ {
			sum := calculateHourglassSum(i, j, &arr)
			if sum > result {
				result = sum
			}
		}
	}
	return result
}

func calculateHourglassSum(x int, y int, arr *[][]int32) int32 {
	return (*arr)[y][x] + (*arr)[y][x+1] + (*arr)[y][x+2] +
		(*arr)[y+1][x+1] +
		(*arr)[y+2][x] + (*arr)[y+2][x+1] + (*arr)[y+2][x+2]
}
