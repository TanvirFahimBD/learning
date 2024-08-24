import { configureStore, getDefaultMiddleware } from '@reduxjs/toolkit';
import cartReducer from './feature/cart/cartSlice';
import productReducer from './feature/products/productSlice';
import { api } from './api/apiSlice';

const store = configureStore({
  reducer: {
    cart: cartReducer,
    product: productReducer,
    [api.reducerPath]: api.reducer,
  },
  middleware: (getDefaultMiddleware) =>
    getDefaultMiddleware().concat(api.middleware),
});

export type RootState = ReturnType<typeof store.getState>;
export type AppDispatch = typeof store.dispatch;

export default store;
