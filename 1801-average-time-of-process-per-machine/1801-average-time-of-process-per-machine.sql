# Write your MySQL query statement below
select m.machine_id ,
  ROUND(AVG(m.timestamp-a.timestamp),3) AS processing_time
  From activity m JOIN activity a
  ON m.machine_id = a.machine_id
  WHERE m.process_id = a.process_id
  AND m.activity_type ='end' 
  AND a.activity_type='start'
  GROUP BY m.machine_id;


    