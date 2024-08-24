package main

import (
	"fmt"
	"net/smtp"
)

func main() {

	//receiver
	send("tanvirfahim6939@gmail.com", "Bismillah email properly sending test from golang")
}

//Before sending email
//Make sure your 2-step security is turned on or enabled
//and app password is generated

func send(to, body string) bool {

	from := "fahim.tanvir.0007@gmail.com" //mailname
	pass := "xtlxwqfbbwgmswki"            //app specific password your AppPassword

	msg := "From: " + from + "\n" +
		"To: " + to + "\n" +
		"Subject: Hello Fahim\n\n" +
		body

	err := smtp.SendMail("smtp.gmail.com:587",
		smtp.PlainAuth("", from, pass, "smtp.gmail.com"),
		from, []string{to}, []byte(msg))

	if err != nil {
		fmt.Println("SMTP error", err.Error())
		return false
	}
	fmt.Println("email successfully sent")
	return true

}

// Successfully Done
