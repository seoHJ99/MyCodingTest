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

  return (
    <div className="container">
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

// props 의 축약버전. 매개변수에 바로 {} 쓰고 그 안에 props 이름 쓰면 됨
function TapContent({ 탭 }) {
  // if문 사용 버전
  // if (탭 == 0) {
  //   return <div>내용0</div>;
  // } else if (탭 == 1) {
  //   return <div>내용1</div>;
  // } else if (탭 == 2) {
  //   return <div>내용2</div>;
  // }

  // array 로 사용하는 버전
  return [<div>내용0</div>, <div>내용1</div>, <div>내용2</div>][탭];
}

export default Detail;
