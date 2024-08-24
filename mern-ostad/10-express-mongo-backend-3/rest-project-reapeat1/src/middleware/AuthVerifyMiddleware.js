const jwt = require("jsonwebtoken");
module.exports = (req, res, next) => {
  let token = req.headers["token"];
  jwt.verify(token, "SecretKey12345", function (err, decoded) {
    if (err) {
      res.status(401).json({ status: "unauthorized" });
    } else {
      //get username from decoded object and add to request header
      let username = decoded["data"]["UserName"];
      req.headers.username = username;
      next();
    }
  });
};
