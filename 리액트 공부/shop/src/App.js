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

function App() {
  return (
    <div className="App">
      <Navbar expand="lg" className="bg-body-tertiary">
        <Container>
          <Navbar.Brand href="#home">쇼핑몰</Navbar.Brand>
          <Navbar.Toggle aria-controls="basic-navbar-nav" />
          <Navbar.Collapse id="basic-navbar-nav">
            <Nav className="me-auto">
              <Nav.Link href="#home">Home</Nav.Link>
              <Nav.Link href="#link">장바구니</Nav.Link>
            </Nav>
          </Navbar.Collapse>
        </Container>
      </Navbar>
      {/* <div
        className="main-bg"
        style={{ backgroundImage: "url(" + image + ")" }}
      ></div> */}
      <div className="main-bg"></div>
      <Container>
        {/* Columns start at 50% wide on mobile and bump up to 33.3% wide on desktop */}
        <Row>
          <Col xs={6} md={4}>
            <img
              src="https://codingapple1.github.io/shop/shoes3.jpg"
              alt=""
              width="80%"
            />{" "}
            <h4>상품명</h4>
            <p>상품 설명</p>
          </Col>
          <Col xs={6} md={4}>
            <img
              src="https://codingapple1.github.io/shop/shoes3.jpg"
              alt=""
              width="80%"
            />{" "}
            <h4>상품명</h4>
            <p>상품 설명</p>{" "}
          </Col>
          <Col xs={6} md={4}>
            <img
              src="https://codingapple1.github.io/shop/shoes3.jpg"
              alt=""
              width="80%"
            />
            <h4>상품명</h4>
            <p>상품 설명</p>{" "}
          </Col>
        </Row>
      </Container>
    </div>
  );
}

export default App;
