import { fstat, readdir, stat } from "fs";
import { createServer } from "http";

let server = createServer((request, response) => {
    let racine = "C:/Users/Amaroke/Documents/Fac"
    let url = (racine + request.url)

    response.writeHead(200, { "Content-Type": "text/html; charset=utf-8" });

    response.write('<ul>')
    readdir(url, (err, files) => {
        if (err)
            console.log(err);
        else {
            files.forEach(file => {
                let fileName = file.toString()
                if (fileName != "desktop.ini" && fileName != "favicon.ico") {
                    stat(url + fileName, async (error, stats) => {
                        if (error) {
                          console.log(error);
                        }
                        else {
                          console.log("Path is file:", stats.isFile());
                          console.log("Path is directory:", stats.isDirectory());
                        }
                      });
                    let requestURL;
                    if (request.url == "/") {
                        requestURL = request.url
                    } else {
                        requestURL = request.url + "/"
                    }
                    response.write(`<li><a href="${(requestURL + fileName)}">${fileName}</li>`);
                }
            })

        }
        response.write('</ul>')
        response.end();
    })

});

server.listen(8500); // start ! 
console.log("Serveur lancé.");

/*TODO
Problème avec les accents et les espaces dans les répertoires/fichiers (utilisser la classe URL ?).
Pas d'ouverture de fichiers.
"Pour envoyer un fichier vers le client, il faut ouvrir un flux sur celui-ci puis appeler la méthode pipe avec 
pour argument la réponse. Il ne faudra pas utiliser write et end dans ce cas (pipe les gère automatiquement)."
"Pour envoyer un fichier vers le client, il faut également préciser son type dans la réponse. Jetez un oeil au 
module mime pour cela. "
*/
