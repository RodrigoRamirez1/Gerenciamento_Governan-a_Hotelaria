CREATE TABLE uh (
    id UUID DEFAULT gen_random_uuid() PRIMARY KEY,
    numero INTEGER NOT NULL ,
    tipo VARCHAR(50) NOT NULL ,
    situacao VARCHAR(50) NOT NULL
);