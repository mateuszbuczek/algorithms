SELECT emp.name "Employee"
from employee emp, employee mgr
WHERE mgr.id = emp,managerId
AND emp.salary > mgr.salary