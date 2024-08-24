import React, { useEffect, useState } from "react";
import { Delete, Read } from "../../APIServices/CRUDServices";
import FullScreenLoader from "../Common/FullScreenLoader";
import { ErrorToast, SuccessToast } from "../../helper/ValidationHelper";
import { Link } from "react-router-dom";

const ListTable = () => {
  let [dataList, setDataList] = useState([]);

  useEffect(() => {
    Read().then((res) => {
      setDataList(res);
      console.log("dataList", res);
    });
  }, []);

  const DeleteItem = (id) => {
    Delete(id).then((res) => {
      if (res === true) SuccessToast("Deleted");
      else ErrorToast("Not deleted");
    });
  };

  if (dataList.length > 0) {
    return (
      <div>
        <table className="table">
          <thead>
            <tr>
              <th>Product Name</th>
              <th>Product Code</th>
              <th>Image</th>
              <th>Unit Price</th>
              <th>Qty</th>
              <th>Total Price</th>
              <th>Action</th>
            </tr>
          </thead>
          <tbody>
            {dataList.map((item, i) => {
              return (
                <tr key={i}>
                  <th>{item.ProductName}</th>
                  <th>{item.ProductCode}</th>
                  <th>
                    <img
                      className="rounded"
                      src={item.Img}
                      alt=""
                      height={100}
                      width={100}
                    />
                  </th>
                  <th>{item.UnitPrice}</th>
                  <th>{item.Qty}</th>
                  <th>{item.TotalPrice}</th>
                  <th>
                    <span>
                      <button className="btn btn-warning mx-3">
                        <Link to={`update/${item._id}`}>Update</Link>
                      </button>
                      <button
                        className="btn btn-danger"
                        onClick={DeleteItem.bind(this, item._id)}
                      >
                        Delete
                      </button>
                    </span>
                  </th>
                </tr>
              );
            })}
          </tbody>
        </table>
      </div>
    );
  } else {
    return (
      <div>
        <FullScreenLoader />
      </div>
    );
  }
};

export default ListTable;
