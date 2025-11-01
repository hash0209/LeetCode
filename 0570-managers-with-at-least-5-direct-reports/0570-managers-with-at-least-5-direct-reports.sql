# Write your MySQL query statement below

select m.name   
from Employee m
JOIN Employee e 
ON e.managerId = m.id
GROUP BY m.id , m.name
HAVING count(e.id) >= 5



