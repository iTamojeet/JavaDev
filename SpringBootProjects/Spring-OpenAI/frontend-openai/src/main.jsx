// console.log("Hello I am JavaScript!!!");

// function abc() {
//   for (var i = 0; i < 3; i++) {
//     console.log("using var i is " + i);
//   }
//   console.log("outside for but inside function using var i is " + i);
// }
// // console.log("i is " + i);

// abc();

// function blockscope() {
//   for (let i = 0; i < 4; i++) {
//     console.log("using let i is " + i);
//   }
//   // console.log("outside for but inside function using let i is " + i);
// }

// blockscope();

// function sayHello() {
//   console.log("I am a function");
// }

// sayHello();

// const igloo = () => console.log("I am an arrow function");

// igloo();

// const how = (x) => console.log("Hello .... " + x);

// how("penguin");

// const user = {
//   name: "Dinosaur",
//   email: "tamosaurus@gmail.com",
//   address: "Russia",
// };

// console.log(
//   user.name + " has email " + user.email + " address is " + user["address"]
// );

// // Object Destructuring

// const products = {
//   name: "TV",
//   brand: "Sony",
//   price: 50000,
// };

// const { name, brand, price } = products;
// console.log(name + " " + brand + " " + price);

// const { name: A, brand: B, price: P } = products;
// console.log(A + " " + B + " " + P);

// const tvs = ["sony", "samsung", "lg", "mi", "bpl", "philips"];

// const data = tvs.map(function (p) {
//   return "<li>" + p + "</li>";
// });
// console.log(data);

// const display = tvs.map((r) => "<li>" + r + "</li>");
// console.log(display);

// const display2 = tvs.map((t) => `<li>${t}</li>`);
// console.log(display2);

import { StrictMode } from "react";
import { createRoot } from "react-dom/client";
import "./index.css";
import App from "./App.jsx";

createRoot(document.getElementById("root")).render(
  <StrictMode>
    <App />
  </StrictMode>
);
