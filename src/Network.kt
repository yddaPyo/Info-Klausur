class Network {

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
        for (car in cars) {
            if (car.driving == true) {
                carsOnTheRoad++
            }
        }
    }

    fun simulateTraffic() {
        countCarsOnTheRoad()
        if (carsOnTheRoad <= capacity) {
            // Step 3 starts here
            for (car in cars) {
                if (car.wantsToDrive == true) {
                    car.drive()
                }
            }
        } else if (carsOnTheRoad > capacity) {
            for (car in cars) {
                if (car.wantsToDrive == true) {
                    car.late()
                }
            }
        }
    }

}
