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

function App() {
  let [shoes] = useState(data);
  // 페이지 이동을 도와주는 useNavigate() 함수
  let navigate = useNavigate();

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
        <Route path="/detail" element={<Detail></Detail>} />
        <Route path="/about" element={<About></About>}>
          <Route path="member" element={<div>맴버 정보</div>} />
          <Route path="location" element={<div>위치 정보임</div>} />
        </Route>
        <Route path="/event" element={<EventPage></EventPage>}>
          <Route path="one" element={<p>양배추사쇼</p>} />
          <Route path="two" element={<p>맘대로 하쇼</p>} />
        </Route>

        <Route path="*" element={<div>없는 페이지입니다.</div>} />
      </Routes>
    </div>
  );
}

function EventPage() {
  return (
    <div>
      <h4>오늘의 이벤트</h4>
      <Outlet></Outlet>
    </div>
  );
}

function About() {
  return (
    <div>
      <h4>회사 정보임</h4>
      <Outlet></Outlet>
    </div>
  );
}

function Product(props) {
  return (
    <Col xs={6} md={4}>
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
