package main

import (
	"encoding/json"
	"fmt"
	"strconv"
)

func main() {

	// result := Sum(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
	// fmt.Println(result)

	// result2 := Sum2(1, 2, 3, 4, 5, "6", "7", 9.99)
	// fmt.Println(result2)

	// strSlc := []interface{}{10, 20, "60"}
	// result2 := Sum2(strSlc...)
	// fmt.Println(result2)

	stooges := [...]string{"Tanvir", "Hossain", "Fahim"}

	bs, err := json.Marshal(stooges)
	if err != nil {
		fmt.Println(err.Error())
	}

	fmt.Println(bs)
	fmt.Println(string(bs))

	var students interface{}

	json.Unmarshal(bs, &students)

	fmt.Println(students)

	// stooges2 := []string{"Tanvir", "Hossain", "Fahim"}

	// fmt.Printf("%T\n", stooges)
	// fmt.Printf("%T\n", stooges2)

	// reftype := reflect.TypeOf(stooges).Kind().String()
	// reftype2 := reflect.TypeOf(stooges2).Kind().String()
	// fmt.Println(reftype)
	// fmt.Println(reftype2)

	// for i, slc := range strSlc {

	// 	res := Sum2(slc)
	// 	fmt.Println(i, res)
	// }

}

func Sum2(nums ...interface{}) int64 {
	var res int64
	for _, n := range nums {
		// res += n
		strval := fmt.Sprintf(`%v`, n)
		nint, _ := strconv.ParseInt(strval, 10, 64)
		res += nint
	}
	return res
}

// Variadic Parameter
// Variadic functions can be called with any number of trailing arguments

func Sum(nums ...int) int {
	res := 0
	for _, n := range nums {
		res += n
	}
	return res
}
