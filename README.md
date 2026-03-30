#  Calculator Hub (Full Stack)

##  Project Overview
Calculator Hub is a full-stack web application built using Spring Boot (backend) and HTML, CSS, JavaScript (frontend).

It provides multiple real-world calculators categorized into finance, personal, health, and business domains. The backend exposes REST APIs, and the frontend consumes them for user interaction.

---

##  Features

###  Finance
- GST Calculator
- ROI Calculator
- Simple Interest
- Break-even
- EMI

###  Personal
- Date Difference
- Time Duration

###  Health
- BMI
- Calories
- Water Intake
- Pregnancy Due Date

###  Business
- Profit Margin
- Startup Valuation
- Cost Estimator

###  Extra
- History
- Filter
- Dashboard
- Delete Records

---

## ️ Tech Stack

###  Frontend
- HTML
- CSS
- JavaScript

###  Backend
- Java 17
- Spring Boot
- Spring Data JPA (Hibernate)
- MySQL

###  Tools
- Postman
- Git & GitHub

---

##  Project Structure

calculatorhub/
│
├── src/main/java/com/example/calculatorhub
│   ├── controller
│   ├── service
│   ├── repository
│   ├── entity
│
├── src/main/resources
│   ├── static
│   │   ├── index.html
│   │   ├── style.css
│   │   └── script.js
│   └── application.properties

---

##  Backend Setup

1. Clone the repository:
   git clone https://github.com/gudurusharathkumar/calculatorhub.git

2. Open project in IntelliJ / Eclipse

3. Configure MySQL in application.properties:

spring.datasource.url=jdbc:mysql://localhost:3306/calculatorhub  
spring.datasource.username=YOUR_USERNAME  
spring.datasource.password=YOUR_PASSWORD

spring.jpa.hibernate.ddl-auto=update

4. Run:
   CalculatorhubApplication.java

5. Server runs at:
   http://localhost:8080

---

##  Frontend

Frontend files are inside:
src/main/resources/static/

Open in browser:
http://localhost:8080

---

##  API Endpoints WITH DATA TYPES & UNITS

###  Finance

**GST Calculator**  
Input: amount (double, ₹), rate (double, %)  
Output: total amount (₹)  
/api/calculators/gst?amount=1000&rate=18

**ROI Calculator**  
Input: gain (double, ₹), investment (double, ₹)  
Output: ROI (%, double)  
/api/calculators/roi?gain=500&investment=2000

**Simple Interest**  
Input: p (double, ₹), r (double, %), t (double, years)  
Output: interest (₹)  
/api/calculators/interest?p=1000&r=10&t=2

**Break-even**  
Input: fixedCost (double, ₹), price (double, ₹/unit), variableCost (double, ₹/unit)  
Output: units (int/double)  
/api/calculators/break-even?fixedCost=10000&price=50&variableCost=30

**EMI**  
Input: principal (double, ₹), rate (double, %), time (double, years)  
Output: EMI per month (₹)  
/api/calculators/emi?principal=100000&rate=10&time=2

---

###  Personal

**Date Difference**  
Input: start (String, YYYY-MM-DD), end (String, YYYY-MM-DD)  
Output: days (long/int)  
/api/calculators/date-diff?start=2024-01-01&end=2024-01-10

**Time Duration**  
Input: start (String, HH:MM), end (String, HH:MM)  
Output: minutes (int)  
/api/calculators/time-duration?start=10:00&end=12:30

---

### ️ Health

**BMI**  
Input: weight (double, kg), height (double, meters)  
Output: BMI (double, kg/m²)  
/api/calculators/bmi?weight=70&height=1.75

**Calories**  
Input: weight (double, kg)  
Output: calories (kcal)  
/api/calculators/calories?weight=70

**Water Intake**  
Input: weight (double, kg)  
Output: water (liters/day)  
/api/calculators/water?weight=70

**Pregnancy Due Date**  
Input: lastPeriod (String, YYYY-MM-DD)  
Output: due date (String, date)  
/api/calculators/pregnancy?lastPeriod=2024-01-01

---

###  Business

**Profit Margin**  
Input: revenue (double, ₹), cost (double, ₹)  
Output: profit (%, double)  
/api/calculators/profit?revenue=10000&cost=7000

**Startup Valuation**  
Input: revenue (double, ₹), multiplier (double)  
Output: valuation (₹)  
/api/calculators/startup?revenue=500000&multiplier=5

**Cost Estimator**  
Input: fixedCost (double, ₹), variableCost (double, ₹/unit), units (int)  
Output: total cost (₹)  
/api/calculators/cost?fixedCost=10000&variableCost=50&units=100

---

###  Extra

**History**  
/api/calculators/history

**Filter**  
/api/calculators/history/filter?type=GST

**Dashboard**  
/api/calculators/dashboard

**Delete**  
DELETE /api/calculators/history/{id}

---

##  Testing (Postman)

- Open Postman
- Select GET method
- Enter API URL
- Click Send

Example:
http://localhost:8080/api/calculators/gst?amount=1000&rate=18

---

##  Notes
- All APIs use GET method (except DELETE)
- Backend handles all calculations
- Frontend displays results
- Ensure MySQL is running

---

##  Author
Sharath Kumar  
GitHub: https://github.com/gudurusharathkumar

---

##  Status
✔ Backend Completed  
✔ Frontend Integrated  
✔ APIs Working  
✔ Database Connected  
✔ Code Uploaded to GitHub  
✔ Project Successfully Running Locally  