"use strict;"

function toString(val) {
    if (typeof val === "string") {
        return "\"" + val + "\""
    }
    return String(val)
}

function test(val) {
    alert("valeur testée : val = " + val + "\n" + "!!val == val renvoie " + (!!val == val) + "\n" + "!(!val || !val) == (val && val) renvoie " + (!(!val || !val) == (val && val)) + "\n" + "!(!val || !val) === (val && val) renvoie " + (!(!val || !val) === (val && val)) + "\n")

    return true
}

test(false)
test("0")
test(true)
test("1")