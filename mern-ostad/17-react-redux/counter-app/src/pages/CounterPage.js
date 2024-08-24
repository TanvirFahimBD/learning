import React, { useRef } from "react";
import { useDispatch, useSelector } from "react-redux";
import { decrement, increment, setCustom } from "../redux/state/counterSlice";

const CounterPage = () => {
  const value = useSelector((state) => state.counter.value);
  const dispatch = useDispatch();
  const typedNumber = useRef();
  return (
    <div className="container">
      <div className="row d-flex justify-content-center">
        <div className="col-6">
          <div className="card shadow">
            <h1 class="card-header bg-secondary text-white">Counter App</h1>
            <div className="card-body">
              <h2 class="card-text my-3">{value}</h2>
              <button
                onClick={() => dispatch(increment())}
                className="mx-2 btn btn-success"
              >
                Increase
              </button>
              <button
                onClick={() => dispatch(decrement())}
                className="mx-2 btn btn-danger"
              >
                Decrease
              </button>

              <div className="my-3">
                <input
                  ref={typedNumber}
                  type="number"
                  className="form-control w-50 mx-auto"
                />
                <button
                  className="my-3 btn btn-secondary w-50"
                  onClick={() =>
                    dispatch(setCustom(Number(typedNumber.current.value)))
                  }
                >
                  SET CUSTOM
                </button>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default CounterPage;
