package main

/** https://www.hackerrank.com/challenges/sock-merchant/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=warmup */

func main() {

}

// Complete the sockMerchant function below.
func sockMerchant(n int32, ar []int32) int32 {
	countMap := make(map[int32]int)

	for _, v := range ar {
		countMap[v]++
	}

	var pairs int32
	for _, v := range countMap {
		pairs += int32(v / 2)
	}

	return pairs
}
