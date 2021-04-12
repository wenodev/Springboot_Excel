import React, { useState, useEffect } from "react";
import { Link } from "react-router-dom";
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
  }, []);

  return (
    <div>
      {products
        ? products.map((product) => (
            <div key={product.id}>
              <span>{product.name}</span>
              <span>{product.price}</span>
              <Link to={`/products/${product.id}`}>
                <button>자세히보기</button>
              </Link>
            </div>
          ))
        : null}
    </div>
  );
}
