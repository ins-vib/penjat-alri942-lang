Joc del Penjat

Aquest projecte implementa el joc del penjat en Java, funcionant per consola.  
El programa ha estat desenvolupat seguint els requeriments de l'exercici: ús de mètodes estàtics, arrays i tractament de caràcters.

Objectiu del joc

L'objectiu és endevinar una paraula oculta abans de cometre 6 errors.  
Cada vegada que el jugador falla, es mostra una part del ninot del penjat.

Funcionalitats

- Escollir aleatòriament una paraula d’un array proporcionat.
- Mostrar un estat inicial de guions baixos (`_`).
- Demanar lletres vàlides (entre 'a' i 'z').
- Actualitzar l’estat amb les lletres encertades.
- Portar un comptador d’errors (màxim 6).
- Mostrar el dibuix del penjat segons els errors acumulats.
- Determinar quan la paraula està completada.

Estructura del programa

El programa inclou els següents mètodes obligatoris:

- `obtenirParaula()`
- `mostrarNinot(int errors)`
- `demanarLletra()`
- `inicialitzarEstat(String paraula)`
- `actualitzarEstat(char[] estat, String paraula, char lletra)`
- `mostrarEstat(char[] estat)`
- `paraulaCompletada(char[] estat)`
- `main()`

Tots els mètodes són estàtics i el joc es gestiona íntegrament des de consola.
