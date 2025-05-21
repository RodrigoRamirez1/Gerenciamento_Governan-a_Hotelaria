CREATE TABLE limpeza(
            id UUID DEFAULT gen_random_uuid() PRIMARY KEY,
            data TIMESTAMP NOT NULL,
            uh_id UUID,
            FOREIGN KEY (uh_id) REFERENCES uh(id) ON DELETE CASCADE,
            camareira_id UUID,
            FOREIGN KEY (camareira_id) REFERENCES funcionario(id) ON DELETE CASCADE

);