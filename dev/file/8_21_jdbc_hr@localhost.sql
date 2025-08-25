SELECT COUNT(*) FROM employees;

SELECT COUNT(*) 
FROM employees
WHERE department_id = 20;

SELECT *
FROM employees;

SELECT * 
FROM employees
WHERE employee_id = 600;


INSERT INTO employees 
(employee_id, first_name, last_name, email, phone_number
, hire_date, job_id, salary, commission_pct, manager_id, department_id )
VALUES (600, 'first_name', 'last_name', 'email', 'phone_number', sysdate, 'MK_REP', 100000.00, 0.99, 201, 20);

UPDATE employees
SET first_name = 'first_name1', last_name = 'last_name1', email = 'email1', salary=120000.00
WHERE employee_id = 600;

DELETE FROM employees WHERE employee_id =600 AND email = 'email1';

commit;

DELETE FROM job_history 
WHERE employee_id = 600;

SELECT department_id, department_name
FROM departments;

SELECT job_id , job_title
FROM jobs;

-- 매니저 아이디와 이름을 출력

-- 1. 조인 사용 

SELECT DISTINCT e.manager_id, e2.first_name AS manager_name
FROM employees e
JOIN employees e2  on e.manager_id = e2.employee_id
ORDER BY e.manager_id;


-- 2. 서브 쿼리 사용 
SELECT manager_id,
        (SELECT first_name FROM employees e2 WHERE e2.employee_id = e1.manager_id) as manager_name 
FROM employees e1;


SELECT * 
FROM employees;
