package main

import "fmt"

//! Interfaec
type Email interface {
	Write(string, string, string)
	Send()
	Read()
}

type Test struct {
	To      string
	From    string
	Subject string
	Message string
}

func (t Test) Write(to string, from string, subject string) {
	fmt.Println(to, from, subject)
}

func (t Test) Send() string {
	// fmt.Println(t.To, "email sent")
	return t.To
}

func (t Test) Read() {
	fmt.Println(t.From, "received from")
}

//! Struct
type Doctor struct {
	Name      string
	Education string
	Age       int
	Salary    float32
}

//! Method - Multiple Method can same name but function have to be different name. It is used on specific task & works on specific data or type work
func (d Doctor) Speak() {
	fmt.Println(d.Name, "can speak")
}

func (d Doctor) getName() string {
	return d.Name
}

func (d Doctor) getSalaryInfo() float32 {
	return d.Salary
}

func main() {
	// var d = Doctor{"Rahim", "MBBS", 27, 63500.5}
	// var d = Doctor{Name: "Rahim", Education: "MBBS", Age: 27, Salary: 63500.5}

	// var d Doctor
	// d.Name = "Rahim"
	// d.Education = "MBBS"
	// d.Age = 27
	// d.Salary = 63500.5

	// fmt.Println(d.getName())
	// fmt.Println(d.getSalaryInfo())

	// fmt.Println(d.Name, d.Education, d.Age, d.Salary)
	// d.Speak()

	// var e Email
	// fmt.Println(e)

	var tst Test
	tst.To = "tanvirfahim6939@gmail.com"
	tst.From = "fahimtanvir9834@gmail.com"
	tst.Subject = "Test Email"
	tst.Message = "Hello Peoples"

	tst.Write(tst.To, tst.From, tst.Subject)
}
