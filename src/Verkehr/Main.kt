import com.univocity.parsers.common.record.Record
import com.univocity.parsers.csv.CsvParser
import com.univocity.parsers.csv.CsvParserSettings
import com.univocity.parsers.csv.CsvWriter
import com.univocity.parsers.CsvWriterSettings

fun main(args: Array<String>) {

    /**
     * did not know how to add a value to a list. so i have made a list with a dozen cars because of the "scenario"-simulation
     * if somebody know how to add a variable number of cars to a list -> do it. But don´t forget the ID´s for each car.
     * idea: sth with (Java Script) add.Cars (cars: list<car>) think a mutableList
     *
     * "var network"  represents the capacity of the network
     *  maybe we should push this in the Network.kt -> 5 was just random
     */
    var cars: List<Car> = listOf(Car(1), Car(2), Car(3), Car(4), Car(5), Car(6), Car(7), Car(8), Car(9), Car(10), Car(11), Car(12))
    var network = Network(5, cars)
    var capacity = 5

    /**
     * initialize simulation
     * for each car in cars which wants to drive/ is driving will be compared to the capacity of the network
     *
     * simulationStep() --> for loop checks each car, which wants to drive. Then checks the boolean from checkCapacityAndCompare()
     * this is the key function
     */

    fun simulationStep() {
        for (car in cars) {
            car.announceWantsToDrive()
        }

        network.simulateTraffic()
    }

    /**
     * initializing variables
     * function "scenario" = simulation step
     * values in the for-loop represent the simulation steps (here: 1=1hour)
     * then back to the key function "simulation step" (see above)
     * cars each announce wether they want to drive or not
     * compare the capacity of the road to the cars on the street
     * and print wether all cars are delayed or not
     * */
    val networkcapacity = network.capacity
    var carsOnTheRoad = 0
    fun scenario() {

        for (i in 0..23) {
            println("Driving for " + i + " hours")
            simulationStep()
            if (networkcapacity >= carsOnTheRoad) {
                println("All cars can drive")

            } else {
                println("All cars are delayed")
            }
        }


        for (car in cars) {

            if (car.driving)
                carsOnTheRoad++

        }
    }

    fun networkfromcsv(fileName: String): Network {
        //setting up Csv
        val settings = CsvParserSettings()
        settings.format.setlineSeperator("\n")
        settings.isHeaderExtractionEnabled = true
        //initializing values
        var CsvParser = CsvParser(settings)
        var reader = FileAccess().getReader(fileName)
        var RowOfACar: MutableList<Record> = csvParser.parseAllRecords(reader)
        var CarList: MutableList<Car> = mutableListOf()

        for (car in RowOfACar) {
            var carID = car.values.get(0)
            var id = carID.toInt()

            var carStatus = car.values.get(1)
            var wantsToDrive = car.drive
            val newCar = Car(id)

            CarList.add(newCar)
        }
        return Network(capacity, cars)
    }


    fun networkToCsv(network: Network, fileName: String) {
        var settings = CsvWriterSettings()
        settings.format.setLineSeperator("\n")
        var writer = AccessToFile().getWriter(fileName)
        var csvWriter = CsvWriter(writer, settings)
        csvWriter.writeHeaders("Car-ID", "Wants to Drive", "delayed")

        var RowOfACar: MutableList<Array<Any>> = mutableListOf()

        for (car in cars) {
            var id = car.id
            var wantsToDrive = car.driving
            var delayed = car.delayed
            var line: Array<Any> = arrayOf(id, wantsToDrive, delayed)
            RowOfACar.add(line)


        }


        csvWriter.writeRowsAndClose(RowOfACar)
    }
    scenario()
    var road = networkfromcsv("/cars.csv")
    road.simulateTraffic()
    networkToCsv(road, "Result.csv")

}