package main

import "fmt"

func main() {
	fmt.Println(twoStrings("qwert", "asdfg"))
	fmt.Println(twoStrings("qwertz", "asdfgz"))
	fmt.Println(twoStrings("qwertzaa", "asdfgz"))
}

// Complete the twoStrings function below.
func twoStrings(s1 string, s2 string) string {
	s1Set := NewSet()
	s2Set := NewSet()

	for i := 0; i < len(s1); i++ {
		s1Set.Add(string(s1[i]))
	}

	for i := 0; i < len(s2); i++ {
		s2Set.Add(string(s2[i]))
	}

	s1Arr := *s1Set.ToArray()
	s2Arr := *s2Set.ToArray()
	for i := 0; i < len(s1Arr); i++ {
		for j := 0; j < len(s2Arr); j++ {
			if s1Arr[i] == s2Arr[j] {
				return "YES"
			}
		}
	}

	return "NO"
}
