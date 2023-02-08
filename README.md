<h1>Testing</h1>
Para ejecutar los test use el comando: 
"mvn test"

Ejemplo de endpoint 1: (mejorable con swagger u openapi)<br/>
curl --location --request PUT 'http://localhost:8080/account/' \
--header 'Content-Type: application/json' \
--data-raw '{
"customerId":1,
"initialCredit":6
}'

Ejemplo de endpoint 2: (mejorable con swagger u openapi)<br/>
curl --location --request GET 'http://localhost:8080/user/1'

Para ver y manipular la data a traves de la consola H2 <br/>
http://localhost:8080/h2-console/
