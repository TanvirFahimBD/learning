import { createSlice } from '@reduxjs/toolkit';
import type { PayloadAction } from '@reduxjs/toolkit';

export interface IProduct {
  status: boolean;
  priceRange: number;
}

const initialState: IProduct = {
  status: false,
  priceRange: 150,
};

export const productSlice = createSlice({
  name: 'product',
  initialState,
  reducers: {
    toggleStock: (state) => {
      state.status = !state.status;
    },
    setPriceRange: (state, action: PayloadAction<number>) => {
      state.priceRange = action.payload;
    },
  },
});

export const { toggleStock, setPriceRange } = productSlice.actions;

export default productSlice.reducer;
