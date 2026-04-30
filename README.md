# 💊 Pharmacy Management System

A robust and user-friendly Pharmacy Management System developed in Java with a Swing Graphical User Interface (GUI) and powered by an MS SQL Server database. This application is designed to streamline pharmacy operations, manage inventory, and handle daily transactions efficiently.

## ✨ Features

- **🔐 User Authentication:** Secure login and registration system for staff.
- **📊 Interactive Dashboard:** A central hub providing an overview of pharmacy operations.
- **📦 Products Management:** Add, update, view, and delete product inventory details.
- **👥 Customers Management:** Maintain records of customers for better service and tracking.
- **🛒 Orders Management:** Process and track customer orders seamlessly.
- **🚚 Suppliers Management:** Manage supplier information and track inventory sources.
- **💾 Database Integration:** Reliable data storage and retrieval using Microsoft SQL Server.

## 🛠️ Technology Stack

- **Language:** Java 21
- **GUI Framework:** Java Swing
- **Database:** Microsoft SQL Server
- **Build Tool:** Maven

## 🚀 Getting Started

### Prerequisites

- Java Development Kit (JDK) 21 or higher
- Apache Maven
- Microsoft SQL Server
- NetBeans IDE (Recommended for GUI editing)

### Database Setup

1. Ensure MS SQL Server is running.
2. The project contains a `Pharmacy-Query.sql` file in the root directory. Execute this script in your MS SQL Server instance to create the necessary database schema and tables.
3. Update the database credentials in the application's connection configuration (located in `src/main/java/com/mycompany/pharmacy/managment/system/DBConnection.java`).

### Building and Running

1. **Clone the repository:**
   ```bash
   git clone <repository-url>
   cd Pharmacy-Managment-System
   ```

2. **Build the project using Maven:**
   ```bash
   mvn clean install
   ```

3. **Run the application:**
   ```bash
   mvn exec:java -Dexec.mainClass="com.mycompany.pharmacy.managment.system.PharmacyManagmentSystem"
   ```
   *Alternatively, you can open and run the project directly through NetBeans IDE.*

## 📸 Screenshots

*(You can add screenshots of your Login, Dashboard, Products, and Orders screens here before uploading to GitHub to make your repository look more appealing)*

## 🤝 Contributing

Contributions, issues, and feature requests are welcome!
