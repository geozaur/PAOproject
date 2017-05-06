-- create Services table

CREATE TABLE sql11172842.services (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(100) NOT NULL,
  type VARCHAR(100) NOT NULL,
  colored TINYINT NOT NULL,
  PRIMARY KEY (id),
  UNIQUE INDEX id_UNIQUE (id ASC));

-- create Clients table

CREATE TABLE sql11172842.clients (
  username VARCHAR(255) NOT NULL,
  password VARCHAR(100) NOT NULL,
  first_name VARCHAR(255) NOT NULL,
  last_name VARCHAR(255) NOT NULL,
  country VARCHAR(255) NOT NULL,
  city VARCHAR(255) NOT NULL,
  address VARCHAR(255) NOT NULL,
  account_type TINYINT NOT NULL,
  security_question VARCHAR(255) NOT NULL,
  security_answer VARCHAR(255) NOT NULL,
  PRIMARY KEY (username),
  UNIQUE INDEX username_UNIQUE (username ASC));

-- create Products table

CREATE TABLE sql11172842.products (
  id INT NOT NULL,
  name VARCHAR(255) NOT NULL,
  color VARCHAR(255),
  size VARCHAR(3),
  PRIMARY KEY (id),
  UNIQUE INDEX id_UNIQUE (id ASC));

-- create Orders table

CREATE TABLE sql11172842.orders (
  id INT NOT NULL AUTO_INCREMENT,
  username_client VARCHAR(255) NOT NULL,
  id_service INT NOT NULL,
  id_product INT NOT NULL,
  date DATETIME NOT NULL,
  state TINYINT NOT NULL DEFAULT 0,
  PRIMARY KEY (id),
  UNIQUE INDEX id_UNIQUE (id ASC),
  INDEX username_idx (username_client ASC),
  INDEX service_idx (id_service ASC),
  INDEX product_idx (id_product ASC),
  CONSTRAINT username
    FOREIGN KEY (username_client)
    REFERENCES sql11172842.clients (username)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT service
    FOREIGN KEY (id_service)
    REFERENCES sql11172842.services (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT product
    FOREIGN KEY (id_product)
    REFERENCES sql11172842.products (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

