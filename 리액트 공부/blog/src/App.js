/* eslint-disable */

import logo from "./logo.svg";
import "./App.css";
import { useState } from "react";

function App() {
  let post = "강남 강남";
  let [글제목, b] = useState(["남자 코트 추천", "글제목 2", "글제목 3"]);
  let [좋아요, 좋아요변경] = useState(0);

  return (
    <div className="App">
      <div className="black-nav">
        <h4>블로그</h4>
      </div>
      <div className="list">
        <h4>
          {글제목[0]}{" "}
          <span
            onClick={() => {
              좋아요변경(++좋아요);
            }}
          >
            😊
          </span>{" "}
          {좋아요}
        </h4>
        <p>발행 날짜</p>
      </div>
      <div className="list">
        <h4>{글제목[1]}</h4>
        <p>발행 날짜</p>
      </div>
      <div className="list">
        <h4>{글제목[2]}</h4>
        <p>발행 날짜</p>
      </div>
    </div>
  );
}

export default App;
