package main

/** https://www.codewars.com/kata/55a29405bc7d2efaff00007c/train/go */

/**
* u1 = (1 / 1!) * (1!)
* u2 = (1 / 2!) * (1! + 2!)
* u3 = (1 / 3!) * (1! + 2! + 3!)
 */
func main() {

}

func Going(n int) float64 {
	f, r := 1.0, 1.0
	for i := n; i > 1; i-- {
		f /= float64(i)
		r += f
	}
	return float64(int(r*1e6)) / 1e6
}
