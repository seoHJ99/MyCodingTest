import logo from "./logo.svg";
import "./App.css";
import {
  Button,
  Navbar,
  Container,
  Nav,
  NavDropdown,
  Row,
  Col,
} from "react-bootstrap";
import image from "./img/bg.png";
import { useState } from "react";
import data from "./data.js";
import { Routes, Route, Link, useNavigate, Outlet } from "react-router-dom";
import Detail from "./routes/detailCom.js";
import axios from "axios";

function App() {
  let [shoes, setShoes] = useState(data);
  let navigate = useNavigate();
  let [btnCount, setCount] = useState(2);
  let [loading, setLoading] = useState(false);

  return (
    <div className="App">
      <Navbar expand="lg" className="bg-body-tertiary">
        <Container>
          <Navbar.Brand href="#home">쇼핑몰</Navbar.Brand>
          <Navbar.Toggle aria-controls="basic-navbar-nav" />
          <Navbar.Collapse id="basic-navbar-nav">
            <Nav className="me-auto">
              <Nav.Link
                onClick={() => {
                  navigate("/");
                }}
              >
                Home
              </Nav.Link>
              <Nav.Link
                onClick={() => {
                  navigate("/detail");
                }}
              >
                상세페이지
              </Nav.Link>
            </Nav>
          </Navbar.Collapse>
        </Container>
      </Navbar>

      <Routes>
        <Route
          path="/"
          element={
            <>
              <div className="main-bg"></div>
              <Container>
                <Row>
                  {shoes.map(function (element, index) {
                    return (
                      <Product shoes={shoes[index]} i={index + 1}></Product>
                    );
                  })}
                </Row>
              </Container>
            </>
          }
        />
        <Route path="/detail/:id" element={<Detail shoes={shoes}></Detail>} />
      </Routes>
      {loading == true ? <div>로딩중</div> : null}
      {btnCount === 4 ? null : (
        <button
          onClick={() => {
            setLoading(true);
            axios
              .get(
                "https://codingapple1.github.io/shop/data" + btnCount + ".json"
              )
              .then((data) => {
                let copy = [...shoes, ...data.data];
                setShoes(copy);
                setCount(btnCount + 1);
                setLoading(false);
              })
              .catch(() => {
                console.log("실패");
                setLoading(false);
              });

            // 데이터 전송
            // axios.post("/url", {name : 'kim'});
            // 동시 요청
            // Promise.all([
            //   axios.post("/url", { name: "kim" }),
            //   axios.post("/url2", { name: "kim" }),
            //   ]).then(() => {});

            // 기본 fetch요청
            // fetch('url').then()
          }}
        >
          ajax통신 더보기 버튼
        </button>
      )}
    </div>
  );
}

function Product(props) {
  let navigate = useNavigate();

  return (
    <Col
      xs={6}
      md={4}
      onClick={() => {
        navigate("/detail/" + (props.i - 1));
      }}
    >
      <img
        src={"https://codingapple1.github.io/shop/shoes" + props.i + ".jpg"}
        alt=""
        width="80%"
      />
      <h4>{props.shoes.title}</h4>
      <p>{props.shoes.content}</p>
    </Col>
  );
}

export default App;
