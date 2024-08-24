import { Button } from "antd";
import Link from "next/link";
import React from "react";
import RootLayout from "../../components/Layouts/RootLayout";

const ArticlePage = () => {
  return (
    <div>
      <h1>Article Page</h1>
      <Button type="primary">
        <Link href="/">Home</Link>
      </Button>
    </div>
  );
};

export default ArticlePage;

ArticlePage.getLayout = function getLayout(page) {
  return <RootLayout>{page}</RootLayout>;
};
