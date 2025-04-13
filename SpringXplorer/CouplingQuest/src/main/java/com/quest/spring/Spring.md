# Spring Core Concepts

## Terminologies

**Dependency** – `GameRunner` is dependent on `GameConsole` to start the game.

      GameRunner
        |
      GameConsole
       |       | 
     Mario    Contra


## @Component

Classes annotated with `@Component` are detected by Spring and managed as beans. When the application starts, Spring creates instances of these component classes.

## @ComponentScan

By default, Spring scans the current package where the class annotated with `@ComponentScan` is located.  
You can also explicitly provide other packages to include additional component classes that are outside the default classpath.

## Dependency Injection (DI)

Spring identifies beans and their dependencies and injects them automatically.

For instance:
- Spring creates a bean for `GameRunner`, which depends on `GameConsole`. It injects this dependency through the constructor.
- `Mario` implements `GameConsole`. When annotated with `@Component`, Spring can inject a `Mario` instance into `GameRunner`.

### Types of Dependency Injection

1. **Constructor-based injection** – *Recommended*, as it ensures that all required dependencies are set at the time of object creation.
2. **Setter-based injection**
3. **Field injection** – Uses reflection and is generally not recommended due to issues with testing and immutability.

## Inversion of Control (IoC)

IoC is the principle of delegating control to the Spring container. Instead of the application managing its dependencies, the container does it.

## IoC Container

Manages the life cycle of beans and handles dependency injection automatically.

## Major Spring Modules

1. **Core** – IoC containers, BeanFactory, ApplicationContext
2. **Testing** – Mock objects, Spring MVC Test
3. **Web** – Spring MVC
4. **Data Access** – JDBC, JPA
5. **Reactive Web** – Spring WebFlux
6. **Integration** – JMS, Messaging

---

## Understanding @Component Logic with Scenarios

### Scene 1: Missing Component

- `GameRunner` has a constructor that depends on `GameConsole`.
- No `@Component` annotation is present on any class implementing `GameConsole`.

**Error:**
Parameter 0 of constructor in GameRunner required a bean of type 'GameConsole' that could not be found.

**Solution:**
Annotate a class implementing `GameConsole` (e.g., `Mario`) with `@Component`.

---

### Scene 2: Multiple Matching Components

- `GameRunner` depends on `GameConsole`.
- Both `Mario` and `Contra` implement `GameConsole` and are annotated with `@Component`.

**Error:**
Parameter 0 of constructor in GameRunner required a single bean, but 2 were found: Mario and Contra.


**Solution:**
- Mark one of them with `@Primary` to indicate the preferred bean.
- Alternatively, use `@Qualifier` to specify which implementation to inject.

---

### Best Practices

- Use **constructor-based DI** for mandatory dependencies.
- Use `@Primary` or `@Qualifier` when multiple beans of the same type exist.
- Always annotate your component classes properly for Spring to detect them.

