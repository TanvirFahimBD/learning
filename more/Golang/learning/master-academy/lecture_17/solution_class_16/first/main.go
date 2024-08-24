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

	// Have to go --> http://localhost:8888/I.jpeg

	// We are going --> http://localhost:8888/img/I.jpeg

	// D:\GO_PROJECT\src\go_world\lecture_16\solution_class_16\first\img

	// http.Handle("/", http.FileServer(http.Dir("./img"))) //Current1 Directory

	// http://localhost:8888/resources/I.jpeg

	http.Handle("/resources/", http.StripPrefix("/resources/", http.FileServer(http.Dir("img")))) //Current1 Directory

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

	w.Header().Set("Content-Type", " text/html; charset=UTF-8")

	fmt.Fprintf(w, "Welcome to CodingBootCamp contact page <img src=\"I.jpeg\" />")
}
