package main

import (
	"html/template"
	"net/http"
)

func main() {

	http.HandleFunc("/", home)
	http.HandleFunc("/features", features)
	http.HandleFunc("/docs", docs)
	http.Handle("/resources/", http.StripPrefix("/resources/", http.FileServer(http.Dir("assets"))))
	http.ListenAndServe(":8888", nil)
}

//tpl variable
var tpl *template.Template

//Function runs at start
func init() {
	tpl = template.Must(template.ParseGlob("source/*/*"))
}

//Function for serving homepage
func home(w http.ResponseWriter, r *http.Request) {
	tpl.ExecuteTemplate(w, "home.gohtml", nil)
}

func features(w http.ResponseWriter, r *http.Request) {

	tpl.ExecuteTemplate(w, "features.gohtml", nil)
}

func docs(w http.ResponseWriter, r *http.Request) {

	tpl.ExecuteTemplate(w, "docs.gohtml", nil)
}
