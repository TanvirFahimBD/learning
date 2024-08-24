package main

import (
	"fmt"
	"html/template"
	"net/http"
	"os"

	_ "github.com/go-sql-driver/mysql"
	"github.com/mateors/mcb"
)

// var db *sql.DB
var db *mcb.DB
var err error

func init() {

	db = mcb.Connect("localhost", "Administrator", "4KmVq31dImcE")

	res, err := db.Ping()
	if err != nil {

		fmt.Println(res)
		os.Exit(1)
	}
	fmt.Println(res, err)

}

func main() {

	http.HandleFunc("/", home)
	http.HandleFunc("/request", request)
	// http.HandleFunc("/requestc", requestc)
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

//Like mysql table schema
type RequesetTable struct {
	ID      string `json:"aid"`
	Name    string `json:"name"`
	Email   string `json:"email"`
	Company string `json:"company"`
	Type    string `json:"type"`
	Status  int    `json:"status"`
}

func request(w http.ResponseWriter, r *http.Request) {

	//r.ParseForm()
	//! Method - 1
	// name := r.FormValue("name")
	// company := r.FormValue("company")
	// email := r.FormValue("email")

	// fmt.Println(name, company, email)
	// fmt.Fprintf(w, `received %s %s %s`, name, company, email) //response

	//! Method - 2 & most useful
	r.ParseForm()

	for key, val := range r.Form {

		fmt.Println(key, val)
	}

	var reqTable RequesetTable

	r.Form.Add("bucket", "tanvir_fahim")
	r.Form.Add("aid", "request::6") // ! We will update Here
	r.Form.Add("type", "request")
	r.Form.Add("status", "1")
	pRes := db.Insert(r.Form, &reqTable)
	fmt.Println(pRes.Status, pRes.Errors)

	fmt.Fprintf(w, `OK`)

}

// couchbase send data with response prallely page refresh
