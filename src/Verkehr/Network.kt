/**
 * Created by Sven on 09.08.2017.
 */

class Network {

    /**
     * initialize of the variables. start(?) value is zero
     * variable cars represent the list/ number of cars
     * constructor(from java).. try to explain in english: for initialisation of values which are relevant for our object (here. cars and capacity)
     * i put the objects (types and the values (above)) in the constructor. This is for an independent output
     */

    var capacity = 0
    var carsOnTheRoad = 0
    var cars = listOf<Car>()

    constructor(capacity: Int, cars: List<Car>) {
        this.capacity = capacity
        this.cars = cars
        println("Network object is initialized")
    }

    /**
     * we need to know how many cars are on the road to compare the with the capacity
     * idea: a loop give us this value
     * At First, it didn't work so i have made an function in car.kt for car dring=true
     * then driving has to be identical true. This for each car so -> carsOnTheRoad increment (++)
     *
     */

    fun countCarsOnTheRoad() {
        carsOnTheRoad = 0
        for(car in cars) {
            if(car.driving == true) {
                carsOnTheRoad++
            }
        }
    }


    /**
     * this is the comparison of the number of cars on the road with the capacity of the network
     * comparison of the driving cars are identical true; see car.drive() in Car.kt
     *
     */

    fun checkCapacityAndCompare() {
        countCarsOnTheRoad()
        if(carsOnTheRoad <= capacity) {
            //here starts the loop for delaying or driving
            for(car in cars) {
                if(car.wantsToDrive == true) {
                    car.drive()
                }
            }
        } else {
            for(car in cars){
                car.delayed = true
            }
        }
    }


}




}