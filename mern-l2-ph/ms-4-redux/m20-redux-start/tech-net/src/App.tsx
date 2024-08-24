import { RootState } from "./redux/store";
import {
  decrement,
  increment,
  incrementByAmount,
} from "./redux/features/counter/counterSlice";
import { useAppDispatch, useAppSelector } from "./redux/hooks";

function App() {
  const count = useAppSelector((state: RootState) => state.counter.count);
  const dispatch = useAppDispatch();

  return (
    <div>
      <h3 className="bg-blue-500 md:bg-green-500">Tech net</h3>
      <h3 className="text-lg mx-14">{count}</h3>
      <button
        className="bg-green-500 w-10 mx-3"
        onClick={() => dispatch(increment())}
      >
        +
      </button>
      <button
        className="bg-red-500  w-10 mx-3"
        onClick={() => dispatch(incrementByAmount(5))}
      >
        +5
      </button>
      <button
        className="bg-red-500  w-10 mx-3"
        onClick={() => dispatch(decrement())}
      >
        -
      </button>
    </div>
  );
}

export default App;
