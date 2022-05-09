# kruger_challenge
Back end developer challenge for kruger coorp

Ejecutar el script DATABASE_QUERYS en la base de datos local de postgres.

Se despliega la API:.../person/addAdmin que recibe un parametro de tipo Persona (verificar documentacion .../swagger-ui/index.html) creando una nueva persona y un usuario a la vez que tendra como username la cedula y password la cedula.

La seguridad esta implementa con jwt, con el nuevo usuario administrador se puede llamar a la API: .../api/login
pasandole como parametros el username y password del usuario administrador para obtener el access_token.

Con el access token se puede acceder al resto de ws... estoy en proceso de implementar validacion por roles aún.



