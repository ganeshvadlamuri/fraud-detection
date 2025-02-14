# 🚀 Fraud Detection API

This is a **Spring Boot** project that detects fraudulent transactions based on **amount limits** and **suspicious activity timing**.

## 🛠 Features
- ✅ **Create transactions** via API (`POST /transactions`)
- ✅ **View all transactions** (`GET /transactions`)
- ✅ **Check for fraud** based on:
  - Transactions **above $5000**
  - **Rapid multiple transactions** (within 10 seconds)
- ✅ **Built-in H2 database** for easy testing

---

## 🏗 Tech Stack
- **Java 17** ☕
- **Spring Boot** 🚀
- **Spring Data JPA (Hibernate)**
- **H2 Database (In-memory)**
- **Maven**

---

## 📌 API Endpoints

| Method | Endpoint                | Description                 |
|--------|-------------------------|-----------------------------|
| `POST`  | `/transactions`         | Add a new transaction       |
| `GET`   | `/transactions`         | Get all transactions        |
| `GET`   | `/transactions/{userId}` | Get transactions by user    |
| `GET`   | `/transactions/fraudulent` | Get only fraudulent transactions |

### **Example Transaction (JSON)**
```json
{
    "userId": "user123",
    "amount": 6000,
    "location": "New York",
    "timestamp": "2025-02-13T12:30:00"
}