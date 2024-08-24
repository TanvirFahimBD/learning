const mongoose = require("mongoose");

const DataSchema = mongoose.Schema(
  {
    Name: { type: String },
    Roll: {
      type: String,
      validate: {
        validator: function (value) {
          return /^01[3-9]\d{8}$/.test(value);
        },
        message: "Invalid Bangladeshi mobile number",
      },
      // validate: {
      //   validator: function (value) {
      //     if (value.length !== 11) {
      //       return false;
      //     } else {
      //       return true;
      //     }
      //   },
      //   message: "11 digit roll number required",
      // },
    },
    Class: { type: String },
    Remarks: { type: String, default: "No Remarks" },
  },
  { versionKey: false }
);

const StudentsModel = mongoose.model("students", DataSchema);
module.exports = StudentsModel;
