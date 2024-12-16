use acme;

DELIMITER //

CREATE TRIGGER registrar_actualizar_estado
AFTER UPDATE ON Persona
FOR EACH ROW
BEGIN
  -- Solo registrar si el campo Estado cambió
  IF OLD.Estado <> NEW.Estado THEN
    INSERT INTO logestado(`Asunto`, `Fecha`, `Descripcion`, `Persona_idPersona`)
    VALUES(
      CONCAT('Cambio a estado ', IF(NEW.Estado, 'activo', 'inactivo')),
      NOW(),
      CONCAT('El estado de ', NEW.Nombre, ' cambió a ', IF(NEW.Estado, 'activo', 'inactivo'), '.'),
      NEW.idPersona
    );
  END IF;
END;
//
DELIMITER ;

DELIMITER //

CREATE FUNCTION validar_documento(nuevo_documento VARCHAR(20))
RETURNS BOOLEAN
DETERMINISTIC
BEGIN
  DECLARE existe INT;
  SELECT COUNT(*) INTO existe FROM Persona WHERE Documento = nuevo_documento;
  RETURN (existe = 0); -- Devolvera TRUE si no existe
END;

//

DELIMITER ;

DELIMITER //
CREATE TRIGGER trg_check_control_acceso BEFORE INSERT ON control_acceso
FOR EACH ROW
BEGIN
    IF NEW.Fecha_Salida <= NEW.Fecha_Ingreso THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Fecha de salida debe ser mayor a la de ingreso.';
    END IF;
END;
//
DELIMITER ;

DELIMITER // 
CREATE TRIGGER trg_update_persona_estado AFTER INSERT ON logestado
FOR EACH ROW
BEGIN
    UPDATE persona
    SET Estado = CASE
        WHEN NEW.Asunto LIKE '%activo%' THEN TRUE
        ELSE FALSE
    END
    WHERE idPersona = NEW.Persona_idPersona;
END;
//
DELIMITER ;

DELIMITER //

CREATE TRIGGER validar_persona_en_vehiculo
BEFORE INSERT ON vehiculo
FOR EACH ROW
BEGIN
    DECLARE persona_existente INT;
    
    SELECT COUNT(*) INTO persona_existente
    FROM persona
    WHERE idPersona = NEW.Persona_idPersona;
    
    IF persona_existente = 0 THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'La persona asignada al vehículo no está registrada';
    END IF;
END //

DELIMITER ;

DELIMITER //



