package main

import (
	"regexp"
)

/** https://www.codewars.com/kata/515de9ae9dcfc28eb6000001/train/go */

func main() {
}

func Solution(str string) []string {
	if len(str)%2 != 0 {
		str += "_"
	}

	var res []string
	for i := 0; i < len(str); i += 2 {
		res = append(res, str[i:i+2])
	}

	return res
}

func Solution1(str string) []string {
	return regexp.MustCompile(`[\w|_]{2}`).FindAllString(str+"_", -1)
}
