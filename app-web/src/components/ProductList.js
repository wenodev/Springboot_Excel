import React, { useState, useEffect } from "react";
import * as API from "../services/api";

export default function ProductList() {
  const [products, setProducts] = useState();
  useEffect(() => {
    API.fetchProducts()
      .then((response) => {
        console.log(response);
        setProducts(response);
      })
      .catch((e) => {
        console.log(e);
      });
  }, [products]);

  function goDetail() {}

  return (
    <div>
      {products
        ? products.map((product) => (
            <div>
              <span>{product.name}</span>
              <span>{product.price}</span>
              <button onClick={goDetail}>자세히보기</button>
            </div>
          ))
        : null}
    </div>
  );
}
