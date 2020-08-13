package main

import (
	"fmt"
	"strconv"
)

// https://www.codewars.com/kata/564057bc348c7200bd0000ff/train/go

func main() {
	fmt.Println(Thirt(8529))
	fmt.Println(Thirt(85299258))
	fmt.Println(Thirt(5634))

}

func Thirt(n int) int {
	result := 0

	inputString := strconv.Itoa(n)
	for i := 0; i < len(inputString); i++ {
		val := inputString[len(inputString)-1-i]
		valInt, _ := strconv.Atoi(string(val))
		result += valInt * getPatternValue(i)
	}

	if result == n {
		return result
	} else {
		return Thirt(result)
	}
}

func getPatternValue(i int) int {
	pattern := []int{1, 10, 9, 12, 3, 4}

	return pattern[i%len(pattern)]
}
