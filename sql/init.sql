create database csp default character set utf8mb4 collate utf8mb4_general_ci;
CREATE USER 'csp'@'%' IDENTIFIED BY 'xgGRt2152GBnmVbPKjh';
GRANT ALL ON csp.* TO 'csp'@'%';
flush privileges;