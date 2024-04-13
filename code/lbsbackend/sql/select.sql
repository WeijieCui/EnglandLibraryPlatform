SELECT ID                   AS id,
       LIBRARY_ID           AS LibraryId,
       TARGET_LIBRARY_ID    AS targetLibraryId,
       BOOK_ID              AS parentId,
       USER_ID              AS name,
       EXPECTED_PICKUP_TIME AS expectedPickupTime,
       REAL_PICKUP_TIME     AS realPickupTime,
       STATUS               AS status,
       CREATED_BY           AS createdBy,
       CREATED_TIME         AS createdTime
FROM book_reservation
WHERE 1 = 1
ORDER BY ID;

SELECT ID                   AS id,
       LIBRARY_ID           AS LibraryId,
       TARGET_LIBRARY_ID    AS targetLibraryId,
       BOOK_ID              AS parentId,
       USER_ID              AS name,
       EXPECTED_PICKUP_TIME AS expectedPickupTime,
       REAL_PICKUP_TIME     AS realPickupTime,
       STATUS               AS status,
       CREATED_BY           AS createdBy,
       CREATED_TIME         AS createdTime
FROM BOOK_RESERVATION
WHERE ID IN (976627986369482752)
ORDER BY ID;