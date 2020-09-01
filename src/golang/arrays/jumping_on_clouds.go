package main

import "fmt"

/** https://www.hackerrank.com/challenges/jumping-on-the-clouds/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=warmup */

func main() {
	fmt.Println(jumpingOnClouds([]int32{0, 0, 1, 0, 0, 1, 0}))
}

func jumpingOnClouds(c []int32) int32 {
	currentIndex := 0
	jumps := 0

	for {
		if canMakeDoubleStep(currentIndex, c) {
			currentIndex += 2
		} else {
			currentIndex++
		}

		jumps++

		if currentIndex == len(c)-1 {
			return int32(jumps)
		}
	}
}

func canMakeDoubleStep(currentIndex int, c []int32) bool {
	if currentIndex+2 <= len(c)-1 && c[currentIndex+2] != 1 {
		return true
	} else {
		return false
	}
}
