create table Movie(
  ID INT PRIMARY KEY,
  Name VARCHAR(500),
  ReleaseDate DATE
);

create table Client(
  ID INT PRIMARY KEY,
  Name VARCHAR(100),
  Address VARCHAR(500)
);

create table Rental(
  ID INT PRIMARY KEY,
  MID INT REFERENCES Movie(ID),
  CID INT REFERENCES Client(ID)
);

alter table Rental
add column rentalstart date;

alter table Rental
add column rentalend date;