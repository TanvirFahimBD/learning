import { configureStore } from '@reduxjs/toolkit';
import cartReducer from './features/cart/cartSlice';
import productReducer from './features/products/productSlice';
<<<<<<< HEAD
import userReducer from './features/user/userSlice';
=======
>>>>>>> 8139f5ff3f06d42d06f9abd790073f253087168a
import { api } from './api/apiSlice';

const store = configureStore({
  reducer: {
    cart: cartReducer,
    product: productReducer,
<<<<<<< HEAD
    user: userReducer,
=======
>>>>>>> 8139f5ff3f06d42d06f9abd790073f253087168a
    [api.reducerPath]: api.reducer,
  },
  middleware: (getDefaultMiddleware) =>
    getDefaultMiddleware().concat(api.middleware),
});

export type RootState = ReturnType<typeof store.getState>;
export type AppDispatch = typeof store.dispatch;

export default store;
