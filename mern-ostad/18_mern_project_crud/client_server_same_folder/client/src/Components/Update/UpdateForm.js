import React, { useEffect, useRef } from "react";
import FullScreenLoader from "../Common/FullScreenLoader";
import { ReadProductById, Update } from "../../APIServices/CRUDServices";
import {
  ErrorToast,
  SuccessToast,
  isEmpty,
} from "../../helper/ValidationHelper";

const UpdateForm = ({ id }) => {
  let ProductName,
    ProductCode,
    Img,
    UnitPrice,
    Qty,
    TotalPrice,
    Loader = useRef();

  useEffect(() => {
    ReadProductById(id).then((res) => {
      ProductName.value = res.ProductName;
      ProductCode.value = res.ProductCode;
      Img.value = res.Img;
      UnitPrice.value = res.UnitPrice;
      Qty.value = res.Qty;
      TotalPrice.value = res.TotalPrice;
      Loader.value = res.Loader;
    });
  }, []);

  const UpdateData = (id) => {
    ProductName = ProductName.value;
    ProductCode = ProductCode.value;
    Img = Img.value;
    UnitPrice = UnitPrice.value;
    Qty = Qty.value;
    TotalPrice = TotalPrice.value;

    if (isEmpty(ProductName)) {
      ErrorToast("Product Name required");
    } else if (isEmpty(ProductCode)) {
      ErrorToast("Product Code required");
    } else if (isEmpty(Img)) {
      ErrorToast("Product Image required");
    } else if (isEmpty(UnitPrice)) {
      ErrorToast("Product Price required");
    } else if (isEmpty(Qty)) {
      ErrorToast("Product Quantity required");
    } else if (isEmpty(TotalPrice)) {
      ErrorToast("Total Price required");
    } else {
      // update data
      let updatedData = {
        ProductName,
        ProductCode,
        Img,
        UnitPrice,
        Qty,
        TotalPrice,
      };
      Update(id, updatedData)
        .then((Result) => {
          console.log("Result", Result);
          Loader.classList.remove("d-none");
          if (Result === true) {
            Loader.classList.add("d-none");
            SuccessToast("Data saved successfully");
          } else {
            Loader.classList.add("d-none");
            ErrorToast("Request Failed");
          }
        })
        .catch((err) => ErrorToast(err.message));
    }
  };

  return (
    <div className="container">
      <div className="row">
        <div className="col-md-4 p-2">
          <label htmlFor="">Product Name</label>
          <input
            ref={(input) => (ProductName = input)}
            type="text"
            className="form-control"
          />
        </div>
        <div className="col-md-4 p-2">
          <label htmlFor="">Product Code</label>
          <input
            ref={(input) => (ProductCode = input)}
            type="text"
            className="form-control"
          />
        </div>
        <div className="col-md-4 p-2">
          <label htmlFor="">Image</label>
          <input
            ref={(input) => (Img = input)}
            type="text"
            className="form-control"
          />
        </div>
        <div className="col-md-4 p-2">
          <label htmlFor="">Unit Price</label>
          <input
            ref={(input) => (UnitPrice = input)}
            type="text"
            className="form-control"
          />
        </div>
        <div className="col-md-4 p-2">
          <label htmlFor="">Qty</label>
          <input
            ref={(input) => (Qty = input)}
            type="text"
            className="form-control"
          />
        </div>
        <div className="col-md-4 p-2">
          <label htmlFor="">Total Price</label>
          <input
            ref={(input) => (TotalPrice = input)}
            type="text"
            className="form-control"
          />
        </div>
        <br />
        <div className="col-md-4 p-2">
          <button
            onClick={UpdateData.bind(this, id)}
            className="btn btn-primary w-100"
          >
            Update
          </button>
        </div>
        <div className="d-none" ref={(div) => (Loader = div)}>
          <FullScreenLoader />
        </div>
      </div>
    </div>
  );
};

export default UpdateForm;
