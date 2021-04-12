export async function postExcel(file) {
  console.log("file", file);
  const url = "http://localhost:8080/upload/product";
  const response = await fetch(url, {
    method: "POST",
    body: file,
  });
  const data = await response.json();
  return data;
}

export async function fetchProducts() {
  const url = "http://localhost:8080/products";
  const response = await fetch(url);
  const data = await response.json();
  return data;
}

export async function fetchProduct(id) {
  const url = "http://localhost:8080/products/" + id;
  const response = await fetch(url);
  const data = await response.json();
  return data;
}
