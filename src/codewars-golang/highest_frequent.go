package main

/** https://www.codewars.com/kata/5420fc9bb5b2c7fd57000004/train/go */

func main() {

}

func HighestRank(nums []int) int {
	countMap, maxK, maxV := make(map[int]int), 0, 0

	for _, v := range nums {
		countMap[v]++
		if countMap[v] > maxV || (countMap[v] == maxV && v > maxK) {
			maxK = v
			maxV = countMap[v]
		}
	}

	return maxK
}
