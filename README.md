#  Calculator Hub Backend

##  Project Overview
Calculator Hub is a backend application built using Spring Boot that provides multiple real-world calculation APIs. It supports finance, personal, health, and business calculations and is designed for frontend integration.

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
- Delete

---

##  Tech Stack
- Java 17
- Spring Boot
- JPA (Hibernate)
- MySQL
- REST API
- Postman

---

##  Run Project

1. Clone:
   git clone https://github.com/gudurusharathkumar/calculatorhub.git

2. Configure DB:
   spring.datasource.url=jdbc:mysql://localhost:3306/calculatorhub  
   spring.datasource.username=YOUR_USERNAME  
   spring.datasource.password=YOUR_PASSWORD

3. Run:
   CalculatorhubApplication.java

4. URL:
   http://localhost:8080

---

##  APIs WITH UNITS

###  Finance

GST  
Input: amount (₹), rate (%)  
Output: ₹  
/api/calculators/gst?amount=1000&rate=18

ROI  
Input: gain (₹), investment (₹)  
Output: %  
/api/calculators/roi?gain=500&investment=2000

Interest  
Input: p (₹), r (%), t (years)  
Output: ₹  
/api/calculators/interest?p=1000&r=10&t=2

Break-even  
Input: fixedCost (₹), price (₹/unit), variableCost (₹/unit)  
Output: units  
/api/calculators/break-even?fixedCost=10000&price=50&variableCost=30

EMI  
Input: principal (₹), rate (%), time (years)  
Output: ₹ per month  
/api/calculators/emi?principal=100000&rate=10&time=2

---

###  Personal

Date Difference  
Input: start (YYYY-MM-DD), end (YYYY-MM-DD)  
Output: days  
/api/calculators/date-diff?start=2024-01-01&end=2024-01-10

Time Duration  
Input: start (HH:MM), end (HH:MM)  
Output: minutes  
/api/calculators/time-duration?start=10:00&end=12:30

---

###  Health

BMI  
Input: weight (kg), height (meters)  
Output: BMI (kg/m²)  
/api/calculators/bmi?weight=70&height=1.75

Calories  
Input: weight (kg)  
Output: kcal  
/api/calculators/calories?weight=70

Water  
Input: weight (kg)  
Output: liters/day  
/api/calculators/water?weight=70

Pregnancy  
Input: lastPeriod (YYYY-MM-DD)  
Output: due date  
/api/calculators/pregnancy?lastPeriod=2024-01-01

---

###  Business

Profit  
Input: revenue (₹), cost (₹)  
Output: %  
/api/calculators/profit?revenue=10000&cost=7000

Startup  
Input: revenue (₹), multiplier  
Output: ₹  
/api/calculators/startup?revenue=500000&multiplier=5

Cost  
Input: fixedCost (₹), variableCost (₹/unit), units  
Output: ₹  
/api/calculators/cost?fixedCost=10000&variableCost=50&units=100

---

###  Extra

History  
/api/calculators/history

Filter  
/api/calculators/history/filter?type=GST

Dashboard  
/api/calculators/dashboard

Delete  
DELETE /api/calculators/history/{id}

---

##  Notes
- All APIs use GET method (except DELETE)
- Backend handles all calculations
- Frontend should send correct units only

---

##  Author
Sharath Kumar  
https://github.com/gudurusharathkumar

---

##  Status
✔ Backend Completed  
✔ APIs Working  
✔ Units Defined  
✔ Ready for Full Stack Integration  