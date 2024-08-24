package main

import "fmt"

func main() {

	// var students [3]string
	// students[0] = "Tanvir"
	// students[1] = "Hossain"
	// students[2] = "Fahim"

	// fmt.Println(students)
	// fmt.Println(len(students))
	// fmt.Println(students[0])
	// fmt.Println(students[1])
	// fmt.Println(students[2])

	students := [...]string{"Tanvir", "Hossain", "Fahim", "Munna"}
	fmt.Println(students)
	fmt.Println(len(students))
	fmt.Println(students[0])
	fmt.Println(students[1])
	fmt.Println(students[2])
	fmt.Println(students[3])

}

// Details: https://docs.google.com/document/d/1v6unnGRQGs-FyqqwwL9Z-RuQevRkwx9VCTWZjRS9Hto/edit?usp=sharing
