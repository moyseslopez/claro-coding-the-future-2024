# Claro Coding The Future Java com Spring 2024
Java Restful API criada para o curso Claro Coding The Future Java com Spring de 2024

# Diagrama de Classes
```mermaid
classDiagram
    class User {
        +String id
        +String name
        +String email
        +String password
        +String birthDate
        +List~Task~ tasks
    }

    class Task {
        +String id
        +String name
        +String description
        +String status
    }

    User "1" * --> "0..*" Task : has
```mermaid
