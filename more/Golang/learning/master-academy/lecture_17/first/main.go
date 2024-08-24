package main

import (
	"fmt"
	"net/http"
)

// type Handler interface {
// 	ServeHTTP(ResponseWriter, *Request)
// }

func main() {

	//var name Datatype
	// var x string
	// var handler func(ResponseWriter, *Request)

	http.HandleFunc("/", home)
	http.HandleFunc("/about", about)
	http.HandleFunc("/contact", contact)
	http.ListenAndServe(":8888", nil)
}

func home(w http.ResponseWriter, r *http.Request) {

	fmt.Fprintf(w, `Welcome to CodingBootCamp golang Homepage`)
}

func about(w http.ResponseWriter, r *http.Request) {

	fmt.Fprintf(w, `Welcome to CodingBootCamp about page`)
}

func contact(w http.ResponseWriter, r *http.Request) {

	fmt.Fprintf(w, `Welcome to CodingBootCamp contact page`)
}

//https://docs.google.com/document/d/14sMNVsS9PcZN6PpMsl5iK7JmALVGT7C-JS2KZXHe_vU/edit?usp=sharing
//net/http package
