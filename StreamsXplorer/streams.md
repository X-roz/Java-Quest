# Java Streams (Functional Programming)

This guide covers Java Streams, a key feature introduced in Java 8 to support functional-style operations on collections.

## What is a Stream?
- A **Stream** is a sequence of elements supporting sequential and parallel aggregate operations.
- It **does not** store data.
- It **does not** modify the original data structure.

## Why Streams?
- Concise and readable code.
- Easy data manipulation (filtering, mapping, reducing).
- Enables functional programming in Java.
- Supports parallel execution.

---

## Key Concepts

### Stream Pipeline
- **Source**: The origin of data for the stream.
- **Intermediate Operations**: Operations that transform a stream without consuming it.
- **Terminal Operations**: Operations that produce a result or side-effect and terminate the stream.

---

## Common Stream Operations

### 1. Creating Streams
Streams can be created from collections, arrays, or explicitly using static methods.

- **collection.stream()**: Convert list,set,Map to a stream
- **Stream.of()**: create a stream of values
- **Arrays.stream()**: Efficient for primitive arrays to stream
- **Stream.builder()**: Manually construct a stream
- **Stream.generate()**: Infinite stream using random values
- **Stream.iterate()**: Infinite stream using pattern (I want a stream of multiple of 5 only)
- **IntStream.range()**: Number range stream


### 2. Intermediate Operations
- **filter(Predicate)**: Selects elements that match a condition.
- **map(Function)**: Transforms each element.
- **sorted()**: Sorts the elements.
- **distinct()**: Removes duplicates.

### 3. Terminal Operations
- **forEach(Consumer)**: Performs an action for each element.
- **collect(Collector)**: Accumulates elements into a collection.
- **reduce(BinaryOperator)**: Reduces elements to a single value.
- **count()**: Counts the number of elements.

### 4. Parallel Streams
Streams that divide the workload across multiple threads for potential performance gain.

---

## Advanced Usage

### 1. flatMap()
Flattens a complex structure into a single stream of elements.

### 2. Collectors
Utilities to collect stream elements into collections or summarize them.

### 3. Primitive Streams
Specialized streams (`IntStream`, `LongStream`, `DoubleStream`) for better performance with primitives.

---

## Best Practices
- Prefer method references for clarity.
- Keep streams short and readable.
- Benchmark before using parallel streams.
- Avoid side-effects inside streams.

---

## Why we need to use Functional Programming ?
- Declarative style - Focus on what needs to be done instead of how, making code cleaner and easier to understand.
- Immutability - Data is not modified, reducing unexpected side effects and makes debugging easier.
- Concise code - Less boilerplate compared to traditional loops and conditions.
- Thread safety - No shared state means safer parallel execution without race conditions.
- Parallel processing - Improves performance

---

> "Think of streams as a pipeline: source -> operations -> result."
