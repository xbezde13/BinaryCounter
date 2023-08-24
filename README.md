# Logic Gates and Binary Counters

This project implements various logic gates and binary counters using Java. The goal of the project is to provide a comprehensive set of classes and methods to simulate the behavior of logic gates and binary counters commonly used in digital circuits.

## Table of Contents

- [Logic Gates](#logic-gates)
  - [NAND Gate](#nand-gate)
  - [AND Gate](#and-gate)
  - [OR Gate](#or-gate)
  - [NOR Gate](#nor-gate)
  - [XOR Gate](#xor-gate)
- [Latch and Flip-Flop](#latch-and-flip-flop)
  - [Gated D-Latch](#gated-d-latch)
  - [Master-Slave D Flip-Flop](#master-slave-d-flip-flop)
- [Binary Counters](#binary-counters)
  - [One-Bit Binary Counter](#one-bit-binary-counter)
  - [Four-Bit Binary Counter](#four-bit-binary-counter)
- [Main Class](#main-class)
- [Usage](#usage)

## Logic Gates

The project includes implementations of common logic gates:

### NAND Gate

A NAND gate returns the logical negation of the conjunction of its inputs.

### AND Gate

An AND gate returns true only if all of its inputs are true.

### OR Gate

An OR gate returns true if at least one of its inputs is true.

### NOR Gate

A NOR gate returns the logical negation of the disjunction of its inputs.

### XOR Gate

An XOR gate returns true if the number of true inputs is odd.

## Latch and Flip-Flop

The project includes implementations of latch and flip-flop circuits:

### Gated D-Latch

A gated D-latch is a simple memory circuit that can store one bit of data. It has an enable input that controls when data is latched.

### Master-Slave D Flip-Flop

A master-slave D flip-flop is a sequential circuit that can store one bit of data. It consists of two D-latches connected in series to avoid the "race condition" that can occur in simple D-latches.

## Binary Counters

The project includes binary counters:

### One-Bit Binary Counter

A one-bit binary counter is the simplest form of a counter. It toggles between 0 and 1 on each clock cycle.

### Four-Bit Binary Counter

A four-bit binary counter is composed of four one-bit binary counters. It counts from 0 to 15 in binary representation.

## Main Class

The `Main` class provides a demonstration of the Four-Bit Binary Counter. It simulates clock cycles and displays the binary count and its decimal equivalent.

## Usage
### Using an Integrated Development Environment (IDE)
1. Clone this repository to your local machine.
2. Open the project in your preferred Java IDE.
3. Navigate to the `Main` class and run it.
4. Observe the output that demonstrates the behavior of the Four-Bit Binary Counter.
### Using Maven Commands
1. Clone this repository to your local machine.
2. Open the terminal or command prompt and navigate to the project's root directory.
3. **Build**: To build the project, run the following Maven command:
```console
mvn clean install
```
4. **Test**: Run unit tests using the following Maven command:
```console
mvn test
```
5. **Clean**: To remove compiled artifacts, use this Maven command:
```console
mvn clean
```
6. **Run**: Execute the application using the Maven command:
```console
mvn exec:java
```
Feel free to explore the various logic gates, latch, flip-flop, and binary counter classes in the project to understand their implementations and usage.