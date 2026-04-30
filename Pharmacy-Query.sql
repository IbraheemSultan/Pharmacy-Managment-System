create database Pharmace_Mangment;

use Pharmace_Mangment;



create table users(
id int IDENTITY(1,1) primary key ,
name varchar(255),
password varchar(255),
firstName varchar(255),
lastName varchar(255)
);

create table Customer (

Custm_ID int IDENTITY(1,1)  primary key ,
Name_Custm varchar (255) ,
Address_Custm varchar(255),
Phone_Custm varchar(255),
Type varchar(255)
);



create table Orders(
order_id int IDENTITY(1,1)  primary key ,
Custm_ID int   foreign key references Customer(Custm_ID),
order_date date ,
status varchar(255),
Product_ID  int   foreign key references Products(Product_ID), 
amount bigint,
);

create table Suppliers(
 Sup_ID INT IDENTITY(1,1) Primary Key, 
 Name varchar(255) ,
 Address varchar(255),
 Phone varchar(255)
 );


create table Products(
Product_ID int  IDENTITY(1,1)  primary key , 
Name varchar(255) ,
price   DECIMAL(10, 2)  ,
Expiry_Date date , 
Amount bigint ,
Sup_ID int  foreign key references Suppliers(Sup_Id)
);

