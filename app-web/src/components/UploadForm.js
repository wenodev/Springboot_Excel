import React, { useState } from "react";
import * as API from "../services/api";

export default function UploadForm() {
  const [uploadFile, setUploadFile] = useState(null);

  // 배송비 등록 전송처리.
  async function OnSubmit(e) {
    e.preventDefault();
    const formData = new FormData();
    formData.append("file", uploadFile);
    await API.postExcel(formData);
  }

  function OnChange(e) {
    setUploadFile(e.target.files[0]);
  }

  return (
    <div>
      <form name="file" onSubmit={OnSubmit}>
        <input type="file" onChange={OnChange} />
        <button type="submit">전송</button>
      </form>
    </div>
  );
}
