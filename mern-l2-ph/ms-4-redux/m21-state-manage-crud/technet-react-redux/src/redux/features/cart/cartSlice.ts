import { IProduct } from '@/types/globalTypes';
import { PayloadAction, createSlice } from '@reduxjs/toolkit';

interface ICart {
  products: IProduct[];
  total: number;
}

const initialState: ICart = {
  products: [],
  total: 0,
};

const cartSlice = createSlice({
  name: 'cart',
  initialState,
  reducers: {
    addToCart: (state, action: PayloadAction<IProduct>) => {
      const findProduct = state.products.find(
        (pd) => pd._id === action.payload._id
      );
      if (findProduct) {
        findProduct.quantity = findProduct.quantity! + 1;
      } else {
        state.products.push({ ...action.payload, quantity: 1 });
      }
      state.total += action.payload.price;
    },
    removeOne: (state, action: PayloadAction<IProduct>) => {
      const findProduct = state.products.find(
        (pd) => pd._id === action.payload._id
      );
      if (findProduct && findProduct.quantity! > 1) {
        findProduct.quantity = findProduct.quantity! - 1;
      } else {
        state.products = state.products.filter(
          (pd) => pd._id !== action.payload._id
        );
      }
      state.total -= action.payload.price;
    },
    removeFromCart: (state, action: PayloadAction<IProduct>) => {
      state.products = state.products.filter(
        (pd) => pd._id !== action.payload._id
      );

      state.total -= action.payload.price * action.payload.quantity!;
    },
  },
});

export const { addToCart, removeOne, removeFromCart } = cartSlice.actions;

export default cartSlice.reducer;
