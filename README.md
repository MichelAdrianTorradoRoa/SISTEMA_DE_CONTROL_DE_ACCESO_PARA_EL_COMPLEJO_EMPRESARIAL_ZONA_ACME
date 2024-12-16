# Proyecto de Base de Datos para Gestión Empresarial 🗄️

Este repositorio contiene el esquema, configuraciones y procedimientos SQL para la implementación de una base de datos de gestión empresarial.

## Tabla de Contenidos 📋
| Índice | Título  |
|--------|---------|
| 1      | [Requerimientos](#requerimientos) |
| 2      | [Instalación](#instalacion)       |
| 3      | [Uso del Proyecto](#uso-del-proyecto) |
| 4      | [Contribuciones](#contribuciones) |
| 5      | [Licencia y Contacto](#licencia-y-contacto) |
| 6      | [Autores](#autores)               |

---

## 1. Requerimientos 📋

Para implementar y ejecutar este proyecto necesitas:

- **Sistema de Gestión de Base de Datos**: MySQL 8.0 o superior.
- **Entorno de Desarrollo**: Apache NetBeans, VSCode u otro editor compatible con SQL.
- **Software de Control de Versiones**: Git.
- **Repositorio Privado en GitHub** (para seguimiento y despliegue).
- **Sistemas Operativos Compatibles**: Windows, Linux o MacOS.

---

## 2. Instalación ⚙️

### 2.1 Clonar el Repositorio

Ejecuta el siguiente comando en tu terminal para clonar este proyecto:
```bash
https://github.com/MichelAdrianTorradoRoa/SISTEMA_DE_CONTROL_DE_ACCESO_PARA_EL_COMPLEJO_EMPRESARIAL_ZONA_ACME.git
```

### 2.2 Configuración de Base de Datos

1. Importa el archivo `acme.sql` que contiene la estructura y datos iniciales:
```bash
mysql -u usuario -p nombre_base_datos < database.sql
```

2. Verifica la creación de tablas y datos:
```sql
USE nombre_base_datos;
SHOW TABLES;
```

### 2.3 Configuración de Usuarios SQL y Roles

Ejecuta el script `roles_usuarios.sql` para crear los roles y usuarios con sus respectivos permisos:
```sql
source roles_usuarios.sql;
```

---

## 3. Uso del Proyecto 🚀

Este proyecto permite:

- Gestión de empleados, clientes, productos y ventas.
- Implementación de permisos y roles para asegurar la integridad y seguridad de la base de datos.
- Ejecución de consultas SQL predefinidas.

### Roles Disponibles:

| Rol           | Permisos                                               |
|---------------|--------------------------------------------------------|
| **Superusuario** | Control total sobre la base de datos.                 |
| **Supervisor**   | Gestionar registros de acceso, incidentes y usuarios. |
| **Guarda**       | Registro de accesos y consulta de anotaciones.        |
| **Gerente**      | Gestión de empleados e invitados asociados a la empresa. |

---


## 4. Autores ✍️
Hecho por [@AlvaroAndresMartinezAlcina](https://github.com/alvaroMartinez13), [@MichelAdrianTorradoRoa](https://github.com/MichelAdrianTorradoRoa) y [@JuanDavidCondeMartinez](https://github.com/juanconde025) 
