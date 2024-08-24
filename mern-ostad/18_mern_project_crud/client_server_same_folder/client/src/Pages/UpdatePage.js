import React from "react";
import UpdateForm from "../Components/Update/UpdateForm";
import AppNavBar from "../Components/Common/AppNavBar";
import { useParams } from "react-router";

const UpdatePage = () => {
  const { id } = useParams();

  return (
    <div>
      <AppNavBar />
      <UpdateForm id={id} />
    </div>
  );
};

export default UpdatePage;
