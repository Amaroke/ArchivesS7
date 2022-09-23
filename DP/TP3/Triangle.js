import { Point } from "./Point.js"
import { Vecteur } from "./Vecteur.js"
import { Segment } from "./Segment.js"
import { GeometrieErreur } from "./GeometrieErreur.js"

export class Triangle {
    #a
    #b
    #c
    constructor(a, b, c) {
        if (a instanceof Point && b instanceof Point && c instanceof Point) {
            this.#a = a
            this.#b = b
            this.#c = c
        } else {
            throw new GeometrieErreur("Paramètres du constructeur de Triangle incorrects.\n");
        }
    }

    estInterieur(point) {
        let a = this.#a
        let b = this.#b
        let c = this.#c
        let pos = Vecteur.position
        let pointDansAB = pos(a, b, point) > 0
        let pointDansBC = pos(b, c, point) > 0
        let pointDansCA = pos(c, a, point) > 0
        return (pointDansAB == pointDansBC && pointDansBC == pointDansCA)
    }

    intersecte(that) {
        // ABC et DEF
        let dDansABC = this.estInterieur(that.a)
        let eDansABC = this.estInterieur(that.b)
        let fDansABC = this.estInterieur(that.c)
        let aDansDEF = that.estInterieur(this.a)
        let bDansDEF = that.estInterieur(this.b)
        let cDansDEF = that.estInterieur(this.c)
        let AB = new Segment(this.a, this.b)
        let BC = new Segment(this.b, this.c)
        let CA = new Segment(this.c, this.a)
        let DE = new Segment(that.a, that.b)
        let EF = new Segment(that.b, that.c)
        let FD = new Segment(that.c, that.a)
        let ABintersectDE = AB.intersecte(DE)
        let BCintersectDE = BC.intersecte(DE)
        let CAintersectDE = CA.intersecte(DE)
        let ABintersectEF = AB.intersecte(EF)
        let BCintersectEF = BC.intersecte(EF)
        let CAintersectEF = CA.intersecte(EF)
        let ABintersectFD = AB.intersecte(FD)
        let BCintersectFD = BC.intersecte(FD)
        let CAintersectFD = CA.intersecte(FD)
        return (dDansABC || eDansABC || fDansABC) || (aDansDEF || bDansDEF || cDansDEF) || (ABintersectDE && BCintersectDE && CAintersectDE && ABintersectEF && BCintersectEF && CAintersectEF && ABintersectFD && BCintersectFD && CAintersectFD)
    }

    get a() { return this.#a }
    get b() { return this.#b }
    get c() { return this.#c }
}

/*
let a = new Point(1, -1);
let b = new Point(-1, -1);
let c = new Point(0, 2);
let d = new Point(0, 0);
let e = new Point(1, 1);
let t = new Triangle(a, b, c);
alert(t.estInterieur(d)); // true 
alert(t.estInterieur(e)); // false 

let t1 = new Triangle(new Point(-2, -2), new Point(2, -2), new Point(0, 2));
let t2 = new Triangle(new Point(-2, 2), new Point(2, 2), new Point(0, -2));
let t3 = new Triangle(new Point(-3, 3), new Point(3, 3), new Point(0, -3));
let t4 = new Triangle(new Point(1000, 0), new Point(1001, 0), new Point(1000, 1));
alert(t1.intersecte(t2)); // true 
alert(t1.intersecte(t3)); // true 
alert(t1.intersecte(t4)); // false 
*/