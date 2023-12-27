# chatroom: a java based and client-server based chat project

## Author:
- Sizhuo Sun

## Basic Structure
```plaintext
chatroom (parent project)
├── chatclient (client to login and send message)
│        ├── cli
│        ├── components
│        │       ├── login
│        │       ├── logout
│        │       └── userClient
│        ├── connector
│        ├── core
│        ├── gui
│        └── thread
├── chatserver (Singleton Server for chat message passing and collecting)
│       ├── api
│       │    ├── cli
│       │    └── rpc
│       ├── components
│       │        ├── chat
│       │        └── user
│       ├── core
│       └── io
│           ├── database
│           └── textfile
├── grpc (Module for communication)
```

## Technical Stack
- Structure: Client-Server for the whole app
- RPC: gRPC
- Database: now: local, future: remote(distributed)
- unit testing: Not Implemented

## S