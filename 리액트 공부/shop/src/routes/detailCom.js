import { useEffect, useState } from "react";
import { useParams } from "react-router-dom";

// 컴포넌트의 lifecycle (생명주기)
// mount: 컴포넌트가 페이지에 장착
// update : 컴포넌트 업데이트
// unmount : 페이지에서 컴포넌트 제거
// 이 과정 중간에 코드를 실행하고자 lifecycle을 이용
// ex) 마운트 될때 특정 코드 실행

// 과거 방식
// class Detail2 extends React.Component {
//   componentDidMount() {
//     // 컴포넌트가 장착될때
//   }

//   componentDidUpdate() {}

//   componentWillUnmount() {}
// }

// 요즘 장식
// useEffect(()->{})

function Detail(props) {
  // useEffect 내부에 있으면 전부 랜더링 된 다음 실행
  // 밖에 쓰면 랜더링 중간에 실행될수도 있음
  // 먼저 사용자에게 화면을 보여주는데 의의가 있음

  let [alert, setAlert] = useState(true);
  useEffect(() => {
    // mount 나 update시 실행
    console.log("안녕?");

    setTimeout(() => {
      setAlert(false);
    }, 2000);
  });

  let [count, setCount] = useState(0);

  let { id } = useParams();
  let findProduct = props.shoes.find(function (x) {
    return x.id == id;
  });

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
      {/* 숙제 */}
      {alert == true ? (
        <div className="alert alert-warning">2초 이후 사라져야 함</div>
      ) : null}
      {/*  */}
      <div className="row">
        <div className="col-md-6">
          <img
            src="https://codingapple1.github.io/shop/shoes1.jpg"
            width="100%"
          />
        </div>
        <div className="col-md-6">
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
