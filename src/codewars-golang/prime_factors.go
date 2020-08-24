package main

import "fmt"

/** https://www.codewars.com/kata/54d512e62a5e54c96200019e/train/go */

func main() {

}

func PrimeFactors(n int) (ret string) {
	for i, m := 2, 0; n > 0; {
		if n%i != 0 {
			if m == 1 {
				ret += fmt.Sprintf("(%d)", i)
			} else if m > 1 {
				ret += fmt.Sprintf("(%d**%d)", i, m)
			}
			if n == 1 {
				break
			}
			i, m = i+1, 0
			continue
		}
		n, m = n/i, m+1
	}
	return ret
}
