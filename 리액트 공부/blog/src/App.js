import logo from "./logo.svg";
import "./App.css";
import { useState } from "react";

function App() {
  let post = "강남 강남";
  let [글제목, b] = useState("남자 코트 추천");
  // a : state 에 담긴 데이터를 나타냄
  // b : state 를 다루는 함수

  // state 를 쓰는 이유
  // 변수에 담긴 데이터가 바뀔 경우, html 이 다시 렌더링되지 않아서 기존에 데이터 그대로 나옴
  // 반면 state 는 변경되면 state를 사용하던 html 이 자동 렌더링됨
  // 자주 변경되는 것, 변경 사항이 바로 반영되는 것을 state에 담음

  return (
    <div className="App">
      <div className="black-nav">
        <h4>블로그</h4>
      </div>
      <div className="list">
        <h4>{글제목}</h4>
        <p>발행 날짜</p>
      </div>
    </div>
  );
}

export default App;
