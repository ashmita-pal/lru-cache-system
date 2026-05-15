# In-Memory LRU Cache System

A full-stack in-memory LRU Cache System built using Java and Spring Boot with O(1) cache operations using HashMap and Doubly Linked List.

---

## Features

- O(1) cache operations
- LRU eviction policy
- TTL-based cache expiration
- REST APIs using Spring Boot
- Cache statistics tracking
- Web-based interface for cache operations

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

### 1. Clone the repository

```bash
git clone https://github.com/ashmita-pal/lru-cache-system.git
```

### 2. Open the project in VS Code

Navigate to the project folder.

### 3. Run the Spring Boot application

```bash
.\mvnw spring-boot:run
```

### 4. Open in browser

Frontend:
http://localhost:8081

---

## Future Improvements

- Redis Integration  
  Replace the custom in-memory cache with Redis to support distributed caching and improve scalability for real-world applications.

- Thread-Safe Cache  
  Implement synchronization or concurrent data structures to safely handle multiple simultaneous user requests.

- Persistent Storage  
  Store cache data in a database or file system so that cache entries remain available even after server restarts.

- User Authentication  
  Add login and authorization features to restrict cache operations to authenticated users only.