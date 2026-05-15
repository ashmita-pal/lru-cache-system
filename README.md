# In-Memory LRU Cache System

A full-stack in-memory LRU Cache System built using Java and Spring Boot with O(1) cache operations using HashMap and Doubly Linked List.

---

## Features

- O(1) cache operations
- LRU eviction policy
- TTL-based cache expiration
- REST APIs using Spring Boot
- Cache statistics tracking
- Frontend interface for cache management

---

## Technologies Used

- Java
- Spring Boot
- REST APIs
- HTML
- CSS
- JavaScript
- HashMap
- Doubly Linked List

---

## API Endpoints

### Store Cache Entry
POST /cache

### Fetch Cache Entry
GET /cache/{key}

### Delete Cache Entry
DELETE /cache/{key}

### Get Cache Statistics
GET /cache/stats

### Display All Cache Entries
GET /cache/all

---

## How to Run

1. Clone the repository
2. Open project in VS Code
3. Run Spring Boot application
4. Open browser and visit:

http://localhost:8081

---

## Future Improvements

- Redis integration
- Thread-safe cache
- Persistent storage
- User authentication
