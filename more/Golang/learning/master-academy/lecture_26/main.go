package main

import (
	"fmt"

	"golang.org/x/crypto/bcrypt"
)

func main() {

	//! Password Encrypt
	// bcrypt.CompareHashAndPassword()
	bs, err := bcrypt.GenerateFromPassword([]byte("test"), 14)
	if err != nil {
		fmt.Println(err.Error())
	}

	fmt.Println(string(bs))

	//! Password compare
	err = bcrypt.CompareHashAndPassword(bs, []byte("test1232"))
	fmt.Println(err)

}
