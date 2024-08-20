
ALTER TABLE reservations
ADD COLUMN date DATE;


-- Si la columna existe pero tiene un tipo de datos incorrecto:
-- ALTER TABLE reservations
-- MODIFY COLUMN date DATE;