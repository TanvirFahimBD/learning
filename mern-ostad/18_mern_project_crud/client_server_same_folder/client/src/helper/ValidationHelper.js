import { toast } from "react-toastify";

class ValidationHelper {
  isEmpty(value) {
    if (value.length === 0) return true;
    else return false;
  }

  ErrorToast(msg) {
    toast.error(msg);
  }
  SuccessToast(msg) {
    toast.success(msg);
  }
}

export const { isEmpty, SuccessToast, ErrorToast } = new ValidationHelper();
