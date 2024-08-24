import express, { Application } from "express";
import cors from "cors";

//Application routes
import UserRouters from "./app/modules/user/user.route";

const app: Application = express();

//use cors
app.use(cors());

//parse data
app.use(express.json());
app.use(express.urlencoded({ extended: true }));

app.use("/api/v1/user", UserRouters);

export default app;
