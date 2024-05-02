import { useContext, useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import { Nav } from "react-bootstrap";
// context Api 사용법
// 문제점
// 1. context 로 넘겨진 state 를 안쓰더라도 state 가 변경되면 무조건 재렌더링됨
// 2. 자식 컴포넌트를 다른 페이지에서 재사용하려고 하면 context 가 안넘겨져서 오류 발생
import { Context1 } from "../App.js";

function Detail(props) {
  let { 재고, shoes } = useContext(Context1);

  let [count, setCount] = useState(0);
  let { id } = useParams();
  let findProduct = props.shoes.find(function (x) {
    return x.id == id;
  });
  let [input, setInput] = useState(0);
  let [탭, 탭변경] = useState(0);

  useEffect(() => {
    let a = setTimeout(() => {}, 2000);

    return () => {
      clearTimeout(a);
    };
  }, [count]);

  useEffect(() => {
    if (isNaN(input)) {
      alert("오직 숫자만");
    }
  }, [input]);

  let [fade2, setFade2] = useState("");
  useEffect(() => {
    setTimeout(() => {
      setFade2("end");
    }, 100);
    return () => {
      setFade2("");
    };
  }, []);
  return (
    <div className={"container start " + fade2}>
      {count}
      <button
        onClick={() => {
          setCount(count + 1);
        }}
      >
        버튼
      </button>
      <div className="row">
        <div className="col-md-6">
          <img
            src="https://codingapple1.github.io/shop/shoes1.jpg"
            width="100%"
          />
        </div>
        <div className="col-md-6">
          <input
            type="text"
            className="numInput"
            onChange={(e) => {
              setInput(e.target.value);
            }}
          ></input>
          <h4 className="pt-5">{findProduct.title}</h4>
          <p>{findProduct.content}</p>
          <p>{findProduct.price}</p>
          <button className="btn btn-danger">주문하기</button>
        </div>
      </div>
      <Nav variant="tabs" defaultActiveKey="link0">
        <Nav.Item>
          <Nav.Link
            eventKey="link0"
            onClick={() => {
              탭변경(0);
              console.log(탭);
            }}
          >
            버튼0
          </Nav.Link>
        </Nav.Item>
        <Nav.Item>
          <Nav.Link
            eventKey="link1"
            onClick={() => {
              탭변경(1);
            }}
          >
            버튼1
          </Nav.Link>
        </Nav.Item>
        <Nav.Item>
          <Nav.Link
            eventKey="link2"
            onClick={() => {
              탭변경(2);
            }}
          >
            버튼2
          </Nav.Link>
        </Nav.Item>
      </Nav>
      <TapContent 탭={탭} shoes={props.shoes}></TapContent>
    </div>
  );
}

function TapContent({ 탭, shoes }) {
  let [fade, setFade] = useState("");
  let { 재고 } = useContext(Context1);
  useEffect(() => {
    setTimeout(() => {
      setFade("end");
    }, 100);
    return () => {
      setFade("");
    };
  }, [탭]);

  return (
    <div className={"start " + fade}>
      {[<div>{shoes[0].title}</div>, <div>{재고}</div>, <div>내용2</div>][탭]}
    </div>
  );
}

export default Detail;
