# inventory

Aplicacion sencilla con spring boot para prueba de java y postgreSQL

Para correr la aplicacion es necesario tener instalado docker-compose

Para ejecutar la aplicacion ejecutar el comando docker-compose up -d

End points de prueba

GET localhost:8080/greetings
  - Parametros
    - name (opcional)
  - Respuesta
    - Hola Mundo

GET localhost:8080/category/all
  - Parametros
    - Ninguno
  - Respuesta
    - Array de objetos
      - id
      - name
      
GET localhost:8080/category/{id}
   - Parametros
      - id en url (Requerido)
      - Ninguno
   - Respuesta
      - id
      - name

POST localhost:8080/category/save
  - Parametros
      - name (Requerido)
  - Respuesta
    - id
    - name
