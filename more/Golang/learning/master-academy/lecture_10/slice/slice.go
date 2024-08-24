package main

import (
	"fmt"
	"reflect"
)

func main() {

	// var students [3]string
	// students[0] = "Tanvir"
	// students[1] = "Hossain"
	// students[2] = "Fahim"
	// x := students[0:3]
	// fmt.Println(x)

	// x := make([]string, 5)
	// fmt.Println(x)

	var fruits []string
	fruits = append(fruits, "Mango", "Apple", "Banana", "Coconut")
	fmt.Println(len(fruits))
	fmt.Printf("%T\n", fruits)

	b := reflect.TypeOf(fruits).Kind().String()
	fmt.Println(b)

}
