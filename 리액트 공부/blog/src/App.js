/* eslint-disable */

import logo from "./logo.svg";
import "./App.css";
import { useState } from "react";

function App() {
  let post = "강남 강남";
  let [글제목, 글제목변경] = useState([
    "남자 코트 추천",
    "글제목 2",
    "글제목 3",
  ]);
  let [좋아요, 좋아요변경] = useState([0, 0, 0]);
  let [modal, setModal] = useState(false);
  let [글제목인덱스, setIndex] = useState(0);

  return (
    <div className="App">
      <div className="black-nav">
        <h4>블로그</h4>
      </div>
      <button
        onClick={() => {
          let copy = [...글제목];
          copy.sort();
          글제목변경(copy);
        }}
      >
        가나다순정렬
      </button>
      <button
        onClick={() => {
          let copy = [...글제목];
          copy[0] = "여자 코트 추천";
          글제목변경(copy);
        }}
      >
        이름 변경
      </button>
      {/* <div className="list">
        <h4>
          {글제목[0]}
          <span
            onClick={() => {
              좋아요변경(++좋아요);
            }}
          >
            😊
          </span>
          {좋아요}
        </h4>
        <p>발행 날짜</p>
      </div>
      <div className="list">
        <h4>{글제목[1]}</h4>
        <p>발행 날짜</p>
      </div>
      <div className="list">
        <h4
          onClick={() => {
            setModal(!modal);
          }}
        >
          {글제목[2]}
        </h4>
        <p>발행 날짜</p>
      </div> */}

      {/*
       map 함수
       array 에 적용 가능한 함수.
       array 의 개수만큼 내부 콜백 함수가 실행됨.
       return 값을 array로 담아줌 
       */}

      {
        // 글제목 역시 array 여서 map함수를 적용 가능
        // 콜백 함수의 매개변수가 array 의 내부 요소가 됨
        // 두번째 매개변수는 index 가 됨
        글제목.map(function (a, i) {
          return (
            <div className="list" key={i}>
              <h4
                onClick={() => {
                  setModal(!modal);
                  setIndex(i);
                }}
              >
                {a}
                <span
                  onClick={() => {
                    let copy = [...좋아요];
                    copy[i] += 1;
                    좋아요변경(copy);
                  }}
                >
                  😊
                </span>
                {좋아요[i]}
              </h4>

              <p>발행 날짜</p>
            </div>
          );
        })
      }
      {modal ? (
        <Modal
          글제목={글제목}
          글제목변경={글제목변경}
          글제목인덱스={글제목인덱스}
        ></Modal>
      ) : null}
    </div>
  );
}

function Modal(props) {
  return (
    <div className="modal">
      <h4>{props.글제목[props.글제목인덱스]}</h4>
      <p>날짜</p>
      <p>상세내용</p>
    </div>
  );
}

export default App;
