import { Point } from "./Point.js"
import { Vecteur } from "./Vecteur.js"
import { GeometrieErreur } from "./GeometrieErreur.js"


export class Segment {
    #a
    #b
    constructor(a, b) {
        if (a instanceof Point && b instanceof Point) {
            this.#a = a
            this.#b = b
        } else {
            throw new GeometrieErreur("Paramètres du constructeur de Segment incorrects.\n");
        }
    }

    intersecte(that) {
        let a = this.#a
        let b = this.#b
        let c = that.a
        let d = that.b
        let aDemiPlanGauche = Vecteur.position(c, d, a) > 0
        let bDemiPlanGauche = Vecteur.position(c, d, b) > 0
        let cDemiPlanGauche = Vecteur.position(a, b, c) > 0
        let dDemiPlanGauche = Vecteur.position(a, b, d) > 0
        return aDemiPlanGauche != bDemiPlanGauche && cDemiPlanGauche != dDemiPlanGauche
    }

    get a() { return this.#a }
    get b() { return this.#b }
}

/*
let a = new Point(1, 0);
let b = new Point(-1, 0);
let c = new Point(0, 1);
let d = new Point(0, -1);
let s1 = new Segment(a, b);
let s2 = new Segment(c, d);
let s3 = new Segment(a, c);
let s4 = new Segment(b, d);
alert(s1.intersecte(s2)); // true 
alert(s3.intersecte(s4)); // false 
*/