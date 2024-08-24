import Head from "next/head";
import { useSession, signOut } from "next-auth/react";
import { useAuthState } from "react-firebase-hooks/auth";
import auth from "@/firbase/firebase.auth";

const HomePage = () => {
  const { data: session } = useSession();
  const [user, loading, error] = useAuthState(auth);
  console.log("home", user);
  return (
    <div>
      <Head>
        <title>Next Auth</title>
      </Head>
      <div style={{ textAlign: "center", marginTop: "10%" }}>
        <h1>Welcome To Next Auth Home Page</h1>
        {/* from next auth user  */}
        {/* <p>
          {session?.user?.name ? `Logged in user: ${session?.user?.name}` : ""}
        </p> */}
        {/* from firebase auth user  */}
        <p>{user?.email ? `Logged in user: ${user?.email}` : ""}</p>
      </div>
    </div>
  );
};

export default HomePage;
