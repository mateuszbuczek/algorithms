package main

func main() {
	repeatedString("abaca", 25)
}

func repeatedString(s string, n int64) int64 {
	full := n / int64(len(s))
	part := n % int64(len(s))

	result := full * count(s)
	result += count(s[:part])

	return result
}

func count(s string) int64 {
	var count int64
	for _, v := range s {
		if v == 97 {
			count++
		}
	}

	return count
}
