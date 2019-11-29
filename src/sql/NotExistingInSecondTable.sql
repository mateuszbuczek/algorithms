# Suppose that a website contains two tables, the Customers table and the Orders table. Write a SQL query to find all customers who never order anything.
#
# Table: Customers.
#
# +----+-------+
# | Id | Name  |
# +----+-------+
# | 1  | Joe   |
# | 2  | Henry |
# | 3  | Sam   |
# | 4  | Max   |
# +----+-------+
# Table: Orders.
#
# +----+------------+
# | Id | CustomerId |
# +----+------------+
# | 1  | 3          |
# | 2  | 1          |
# +----+------------+
# Using the above tables as example, return the following:
#
# +-----------+
# | Customers |
# +-----------+
# | Henry     |
# | Max       |
# +-----------+

SELECT a.Name as Customers
FROM Customers AS a
WHERE a.Id NOT IN (SELECT customerId FROM Orders);

SELECT a.Name as Customers
FROM Customers a
LEFT JOIN Orders o
ON a.Id = o.CustomerId
WHERE o.CustomerId IS NULL;