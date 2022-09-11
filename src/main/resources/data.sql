do '
DECLARE
    valueCounts INTEGER;
BEGIN
    SELECT COUNT(*) INTO valueCounts FROM user_table;
    IF valueCounts = 0 THEN
        INSERT INTO user_table values (1, ''No'', ''Owner'');
    END IF;
END
' LANGUAGE plpgsql;