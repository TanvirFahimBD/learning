import React from "react";
import RootLayout from "../components/Layouts/RootLayout";
import Head from "next/head";

const HomePage = () => {
  return (
    <div>
      <Head>
        <title>Next Home page</title>
        <meta name="home page" description="this page is created by next js" />
      </Head>
      <h1>Home Page</h1>
    </div>
  );
};

export default HomePage;

HomePage.getLayout = function getLayout(page) {
  return <RootLayout>{page}</RootLayout>;
};
