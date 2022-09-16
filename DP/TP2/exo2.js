"use strict"

function List(...values) {

    this.isEmpty = function isEmpty() {
        return this.head === null;
    }

    this.add = function add(...values) {
        values.reverse()
        for (let val of values) {
            this.head = { value: val, next: this.head }
        }
    }

    this.get = function get(indice) {
        let maillon = this.head
        while (maillon != null && indice != 0) {
            maillon = maillon.next
            indice--
        }
        if (maillon === null) {
            return undefined
        }
        return maillon.value
    }

    this.head == null
    this.add(...values)
}

/*
let l = new List();
alert(l.isEmpty()); // true
l.add(3);
l.add(2);
l.add(1);
alert(l.isEmpty()); // false
alert(`${l.get(0)}, ${l.get(1)}, ${l.get(2)}`); // 1, 2, 3
alert(`${l.get(-1)}, ${l.get(3)}, ${l.get(null)}`); // undefined, undefined, undefined

let l2 = new List(4, 5, 6);
l2.add(1, 2, 3);
alert([0, 1, 2, 3, 4, 5].map((i) => l2.get(i))); // [1, 2, 3, 4, 5, 6]
*/

function getIterator(list) {
    return 
}

let l2 = new List(4, 5, 6);
l2.add(1, 2, 3);
function toArray(list) {
    let iterator = getIterator(list);
    let array = [];
    for (let { done, value } = iterator.next();
        !done;
        { done, value } = iterator.next()) {
        array.push(value);
    }
    return array;
}
alert(toArray(l2)); // [1, 2, 3, 4, 5, 6]