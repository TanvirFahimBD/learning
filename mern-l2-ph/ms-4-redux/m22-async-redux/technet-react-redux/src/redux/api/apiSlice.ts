import { createApi, fetchBaseQuery } from '@reduxjs/toolkit/query/react';

export const api = createApi({
  reducerPath: 'api',
  baseQuery: fetchBaseQuery({ baseUrl: 'http://localhost:5000' }),
<<<<<<< HEAD
  tagTypes: ['comments'],
  endpoints: () => ({}),
});
=======
  endpoints: (builder) => ({
    getProducts: builder.query({
      query: () => '/products',
    }),
    singleProduct: builder.query({
      query: (id) => `/product/${id}`,
    }),
  }),
});

export const { useGetProductsQuery, useSingleProductQuery } = api;
>>>>>>> 8139f5ff3f06d42d06f9abd790073f253087168a
