import mongoose from "mongoose";
import app from "./app";

const port: number = 5000;

//database conncetion
async function main() {
  try {
    await mongoose.connect("mongodb://127.0.0.1:27017/test");
    console.log("🛢 db connection successful");

    app.listen(port, () => {
      console.log(`Server listening on port ${port}`);
    });
  } catch (err) {
    console.log("Failed to connect", err);
  }
}

main();
