package main

/** https://www.codewars.com/kata/589273272fab865136000108/train/go */

func main() {

}

const (
	w = "white"
	b = "black"
)

func BlackOrWhiteKey(key int) string {
	keys := []string{w, b, w, w, b, w, b, w, w, b, w, b}
	return keys[((key-1)%88)%len(keys)]
}
