SELECT MAX(A.salary) as SecondHighestSalary FROM employee A join employee B on A.salary < B.salary and A.id != B.id
