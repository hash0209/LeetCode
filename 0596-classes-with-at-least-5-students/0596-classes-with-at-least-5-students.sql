# Write your MySQL query statement below
select class from courses 
GROUP BY class 
HAVING count(student)>= 5; 