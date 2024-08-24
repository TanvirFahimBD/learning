package main

import "fmt"

//* Method-1, Function with return type
// func add(x int, y int) int {
// 	r := x + y
// 	return r
// }

//* Method-2
// func add(x, y int) int {
// 	r := x + y
// 	return r
// }

//* Method-3, Named return value
// func add(x, y int) (r int) {
// 	r = x + y
// 	return r
// }

//* Method-4
// func add(x, y int) (r int) {
// 	r = x + y
// 	return
// }

//* Multiple return value
// func rectangle(l int, b int) (area int, parameter int) {
// 	parameter = 2 * (l + b)
// 	area = l * b
// 	return
// }

//* Function passing address
// func update(a *int, t *string) {
// 	*a = *a + 5
// 	*t = *t + " Fahim"
// 	return
// }

func main() {
	// x := add(10, 30)
	// fmt.Println(x)

	// a, p := rectangle(10, 10)
	// fmt.Println(a, p)

	// a := 10
	// t := "Tanvir"
	// update(&a, &t)
	// fmt.Println(a, t)

	//* Anonymous Function
	a := func(x, y int) (r int) {
		r = x * y
		return
	}(10, 10)
	// fmt.Println(a(10, 10))
	fmt.Println(a)
}
