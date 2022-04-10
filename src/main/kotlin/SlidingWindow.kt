var sv = "cbaebabacd"
var p = "abc"
var svw = "ababababab"
var pw = "aab"

class SlidingWindow {

    fun findAnagrams(s: String, p: String): List<Int> {
        var list = arrayListOf<Int>()
        val lengthOfP = p.length - 1
        val lengthOfS = s.length - 1
        val hashMapOfP = p.groupBy { it }
        println(hashMapOfP)

        for(i in 0..lengthOfS - lengthOfP){
            val s = s.substring(i..lengthOfP + i)
            if(s.groupBy { it } == hashMapOfP) list.add(i)
        }
        return list.toList()
    }
}