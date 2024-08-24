import { PayloadAction, createSlice } from '@reduxjs/toolkit';

interface IProduct {
  status: boolean;
  priceRange: number;
}

const initialState: IProduct = {
  status: false,
  priceRange: 150,
};

const prodcuts = createSlice({
  name: 'product',
  initialState,
  reducers: {
    toggleState: (state) => {
      state.status = !state.status;
    },
    setPriceRange: (state, action: PayloadAction<number>) => {
      state.priceRange = action.payload;
    },
  },
});

export const { toggleState, setPriceRange } = prodcuts.actions;
export default prodcuts.reducer;
