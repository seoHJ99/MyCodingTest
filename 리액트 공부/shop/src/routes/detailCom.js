import { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import { Nav } from "react-bootstrap";

function Detail(props) {
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
      <TapContent 탭={탭}></TapContent>
    </div>
  );
}

function TapContent({ 탭 }) {
  // 리액트 automatic batching 기능이 있음
  // state 변경이 여러번 이뤄지면, 모든 변경이 이뤄지고 난 이후 최종 결과만 적용한체 재랜더링이 이뤄짐
  // 그래서 시간차를 두지 않으면 최종 결과본만 적용함
  let [fade, setFade] = useState("");
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
      {[<div>내용0</div>, <div>내용1</div>, <div>내용2</div>][탭]}
    </div>
  );
}

export default Detail;
