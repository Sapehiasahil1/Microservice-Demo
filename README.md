# 🎯 Quiz App – Microservices Architecture

This repository contains a **microservices-based Quiz Application** built with **Spring Boot**.  
It demonstrates **service discovery, inter-service communication, API gateway routing, and load balancing**.

---

## 🏗️ Architecture

- **Eureka Server** – Service registry for discovery
- **API Gateway** – Central gateway for routing requests
- **Question Service** – Manages quiz questions and categories
- **Quiz Service** – Creates quizzes and fetches questions using **OpenFeign**
- **Eureka Clients** – Each microservice registers with the Eureka server

---

## 🔧 Tech Stack

- Java / Spring Boot
- Eureka, OpenFeign, LoadBalancer, Gateway
- Maven

