//TODO:remove domain for scafolding project
import axios from "axios";

export function Create(
  ProductName,
  ProductCode,
  Img,
  UnitPrice,
  Qty,
  TotalPrice
) {
  let URL = "http://localhost:5000/api/v1/CreateProduct";
  let PostBody = {
    ProductName,
    ProductCode,
    Img,
    UnitPrice,
    Qty,
    TotalPrice,
  };
  return axios
    .post(URL, PostBody)
    .then((res) => {
      if (res.status === 200) {
        return true;
      } else {
        return false;
      }
    })
    .catch((err) => {
      console.log(err);
      return false;
    });
}

//Read
export function Read() {
  let URL = "http://localhost:5000/api/v1/ReadProduct";
  return axios
    .get(URL)
    .then((res) => {
      if (res.status === 200) {
        return res.data.data;
      }
    })
    .catch((err) => {
      console.log(err);
      return false;
    });
}

//Read by ID
export function ReadProductById(id) {
  let URL = "http://localhost:5000/api/v1/ReadProduct/" + id;
  return axios
    .get(URL)
    .then((res) => {
      if (res.status === 200) {
        return res.data["data"][0];
      }
    })
    .catch((err) => {
      console.log(err);
      return false;
    });
}

export function Delete(id) {
  let URL = "http://localhost:5000/api/v1/DeleteProduct/" + id;
  return axios
    .get(URL)
    .then((res) => {
      if (res.status === 200) {
        return true;
      } else {
        return false;
      }
    })
    .catch((err) => {
      console.log(err);
      return false;
    });
}

//FIXME: when send update data, data properties name will be same
export function Update(id, PostBody) {
  let URL = "http://localhost:5000/api/v1/UpdateProduct/" + id;
  return axios
    .post(URL, PostBody)
    .then((res) => {
      if (res.status === 200) {
        return true;
      } else {
        return false;
      }
    })
    .catch((err) => {
      console.log(err);
      return false;
    });
}
