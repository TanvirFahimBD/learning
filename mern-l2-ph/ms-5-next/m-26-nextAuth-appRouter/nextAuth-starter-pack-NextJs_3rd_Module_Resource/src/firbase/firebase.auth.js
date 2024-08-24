import { getAuth } from "firebase/auth";
import app from "@/firbase/firbase.config";

const auth = getAuth(app);

export default auth;
