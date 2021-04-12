import React, { useState, useEffect } from "react";
import { withRouter } from "react-router";
import * as API from "../services/api";

function ProductDetail({ match }) {
  const [product, setProduct] = useState(null);

  useEffect(() => {
    console.log(match.params.id);

    API.fetchProduct(match.params.id)
      .then((response) => {
        setProduct(response);
      })
      .catch((e) => {
        console.log(e);
      });
  }, []);

  // if (!product) {
  //   return;
  // }
  console.log(product);
  if (product === null) return null;
  return (
    <div>
      <h3>상세</h3>
      <span>{product.id}</span>
      <span>{product.name}</span>
      <span>{product.price}</span>
      <span>{product.weight}</span>
      <span>{product.description}</span>
    </div>
  );
}

export default withRouter(ProductDetail);
