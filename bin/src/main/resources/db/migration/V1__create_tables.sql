
CREATE TABLE users(
	id_user BIGINT AUTO_INCREMENT PRIMARY KEY,
	username VARCHAR(100) NOT NULL UNIQUE,
	password VARCHAR(100) NOT NULL,
	email VARCHAR(100) NOT NULL UNIQUE,
	user_type VARCHAR(50) NOT NULL
);

CREATE TABLE profile_photos(
	id_profile_photo BIGINT AUTO_INCREMENT PRIMARY KEY,
	url VARCHAR(255) NOT NULL
);

CREATE TABLE background_photos(
	id_background_photo BIGINT AUTO_INCREMENT PRIMARY KEY,
	url VARCHAR(255) NOT NULL
);

CREATE TABLE companies(
	id_company BIGINT AUTO_INCREMENT PRIMARY KEY,
	name VARCHAR(100) NOT NULL,
	manager VARCHAR(100) NOT NULL,
	phone VARCHAR (50) NOT NULL,
	email VARCHAR(100) NOT NULL,
	address VARCHAR(255) NOT NULL,
	description TEXT NOT NULL,
	id_user BIGINT,
	id_profile_photo BIGINT,
	id_background_photo BIGINT ,
	FOREIGN KEY (id_user) REFERENCES users(id_user) ON DELETE CASCADE,
	FOREIGN KEY (id_profile_photo) REFERENCES profile_photos(id_profile_photo) ON DELETE CASCADE,
	FOREIGN KEY (id_background_photo) REFERENCES background_photos(id_background_photo) ON DELETE CASCADE
);


CREATE TABLE services(
	id_service BIGINT AUTO_INCREMENT PRIMARY KEY,
	name VARCHAR(100) NOT NULL,
	description TEXT,
	base_price DECIMAL(10, 2) NOT NULL,
	id_company BIGINT,
	FOREIGN KEY (id_company) REFERENCES companies(id_company) ON DELETE CASCADE
);


CREATE TABLE services_media(
	id_business_service_media BIGINT AUTO_INCREMENT PRIMARY KEY,
	url VARCHAR(255) NOT NULL,
	design_type VARCHAR(20),
	id_service BIGINT,
	FOREIGN KEY (id_service) REFERENCES services(id_service) ON DELETE CASCADE
);




CREATE TABLE customers(
	id_customer BIGINT AUTO_INCREMENT PRIMARY KEY,
	name VARCHAR(100) NOT NULL,
	phone VARCHAR (50) NOT NULL,
	email VARCHAR(100) NOT NULL,
	address VARCHAR(255) NOT NULL,
	description TEXT NOT NULL,
	id_user BIGINT ,
	id_profile_photo BIGINT ,
	id_background_photo BIGINT ,
	FOREIGN KEY (id_user) REFERENCES users(id_user) ON DELETE CASCADE,
	FOREIGN KEY (id_profile_photo) REFERENCES profile_photos(id_profile_photo) ON DELETE CASCADE,
	FOREIGN KEY (id_background_photo) REFERENCES background_photos(id_background_photo) ON DELETE CASCADE
);


CREATE TABLE reservations(
	id_reservation BIGINT AUTO_INCREMENT PRIMARY KEY,
	person_served INT NOT NULL,
	details TEXT NOT NULL,
	total_payment DECIMAL(10, 2) NOT NULL,
	id_service BIGINT NOT NULL ,
	id_customer BIGINT NOT NULL ,
	FOREIGN KEY (id_service) REFERENCES services(id_service) ON DELETE CASCADE,
	FOREIGN KEY (id_customer) REFERENCES customers(id_customer) ON DELETE CASCADE
);

CREATE TABLE favorite_topics(
	id_favorite_topics BIGINT AUTO_INCREMENT PRIMARY KEY,
	name VARCHAR(50),
	id_customer BIGINT,
	FOREIGN KEY (id_customer) REFERENCES customers(id_customer) ON DELETE CASCADE
);
