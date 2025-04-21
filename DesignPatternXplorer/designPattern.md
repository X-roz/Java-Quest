# 📘 Design Pattern Xplorer

Explore core design patterns in Java with brief definitions and categorized structure.

🔗 [Code Link](https://github.com/X-roz/Java-Quest/tree/main/DesignPatternXplorer/src)

---

## 📌 Types of Design Patterns

Design patterns are categorized into three main types:

---

### 1. Creational Patterns 🏗️
These patterns focus on object creation mechanisms, trying to create objects in a manner suitable to the situation.

- **Singleton** – Ensures a class has only one instance and provides a global access point.
    - **Eager Initialization** – Instance is created at the time of class loading.
    - **Static Block** – Instance is created in a static block, allowing exception handling.
    - **Lazy Initialization** – Instance is created when requested.
    - **Thread-Safe** – Handles multi-threading while creating the instance.
    - **Double-Check Lock** – Reduces the overhead of synchronized access.

- **Factory** – Defines an interface for creating objects, but lets subclasses alter the type of objects that will be created.

- **Abstract Factory** – Produces families of related or dependent objects without specifying their concrete classes.

- **Builder** – Separates the construction of a complex object from its representation.

- **Prototype** – Creates new objects by copying an existing object, known as the prototype.

---

### 2. Structural Patterns 🧱
These patterns deal with object composition, ensuring that if one part of a system changes, the entire structure doesn't need to.

- **Adapter** – Allows incompatible interfaces to work together.

- **Bridge** – Decouples an abstraction from its implementation so that the two can vary independently.

- **Facade** – Provides a simplified interface to a complex subsystem.

- **Decorator** – Adds new behaviors to objects dynamically without altering their structure.
