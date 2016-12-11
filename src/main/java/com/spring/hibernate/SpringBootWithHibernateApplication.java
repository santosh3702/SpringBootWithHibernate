package com.spring.hibernate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootWithHibernateApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootWithHibernateApplication.class, args);
	}
}

/*Employee Table
mysql> CREATE TABLE EMPLOYEE
 (
     ID          INT PRIMARY KEY AUTO_INCREMENT,
     FIRSTNAME   VARCHAR(30),
     LASTNAME    VARCHAR(30),
     TELEPHONE   VARCHAR(15),
     EMAIL       VARCHAR(30),
     CREATED     TIMESTAMP DEFAULT NOW()
 );
*/