ALTER TABLE usuarios ADD active BOOLEAN;
UPDATE usuarios set active = true;