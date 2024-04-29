import { useEffect, useState } from "react";
import { useParams } from "react-router-dom";

function Detail(props) {
  let [count, setCount] = useState(0);
  let { id } = useParams();
  let findProduct = props.shoes.find(function (x) {
    return x.id == id;
  });

  useEffect(() => {
    let a = setTimeout(() => {}, 2000);

    return () => {
      clearTimeout(a);
    };
  }, [count]);

  let [input, setInput] = useState(0);

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
    </div>
  );
}

export default Detail;
