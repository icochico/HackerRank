//Objective
//Today we're expanding our knowledge of Strings and combining it with what we've already learned about loops. Check out the Tutorial tab for learning materials and an instructional video!
//
//Task
//Given a string, , of length  that is indexed from  to , print its even-indexed and odd-indexed characters as  space-separated strings on a single line (see the Sample below for more detail).
//
//Note:  is considered to be an even index.
//
//Input Format
//
//The first line contains an integer,  (the number of test cases).
//Each line  of the  subsequent lines contain a String, .
//
//Constraints
//
//Output Format
//
//For each String  (where ), print 's even-indexed characters, followed by a space, followed by 's odd-indexed characters.
//
//Sample Input
//
//2
//Hacker
//Rank
//Sample Output
//
//Hce akr
//Rn ak

import java.io.*
import java.util.*
import kotlin.io.*

fun main(args: Array<String>) {
    val t = readLine()
    val numStrings = Integer.parseInt(t)
    val inputStrings = ArrayList<String>()

    for (i in 0 until numStrings) {
        inputStrings.add(readLine()!!)
    }

    val outputStrings = ArrayList<String>()
    inputStrings.forEach {

        val even = StringBuilder()
        val odd = StringBuilder()
        var i = 0

        for (c: Char in it) {

            if (i % 2 == 0) {
                even.append(c)
            } else {
                odd.append(c)
            }

            i++
        }

        outputStrings.add(even.toString() + " " + odd.toString())
    }

    outputStrings.forEach {
        println(it)
    }

}
