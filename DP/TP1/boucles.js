"use strict;"

function forRange(i, j, process) {
    if (i == j) {
        process(i)
    } else {
        process(i)
        forRange(i + 1, j, process)
    }
}

function forStep(val, pred, process, next) {
    if (pred(val)) {
        process(val)
    } else {
        forStep(next(val), pred, process, next)
    }
}

function forRangeFilter(i, j, pred, processTrue, processFalse) {
    if (i == j) {
        return 0
    } else if (pred(i)) {
        processTrue(i)
        forRangeFilter(i + 1, j, pred, processTrue, processFalse)
    } else {
        processFalse(i)
        forRangeFilter(i + 1, j, pred, processTrue, processFalse)
    }
}

 
alert("Test de forRange de 0 à 5")
forRange(0, 5, function (val) { alert(val) })
alert("Test de forStep depuis 1 (doit afficher le premier multiple de 3)")
forStep(1, function (val) { return val % 3 == 0 }, function (val) { alert(val) }, function (val) { return val + 1 })
alert("Test de forRangeFilter de 0 à 10 (doit afficher les multiples de 3)")
forRangeFilter(0, 10, function (val) { return val % 3 == 0 }, function (val) { alert("" + val + " est un multiple de 3") }, function (val) { alert("" + val + " n'est pas un multiple de 3") })