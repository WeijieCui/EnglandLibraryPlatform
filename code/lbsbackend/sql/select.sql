SELECT ID              AS id,
       CATEGORY_ID     AS categoryId,
       LIBRARY_ID      AS libraryId,
       REAL_LIBRARY_ID AS realLibraryId,
       SHELF_ID        AS shelfId,
       TITLE           AS title,
       SUMMARY         AS summary,
       IMAGE           AS image,
       AUTHOR          AS author,
       SUBJECT         AS subject,
       FORMAT          AS format,
       PUBLISHER       AS publisher,
       PUBLISHED_DATE  AS publishedDate,
       LANGUAGE        AS language,
       COUNTRY         AS country,
       ISBN            AS isbn,
       STATUS          AS status
FROM BOOK
WHERE ID = 976122732829872100;
select *
from book_printing;
insert into book_printing (ID, BOOK_ID, LIBRARY_ID, REAL_LIBRARY_ID, SHELF_ID, REAL_SHELF_ID, STATUS,
                           EXP_AVAILABLE_DATE, CREATED_BY, CREATED_TIME)
values (1,6122732829872129,1,1,1,1,'AVAILABLE',null, 'admin',NOW());