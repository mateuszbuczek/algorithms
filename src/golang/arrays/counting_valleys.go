package main

/** https://www.hackerrank.com/challenges/counting-valleys/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=warmup&h_r=next-challenge&h_v=zen */

const (
	up   = 85
	down = 68
)

func main() {
	countingValleys(5, "UDUDU")
}

func countingValleys(n int32, s string) int32 {
	currentLevel := int32(0)
	var result int32
	for _, v := range s {
		next := getNext(v)

		if currentLevel == 0 && next == -1 {
			result += 1
		}

		currentLevel += next
	}

	return result
}

func getNext(v int32) int32 {
	if v == up {
		return 1
	} else {
		return -1
	}
}
