# Workforce Management System

## Project Overview
This is a Spring Boot backend application for managing construction worker attendance and overtime settlement.

The system allows workers to:
- Clock in
- Clock out
- Track active workers
- Calculate overtime automatically

---

## Technologies Used

- Java 21
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Supabase
- Maven
- Lombok
- Postman

---

## Features

### Worker Management
- Store worker details
- Designation management
- Daily wage tracking

### Site Management
- Multiple construction sites
- Site location tracking

### Attendance Management
- Worker clock-in
- Worker clock-out
- Active workers API
- Attendance history

### Overtime Calculation
- Automatic overtime calculation
- Shift hour tracking
- Flag long working hours

### Error Handling
- Global exception handling
- Structured JSON error responses

---

## Database Tables

- workers
- sites
- attendance_logs
- overtime_entries

---

## API Endpoints

### Clock-In API
POST /api/attendance/clock-in

Request:
```json
{
  "workerId": 1,
  "siteId": 1
}# Workforce Management System

## Project Overview
This is a Spring Boot backend application for managing construction worker attendance and overtime settlement.

The system allows workers to:
- Clock in
- Clock out
- Track active workers
- Calculate overtime automatically

---

## Technologies Used

- Java 21
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Supabase
- Maven
- Lombok
- Postman

---

## Features

### Worker Management
- Store worker details
- Designation management
- Daily wage tracking

### Site Management
- Multiple construction sites
- Site location tracking

### Attendance Management
- Worker clock-in
- Worker clock-out
- Active workers API
- Attendance history

### Overtime Calculation
- Automatic overtime calculation
- Shift hour tracking
- Flag long working hours

### Error Handling
- Global exception handling
- Structured JSON error responses

---

## Database Tables

- workers
- sites
- attendance_logs
- overtime_entries

---

## API Endpoints

### Clock-In API
POST /api/attendance/clock-in

Request:
```json
{
  "workerId": 1,
  "siteId": 1
}