# Problem Statement: Abstract Factory Pattern - Vehicle Manufacturing System

## Overview

You are tasked with designing a **Vehicle Manufacturing System** for an international automotive company. The company produces multiple **types of vehicles** (Car, Bike, Truck) across **different regional markets** (India, USA, Europe). Each market has **region-specific requirements and configurations** for the vehicles, such as emission norms, steering configuration (left/right), and feature sets.

To support **scalability and regional customization**, the system must allow for:

- Creating families of related objects (Car, Bike, Truck) tailored to each region.
- Abstracting away the instantiation logic so client code remains unaware of the concrete classes being used.
- Easily adding new regions or vehicle types in the future.

## Requirements

1. Each region has its own **regional factory** (e.g., `IndiaVehicleFactory`, `USAVehicleFactory`, `EuropeVehicleFactory`).
2. Each regional factory must be able to produce:
    - A region-specific **Car**
    - A region-specific **Bike**
    - A region-specific **Truck**
3. All vehicle types implement a common interface (e.g., `Car`, `Bike`, `Truck`) to ensure uniform behavior.
4. The client should interact with a single **Abstract Factory Interface** that defines methods like `createCar()`, `createBike()`, and `createTruck()`.

## Objective

Design this system using the **Abstract Factory Pattern** such that:

- The **creation logic** for each vehicle is hidden from the client.
- The client can easily switch between different regional factories at runtime.
- Adding a new region or vehicle type requires minimal changes to existing code.

## Example Use Case

A user selects the "USA" region in the UI. The system should internally use the `USAVehicleFactory` to create region-appropriate `Car`, `Bike`, and `Truck` objects without the user or client code knowing the internal details.

