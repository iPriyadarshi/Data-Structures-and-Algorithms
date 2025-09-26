-- # Write your MySQL query statement below
select contest_id,
    round(
        100.0 * count(distinct Register.user_id) / (
            select count(*)
            from Users
        ),
        2
    ) as percentage
from Users,
    Register
where Users.user_id = Register.user_id
group by contest_id
order by percentage desc,
    contest_id asc;