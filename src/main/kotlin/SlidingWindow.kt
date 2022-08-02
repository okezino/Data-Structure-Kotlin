var sv = "cbaebabacd"
var p = "abc"
var svw = "ababababab"
var pw = "aab"

object SlidingWindow {
    /** Longest Substring Without Repeating Characters
      Given a string s, find the length of the longest substring without repeating characters.
    Example 1:

    Input: s = "abcabcbb"
    Output: 3
    Explanation: The answer is "abc", with the length of 3.
    Example 2:

    Input: s = "bbbbb"
    Output: 1
    Explanation: The answer is "b", with the length of 1.
    Example 3:

    Input: s = "pwwkew"
    Output: 3
    Explanation: The answer is "wke", with the length of 3.
    Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
     */

    fun lengthOfLongestSubstring(s: String): Int {
//      var count = 1
//        for(i in s.indices){
//            var sub = "${s[i]}"
//            loo@for(j in i + 1..s.lastIndex){
//                if(!sub.contains(s[j])){
//                    sub += s[j]
//                }else {
//                    if (count < sub.length) count = sub.length
//                    break@loo
//                }
//            }
//        }
//        return count


        var start = 0
        var end = 0
        var max = 0
        val hashset = mutableSetOf<Char>()
        while ( end < s.length){
            if(!hashset.contains(s[end])){
               hashset.add(s[end])
                end++
                max = Math.max(hashset.size, max)
            }else {
                hashset.remove(s[start])
                start++
            }
        }



        return max
    }


//
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

    /**
     * 904. Fruit Into Baskets
     * Example 1:

    Input: fruits = [1,2,1]
    Output: 3
    Explanation: We can pick from all 3 trees.
    Example 2:

    Input: fruits = [0,1,2,2]
    Output: 3
    Explanation: We can pick from trees [1,2,2].
    If we had started at the first tree, we would only pick from trees [0,1].
    Example 3:

    Input: fruits = [3,3,3,1,1,3,2,1,1,2,3,3,4]
    Output: 4
    Explanation: We can pick from trees [2,3,2,2].
    If we had started at the first tree, we would only pick from trees [1,2].
     */


    fun totalFruit(fruits: List<Int>): Int {
        var lastFruit = -1
        var  lastFruitCount = 0
        var secondLastFruit = -1
        var count = 0
        var max = 0

        for(i in fruits){
            if(i == lastFruit || i == secondLastFruit){
                max++
            }else {
              max =+  lastFruitCount + 1
            }

            if(i == lastFruit){
                lastFruitCount++
            }else {
                lastFruitCount = 1
                secondLastFruit = lastFruit
                lastFruit = i

            }
            count = Math.max(max, count)
        }
        return count

    }
}