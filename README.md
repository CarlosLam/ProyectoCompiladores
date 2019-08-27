## Proyecto Compiladores
<b>Objetivo general</b>
<ul>
<li type="disc">Crear un compilador con la aplicación del análisis léxico.</li>
</ul>
<b>Objetivos especificos</b>
<ul>
<li type="disc">Crear un escáner para el lenguaje de programación Mini-SQL.</li>
<li type="disc">Reconocer los tokens de Mini-SQ.L</li>
</ul>
<b>Funcionamiento</b>

Primero se debe hacer click en el botón de "Carga JFlex", procede a seleccionar donde se encuentra el archivo JFlex, generará un archivo
.java la cual utilizara java para analizar todas las cadenas que ingresemos. Posteriormente, se hará click en el botón "Carga SQL" que
llevará a una ventana en la cual debemos seleccionar el archivo .sql que deseamos analizar. 
A continuación el programa empezará a leer el archivo .sql y hasta no terminar de leer todos los tokens no se detendra. 
Para cada Token se analizará su estructura y se comparara con la clase .java que contiene todos los posibles tokens.
En caso de encontar un igual se retornara el token a la clase principal y esta se encargará de escribirlo en la tabla que se encuentra
en pantalla de la misma manera que lo escribirá en un archivo .out con su respectivo numero de linea que se encuentra en el archivo .sql
al igual que las columnas donde comienza y termina el token, así como también a que token pertenece.

Como errores podemos encontrar: 
<ul>
<li type="circle">La letra no es parte del lenguaje: en este caso se mostrara en pantalla y el archivo final la letra que no pertenece 
seguido de un mensaje de error</li>
<li type="circle">No se encuentra apertura/cerradura de comentario multilinea: Cuando el usuario por equivocacion ingresa una apertura/cerradura
de comentario multilinea pero se olvida del otro el programa detecta el token, informa al usuario de la falta de uno de los dos y continua
con la siguiente linea del archivo .sql</li>
<li type="circle">Identificador con más de 31 cáracteres: Cuando el programa se topa con este problema, recorta el identificador a los 
primeros 31 cáracteres y reporta en la columna "Token" en la tabla que se ha cortado el identificador, mostrando entonces el nuevo
identificador</li>
<li type="circle">Errores en cadena: esto puede tener dos casos, el primero que se encuentre una nueva linea o un apóstrofo. 
El programa indicará al usuario que tipo de error es y se pasará a analizar la siguiente línea y el otro es que no se encuentre
en la misma linea que no se encuentra la cerradura de la cadena, que también se informará del error y continuará con la siguiente linea.</li>
</ul>
