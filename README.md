# 🏧 ATM Management System

A Java-based ATM Management System project developed to simulate real-world banking operations such as account creation, balance enquiry, deposit, withdrawal, mini statement generation, and PIN management.

---

# 📌 Features

* User Login Authentication
* Create Bank Account
* Deposit Money
* Withdraw Money
* Balance Enquiry
* Mini Statement
* PIN Change Functionality
* Transaction History
* MySQL Database Integration
* Secure Backend Connectivity using JDBC

---

# 🛠️ Tech Stack

## Frontend

* Java Swing / AWT

## Backend

* Java
* JDBC

## Database

* MySQL

## Tools & IDE

* Eclipse IDE
* MySQL Workbench
* Git & GitHub

---

# 📂 Project Structure

```bash
ATM-Management-System/
│
├── src/
│   ├── Login.java
│   ├── Signup.java
│   ├── Transactions.java
│   ├── Deposit.java
│   ├── Withdraw.java
│   ├── BalanceEnquiry.java
│   ├── MiniStatement.java
│   └── Conn.java
│
├── icons/
├── README.md
└── database.sql
```

---

# ⚙️ Installation & Setup

## 1️⃣ Clone the Repository

```bash
git clone https://github.com/your-username/your-repository-name.git
```

## 2️⃣ Open Project in Eclipse

* Open Eclipse IDE
* Click on `File → Import`
* Select `Existing Projects into Workspace`
* Choose the cloned project folder

---

## 3️⃣ Configure MySQL Database

Create a database in MySQL:

```sql
CREATE DATABASE atm_system;
```

Use the database:

```sql
USE atm_system;
```

Create required tables according to your project structure.

---

## 4️⃣ Update Database Credentials

Open `Conn.java` and update:

```java
String url = "jdbc:mysql://localhost:3306/atm_system";
String user = "root";
String password = "your_password";
```

---

## 5️⃣ Run the Project

* Run `Login.java`
* Start using the ATM system

---

# 📸 Project Screenshots

Add your screenshots here:

```md
![Login Screen](screenshots/login.png)
![Transaction Screen](screenshots/transactions.png)
```

---

# 🚀 Future Enhancements

* OTP Verification
* Card Generation System
* Online Banking Integration
* Admin Dashboard
* Mobile App Version
* Transaction PDF Receipt
* Email & SMS Notifications

---

# 🧠 Learning Outcomes

This project helped in understanding:

* Core Java Concepts
* OOP Principles
* JDBC Connectivity
* MySQL Database Operations
* GUI Development using Swing
* CRUD Operations
* Exception Handling
* Project Structure & Debugging

---

# 🤝 Contributing

Contributions are welcome.

1. Fork the repository
2. Create your feature branch
3. Commit your changes
4. Push to the branch
5. Open a Pull Request

---

# 📜 License

This project is created for learning and educational purposes.

---

# 👨‍💻 Author

Bhaskar Reddy

* GitHub: [https://github.com/](https://github.com/)
* LinkedIn: [https://linkedin.com/](https://linkedin.com/)

---

# ⭐ Support

If you like this project, give it a ⭐ on GitHub.
