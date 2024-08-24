let jwt = require("jsonwebtoken");

exports.TokenIssue = (req, res) => {
  let payload = {
    exp: Math.floor(Date.now() / 1000) + 60 * 60,
    data: { Name: "Hossain", City: "Sylhet", admin: true },
  };
  let token = jwt.sign(payload, "secretkey");
  res.send(token);
};
