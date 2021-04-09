export async function postExcel(file) {
  const url = "http://localhost:8080/upload/product";

  const formData = new FormData();
  formData.append("file", file);

  const response = await fetch(url, formData, {
    method: "POST",
    headers: {
      "Content-Type": "multipart/form-data",
    },
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
