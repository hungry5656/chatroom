# chatroom: a java based and client-server based chat project

## Author:
- Sizhuo Sun

## Basic Structure
```plaintext
chatroom (parent project)
├── chatclient (client to login and send message)
│   ├── cli
│   ├── components
│   │   ├── login
│   │   ├── logout
│   │   └── userClient
│   ├── connector
│   ├── core
│   ├── gui
│   └── thread
├── chatserver (Singleton Server for chat message passing and collecting)
│   ├── api
│   │   └── rpc
│   ├── cli
│   │   ├── command
│   │   │   ├── Command (Interface)
│   │   │   │   ├── StartServerCommand
│   │   │   │   ├── StopServerCommand
│   │   │   │   └── more Commands ...
│   │   └── CLIServer
│   ├── components
│   │   ├── chat
│   │   ├── config
│   │   ├── message
│   │   └── user
│   ├── core
│   │   ├── ChatServer
│   │   └── MultithreadingBridge
│   ├── io
│   │   ├── database
│   │   └── textfile
│   └── state
│       ├── connection
│       │   ├── ConnectionState (Interface)
│       │   └── more ConnectionState ...
│       └── server
│           ├── ServerState (Interface)
│           └── more ServerState ...
├── grpc (Module for communication)

```

## Technical Stack
- Structure: Client-Server for the whole app
- RPC: gRPC
- Database: now: local, future: remote(distributed)
- unit testing: Not Implemented

## On going Tasks
- Create maven site for the projects (Documentation)
- - multimodule site and stacked with one parent page, then published to the github page
- - possible link: https://hungry5656.github.io/chatroom
- Add grpc service for login to server and establish connection with the server (grpc)
- Add grpc service for connecting with the other client (grpc)
- create test for message passing grpc service that is already written (grpc)
- implement components in the chatserver (chatserver)