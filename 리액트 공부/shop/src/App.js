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

function App() {
  let [shoes] = useState(data);

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
          {shoes.map(function (element, index) {
            return <Product shoes={shoes[index]}></Product>;
          })}
        </Row>
      </Container>
    </div>
  );
}

function Product(props) {
  return (
    <Col xs={6} md={4}>
      <img
        src="https://codingapple1.github.io/shop/shoes3.jpg"
        alt=""
        width="80%"
      />
      <h4>{props.shoes.title}</h4>
      <p>{props.shoes.content}</p>
    </Col>
  );
}

export default App;
