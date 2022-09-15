from socket import *

mysocket = socket(AF_INET6, SOCK_STREAM, IPPROTO_TCP)
mysocket.connect(('fe80::7686:e2ff:fe09:3dc5', 6667, 0, 2))

mysocket.send(b"USER Amaroke * * :Amaroke\r\n")
mysocket.send(b"NICK Amaroke\r\n")
mysocket.send(b"JOIN ##tprsxm1nancy\r\n")

while True:
    message = mysocket.recv(60)
    message = message.decode()
    if message[0] == 'P' and message[1] == 'I' and message[2] == 'N' and message[3] == 'G':
        print(message)
        mysocket.send(("PONG"+message[4:]).encode())
        print(("PONG"+message[4:]).encode())
    else:
        print(message)

mysocket.close()
