

import java.util.Random

/**
 *  made a class with the functions we need to implement the simulation; simple boolean type
 *  the set up is: driving, delayed, wants to drive (difficult.. thought random)
 */

class Car {

    var driving = false
    var wantsToDrive = false
    var delayed = false
    var id = 0


    /**
     * gave the constructor a value with type integer. thought we want to know which car of the list(see: Network.kt) is initialized, driving or delayed
     * further, i thought to randomize the simulation.. just because it is a simulation and the cars have to know if they are driving or not. not the user(we)?!
     */

    constructor(id: Int) {
        this.id = id
        println("Car: " +id + " object is initialized")
    }



    /**
     * next.Boolean for the next input of boolean
     */


    /**
     * announceWantsToDrive just for the Output
     */
    fun announceWantsToDrive() {
        if(wantsToDrive) {
            println("Car " + id + " wants to drive")
        }  else {
            println("Car " + id + " does not want to drive")
            }


    }


    fun drive() {
        this.driving = true
    }

    /** need this for the countCarsOnTheRoad() in Network.kt */

}