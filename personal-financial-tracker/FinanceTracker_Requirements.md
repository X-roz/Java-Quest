# 💸 Personal Finance Tracker with Smart Rules Engine

## 📝 Project Summary
A backend system for a Personal Finance Tracker application. Users can track income and expenses, categorize transactions, set budgets, get alerts, and define custom rules for analyzing their financial behavior. The project leverages Java functional programming and Spring Boot with a focus on clean low-level design.

---

## ✅ Core Functional Requirements

### 1. User Authentication & Authorization
- Sign up and log in using JWT-based authentication (optional: Spring Security).
- Each user has their own set of data (transactions, budgets, rules).

### 2. Transaction Management
- Add, update, delete transactions.
- Transactions can be income or expense.
- Categorize each transaction (Food, Rent, Travel, etc.)
- Fetch transactions by time period and/or category.

### 3. Budgeting System
- Set monthly budgets per category.
- Track budget usage per category.
- Alert if user exceeds category budget.

### 4. Smart Rules Engine (Functional Programming Focus)
- Users can create custom rules using conditions.
  - Example rules:
    - “If spending on Food > ₹5,000 in a month, alert me.”
    - “Flag any single transaction > ₹10,000.”
- Rule logic implemented using Java functional interfaces (`Predicate`, `Function`, etc.)
- Rules applied dynamically over transaction streams.

### 5. Analytics
- Generate monthly summary: total income, total expenses.
- Category-wise breakdown.
- Trend analysis (optional).

---

## 📚 Non-Functional Requirements
- Backend REST API built with Spring Boot.
- Data persistence using Spring Data JPA (H2 or PostgreSQL).
- Basic validation and exception handling.
- Swagger/OpenAPI documentation (optional).

---

## 🗂️ Suggested Package Structure

```
com.financeapp
├── controller         # REST controllers
├── service            # Business logic
├── repository         # JPA repositories
├── model              # Entity classes
│   └── enums          # Enum types (e.g., Category, TransactionType)
├── dto                # Data Transfer Objects
├── config             # Configuration classes
├── security           # (Optional) JWT and authentication logic
├── ruleengine         # Rule evaluation logic using functional programming
```

---

## 🔧 Optional Enhancements
- Scheduled alerts using Spring Scheduler.
- Transaction import from CSV.
- Integration with external APIs for bank data (mocked).
- Admin dashboard (basic auth) to view usage stats.