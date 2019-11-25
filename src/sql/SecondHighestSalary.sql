SELECT MAX(A.salary) as SecondHighestSalary FROM employee A join employee B on A.salary < B.salary and A.id != B.id

SELECT (SELECT DISTINCT Salary FROM Employee ORDER BY Salary DESC LIMIT 1 OFFSET 1) AS SecondHighestSalary;