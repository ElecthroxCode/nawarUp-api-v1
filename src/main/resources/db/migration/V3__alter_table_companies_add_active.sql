
ALTER TABLE companies ADD active TINYINT;
UPDATE companies SET active = 1;

-- Agregar una nueva columna llamada active de tipo boolean:
-- ALTER TABLE companies ADD active TINYINT