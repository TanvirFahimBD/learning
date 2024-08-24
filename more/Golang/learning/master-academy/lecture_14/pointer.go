package main

import "fmt"

func update(a *int) {
	*a = *a + 10
}

func main() {
	var x int
	// var y *int

	//* Default value of pointer in nill
	// fmt.Println("x value is", x)
	// fmt.Println("x memory address is", &x)

	// fmt.Println("y value is", y)
	// fmt.Println("y memory address is", &y)

	x = 10
	// y = &x

	// fmt.Println("x value is", x)
	// fmt.Println("x memory address is", &x)
	// fmt.Println("y content values value is x value or y dereferencing value is ", *y)
	// fmt.Println("y value is x address", y)
	// fmt.Println("y memory address is", &y)

	update(&x)
	fmt.Println(x)
}

//https://docs.google.com/document/d/1qQHUjDKADYT6dScIJZ-eXEl4sQeTOIM6ZyzVBFgPbEY/edit?usp=sharing
