import { configureStore, createSlice } from "@reduxjs/toolkit";

// useState 와 비슷한 역할
let user = createSlice({
  name: "user", // state이름
  initialState: "kim", // 값
});

let info = createSlice({
  name: "info",
  initialState: [
    { id: 0, name: "White and Black", count: 2 },
    { id: 2, name: "Grey Yordan", count: 1 },
  ],
});

let stock = createSlice({
  name: "stock", // state이름
  initialState: [10, 11, 12], // 값
});

export default configureStore({
  reducer: {
    user: user.reducer,
    stock: stock.reducer,
    info: info.reducer,
  }, // 등록
});
