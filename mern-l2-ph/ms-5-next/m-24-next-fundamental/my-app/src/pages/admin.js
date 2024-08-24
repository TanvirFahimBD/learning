import React from "react";
import DashboardLayout from "@/components/Layouts/DashboardLayout";
import RootLayout from "@/components/Layouts/RootLayout";
import Head from "next/head";

const AdminPage = () => {
  return (
    <div>
      <Head>
        <title>Home page</title>
      </Head>
      <h1>Admin Page</h1>
    </div>
  );
};

export default AdminPage;

AdminPage.getLayout = function getLayout(page) {
  return (
    <RootLayout>
      <DashboardLayout>{page}</DashboardLayout>;
    </RootLayout>
  );
};
