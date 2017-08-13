/**
 * Created by Sven on 13.08.2017.
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
var network = Network(2, cars)

fun main(args: Array<String>) {

    scenario()

}

fun simulationStep() {
    for(car in cars) {
        car.announceWantsToDrive()
    }

    network.simulateTraffic()
}

/**
 * initialize simulation
 * for each car in cars which wants to drive/ is driving will be compared to the capacity of the network
 *
 * simulationStep() --> for loop checks each car, which wants to drive. Then checks the boolean from checkCapacityAndCompare()
 * this is the key function
 */

fun scenario() {

    for (i in 0..3) {
        println("Driving for " + i + " hours")
        simulationStep()
    }

    for (car in cars) {
        println("Car ID: " + car.id + " is driving: " + car.driving + " and is delayed: " + car.delayed)
    }


}