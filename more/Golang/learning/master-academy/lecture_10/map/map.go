package main

import "fmt"

func main() {

	x := make(map[string]string)
	x["name"] = "Tanvir"
	x["age"] = "22"
	x["address"] = "Khulna"

	delete(x, "name")

	fmt.Println(x)
	fmt.Println(x["name"])
	fmt.Println(x["age"])
	fmt.Println(x["address"])

}
