create table abonne(
idab int primary key,
nom_prenom varchar(100) not null,
speciality varchar(100),
grp varchar(100));


create table livre(
idlivre int primary key,
titre varchar(90) not null,
autheur varchar(50),
genre varchar(50),
quantite int);


create table emprunts(
idemprunt int primary key,
idlivre int,
idab int,
dateemprt date,
datalimit date,
status smallint,
FOREIGN KEY (idlivre) REFERENCES livre(idlivre),
FOREIGN KEY (idab) REFERENCES abonne(idab),
);


INSERT INTO abonne (idab, nom_prenom, speciality, grp)
VALUES (1, 'John Doe', 'Medicine', 'Group A');
INSERT INTO abonne (idab, nom_prenom, speciality, grp)
VALUES (2, 'Jane Smith', 'Engineering', 'Group B');
INSERT INTO abonne (idab, nom_prenom, speciality, grp)
VALUES (3, 'Michael Johnson', 'Literature', 'Group A');
INSERT INTO abonne (idab, nom_prenom, speciality, grp)
VALUES (4, 'Sarah Johnson', 'Psychology', 'Group B');
INSERT INTO abonne (idab, nom_prenom, speciality, grp)
VALUES (5, 'Robert Wilson', 'History', 'Group A');

INSERT INTO livre (idlivre, titre, autheur, genre, quantite)
VALUES (1, 'The Great Gatsby', 'F. Scott Fitzgerald', 'Fiction', 5);
INSERT INTO livre (idlivre, titre, autheur, genre, quantite)
VALUES (2, 'Introduction to Python', 'John Smith', 'Computer Science', 10);
INSERT INTO livre (idlivre, titre, autheur, genre, quantite)
VALUES (3, 'Medical Encyclopedia', 'Dr. Emily Davis', 'Medicine', 3);
INSERT INTO livre (idlivre, titre, autheur, genre, quantite)
VALUES (4, 'To Kill a Mockingbird', 'Harper Lee', 'Fiction', 7);
INSERT INTO livre (idlivre, titre, autheur, genre, quantite)
VALUES (5, 'The Art of War', 'Sun Tzu', 'Philosophy', 3);

INSERT INTO emprunts (idemprunt, idlivre, idab, dateemprt, datalimit, status)
VALUES (1, 1, 2, '2023-05-15', '2023-05-30', 1);
INSERT INTO emprunts (idemprunt, idlivre, idab, dateemprt, datalimit, status)
VALUES (2, 3, 1, '2023-05-20', '2023-06-05', 1);
INSERT INTO emprunts (idemprunt, idlivre, idab, dateemprt, datalimit, status)
VALUES (3, 2, 3, '2023-05-10', '2023-05-25', 0);
INSERT INTO emprunts (idemprunt, idlivre, idab, dateemprt, datalimit, status)
VALUES (4, 2, 4, '2023-05-18', '2023-06-02', 1);
INSERT INTO emprunts (idemprunt, idlivre, idab, dateemprt, datalimit, status)
VALUES (5, 1, 5, '2023-05-12', '2023-05-27', 0);


SELECT idemprunt,titre,nom_prenom,dateemprt,datalimit,status FROM emprunts,abonne,livre WHERE emprunts.idlivre=livre.idlivre AND emprunts.idab=abonne.idab;
select * from livre;
select * from abonne;


