Práctica 1 realizada por:
  - Moisés Moyano Cejudo
  - Alba Palomino Jiménez
  - Carlos Rivero Talavera
  - Silvia Roldán Flores
  
 Para ejecutar los ficheros compilados a través de una terminal, se ha de ejecutar el siguiente comando:
 	
 	java -jar practica1.jar
 	
 El programa comenzará a ejecutarse, cargando la información de los ficheros usuarios.txt, pistas.txt y reservas.txt. En caso de no existir, el programa creará estos ficheros vacíos.
 
 La estructura de los ficheros es la siguiente:
 
   - usuarios.txt:
   	email/nombre completo/fecha de nacimiento/fecha de la primera reserva realizada
   	
   - pistas.txt:
   	nombre/estado/dificultad/número máximo de karts/karts asociados
   	
   - reservas.txt:
   	ID del usuario/fecha/duración/ID de la pista/precio/descuento/tipo de reserva
   	
  Asimismo, es posible registrarse si no está previamente en el sistema. En caso de estarlo, basta con iniciar sesión con el email de usuario con el que se registró.
