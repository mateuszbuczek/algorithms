package main

import (
	"log"
	"regexp"
	"strings"
)

/** https://www.codewars.com/kata/517abf86da9663f1d2000003/train/go */

func main() {
	log.Println(ToCamelCase("the-stealth-warrior"))
	log.Println(ToCamelCase("The_Stealth_Warrior"))
}

func ToCamelCase(s string) string {
	words := regexp.MustCompile("-|_").Split(s, -1)

	for i, w := range words[1:] {
		words[i+1] = strings.Title(w)
	}

	return strings.Join(words, "")
}
