package main

import "strings"

//The goal of this exercise is to convert a string to a new string where each character in the new string is "("
//if that character appears only once in the original string, or ")" if that character appears more than once in the original string.
//Ignore capitalization when determining if a character is a duplicate.

func main() {

}

func DuplicateEncode(word string) (r string) {
	word = strings.ToLower(word)

	t := map[rune]int{}

	for _, c := range word {
		t[c]++
	}

	for _, c := range word {
		if t[c] == 1 {
			r += "("
		} else {
			r += ")"
		}
	}

	return
}
