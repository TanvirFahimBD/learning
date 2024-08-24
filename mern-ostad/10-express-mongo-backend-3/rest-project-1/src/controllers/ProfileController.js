const ProfileModel = require("../models/ProfileModel");
const jwt = require("jsonwebtoken");

exports.HelloGet = (req, res) => {
  res.status(200).send({ status: "OK", message: "Server Hello" });
};

exports.CreateProfile = (req, res) => {
  const reqBody = req.body;
  ProfileModel.create(reqBody)
    .then((data) => res.status(200).send({ status: "success", data: data }))
    .catch((err) => res.status(401).send({ status: "fail", data: err }));
};

exports.UserLogin = (req, res) => {
  let UserName = req.body["UserName"];
  let Password = req.body["Password"];
  ProfileModel.find({ UserName: UserName, Password: Password })
    .then((data) => {
      if (data.length > 0) {
        let Payload = {
          exp: Math.floor(Date.now() / 1000) + 24 * 60 * 60,
          data: data[0],
        };
        let token = jwt.sign(Payload, "SecretKey123456789");
        res.status(200).send({ status: "success", token: token, data: data });
      } else {
        res.status(401).send({ status: "unauthorized" });
      }
    })
    .catch((err) => res.status(401).send({ status: "fail", data: err }));
};

exports.SelectProfile = (req, res) => {
  let UserName = req.headers.userName;
  ProfileModel.find({ UserName: UserName })
    .then((data) => {
      res.status(200).send({ status: "success", data: data });
    })
    .catch((err) => res.status(401).send({ status: "fail", data: err }));
};

exports.UpdateProfile = (req, res) => {
  let UserName = req.headers.userName;
  let reqBody = req.body;
  ProfileModel.updateOne({ UserName: UserName }, reqBody)
    .then((data) => {
      res.status(200).send({ status: "success", data: data });
    })
    .catch((err) => res.status(401).send({ status: "fail", data: err }));
};
