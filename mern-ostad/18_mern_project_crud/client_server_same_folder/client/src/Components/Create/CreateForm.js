import React, { useRef } from "react";
import {
  ErrorToast,
  SuccessToast,
  isEmpty,
} from "../../helper/ValidationHelper";
import { Create } from "../../APIServices/CRUDServices";
import FullScreenLoader from "../Common/FullScreenLoader";

const CreateForm = () => {
  let ProductName,
    ProductCode,
    Img,
    UnitPrice,
    Qty,
    TotalPrice,
    Loader = useRef();

  const SaveData = () => {
    let Product_Name = ProductName.value;
    let Product_Code = ProductCode.value;
    let Product_Img = Img.value;
    let Unit_Price = UnitPrice.value;
    let Product_Qty = Qty.value;
    let Total_Price = TotalPrice.value;

    if (isEmpty(Product_Name)) {
      ErrorToast("Product Name required");
    } else if (isEmpty(Product_Code)) {
      ErrorToast("Product Code required");
    } else if (isEmpty(Product_Img)) {
      ErrorToast("Product Image required");
    } else if (isEmpty(Unit_Price)) {
      ErrorToast("Product Price required");
    } else if (isEmpty(Product_Qty)) {
      ErrorToast("Product Quantity required");
    } else if (isEmpty(Total_Price)) {
      ErrorToast("Total Price required");
    } else {
      // create data
      Create(
        Product_Name,
        Product_Code,
        Product_Img,
        Unit_Price,
        Product_Qty,
        Total_Price
      )
        .then((Result) => {
          Loader.classList.remove("d-none");
          if (Result === true) {
            Loader.classList.add("d-none");
            SuccessToast("Data saved successfully");
            ProductName.value = "";
            ProductCode.value = "";
            Img.value = "";
            UnitPrice.value = "";
            Qty.value = "";
            TotalPrice.value = "";
          } else {
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
          <button onClick={SaveData} className="btn btn-primary w-100">
            Save
          </button>
        </div>
        <div className="d-none" ref={(div) => (Loader = div)}>
          <FullScreenLoader />
        </div>
      </div>
    </div>
  );
};

export default CreateForm;
