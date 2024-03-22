/* eslint-disable */

import logo from "./logo.svg";
import "./App.css";
import { useState } from "react";
import * as React from "react";

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
  let [입력값, 입력값변경] = useState("");

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

      {글제목.map(function (a, i) {
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
                onClick={(e) => {
                  e.stopPropagation();
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
            <button
              onClick={() => {
                let copy = [...글제목];
                copy.splice(i, 1);
                console.log(copy);
                글제목변경(copy);
              }}
            >
              삭제
            </button>
          </div>
        );
      })}

      <input
        type="text"
        onChange={(e) => {
          입력값변경(e.target.value);
        }}
      />
      <button
        onClick={() => {
          let copy = [...글제목];
          copy.push(입력값);
          글제목변경(copy);
        }}
      >
        글추가
      </button>
      {modal ? (
        <Modal
          글제목={글제목}
          글제목변경={글제목변경}
          글제목인덱스={글제목인덱스}
        ></Modal>
      ) : null}
      <Modal2></Modal2>
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

class Modal2 extends React.Component {
  constructor() {
    super();
    this.state = {
      name: "kim",
      age: 20,
    };
  }
  render() {
    return (
      <div>
        {this.state.age}
        <button
          onClick={() => {
            this.setState({ age: 21 });
          }}
        >
          버튼
        </button>
      </div>
    );
  }
}

export default App;
