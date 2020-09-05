package main

import "fmt"

/** https://www.hackerrank.com/challenges/ctci-array-left-rotation/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=arrays */

func main() {
	fmt.Println(rotLeft([]int32{1, 2, 3, 4, 5}, 2))
}

// Complete the rotLeft function below.
func rotLeft(a []int32, d int32) []int32 {
	if int(d)%len(a) == 0 {
		return a
	} else {
		rotation := int(d) % len(a)
		return append(a[rotation:], a[0:rotation]...)
	}
}
