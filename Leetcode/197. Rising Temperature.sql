-- # Write your MySQL query statement below
SELECT W2.id
FROM Weather W1
    JOIN Weather W2 ON DATEDIFF(W2.recordDate, W1.recordDate) = 1
WHERE W2.temperature > W1.temperature;