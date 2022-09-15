#client UDP

from socket import *
import sys

mysocket = socket(AF_INET6, SOCK_DGRAM, IPPROTO_UDP)

sent = mysocket.sendto(b"Salut !", (sys.argv[1], 32000, 0, 2))

(resultat, adresse_serveur) = mysocket.recvfrom(60)

print(resultat.decode())

mysocket.close()
