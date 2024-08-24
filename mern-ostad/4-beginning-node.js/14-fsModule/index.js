//!m5-23 fs File Exists Async
var fs = require("fs");
var http = require("http");

var server = http.createServer(function (req, res) {
  if (req.url == "/") {
    //! exists delete
    fs.exists("test.txt", function (result) {
      if (result) {
        res.end("True");
      } else {
        res.end("False");
      }
    });

    //! existsSync delete
    // var result = fs.existsSync("test.txt");
    // if (result) {
    //   res.end("True");
    // } else {
    //   res.end("False");
    // }

    //! sync delete
    // var err = fs.unlinkSync("test.txt");
    // if (err) {
    //   res.writeHead(200, { "Content-Type": "text/html" });
    //   res.write("File delete failed");
    //   res.end();
    // } else {
    //   res.writeHead(200, { "Content-Type": "text/html" });
    //   res.write("File delete succeeded");
    //   res.end();
    // }

    //! async delete
    // fs.unlink("test.txt", function (err) {
    //   if (err) {
    //     res.writeHead(200, { "Content-Type": "text/html" });
    //     res.write("File delete failed");
    //     res.end();
    //   } else {
    //     res.writeHead(200, { "Content-Type": "text/html" });
    //     res.write("File delete succeeded");
    //     res.end();
    //   }
    // });

    //! sync renameFile
    // var err = fs.renameSync("demoNew.txt", "demoNew2.txt");
    // if (err) {
    //   res.writeHead(200, { "Content-Type": "text/html" });
    //   res.write("File rename failed");
    //   res.end();
    // } else {
    //   res.writeHead(200, { "Content-Type": "text/html" });
    //   res.write("File rename succeeded");
    //   res.end();
    // }

    //! async renameFile
    // fs.rename("demo.txt", "demoNew.txt", function (err) {
    //   if (err) {
    //     res.writeHead(200, { "Content-Type": "text/html" });
    //     res.write("File rename failed");
    //     res.end();
    //   } else {
    //     res.writeHead(200, { "Content-Type": "text/html" });
    //     res.write("File rename succeeded");
    //     res.end();
    //   }
    // });

    //! sync writeFile
    // var error = fs.writeFileSync("demo.txt", "Hello bro");
    // if (error) {
    //   res.writeHead(200, { "Content-Type": "text/html" });
    //   res.write("File write failed");
    //   res.end();
    // } else {
    //   res.writeHead(200, { "Content-Type": "text/html" });
    //   res.write("File write succeeded");
    //   res.end();
    // }

    //! async writeFile
    // fs.writeFile("demo.txt", "Hello World", function (err) {
    //   if (err) {
    //     res.writeHead(200, { "Content-Type": "text/html" });
    //     res.write("File write failed: " + err.message);
    //     res.end();
    //   } else {
    //     res.writeHead(200, { "Content-Type": "text/html" });
    //     res.write("File write succeeded");
    //     res.end();
    //   }
    // });

    //! sync readFile
    // var data = fs.readFileSync("Home.html");
    // res.writeHead(200, { "Content-Type": "text/html" });
    // res.write(data);
    // res.end();
    //! async readFile
    // fs.readFile("Home.html", function (err, data) {
    //   if (data) {
    //     res.writeHead(200, { "Content-Type": "text/html" });
    //     res.write(data);
    //     res.end();
    //   } else {
    //     res.send(err);
    //   }
    // });
  }
});

server.listen(4040);
console.log("Server listening on port 4040");
