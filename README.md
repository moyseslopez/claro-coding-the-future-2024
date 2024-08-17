# Claro Coding The Future Java com Spring 2024
Java Restful API criada para o curso Claro Coding The Future Java com Spring de 2024

# Diagrama de Classes
```mermaid
classDiagram
    class User {
        +Long id
        +String name
        +String email
        +String password
        +String birthDate
        +List~Task~ tasks
    }

    class Task {
        +Long id
        +String title
        +String description
        +String deadline
        +String status
    }

    User "1" * --> "0..*" Task : has
```mermaid
