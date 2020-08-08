package main

/** https://www.codewars.com/kata/5277c8a221e209d3f6000b56/train/go */

func main() {

}

func ValidBraces(str string) bool {
	stack := make([]int, 0)
	for _, s := range str {
		v := int(s)

		// opener
		if v == 40 || v == 91 || v == 123 {
			stack = append(stack, v)
		} else if ln := len(stack); ln > 0 && v-stack[(ln-1)] <= 2 {
			stack = stack[:(ln - 1)]
		} else {
			return false
		}
	}

	return len(stack) == 0
}
