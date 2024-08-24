let jwt = require("jsonwebtoken");

exports.CreateToken = (req, res) => {
  let payload = {
    exp: Math.floor(Date.now() / 1000) + 60 * 60,
    data: { Name: "Hossain", City: "Sylhet", admin: true },
  };
  let token = jwt.sign(payload, "secretkey");
  res.send(token);
};

exports.DecodeToken = (req, res) => {
  let token = req.headers["token-key"];
  jwt.verify(token, "secretkey", (err, decoded) => {
    if (err) {
      res.status(401).send(err);
    } else {
      res.status(200).send(decoded);
    }
  });
};
