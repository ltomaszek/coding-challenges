package com.ltcode.solutions;

/**
 * Write a SQL query to find all duplicate emails in a table named Person.
 *
 * +----+---------+
 * | Id | Email   |
 * +----+---------+
 * | 1  | a@b.com |
 * | 2  | c@d.com |
 * | 3  | a@b.com |
 * +----+---------+
 */
public class _182_DuplicateEmails {
    /*
    SELECT Email FROM Person
    GROUP BY Email
    HAVING COUNT(Email) > 1;
     */
}
