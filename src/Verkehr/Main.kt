/**
 * Created by Sven on 09.08.2017.
 */


/**
 * did not know how to add a value to a list. so i have made a list with a dozen cars because of the "scenario"-simulation
 * if somebody know how to add a variable number of cars to a list -> do it. But don´t forget the ID´s for each car.
 * idea: sth with (Java Script) add.Cars (cars: list<car>) think a mutableList
 *
 * "var network"  represents the capacity of the network
 *  maybe we should push this in the Network.kt -> 5 was just random
 */
var cars : List<Car> = listOf(Car(1), Car(2), Car(3), Car(4), Car(5), Car(6), Car(7), Car(8), Car(9), Car(10), Car(11), Car(12))
var network = Network(5, cars)
