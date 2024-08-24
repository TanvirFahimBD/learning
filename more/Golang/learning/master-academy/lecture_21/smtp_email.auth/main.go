package main

import (
	"encoding/base64"
	"fmt"
)

func main() {

	fmt.Println(base64Encode("AnyTextYouWantBase64Encoded"))

}

func base64Encode(strtxt string) (encodedStr string) {

	//
	encodedStr = base64.StdEncoding.EncodeToString([]byte(strtxt))
	return
}

func gmailPlainTextAuthCode() {

	//\x00smbiz.temp@gmail.com\x00Temp@2020
	resp := []byte("\x00" + "fahim.tanvir.0007@gmail.com" + "\x00" + "4K2fBntA2D")
	fmt.Println(string(resp), resp)

	sEnc := base64.StdEncoding.EncodeToString([]byte(resp))
	fmt.Println(sEnc)

}
