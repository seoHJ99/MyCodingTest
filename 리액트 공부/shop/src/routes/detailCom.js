import { useParams } from "react-router-dom";
import styled from "styled-components";

// styled.태그 스타일 css 적용하면 페이지 로딩 시간 단축. 현재 페이지에만 적용 가능

let YellowBtn = styled.button`
  background: ${(props) => props.bg};
  color: ${(props) => (props.bg == "blue" ? "white" : "black")};
  padding: 10px;
`;

// 기존 css 복사해서 커스텀 가능
let newBtn = styled.button(YellowBtn);

let Box = styled.div`
  background : Grey;
  padding 20px
`;
// css 파일 이름을 js파일이름.modules.css 형식으로 작성하면 해당 모듈에만 css적용됨

function Detail(props) {
  let { id } = useParams();
  let findProduct = props.shoes.find(function (x) {
    return x.id == id;
  });

  console.log(findProduct);
  return (
    <div className="container">
      <Box>
        <YellowBtn bg="blue">버튼</YellowBtn>
        <YellowBtn bg="orange">버튼</YellowBtn>
      </Box>

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
