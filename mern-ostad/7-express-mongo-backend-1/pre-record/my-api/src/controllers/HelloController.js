exports.HelloGet = (req, res) => {
  res.status(200).json({ status: "success", message: "Hello from get server" });
};

exports.HelloPost = (req, res) => {
  res
    .status(200)
    .json({ status: "success", message: "Hello from post server" });
};
