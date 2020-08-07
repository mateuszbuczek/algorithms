package main

import (
	"reflect"
	"sort"
)

/** https://www.codewars.com/kata/550498447451fbbd7600041c/train/go */

func main() {

}

func Comp(a []int, b []int) bool {
	if a == nil || b == nil {
		return false
	}

	c, d := a[:], b[:]
	for i, n := range a {
		c[i] = n * n
	}

	sort.Ints(c)
	sort.Ints(d)
	return reflect.DeepEqual(c, d)
}
