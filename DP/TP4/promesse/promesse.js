function delay(ms) {
    return new Promise((resolve) => {
        return setTimeout(resolve, ms)
    })
}


delay(1000).then(
    () => {
        let msg = prompt("Saisissez un message : ")
        if (msg != null) {
            delay(1000).then(() => alert(msg))
        } else {
            throw new Error
        }
    }
).catch(() => alert("Erreur"))

