package main

import (
	"database/sql"
	"fmt"
	"html/template"
	"net/http"

	_ "github.com/go-sql-driver/mysql"
)

var db *sql.DB
var err error

func init() {

	// Open up our database connection.
	// I've set up a database on my local machine using phpmyadmin.
	// The database is called testDb
	db, err = sql.Open("mysql", "root:vFgK12B2h1@tcp(127.0.0.1:3306)/hosting_db")

	// if there is an error opening the connection, handle it
	if err != nil {
		panic(err.Error())
	}

	// defer the close till after the main function has finished
	// executing
	// defer db.Close()

	fmt.Println("db connection successful")
}

func main() {

	http.HandleFunc("/", home)
	http.HandleFunc("/request", request)
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

func request(w http.ResponseWriter, r *http.Request) {

	//r.ParseForm()
	//! Method - 1
	name := r.FormValue("name")
	company := r.FormValue("company")
	email := r.FormValue("email")

	// fmt.Println(name, company, email)
	// fmt.Fprintf(w, `received %s %s %s`, name, company, email) //response

	//! Method - 2 & most useful
	// r.ParseForm()

	// for key, val := range r.Form {

	// 	fmt.Println(key, val)
	// }

	//! In MySQL --> ``= column, ''= value
	qs := "INSERT INTO `request` (`id`, `name`, `company`, `email`, `status`) VALUES (NULL, '%s', '%s', '%s', '1');"
	sql := fmt.Sprintf(qs, name, company, email)

	// fmt.Println(sql)
	insert, err := db.Query(sql)

	//If there is an error inserting, handle it
	if err != nil {
		panic(err.Error())
	}
	defer insert.Close()

	fmt.Fprintf(w, `OK`) //response

}

// Details: https://docs.google.com/document/d/14N-nOgHS5FmapGSCeYB8Nh7S0JDMIcBXK67iDpmcMTw/edit?usp=sharing
