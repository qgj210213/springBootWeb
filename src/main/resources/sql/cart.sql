CREATE TABLE DB_CART(
  USER_ID INT (11) NOT NULL
  , PRODUCT_ID INT (11) NOT NULL
  , PRODUCT_NAME VARCHAR (50) NOT NULL
  , PRIMARY KEY (USER_ID)
) ENGINE = InnoDB DEFAULT CHARSET = utf8;
--alter table db_cart drop primary key;
--alter table db_cart add primary key(USER_ID,PRODUCT_ID);
/*
CREATE TABLE `db_cart` (
  `USER_ID` int(11) NOT NULL,
  `PRODUCT_ID` int(11) NOT NULL,
  `PRODUCT_NAME` varchar(50) NOT NULL,
  PRIMARY KEY  (`USER_ID`,`PRODUCT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8
*/

select
  car.USER_ID
  , car.PRODUCT_ID
  , car.PRODUCT_NAME
from
  db_cart car
  left join db_user usr
    on car.USER_ID = usr.id
  left join db_product pt
    on car.PRODUCT_ID = pt.product_id