let jwt = require("jsonwebtoken");

module.exports = (req, res, next) => {
  let token = req.headers["token-key"];
  jwt.verify(token, "secretkey", (err, decoded) => {
    if (err) {
      res.status(401).send(err);
    } else {
      next();
    }
  });
};
