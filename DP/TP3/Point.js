export class Point {
    #x
    #y
    constructor(x, y) {
        this.#x = x
        this.#y = y
    }

    get x() { return this.#x }
    get y() { return this.#y }
}

/*
let point = new Point(0, 1);
alert(`Point de coordonnées (${point.x}, ${point.y})`); 
*/