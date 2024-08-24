const mongoose = require("mongoose");
const DataShema = mongoose.Schema(
  {
    ProductName: { type: String },
    ProductCode: { type: String },
    Img: { type: String },
    UnitPrice: { type: String },
    Qty: { type: String },
    TotalPrice: { type: String },
    CreatedDate: { type: Date, default: Date.now() },
  },
  { versionKey: false }
);
const productModel = mongoose.model("products", DataShema);
module.exports = productModel;
