# Expense Tracker

A simple Java console application for managing personal expenses with MySQL JDBC integration.

## Overview

This expense tracker allows users to manage their financial expenses through a command-line interface. The application provides basic CRUD (Create, Read, Update, Delete) operations for expense management using a MySQL database.

## Features

- **Add Expenses** - Record new expenses with description, amount, and date
- **View All Expenses** - Display all recorded expenses in a formatted list
- **Calculate Total** - Get the sum of all expenses
- **Remove Expenses** - Delete expenses by ID
- **Database Integration** - Persistent storage using MySQL

## Technology Stack

- **Language**: Java
- **Database**: MySQL
- **Database Driver**: MySQL Connector/J (mysql-connector-j-9.3.0.jar)
- **Architecture**: Simple DAO (Data Access Object) pattern

## Project Structure

```
Expense-Tracker/
├── Main.java                    # Application entry point
├── ExpenseDAO.java             # Data Access Object for expense 
├── DBConnection.java           # Database connection management
├── mysql-connector-j-9.3.0.jar # MySQL JDBC driver
└── README.md                   # Project documentation
```

## Prerequisites

- Java 8 or higher
- MySQL Server 5.7 or higher
- MySQL Connector/J (included in project)

## Setup Instructions

### 1. Database Schema

The application uses a MySQL database named `expense_tracker` with `expenses` table structure:

```sql
CREATE DATABASE expense_tracker;
USE expense_tracker

CREATE TABLE expenses (
    id INT AUTO_INCREMENT PRIMARY KEY,
    description VARCHAR(255) NOT NULL,
    amount DECIMAL(10,2) NOT NULL,
    expense_date DATE NOT NULL
);
```

### 2. Dependencies

**mysql-connector-j-9.3.0.jar**: MySQL JDBC driver for database connectivity

