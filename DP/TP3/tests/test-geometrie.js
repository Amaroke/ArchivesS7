// fixez éventuellement les imports pour Point et Triangle
import { Point } from "../Point.js";
import { Triangle } from "../Triangle.js";

const backgroundColor = "LightGray";
const strokeColor1 = "Red";
const fillColor1 = "rgba(255, 0, 0, 0.1)";
const strokeColor2 = "Blue";
const fillColor2 = "rgba(0, 0, 255, 0.1)";

const buttonText = "Définissez deux triangles.";
const textIntersect = "Les deux triangles s'intersectent.";
const textNotIntersect = "Les deux triangles ne s'intersectent pas.";

const button = document.querySelector("#button");
const text = document.querySelector("#text");
const canvas = document.querySelector("#canvas");
const ctx = canvas.getContext("2d");

let points = [];
let position;

button.addEventListener("click", reset);
reset();

function reset() {
  points = [];
  text.textContent = buttonText;
  draw();
  canvas.addEventListener("click", canvasClick);
  canvas.addEventListener("mousemove", canvasMove);
}

function control() {
  let t1 = new Triangle(...points.slice(0, 3));
  let t2 = new Triangle(...points.slice(3, 6));
  text.textContent = t1.intersecte(t2) ? textIntersect : textNotIntersect;
}

function draw() {
  ctx.clearRect(0, 0, canvas.width, canvas.height);
  ctx.fillStyle = backgroundColor;
  ctx.fillRect(0, 0, canvas.width, canvas.height);
  switch (points.length) {
    case 1:
      drawLine(strokeColor1, points[0], position);
      break;
    case 2:
      drawTriangle(strokeColor1, fillColor1, ...points.slice(0, 2), position);
      break;
    case 3:
      drawTriangle(strokeColor1, fillColor1, ...points.slice(0, 3));
      break;
    case 4:
      drawTriangle(strokeColor1, fillColor1, ...points.slice(0, 3));
      drawLine(strokeColor2, points[3], position);
      break;
    case 5:
      drawTriangle(strokeColor1, fillColor1, ...points.slice(0, 3));
      drawTriangle(strokeColor2, fillColor2, ...points.slice(3, 5), position);
      break;
    case 6:
      drawTriangle(strokeColor1, fillColor1, ...points.slice(0, 3));
      drawTriangle(strokeColor2, fillColor2, ...points.slice(3, 6));
      break;
  }
}

function drawLine(strokeColor, { x: x1, y: y1 }, { x: x2, y: y2 }) {
  ctx.strokeStyle = strokeColor;
  ctx.beginPath();
  ctx.moveTo(x1, y1);
  ctx.lineTo(x2, y2);
  ctx.stroke();
}

function drawTriangle(
  strokeColor,
  fillColor,
  { x: x1, y: y1 },
  { x: x2, y: y2 },
  { x: x3, y: y3 }
) {
  ctx.strokeStyle = strokeColor;
  ctx.fillStyle = fillColor;
  ctx.beginPath();
  ctx.moveTo(x1, y1);
  ctx.lineTo(x2, y2);
  ctx.lineTo(x3, y3);
  ctx.closePath();
  ctx.fill();
  ctx.stroke();
}

function getMousePos(event) {
  let rect = canvas.getBoundingClientRect();
  return { x: event.clientX - rect.left, y: event.clientY - rect.top };
}

function canvasClick(event) {
  let { x, y } = getMousePos(event);
  points.push(new Point(x, y));
  draw();
  if (points.length == 6) {
    canvas.removeEventListener("click", canvasClick);
    canvas.removeEventListener("mousemove", canvasMove);
    control();
  }
}

function canvasMove(event) {
  let { x, y } = getMousePos(event);
  position = new Point(x, y);
  draw();
}
