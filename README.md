# 🧪 SauceDemo Automation Project – Selenium + Java + TestNG + POM

A test automation project for [SauceDemo](https://www.saucedemo.com), covering login, cart operations, and checkout flow using:
- Selenium WebDriver
- Java
- TestNG (with groups: positive, negative)
- Page Object Model (POM)
- WebDriverManager

---

## 🔧 Tech Stack
- Java 8+
- Maven
- Selenium WebDriver
- TestNG
- WebDriverManager

---

## 📁 Project Structure
    src/
    ├── main/java/pages/
    │ ├── LoginPage.java
    │ ├── InventoryPage.java
    │ ├── CartPage.java
    │ └── CheckoutPage.java
    ├── test/java/tests/
    │ ├── BaseTest.java
    │ ├── LoginTest.java
    │ ├── InventoryTest.java
    │ ├── CartTest.java
    │ └── CheckoutTest.java

---

## ✅ Test Scenarios Covered

| Test Case                            | Group     |
|-------------------------------------|-----------|
| Login with valid credentials        | positive  |
| Login with invalid credentials      | negative  |
| Add item to cart                    | positive  |
| Proceed to checkout with item       | positive  |
| Proceed to checkout without item    | negative  |
| Complete checkout with valid data   | positive  |
| Checkout with empty form            | negative  |

---

## 🚀 How to Run


# Run all tests
```bash
mvn clean test
```

# Run via TestNG
Right click testng.xml → Run
---

# 👩‍💻 Author
Swathi Thoorpati – QA Automation Engineer in the making 💥

📷 Optional Add-ons
  - Extent Reports
  - CI/CD with Jenkins
  - Data-driven testing
