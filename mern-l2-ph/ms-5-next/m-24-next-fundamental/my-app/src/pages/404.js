import { useRouter } from "next/router";
import React from "react";

const Notfound = () => {
  const router = useRouter();

  setTimeout(() => {
    router.push("/article");
  }, 3000);

  return (
    <div>
      <img
        src="https://img.freepik.com/free-vector/page-found-concept-illustration_114360-1869.jpg?size=626&ext=jpg"
        alt=""
        width="100%"
      />
    </div>
  );
};

export default Notfound;
