import Image from "next/image";
import React from "react";
import localImage from "@/assets/images/nextjs-logo.png";

const Album = () => {
  return (
    <div>
      <h1>This page is using image tag</h1>
      <img
        src="https://testrigor.com/wp-content/uploads/2023/04/nextjs-logo.png"
        alt=""
      />

      <h1>This page is using Next image component</h1>
      <Image
        src="https://testrigor.com/wp-content/uploads/2023/04/nextjs-logo.png"
        alt=""
        width={100}
        height={100}
        layout="responsive"
      />

      <h1>This page is using Next image from local file</h1>
      <Image
        src={localImage}
        alt=""
        width={100}
        height={100}
        layout="responsive"
      />
    </div>
  );
};

export default Album;
