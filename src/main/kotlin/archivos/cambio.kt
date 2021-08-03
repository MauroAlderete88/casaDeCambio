package archivos

import java.text.DecimalFormat
import kotlin.math.floor


fun main(){
    var programa : Int = 0;
    var caja_dolar : Double
    var caja_peso : Double
    val cotizacion : Double
    var  formato = DecimalFormat( "#,###.00") //Variable para formato con 2 decimales.

    //Presentacion
    println("********** Bienvenidos a la casa de cambio  **************")

    // primero pido caja inicial
    println("Ingresar caja inicial en dolares del dia :")
    caja_dolar = readLine()!!.toDouble()

    // primero pido caja inicial
    println("Ingresar caja inicial en pesos del dia :")
    caja_peso = readLine()!!.toDouble()

    // segundo pido cotizacion del peso
    println("Ingresar valor de 1 ARS con respecto a 1 USD")
    cotizacion = readLine()!!.toDouble()

    //Bucle para ejecucion del programa. El sistema es sencillo, si la variable tipo entero llamado programa es 0, se ejecuta.
    //En caso contrario, si el valor es 1 se finaliza el bucle, por ende, el programa.
    while (programa == 0) {
        
        println("************** Actualmente posee USD ${formato.format(caja_dolar)} y ARS ${formato.format(caja_peso)} **************")
        println(" 1 - Vender dolares.")
        println(" 2 - Comprar dolares.")
        println(" 3 - Mostrar datos")
        println(" 4 - Finalizar programa")
        println("****************************************************")

        //Las opciones de arriba se guardaran en variable tipo entero llamada opciones.

        var opciones : Int = readLine()!!.toInt()

        if (opciones == 1) {

            println("Ingresar monto que desea vender (max posible USD ${formato.format(caja_dolar)}): ")

            var venta_accion  = readLine()!!.toDouble()

            if (venta_accion > caja_dolar){ //La orden de venta es superior a la caja en dolares imprime el error.
                println("Actualmente no posee esa cantidad de dinero en caja. ")
                println("Operacion fallo. Reintente nuevamente, ingresando un numero menor al de la caja.")
            } else {
                var resultado_peso = venta_accion * cotizacion //Variable local para cotizar la orden en ARS
                var parcial = caja_dolar - venta_accion // Variable local para depositar el resultado de la caja despues de la extraccion en dolares.
                caja_peso += resultado_peso // Se acumula en la caja en ARS el ingreso nuevo por la venta en dolares.
                caja_dolar = parcial //Se le asigna la variable local con el monto en USD actualizados a la caja en dolares para finalizar la operacion.
                println("Operacion exitosa, se actualizo su caja, ahora esta en USD ${formato.format(caja_dolar)} y ARS ${formato.format(caja_peso)}")
            }

        }else if (opciones ==2){
            var posibleCompra = caja_peso / cotizacion; //Calcula la cantidad de dolares que podes comprar de acuerdo a tu cantidad de ARS

            println("Usted posee ARS ${formato.format(caja_peso)} actualmente en caja, puede comprar hasta USD" + floor(posibleCompra) + " . Ingresar valor en USD: ")

            var compra_accion  = readLine()!!.toDouble()

            if (compra_accion > posibleCompra) { //Si el monto en USD a comprar es mayor a la posible compra envia mensaje de error.
                println("Usted no posee la cantidad de ARS para esa compra. Operacion fallida.")
                } else {
                var resultado_peso = compra_accion * cotizacion
                caja_peso -= resultado_peso
                caja_dolar += compra_accion
                println("Operacion exitosa, se actualizo su caja, ahora esta en USD ${formato.format(caja_dolar)} y ARS ${formato.format(caja_peso)}")
                }

        }else if (opciones ==3){

            println("********************* Datos ***********************")
            println("")
            println("Caja actual : USD ${formato.format(caja_dolar)} y ARS ${formato.format(caja_peso)} .")
            println("Cotizacion del dia : ARS $cotizacion = 1 USD")
            var resultado = caja_dolar * cotizacion
            println("Valor de tus dolares en ARS : $  $resultado")
            println("****************************************************")



        }else if (opciones ==4){
            println("El programa sera cerrado")
            programa++;
        }




        
        
    }
    print("*************** Programa finalizado *******************")
}