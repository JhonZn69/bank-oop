# Banco 

Crea una aplicación que sirva para gestionar las cuentas de los clientes de un banco. 

## Beans

### Bank

Campos:
- Nombre del banco
- Array de cuentas.

Métodos:
- Mostrar todas las cuentas del banco (IBAN, saldo y NIF del cliente)
- Dado un IBAN, mostrar la información de la cuenta con ese IBAN.
- Dado un NIF, mostrar todas las cuentas del cliente con ese NIF 
- Dado un IBAN y una cantidad de dinero, ingresar esa cantidad en la cuenta con ese IBAN. Si no se encuentra la cuenta con ese IBAN muestra el mensaje "No se encuentra la cuenta"
- Dado un NIF, devuelve el numero de cuentas de ese cliente
- Dado un IBAN, devuelve los datos del cliente al que  pertenece la cuenta. Si no existe la cuenta, devuelve null 
- Dados dos IBAN y una cantidad de dinero, realiza una transferencia desde la cuenta con el primer IBAN a la cuenta con el segundo IBAN. Si una de las cuentas no existo o no hay suficiente saldo en la cuenta de origen no se realiza la trasnferencia y se muestra un error explicando el problam

### Account

Campos:
- IBAN: String
- Saldo: double
- Cliente: customer

### Customer (cliente)

Campos:
- NIF
- Nombre
- Apellidos

## Componentes

### Readers

Crea readers para todos los beans

### BankApp

Tendrá un método run() que realice los siguiente:
- Pide los datos de un banco
- Inicia un bucle de menú con las siguientes opciones
  1. Mostrar las cuentas del banco
  2. Mostrar datos de una cuenta
     - Se pide un IBAN
     - Se busca la cuenta con ese IBAN.
     - Si no existe se muestra el mensaje "No existe la cuenta", si existe se muestra todo en pantall
  3. Mostrar los datos de las cuentas de un cliente
     - Se pide un nif
     - Se recorren las cuentas comprobando si son del cliente con ese nif. Se muestran en pantalla
  4. Ingresar dinero en cuenta
     - Se pide un IBAN
     - Se pide una cantidad de dinero
     - Se busca la cuenta con el IBAN. 
       - Si no existe se muestra el mensaje "No existe la cuenta"
       - Si existe se modifica el saldo, añadiendo la cantidad. 
       - Se muestra la cuenta
  5. Sacar diner de una cuenta
     - Se pide un IBAN
     - Se pide una cantidad de dinero
     - Se busca la cuenta con el IBAN.
         - Si no existe se muestra el mensaje "No existe la cuenta"
         - Si hay suficiente saldo, se reduce el saldo. Si no hay suficiente saldo se muestra "Saldo insuficiente"
         - Se muestra la cuenta
  6. Contar cuentas de cliente
  7. Mostrar cliente de cuenta
  8. Realizar transferencia

### BankApp2

Tendrá un método run() que realice lo siguiente:
- Pide un banco usando BankReader
- Busca la cuenta con IBAN "ES0001".
  - Si no existe muestra "La cuenta no existe"
  - Si existe, hace un deposito en la misma de 500
- Busca otra cuenta con IBAN "ES0002"
  - Si no existe muestra "La cuenta no existe"
  - Si existe, saca 30 euros 
- Muestra en pantalla la información de la cuenta "ES0001"
- Muestra en pantalla la información de la cuenta "ES0002"
- Haz una trasnferencia de 500 euros desde "ES0001" a "ES0002"

### BankApp3

Tendrá un método run() que realice lo siguiente:
- Pide un banco usando BankReader
- Muestra todas las cuentas del banco
- Saca 50 de la cuenta ES0003
- Muestra las cuentas del cliente con NIF 000X
- Mete 300 en la cuenta ES004
- Muestra los datos del titular de la cuenta ES0001

### BankApp4

Tendrá un método run() que realice lo siguiente:
- Pide un banco usando BankReader
- Busca la cuenta con IBAN ES0001
  - Si no existe la cuenta muestra un mensaje de error
  - Si existe:
    - Muestra los datos de la cuenta
    - Haz una transferencia de todo el dinero de la cuenta ES0001 a la cuenta ES0002
    - Muestra la información del banco
