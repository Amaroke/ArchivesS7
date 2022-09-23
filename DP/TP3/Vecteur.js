import { Point } from "./Point.js";
import { GeometrieErreur } from "./GeometrieErreur.js"

export class Vecteur {
    #a
    #b
    constructor(a, b) {
        if (a instanceof Point && b instanceof Point) {
            this.#a = b.x - a.x
            this.#b = b.y - a.y
        }
        else if (typeof a === "number" && typeof b === "number") {
            this.#a = a
            this.#b = b
        }
        else {
            throw new GeometrieErreur("Paramètres du constructeur de Vecteur incorrects.\n");
        }
    }

    get a() { return this.#a }
    get b() { return this.#b }

    determinant(that) {
        return this.#a * that.b - that.a * this.#b
    }

    static position(a, b, c) {
        let ab = new Vecteur(a,b)
        let bc = new Vecteur(b,c)
        return ab.determinant(bc)
    }
}

/*
let a = new Point(0, 1);
let b = new Point(1, 0);
//let v1 = new Vecteur(1, -1); // le vecteur de coordonnées (1, -1) 
//let v2 = new Vecteur(a, b); // aussi le vecteur de coordonnées (1, -1) 
let v3 = new Vecteur(1, b); // erreur 

let v1 = new Vecteur(1, 2); 
let v2 = new Vecteur(1, 1); 
alert(v1.determinant(v2)); // affiche -1 

let a = new Point(0, 0); 
let b = new Point(1, 0); 
let c = new Point(0, 1); 
alert(Vecteur.position(a, b, c) > 0); // true 
alert(Vecteur.position(a, c, b) < 0); // true 
alert(Vecteur.position(a, b, b) == 0); // true 
*/