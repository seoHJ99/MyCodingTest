import { useEffect, useState } from "react";
import { useParams } from "react-router-dom";

function Detail(props) {
  let [count, setCount] = useState(0);
  let { id } = useParams();
  let findProduct = props.shoes.find(function (x) {
    return x.id == id;
  });

  useEffect(() => {
    console.log("1111111");
    let a = setTimeout(() => {
      console.log("xxxxxxxxxxx");
    }, 2000);

    // useEffect 동작 전에 실행되는 함수는 return으로 넘김
    // clean Up Function
    // mount 시 실행안되지만 unmount 시에는 실행됨
    return () => {
      // 타이머 같은 코드를 작성할때 기존 타이머 시간 제거 등으로 사용
      // 오래 걸리는 요청이 계속 날아가(새로고침 등으로) 중복되는 것을 막기 위해서 기존 요청 제거시 사용
      clearTimeout(a);
      console.log("eeeeeeeeeeeeeeee");
    };
  }, [count]); // []내부의 값: 디펜던시. 해당 변수가 변할때만 실행됨
  // 디펜던시 값이 없으면 mount시에만 실행

  let [input, setInput] = useState(0);

  useEffect(() => {
    console.log(input);
    if (isNaN(input)) {
      alert("xxx");
    }
    console.log("xx");
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

// useEffect
// 1. 재렌더링마다 코드 실행
//    useEffect(()={})
// 2. mount 시마다 1회만 실행
//    useEffect(()={}, [])
// 3. unmount 시 코드 1회 실행
//    useEffect(()={
//     return ()={}
//   }, [])
