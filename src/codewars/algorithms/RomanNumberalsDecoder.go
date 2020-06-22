package main

var mapping map[rune]int = map[rune]int{'I': 1, 'V': 5, 'X': 10, 'L': 50, 'C': 100, 'D': 500, 'M': 1000}

func main() {
	Decode("XI")
}

func Decode(roman string) int {
	var intern []int
	var result int
	for _, r := range roman {
		intern = append(intern, mapping[r])
	}

	for i := 1; i < len(intern); i++ {
		if intern[i-1] >= intern[i] {
			result += intern[i-1]
		} else {
			result -= intern[i-1]
		}
	}

	result += intern[len(intern)-1]

	return result
}

/* https://www.codewars.com/kata/51b6249c4612257ac0000005/train/go */
