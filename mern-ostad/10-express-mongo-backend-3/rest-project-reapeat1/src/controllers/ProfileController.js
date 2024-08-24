const ProfileModel = require("../models/ProfileModel");

exports.SelectProfile = (req, res) => {
  let UserName = req.headers.username;
  ProfileModel.find({ UserName: UserName })
    .then((data) => {
      res.status(200).json({ status: "success", data: data });
    })
    .catch((err) => {
      res.status(400).json({ status: "fail", data: err });
    });
};

exports.UpdateProfile = (req, res) => {
  let UserName = req.headers.username;
  let reqBody = req.body;
  ProfileModel.updateOne({ UserName: UserName }, reqBody)
    .then((data) => {
      res.status(200).json({ status: "success", data: data });
    })
    .catch((err) => {
      res.status(400).json({ status: "fail", data: err });
    });
};
