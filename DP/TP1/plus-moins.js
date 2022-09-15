"use strict;" 

function randInt(from, to) {
    if (to == null) {
        to = from
        from = 0
    }
    return Math.floor(Math.random() * (to - from + 1)) + from
}

function demarrerPartie(max) {
    let aTrouver = randInt(max)
    let trouve = false
    let nbessais = 0
    let quitter = false
    while (!trouve && !quitter) {
        essai = prompt("Devinez le nombre entre 0 et " + max + " : ")
        quitter = essai === null
        if(essai.trim() === "") {
            essai = NaN
        }
        if (Number.isInteger(+essai)) {
            nbessais++
            if (!quitter) {
                trouve = essai == aTrouver
                if (trouve) {
                    alert("C'est trouvé ! En " + nbessais + " tentatives !")
                } else if (essai > aTrouver) {
                    alert("C'est moins !")
                } else {
                    alert("C'est plus !")
                }
            } else {
                quitter = confirm("Voulez-vous vraiment quitter la partie ?")
            }
        } else {
            alert("Attention, vous n'avez pas saisi un entier ! Rejouez !")
        }

    }
}

let rejouer = true
while (rejouer) {
    demarrerPartie(5)
    rejouer = confirm("Voulez-vous rejouer ?")
}