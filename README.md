\# Order \& Inventory Microservices



This project demonstrates a simple microservices architecture using Spring Boot, Spring Data JPA, and H2 Database.  

It consists of two services:

-Inventory Service\*\* (manages product batches and stock levels)

-Order Service\*\* (places orders and updates inventory via REST calls)





\## Project Setup Instructions



\## Prerequisites

\- Java 17+

\- Maven 3.8+


\## Steps

1\. Clone the repository

&nbsp;  git clone https://github.com/your-repo/order-inventory-microservices.git

&nbsp;  cd order-inventory-microservices
2. Build the project

&nbsp;  mvn clean install

3\. Runs on port 8081 \& 8082 by default.
4. Run Inventory Service

5\. Access H2 Console

&nbsp;  Inventory Service: http://localhost:8081/h2-console
   Order Service: http://localhost:8082/h2-console


\## API List

Inventory Service (Port 8081)

\- GET /inventory/{productId} → Get all batches for a product

\- POST /inventory/update?productId={id}\&quantity={qty} → Update inventory quantity for a product

Order Service (Port 8082)

\- POST /order?productId={id}\&quantity={qty} → Place an order and update inventory





\## Testing:


1.Test Inventory Service

\- Check stock:

GET http://localhost:8081/inventory/P1

Expected: JSON list of batches for product P1.

\- Update stock:

POST http://localhost:8081/inventory/update?productId=P1\&quantity=10

Expected: "Inventory updated"


2\. Test Order Service

\- Place an order:

POST http://localhost:8082/order?productId=P1\&quantity=5

Expected: JSON with order details (id, productId, quantity, orderDate).

\- Verify inventory reduced:

GET http://localhost:8081/inventory/P1

Expected: Quantity reduced compared to before.

























