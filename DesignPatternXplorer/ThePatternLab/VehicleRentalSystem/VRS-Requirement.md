
---

### 🎯 Scenario: **Vehicle Rental System**

#### 🚘 Context
You're building a module for a **vehicle rental platform** like ZoomCar or Drivezy.
User can rent different types of vehicles, and your job is to **dynamically create vehicle objects** 
based on user input without exposing the instantiation logic directly.

---

### 🛠️ Requirements (Functional)

1. User can rent **Car**, **Bike**, or **Truck**.
2. Each vehicle must have:
    - `getType()`: returns `"Car"`, `"Bike"`, or `"Truck"`
    - `getRentalPricePerHour()`: returns a price (e.g., 50 for bike, 200 for car, 500 for truck)
3. You must create a **VehicleFactory** that returns the appropriate object based on a string input (e.g., `"bike"`).

---

### 🎯 Bonus Requirements (if time allows)

- Add a feature where new vehicle types (e.g., `"Scooter"`, `"SUV"`) can be added with minimal code changes.
- Add a method like `calculateRentalCost(int hours)` to each vehicle type.
- Add unit tests using JUnit.

---

### 🧱 Constraints

- Do **not** use `if-else` or `switch` inside client code.
- Avoid using frameworks—just plain Java.

---

### 🧪 Test Case Ideas

1. Create a `Vehicle` using the factory and print the type and price.
2. Pass an invalid string and ensure the factory handles it gracefully.
3. Add a new vehicle type (`SUV`) and verify it works without touching the factory logic too much (bonus).

---