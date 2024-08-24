const jwt = require("jsonwebtoken");

module.exports = (req, res, next) => {
  let Token = req.headers["token-key"];
  jwt.verify(Token, "SecretKey123456789", (err, decoded) => {
    if (err) {
      return res.status(401).json({ message: "Invalid Token" });
    }
    //get username from decoded token & add with the request header
    req.headers.userName = decoded["data"]["UserName"];
    next();
  });
};
