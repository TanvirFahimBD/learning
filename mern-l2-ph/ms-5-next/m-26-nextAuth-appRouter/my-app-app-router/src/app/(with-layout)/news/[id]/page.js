import React from "react";

const SingleNews = ({ params, searchParams }) => {
  console.log(searchParams);
  return (
    <div>
      <h1>
        Single News id : {params.id} & query : {searchParams.name}
      </h1>
    </div>
  );
};

export default SingleNews;
