import { configureStore } from "@reduxjs/toolkit";
// import logger from "redux-logger";
import counterReducer from "./features/counter/counterSlice";
import logger from "./middleware/logger";

const store = configureStore({
  reducer: {
    counter: counterReducer,
  },
  middleware: (getDefaultMiddleware) => getDefaultMiddleware().concat(logger),
  // devTools:true,
});

export type RootState = ReturnType<typeof store.getState>;
export type AppDispatch = typeof store.dispatch;

export default store;
