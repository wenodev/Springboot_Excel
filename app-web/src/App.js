import React from "react";
import UploadFrom from "./components/UploadForm";
import ProductList from "./components/ProductList";
import { Route } from "react-router-dom";
import ProductDetail from "./components/ProductDetail";

function App() {
  return (
    <div className="App">
      <Route exact component={ProductList} path="/" />
      <Route exact component={ProductList} path="/products" />
      <Route exact component={ProductDetail} path="/products/:id" />
      <Route component={UploadFrom} path="/upload" />
      {/* <ProductList /> */}
    </div>
  );
}

export default App;
