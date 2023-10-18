/* データベース: customer_manager_db */
DROP DATABASE IF EXISTS customer_manager_db;
CREATE DATABASE customer_manager_db CHARACTER SET utf8 COLLATE utf8_general_ci;
​
​
/* ユーザを作成 */
DROP USER IF EXISTS customerU;
CREATE USER customerU IDENTIFIED BY 'customerP';
​
​
/* 権限付与 */
GRANT ALL PRIVILEGES ON customer_manager_db.* TO 'customerU';
​
​
/* DBの選択*/
USE customer_manager_db;
​
/* ③権限マスタテーブル */
CREATE TABLE m_authority (
  authority_code CHAR(2) PRIMARY KEY,
  authority_name VARCHAR(10) NOT NULL UNIQUE
);
​
INSERT INTO m_authority(authority_code, authority_name)
  VALUES('A0', '閲覧者'),('A1', '編集者'),('A2', '管理者');
​
-- ④地区テーブル
CREATE TABLE m_area (
  area_code CHAR(4) PRIMARY KEY,
  area_name VARCHAR(10) NOT NULL UNIQUE
);
​
INSERT INTO m_area (area_code, area_name)
  VALUES('A000', '未設定'),
  ('A001','北海道'),
  ('A002','東北'),
  ('A003','関東'),
  ('A004','中部'),
  ('A005','近畿'),
  ('A006','中国'),
  ('A007','四国'),
  ('A008','九州沖縄');
​
/* ②ユーザマスタテーブル */
CREATE TABLE m_user (
  user_id VARCHAR(24),
  password VARCHAR(32) NOT NULL,
  authority_code CHAR(2) NOT NULL,
  PRIMARY KEY(user_id),
  FOREIGN KEY (authority_code) REFERENCES m_authority(authority_code) ON DELETE CASCADE ON UPDATE CASCADE
  -- 外部キー制約を追加↑
);
​
/* ユーザマスタINSERT */
INSERT INTO m_user(user_id, password, authority_code)
  VALUES('readerU', 'readerP', 'A0');
INSERT INTO m_user(user_id, password, authority_code)
  VALUES('editU', 'editP', 'A1');
INSERT INTO m_user(user_id, password, authority_code)
  VALUES('managerU', 'managerP', 'A2');
​
​
/* ①顧客マスタテーブル */
CREATE TABLE m_customer (
  customer_id INT AUTO_INCREMENT,
  customer_name VARCHAR(20) NOT NULL,
  customer_name_kana VARCHAR(40) NOT NULL ,
  post_code CHAR(7) NOT NULL,
  area_code CHAR(4) NOT NULL,
  gender CHAR(1) NOT NULL, 
  birthday DATE NOT NULL,
  phone_number VARCHAR(13) NOT NULL,
  insert_datetime DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL,
  UPDATE_datetime DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP NOT NULL,
  PRIMARY KEY(customer_id),
  FOREIGN KEY (area_code) REFERENCES m_area(area_code) ON DELETE CASCADE ON UPDATE CASCADE
  -- 外部キー制約を追加↑
);
​
​
INSERT INTO m_customer(customer_name, customer_name_kana, post_code, area_code, gender, birthday, phone_number)
  VALUES('蓑田冬弥', 'みのだとうや', '8110000', 'A008', '男', 19950116, '08012345678')
  ,('山田太郎', 'やまだたろう', '8000000', 'A008', '男', 19920715, '07054545454')
  ,('安藤忠雄', 'あんどうただお', '5520015', 'A005', '男', 19410913, '09055555555');
​
COMMIT;