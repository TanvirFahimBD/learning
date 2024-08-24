package main

import (
	"fmt"
	"html/template"
	"net/http"
)

func main() {

	http.HandleFunc("/", home)
	http.HandleFunc("/features", features)
	http.HandleFunc("/docs", docs)
	http.Handle("/resources/", http.StripPrefix("/resources/", http.FileServer(http.Dir("./assets"))))
	http.ListenAndServe(":8888", nil)
}

func home(w http.ResponseWriter, r *http.Request) {

	ptmp, err := template.ParseFiles("template/base.gohtml")
	if err != nil {
		fmt.Println(err.Error())
	}

	ptmp.Execute(w, nil)
	// fmt.Fprintf(w, `Welcome`)
}

func features(w http.ResponseWriter, r *http.Request) {

	ptmp, err := template.ParseFiles("template/base.gohtml")
	if err != nil {
		fmt.Println(err.Error())
	}

	ptmp, err = ptmp.ParseFiles("wpage/features.gohtml")
	if err != nil {
		fmt.Println(err.Error())
	}

	ptmp.Execute(w, nil)
	// fmt.Fprintf(w, `Welcome`)
}

func docs(w http.ResponseWriter, r *http.Request) {

	ptmp, err := template.ParseFiles("template/base.gohtml")
	if err != nil {
		fmt.Println(err.Error())
	}

	ptmp, err = ptmp.ParseFiles("wpage/docs.gohtml")
	if err != nil {
		fmt.Println(err.Error())
	}

	ptmp.Execute(w, nil)
	// fmt.Fprintf(w, `Welcome`)
}

//https://docs.google.com/document/d/1GGZ5AQGfp_vnCuPIJhG32zSsyMVtoju-VLTpLi2T9eQ/edit?usp=sharing
//A web Application created using golang !
