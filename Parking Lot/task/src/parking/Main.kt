package parking

import java.util.*
import kotlin.collections.ArrayList

fun main() {
    var parking = ArrayList<Spot>()
    var parkingLots = 0
    var allSpotsAreFull = false
    var allSpotsAreFree = true

    var foundRegByColorCars = ArrayList<String>()
    var foundSpotByColorCars = ArrayList<Int>()
    var foundSpotByRegCars = ArrayList<Int>()

    while (true) {
        val command = readLine()!!.split(" ")
        when (command[0].lowercase()) {

            "create" -> {
                parkingLots = command.last().toInt()
                parking = ArrayList()
                allSpotsAreFree = true
                for (i in 0 until parkingLots) {
                    parking.add(Spot(true, i))
                }
                println("Created a parking lot with ${parking.size} spots.")
            }

            "status" -> {
                if (parkingLots > 0) {
                    if (allSpotsAreFree) {
                        println("Parking lot is empty.")
                    } else {
                        for (i in 0 until parking.size) {
                            if (!parking[i].isEmpty) {
                                println("${parking[i].number + 1} ${parking[i].plate} ${parking[i].color}")
                            }
                        }
                    }
                } else {
                    println("Sorry, a parking lot has not been created.")
                }
            }

            "reg_by_color" -> {
                if (parkingLots > 0) {
                    if (allSpotsAreFree) {
                        println("Parking lot is empty.")
                    } else {
                        var foundRegByColor = false
                        for (i in 0 until parking.size) {
                            if (!parking[i].isEmpty && parking[i].color == command[1].lowercase(Locale.getDefault())) {
                                parking[i].plate?.let { foundRegByColorCars.add(it) }
                                foundRegByColor = true
                            }
                        }
                        if (foundRegByColorCars.isNotEmpty()) {
                            println(foundRegByColorCars.joinToString(", "))
                            foundRegByColorCars = ArrayList()
                        }
                        if (!foundRegByColor) {
                            println("No cars with color ${command[1]} were found.")
                        }
                    }
                } else {
                    println("Sorry, a parking lot has not been created.")
                }
            }

            "spot_by_color" -> {
                if (parkingLots > 0) {
                    if (allSpotsAreFree) {
                        println("Parking lot is empty.")
                    } else {
                        var foundSpotByColor = false
                        for (i in 0 until parking.size) {
                            if (!parking[i].isEmpty && parking[i].color == command[1].lowercase(Locale.getDefault())) {
                                parking[i].number.let { foundSpotByColorCars.add(it + 1) }
                                foundSpotByColor = true
                            }
                        }
                        if (foundSpotByColorCars.isNotEmpty()) {
                            println(foundSpotByColorCars.joinToString(", "))
                            foundSpotByColorCars = ArrayList()
                        }
                        if (!foundSpotByColor) {
                            println("No cars with color ${command[1]} were found.")
                        }
                    }
                } else {
                    println("Sorry, a parking lot has not been created.")
                }
            }

            "spot_by_reg" -> {
                if (parkingLots > 0) {
                    if (allSpotsAreFree) {
                        println("Parking lot is empty.")
                    } else {
                        var foundSpotByReg = false
                        for (i in 0 until parking.size) {
                            if (!parking[i].isEmpty && parking[i].plate == command[1]) {
                                parking[i].number.let { foundSpotByRegCars.add(it + 1) }
                                foundSpotByReg = true
                            }
                        }
                        if (foundSpotByRegCars.isNotEmpty()) {
                            println(foundSpotByRegCars.joinToString(", "))
                            foundSpotByRegCars = ArrayList()
                        }
                        if (!foundSpotByReg) {
                            println("No cars with registration number ${command[1]} were found.")
                        }
                    }
                } else {
                    println("Sorry, a parking lot has not been created.")
                }
            }

            "park" -> {
                if (parkingLots > 0) {
                    for (i in 0 until parking.size) {
                        if (parking[i].isEmpty) {
                            parking[i] =
                                (Spot(false, command[1], command[2].lowercase(Locale.getDefault()), parking[i].number))
                            println("${command.last()} car parked in spot ${parking[i].number + 1}.")
                            allSpotsAreFull = false
                            allSpotsAreFree = false
                            break
                        } else {
                            allSpotsAreFull = true
                        }
                    }
                    if (allSpotsAreFull) {
                        println("Sorry, the parking lot is full.")
                    }
                } else {
                    println("Sorry, a parking lot has not been created.")
                }
            }

            "leave" -> {
                if (parkingLots > 0) {
                    if (parking[command.last().toInt() - 1].isEmpty) {
                        println("There is no car in spot ${command.last().toInt()}.")
                    } else {
                        parking[command.last().toInt() - 1] = Spot(true, command.last().toInt() - 1)
                        println("Spot ${command.last().toInt()} is free.")
                        allSpotsAreFull = false
                    }
                    for (i in 0 until parking.size) {
                        if (!parking[i].isEmpty) {
                            allSpotsAreFree = false
                            break
                        } else {
                            allSpotsAreFree = true
                        }
                    }
                } else {
                    println("Sorry, a parking lot has not been created.")
                }
            }
            "exit" -> break
            else -> println("unknown command")
        }
    }
}

class Spot {
    var isEmpty: Boolean = true
    var plate: String? = null
    var color: String? = null
    var number: Int = 0

    constructor(_isEmpty: Boolean, _plate: String, _color: String, _number: Int) {
        isEmpty = _isEmpty
        plate = _plate
        color = _color
        number = _number
    }

    constructor(_isEmpty: Boolean, _number: Int) {
        isEmpty = _isEmpty
        number = _number
    }
}