CREATE DATABASE papeleria_sena;
GO

USE papeleria_sena;
GO

CREATE TABLE producto (
                          id INT IDENTITY(1,1) PRIMARY KEY,
                          nombre VARCHAR(100) NOT NULL,
                          descripcion VARCHAR(255),
                          cantidad INT NOT NULL,
                          precio DECIMAL(10,2) NOT NULL
);
GO