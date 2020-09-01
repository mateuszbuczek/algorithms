package main

import (
	"sort"
	"strings"
)

/** https://www.codewars.com/kata/550554fd08b86f84fe000a58/train/go */

func main() {

}

func appendIf(a []string, s string) []string {
	for _, el := range a {
		if el == s {
			return a
		}
	}
	return append(a, s)
}

func InArray(array1 []string, array2 []string) []string {
	var res = []string{}
	for _, s1 := range array1 {
		for _, s2 := range array2 {
			if strings.Contains(s2, s1) {
				res = appendIf(res, s1)
			}
		}
	}
	sort.Strings(res)
	return res
}
