"use strict"

/* 1.
new Object(objectToClone)
Object.assign({}, objectToClone)
let clone = {};
for(let key in objectToClone) {
    clone[key] = objectToClone[key]
}
*/

// 2.
function deepClone(objectToClone) {
    let clone = {};
    for (let key in objectToClone) {
        if (typeof objectToClone[key] == "object") {
            clone[key] = deepClone(objectToClone[key]);

        } else {
            clone[key] = objectToClone[key];
        }
    }
    return clone
}

let obj = {
    a: 1,
    b: { c: 2, d: 3 },
    e: null,
    f() {
        alert(this.a + this.b.c + this.b.d);
    },
};
let clone = deepClone(obj);
clone.f(); // 6
delete obj.b.c;
obj.f(); // NaN
clone.f(); // 6

// 3.
let circularObj = {};
circularObj.autoRef = circularObj;
deepClone(circularObj);

// 4. Ca "tourne en rond", une solution serait de stocker les objets parcourus dans une liste.