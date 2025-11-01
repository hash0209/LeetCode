# Write your MySQL query statement below
select c.name as customers from customers c
LEFT Join Orders o 
ON c.id = o.customerId
WHERE o.id is NULL
