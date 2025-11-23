SELECT e1.name
FROM Employee e1
    JOIN (
        SELECT managerId
        FROM Employee
        GROUP BY managerId
        HAVING COUNT(*) >= 5
    ) e2 ON e1.id = e2.managerId;

SELECT e1.name
FROM Employee e1
WHERE e1.id IN (
        SELECT managerId
        FROM Employee
        GROUP BY managerId
        HAVING COUNT(*) >= 5
    );

SELECT e1.name
FROM Employee e1
    JOIN Employee e2 ON e1.id = e2.managerId
GROUP BY e2.managerId
HAVING COUNT(e2.managerId) >= 5;