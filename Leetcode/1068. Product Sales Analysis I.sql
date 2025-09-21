-- # Write your MySQL query statement below
SELECT
    Product.product_name,
    Sales.year,
    Sales.price
FROM
    Sales,
    Product
WHERE
    Sales.product_id = Product.product_id;

-- Alternative solution using explicit JOIN
SELECT
    p.product_name,
    s.year,
    s.price
FROM
    Sales s
    JOIN Product p ON s.product_id = p.product_id;