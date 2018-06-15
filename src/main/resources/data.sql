LOCK TABLES `role` WRITE;
INSERT INTO `role`(name) VALUES ('USER');
INSERT INTO `role`(name) VALUES ('ADMIN');
UNLOCK TABLES;

LOCK TABLES `user` WRITE;
INSERT INTO `user`(email,password,isactive) VALUES ('aravindc@sivapriya.org','Welcome123',true);
INSERT INTO `user`(email,password,isactive) VALUES ('test@test.com','Welcome123',true);
INSERT INTO `user`(email,password,isactive) VALUES ('test@user.com','Welcome123',false);
UNLOCK TABLES;

LOCK TABLES `user_role` WRITE;
INSERT INTO `user_role`(userid,roleid) VALUES (1,1);
INSERT INTO `user_role`(userid,roleid) VALUES (1,2);
INSERT INTO `user_role`(userid,roleid) VALUES (2,1);
INSERT INTO `user_role`(userid,roleid) VALUES (3,1);
UNLOCK TABLES;

LOCK TABLES `offer` WRITE;
INSERT INTO `offer`(offername,offerdescription,offercode,offerstartdate,offerenddate) VALUES ('Test Offer1','Test Offer Desc 1','OFFER0001','2017-01-01','2017-12-31');
INSERT INTO `offer`(offername,offerdescription,offercode,offerstartdate,offerenddate) VALUES ('Test Offer2','Test Offer Desc 2','OFFER0002','2017-01-01','2017-12-31');
INSERT INTO `offer`(offername,offerdescription,offercode,offerstartdate,offerenddate) VALUES ('Test Offer3','Test Offer Desc 3','OFFER0003','2017-01-01','2017-12-31');
INSERT INTO `offer`(offername,offerdescription,offercode,offerstartdate,offerenddate) VALUES ('Test Offer4','Test Offer Desc 4','OFFER0004','2017-01-01','2017-12-31');
INSERT INTO `offer`(offername,offerdescription,offercode,offerstartdate,offerenddate) VALUES ('Test Offer5','Test Offer Desc 5','OFFER0005','2017-01-01','2017-12-31');
INSERT INTO `offer`(offername,offerdescription,offercode,offerstartdate,offerenddate) VALUES ('Test Offer6','Test Offer Desc 6','OFFER0006','2017-01-01','2017-12-31');
UNLOCK TABLES;

LOCK TABLES `product` WRITE;
INSERT INTO `product`(productname,productcode,skuno,classid,classvalue,categoryid,categoryvalue,supercatid,supercatvalue,groupid,groupvalue,departmentid,departmentvalue,brandid,brandvalue) VALUES ('Test Product1','PROD0001',100000234,'CLASS0001','CLASS 1','CAT0001','CATEGORY 1','SCAT0001','SUPER CAT 1','GRP0001','GROUP 1','DEPT0001','DEPARTMENT 1','BRND0001','BRAND 1');
INSERT INTO `product`(productname,productcode,skuno,classid,classvalue,categoryid,categoryvalue,supercatid,supercatvalue,groupid,groupvalue,departmentid,departmentvalue,brandid,brandvalue) VALUES ('Test Product2','PROD0002',100000235,'CLASS0001','CLASS 1','CAT0001','CATEGORY 1','SCAT0001','SUPER CAT 1','GRP0001','GROUP 1','DEPT0001','DEPARTMENT 1','BRND0001','BRAND 1');
INSERT INTO `product`(productname,productcode,skuno,classid,classvalue,categoryid,categoryvalue,supercatid,supercatvalue,groupid,groupvalue,departmentid,departmentvalue,brandid,brandvalue) VALUES ('Test Product3','PROD0003',100000236,'CLASS0002','CLASS 2','CAT0001','CATEGORY 1','SCAT0001','SUPER CAT 1','GRP0001','GROUP 1','DEPT0001','DEPARTMENT 1','BRND0001','BRAND 1');
INSERT INTO `product`(productname,productcode,skuno,classid,classvalue,categoryid,categoryvalue,supercatid,supercatvalue,groupid,groupvalue,departmentid,departmentvalue,brandid,brandvalue) VALUES ('Test Product4','PROD0004',100000237,'CLASS0002','CLASS 2','CAT0002','CATEGORY 2','SCAT0001','SUPER CAT 1','GRP0001','GROUP 1','DEPT0001','DEPARTMENT 1','BRND0001','BRAND 1');
INSERT INTO `product`(productname,productcode,skuno,classid,classvalue,categoryid,categoryvalue,supercatid,supercatvalue,groupid,groupvalue,departmentid,departmentvalue,brandid,brandvalue) VALUES ('Test Product5','PROD0005',100000238,'CLASS0003','CLASS 3','CAT0002','CATEGORY 2','SCAT0001','SUPER CAT 1','GRP0001','GROUP 1','DEPT0001','DEPARTMENT 1','BRND0001','BRAND 1');
INSERT INTO `product`(productname,productcode,skuno,classid,classvalue,categoryid,categoryvalue,supercatid,supercatvalue,groupid,groupvalue,departmentid,departmentvalue,brandid,brandvalue) VALUES ('Test Product6','PROD0006',100000239,'CLASS0003','CLASS 3','CAT0002','CATEGORY 2','SCAT0001','SUPER CAT 1','GRP0001','GROUP 1','DEPT0001','DEPARTMENT 1','BRND0001','BRAND 1');
UNLOCK TABLES;

LOCK TABLES `offer_product` WRITE;
INSERT INTO `offer_product` (offerid,productid) values(3,1);
INSERT INTO `offer_product` (offerid,productid) values(3,2);
INSERT INTO `offer_product` (offerid,productid) values(3,3);
INSERT INTO `offer_product` (offerid,productid) values(4,2);
UNLOCK TABLES;