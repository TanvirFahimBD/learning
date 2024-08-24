import React from "react";
import loader from "../../Assets/img/Eclipse-1s-200px.svg";

const FullScreenLoader = () => {
  return (
    <div className="mt-5 text-center">
      <img src={loader} alt="" />
    </div>
  );
};

export default FullScreenLoader;
