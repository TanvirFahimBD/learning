import ProductReview from '@/components/ProductReview';
import { Button } from '@/components/ui/button';
<<<<<<< HEAD
import { addToCart } from '@/redux/features/cart/cartSlice';
import { useSingleProductQuery } from '@/redux/features/products/productApi';
import { useAppDispatch } from '@/redux/hook';
=======
import { useSingleProductQuery } from '@/redux/api/apiSlice';
>>>>>>> 8139f5ff3f06d42d06f9abd790073f253087168a
import { IProduct } from '@/types/globalTypes';
import { useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';

export default function ProductDetails() {
  const { id } = useParams();
<<<<<<< HEAD
  const dispatch = useAppDispatch();
=======
>>>>>>> 8139f5ff3f06d42d06f9abd790073f253087168a

  const { data: product, isLoading, error } = useSingleProductQuery(id);

  return (
    <>
      <div className="flex max-w-7xl mx-auto items-center border-b border-gray-300">
        <div className="w-[50%]">
          <img src={product?.image} alt="" />
        </div>
        <div className="w-[50%] space-y-3">
          <h1 className="text-3xl font-semibold">{product?.name}</h1>
          <p className="text-xl">Rating: {product?.rating}</p>
          <ul className="space-y-1 text-lg">
            {product?.features?.map((feature: string) => (
              <li key={feature}>{feature}</li>
            ))}
          </ul>
<<<<<<< HEAD
          <Button onClick={() => dispatch(addToCart(product))}>
            {' '}
            Add to cart
          </Button>
=======
          <Button>Add to cart</Button>
>>>>>>> 8139f5ff3f06d42d06f9abd790073f253087168a
        </div>
      </div>
      <ProductReview id={id!} />
    </>
  );
}
