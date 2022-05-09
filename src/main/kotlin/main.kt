import MemoizationAndRecursion.canSum
import MemoizationAndRecursion.coinChange
import MemoizationAndRecursion.fib
import MemoizationAndRecursion.gridTravel
import MemoizationAndRecursion.magic
import MemoizationAndRecursion.shortestCombination
import ScopeFunctionKotlin.ep
import ScopeFunctionKotlin.okemena
import ScopeFunctionKotlin.okezi
import ScopeFunctionKotlin.okezino
import ScopeFunctionKotlin.squareE
import ScopeFunctionKotlin.squareEp
import java.util.*

fun main() {
// println(threeSum(nums))
// validPalindrome(s)
    //println(fourSum(su,8))
// SlidingWindow().also {
//  println(it.findAnagrams(sv,p))
//  println(it.findAnagrams(svw,pw))
// }
// println(merge(su,3,nums,3))

//    println(solve("codility we test coders", 14))
//    println(solve("codility we test coders", 8))
//    println(solve("why not", 100))
//    println(solve("to crop or not to crop", 21))
//    println(solve("the quick brown fox jumps over the lazy dog", 39))

 println(solving(intArrayOf(1,4,1), intArrayOf(1,5,1)))
 println(solving(intArrayOf(4,4,2,4), intArrayOf(5,5,2,5)))
 println(solving(intArrayOf(2,3,4,2), intArrayOf(2,5,7,2)))

// println(solving(intArrayOf(2,3,4,2), intArrayOf(2,5,7,2)))

    //  println(solve("abcab","ab"))
}
//
//
fun solve(s: String, K: Int): String {
    val result = s.take(K)
    if (K >= s.length) return s else {
        var count = 0
        if (s[K] == ' ') return s.take(K)
        for (i in result.lastIndex downTo 0) {
            if (result[i] == ' ') {
                count = i
                break
            }
        }
        return if (count == 0) "" else result.take(count)
    }
}


fun solving(P: IntArray, S: IntArray): Int {

    val sumPerson = P.sum()
    val arranged = S.sortedDescending()
    var count = 0
    var keep = 0

    for (i in 0..arranged.lastIndex) {
        if (sumPerson > count) {
            count += arranged[i]
            keep +=1
        }
    }
    return keep
}


fun checkAvail(s: String, a: String): Boolean {


    a.forEach {
        if (s.contains(it)) {
            return true
        }
    }
    return false
}

fun checkAvailItem(s: String, a: String): Boolean {

    s.forEach {
        if (!a.contains(it)) {
            return false
        }
    }
    return true
}
//
//fun solve(s : String , a : String) : Int {
//    var count = 0
//    for(i in 0..s.lastIndex){
//        if(checkAvailItem(s[i].toString(), a) ) count++
//        for(j in i..s.lastIndex){
//            if(checkAvailItem(s.substring(i,j), a)) count++
//        }
//    }
//
//return count
//}













