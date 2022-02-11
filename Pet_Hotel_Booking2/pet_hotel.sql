
CREATE DATABASE pet_hotel;

CREATE TABLE Admin (
	name TEXT NOT NULL ,
    username TEXT NOT NULL ,
	email TEXT NOT NULL ,
    password TEXT NOT NULL
);

CREATE TABLE Customer (
	name TEXT NOT NULL ,
    username TEXT NOT NULL ,
	email TEXT NOT NULL ,
    password TEXT NOT NULL
);



CREATE TABLE Hotel (
    id INT NOT NULL AUTO_INCREMENT ,
    hotel_id TEXT NOT NULL ,
    name TEXT NOT NULL ,
    type TEXT NOT NULL ,
    descr TEXT NOT NULL ,
    rating TEXT NOT NULL,
    address TEXT NOT NULL ,
    town TEXT NOT NULL ,
    city TEXT NOT NULL ,
    PRIMARY KEY (id)  
);

CREATE TABLE Room (
	id INT NOT NULL AUTO_INCREMENT, 
        room_id TEXT NOT NULL ,  
        hotel_id TEXT NOT NULL,
        price TEXT NOT NULL,
        type TEXT NOT NULL ,
        descr TEXT NOT NULL,
        day TEXT NOT NULL ,
        month TEXT NOT NULL ,
        year TEXT NOT NULL ,
        isAvailable TEXT NOT NULL ,
        PRIMARY KEY (id)        
);

CREATE TABLE Booking (
    id INT NOT NULL AUTO_INCREMENT, 
    room_id TEXT NOT NULL,
    name TEXT NOT NULL,
    duration TEXT NOT NULL,
PRIMARY KEY (id) 
);

INSERT INTO Customer(name,username,email, password ) VALUES('a', 'a','a','a');
INSERT INTO Admin(name,username,email, password ) VALUES('a', 'a','a','a');

INSERT INTO `room` (`id`, `room_id`, `hotel_id`, `price`, `type`, `descr`, `day`, `month`, `year`, `isAvailable`) VALUES
(1, '1', '1', '100', 'Dog', 'a', '10', '10', '2020', 'true'),
(2, '2', '1', '200', 'Dog', 'a', '11', '11', '2020', 'true'),
(3, '3', '1', '100', 'Cat', 'a', '10', '10', '2020', 'true');

INSERT INTO `hotel` (`id`, `hotel_id`, `name`, `type`, `descr`, `rating`, `address`, `town`, `city`) VALUES
(1, '1', 'hotel1', 'Cat', 'animal', '3', 'Jones Street', 'Manhattan', 'NewYork'),
(2, '2', 'hotel2', 'Dog', 'animal', '2', 'boston', 'boston', 'boston'),
(3, '3', 'hotel3', 'Cat', 'animal', '1', 'italy', 'italy', 'italy'),
(4, '4', 'hotel4', 'Cat', 'animal', '4', 'newyork', 'newyork', 'newyork'),
(5, '5', 'hotel5', 'Dog', 'animal', '5', 'usa', 'usa', 'usa');


INSERT INTO `booking` (`id`, `room_id`, `name`, `duration`) VALUES
(1, '1', 'a', '1');