#serveur UDP

from socket import *

mysocket = socket(AF_INET6, SOCK_DGRAM, IPPROTO_UDP)
mysocket.bind(('::', 32000))

while (True):

    (message, adresse_client) = mysocket.recvfrom(60)
    print("Message reçu : " + message.decode())
    mysocket.sendto(message, adresse_client)
    print("Message envoyé !")

mysocket.close()
