USE acme;


-- Creación de Roles
CREATE ROLE IF NOT EXISTS 'Superusuario';
CREATE ROLE IF NOT EXISTS 'Supervisor';
CREATE ROLE IF NOT EXISTS 'Guarda';
CREATE ROLE IF NOT EXISTS 'Gerente';

-- Permisos para el rol Superusuario
-- Total control sobre el sistema
GRANT ALL PRIVILEGES ON *.* TO 'Superusuario' WITH GRANT OPTION;

-- Permisos para el rol Supervisor
-- Gestionar guardas, funcionarios y anotaciones, además de monitorear el sistema
GRANT SELECT, INSERT, UPDATE ON acme.usuario TO 'Supervisor';
GRANT SELECT, INSERT, UPDATE ON acme.rol TO 'Supervisor';
GRANT SELECT, INSERT, UPDATE ON acme.control_acceso TO 'Supervisor';
GRANT SELECT, INSERT, UPDATE ON acme.incidente TO 'Supervisor';
GRANT SELECT, INSERT, UPDATE ON acme.logincidente TO 'Supervisor';
GRANT SELECT, INSERT, UPDATE ON acme.logestado TO 'Supervisor';

-- Permisos para el rol Guarda
-- Registro de accesos y salidas, consulta de anotaciones y restricciones
GRANT SELECT, INSERT ON control_acceso_persona TO 'Guarda';
GRANT SELECT, INSERT ON control_acceso_vehiculo TO 'Guarda';
GRANT SELECT ON restriccion TO 'Guarda';
GRANT SELECT ON incidente TO 'Guarda';
GRANT SELECT ON categoria_incidente TO 'Guarda';

-- Permisos para el rol Gerente
-- Registro de trabajadores e invitados asociados a la empresa
GRANT SELECT, INSERT,UPDATE ON oficina_persona TO 'Gerente';
GRANT SELECT, INSERT, UPDATE ON persona TO 'Gerente';
GRANT SELECT ON empresa TO 'Gerente';
GRANT SELECT, UPDATE ON restriccion TO 'Gerente';
GRANT SELECT ON incidente TO 'Gerente';

-- Permisos adicionales específicos por tabla
-- Gestión de oficinas y estructura del complejo empresarial
GRANT SELECT ON torre TO 'Superusuario', 'Supervisor';
GRANT SELECT ON piso TO 'Superusuario', 'Supervisor';
GRANT SELECT ON oficina TO 'Superusuario', 'Supervisor';
GRANT SELECT ON piso_oficina TO 'Superusuario', 'Supervisor';

-- Gestión de vehículos
GRANT SELECT, INSERT ON vehiculo TO 'Supervisor', 'Guarda';
GRANT SELECT, INSERT, UPDATE ON categoriavehiculo TO 'Supervisor';

-- Gestión de permisos
GRANT SELECT, INSERT, UPDATE ON permiso TO 'Superusuario',"Supervisor";

-- Trazabilidad
GRANT SELECT ON logestado TO 'Supervisor';
GRANT SELECT ON logincidente TO 'Supervisor';

-- Permisos de acceso general según el rol
GRANT SELECT ON control_acceso TO 'Guarda';
GRANT SELECT, UPDATE ON control_acceso TO "Supervisor";
GRANT SELECT ON control_acceso_persona TO 'Guarda', 'Supervisor';
GRANT SELECT ON control_acceso_vehiculo TO 'Guarda', 'Supervisor';

-- Usuarios asociados a roles
GRANT SELECT, INSERT, UPDATE ON usuario TO 'Supervisor';

-- Crear usuarios y asignar roles
SELECT idPersona FROM acme.persona;
-- Superusuario
CREATE USER IF NOT EXISTS 'superadmin'@'%' IDENTIFIED BY 'password_superadmin';
GRANT Superusuario TO 'superadmin'@'%';

-- Supervisores
CREATE USER IF NOT EXISTS 'supervisor1'@'%' IDENTIFIED BY 'password_supervisor1';
GRANT Supervisor TO 'supervisor1'@'%';

CREATE USER IF NOT EXISTS 'supervisor2'@'%' IDENTIFIED BY 'password_supervisor2';
GRANT Supervisor TO 'supervisor2'@'%';

-- Guardas
CREATE USER IF NOT EXISTS 'guarda1'@'%' IDENTIFIED BY 'password_guarda1';
GRANT Guarda TO 'guarda1'@'%';

CREATE USER IF NOT EXISTS 'guarda2'@'%' IDENTIFIED BY 'password_guarda2';
GRANT Guarda TO 'guarda2'@'%';

-- Gerentes (funcionarios)
CREATE USER IF NOT EXISTS 'gerente1'@'%' IDENTIFIED BY 'password_gerente1';
GRANT Gerente TO 'gerente1'@'%';

CREATE USER IF NOT EXISTS 'gerente2'@'%' IDENTIFIED BY 'password_gerente2';
GRANT Gerente TO 'gerente2'@'%';

CREATE USER IF NOT EXISTS 'gerente3'@'%' IDENTIFIED BY 'password_gerente3';
GRANT Gerente TO 'gerente3'@'%';

CREATE USER IF NOT EXISTS 'gerente4'@'%' IDENTIFIED BY 'password_gerente4';
GRANT Gerente TO 'gerente4'@'%';

CREATE USER IF NOT EXISTS 'gerente5'@'%' IDENTIFIED BY 'password_gerente5';
GRANT Gerente TO 'gerente5'@'%';

CREATE USER IF NOT EXISTS 'gerente6'@'%' IDENTIFIED BY 'password_gerente6';
GRANT Gerente TO 'gerente6'@'%';

CREATE USER IF NOT EXISTS 'gerente7'@'%' IDENTIFIED BY 'password_gerente7';
GRANT Gerente TO 'gerente7'@'%';

CREATE USER IF NOT EXISTS 'gerente8'@'%' IDENTIFIED BY 'password_gerente8';
GRANT Gerente TO 'gerente8'@'%';

CREATE USER IF NOT EXISTS 'gerente9'@'%' IDENTIFIED BY 'password_gerente9';
GRANT Gerente TO 'gerente9'@'%';

CREATE USER IF NOT EXISTS 'gerente10'@'%' IDENTIFIED BY 'password_gerente10';
GRANT Gerente TO 'gerente10'@'%';

