# Practice Project: Backend Functionalities and Integrations

*This repository includes various modules for practicing and demonstrating backend development using **Java Spring Boot**. It covers real-world backend tasks such as **WhatsApp API integration** with Meta, **complex SQL joins**, and **bulk data import from Excel files or CSV files** using Postman.*

---

## 🚀 Modules Included:

### 1. WhatsApp Messaging (Meta API via Webhooks)
- **Description:** *Send and receive automated WhatsApp messages using **Meta’s WhatsApp Cloud API**, with webhook routing via **Hookdeck** and tunneling via **Loophole**.*
- **Tech Used:** 
  - Backend: Java 17, Spring Boot  
  - WhatsApp API: Meta for Developers  
  - Webhook Routing: Hookdeck  
  - Tunneling: Loophole
- **Features:**
  - Send text messages to WhatsApp users
  - Verify webhook setup
  - Environment-based configuration for secure tokens

---

### 2. WhatsApp Integration Setup
- **Description:** *End-to-end setup and integration of Meta’s WhatsApp Cloud API using Spring Boot.*
- **Tech Used:** 
  - Spring Boot for REST API and webhook listener  
  - Hookdeck for webhook monitoring  
  - Loophole for exposing local server
- **Setup Instructions:**
  - Create a Meta Developer account and WhatsApp App
  - Receive and log incoming messages via webhook
  - Generate access token and configure webhook callback URL
  - Use Hookdeck to forward webhook traffic to localhost
  - Use Loophole to tunnel local Spring Boot server to a public endpoint
  - Add `verify.token`, `access.token`, and `phone.number.id` in `application.properties`

---

### 3. Store Data in Local JSON File
**Description:** *Implements functionality to save submitted form or API request data into a local JSON file. This provides a backup or logging mechanism to track all incoming data, useful for auditing or recovery.*

**Tech Used:**
 - Java Spring Boot
 - Jackson Library (for JSON serialization)
 - File I/O (Java NIO or standard I/O)

**Features:**
 - Automatic JSON file creation and update on each data submission
 - Appends new entries to maintain a full log
 - Useful for offline access, debugging, or data recovery scenarios

---

### 4. Join Three Tables in SQL
- **Description:** *Demonstrates SQL JOIN queries using Spring Boot and MySQL. Example uses `Users`, `Co-ordinators`, and `TimeTable` tables to retrieve combined relational data.*
- **Tech Used:** 
  - Java Spring Boot  
  - MySQL  
  - Spring Data JPA or native SQL queries
- **Example Use Case:**
  - Join `co-ordinators`, `user`, and `timetable` tables to fetch user info with their order and product details
- **Features:**
  - REST API endpoint to fetch joined data
  - Clean model and repository structure
  - On registering, all submitted values are also stored in a local JSON file for backup/logging purposes.

---

### 5. Bulk Upload from Excel to MySQL
- **Description:** *Upload an Excel (.xlsx) file via Postman and insert the data into MySQL in bulk.*
- **Tech Used:** 
  - Java Spring Boot  
  - Apache POI (Excel file parsing)  
  - MySQL  
  - Postman for API testing
- **Features:**
  - Upload Excel file via `multipart/form-data` endpoint
  - Parse and validate rows using Apache POI
  - Batch insert validated records into MySQL
  - API returns success/failure response for each row

---

 ### 6. Bulk Upload from CSV to MySQL with OpenAPI Documentation
 - **Description:** *Upload a CSV (.csv) file via a REST API and insert the data into MySQL in bulk.*
 - **Tech Used:**
    - Java Spring Boot
    - OpenCSV (CSV file parsing)
    - MySQL
    - Postman for API testing

 - **Features**:
    - Upload CSV file via `multipart/form-data` endpoint
    - Parse and validate CSV rows using OpenCSV
    - Perform batch insertion of valid records into MySQL
    - API response showing success/failure for each record

---

## 🧪 How to Use

### Prerequisites
- Java 17+
- Maven
- MySQL database setup
- Postman for testing APIs
- Hookdeck & Loophole accounts (for WhatsApp webhook)

---

### Setup

1. Clone the repository:
```bash
git clone https://github.com/yourusername/your-repo-name.git
cd your-repo-name
