package main

import (
	"fmt"
	"strconv"
	"strings"
)

func main() {

}

func IsValidCoordinates(coordinates string) bool {
	if strings.Contains(coordinates, "e") {
		return false
	}
	split := strings.Split(coordinates, ", ")
	if len(split) != 2 {
		return false
	}
	if lat, err := strconv.ParseFloat(split[0], 64); err != nil || lat < -90 || lat > 90 {
		return false
	}
	if long, err := strconv.ParseFloat(split[1], 64); err != nil || long < -180 || long > 180 {
		return false
	}
	fmt.Println(coordinates, true)
	return true
}
