//! url module
var http = require("http");
var URL = require("url");

var server = http.createServer(function (req, res) {
  var myURL = "http://x.com/blog.html?year=2015&month=july";
  var myURLObj = URL.parse(myURL, true);
  var myHostName = myURLObj.host;
  var myPathName = myURLObj.pathname;
  var mySearchName = myURLObj.search;
  res.writeHead(200, { "Content-Type": "text/html" });
  res.write(myHostName);
  res.write(myPathName);
  res.write(mySearchName);
  res.end();
});

server.listen("5050");
console.log("Server running on 5050");

//! http module
// var http = require("http");

// var server = http.createServer(function (req, res) {
//   if (req.url == "/") {
//     res.writeHead(200, { "Content-Type": "text/html" });
//     res.write("<h1>This is Home Page</h1>");
//     res.end();
//   } else if (req.url == "/about") {
//     res.writeHead(200, { "Content-Type": "text/html" });
//     res.write("<h1>This is About Page</h1>");
//     res.end();
//   } else if (req.url == "/contact") {
//     res.writeHead(200, { "Content-Type": "text/html" });
//     res.write("<h1>This is Contact Page</h1>");
//     res.end();
//   }
// });

// server.listen("5050");
// console.log("Server running on 5050");

//! server create
// var http = require("http");

// var server = http.createServer(function (req, res) {
//   res.end("hello world");
// });

// server.listen("5050");
// console.log("Server running on 5050");
