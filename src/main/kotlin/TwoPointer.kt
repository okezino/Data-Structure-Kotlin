

 var numb = intArrayOf(2,7,11,15)
var nums = intArrayOf(-1,0,1,2,-1,-4)
 var su = intArrayOf(0,0,0,0)


 var s = "abca"

 /**
  * Palindrome is simple solve using the reverse method ,
  * but to analyze 2 pointer technique we will be looping through.
  */
 fun isPalindrome(s: String): Boolean {
     var result = true
     var regex = Regex("[^a-z0-9]")

     /**
      * we can also use String.filter{ it.isLetterOrDigit() } in place of the regex
      */
     var input = s.toLowerCase()
     var string = regex.replace(input,"")
     var first = 0
     var last = string.lastIndex

     loo@while(first <= last){
         if(string[first] != string[last]){
             result = false
             break@loo
         }
         first++
         last--
     }

     return result

 }

 /**
  *This is a more complicated palindrome that creates room for one more mistake.
  * if removing one wrong letter from a non palindrome string will make it palindrome , then return true
  */

 fun validPalindrome(s: String): Boolean {
     var first = 0
     var last = s.lastIndex

     while (first < last ){
         if(s[first] != s[last]){
             val firsts = s.substring(first until last)
             val lasts = s.substring(first +1..last)
             return firsts == firsts.reversed() || lasts == lasts.reversed()
         }else{
             first++
             last--
         }
     }

     return true
 }

fun twoSum(numbers: IntArray, target: Int): IntArray {

    var first = 0
    var last = numbers.lastIndex
    var sum = numbers[first] + numbers[last]

    while(sum != target){
        sum = if(sum > target){
            last--
            numbers[first] + numbers[last]
        }else {
            first++
            numbers[first] + numbers[last]
        }
    }
    return intArrayOf(first,last)

}


fun threeSum(nums: IntArray): List<List<Int>> {
    val arr = arrayListOf<List<Int>>()
    nums.sorted()
    for(i in 0..nums.lastIndex - 2){
       if(i == 0 || nums[i] != nums[i - 1]){
           var first = i + 1
           var last = nums.lastIndex
           var sum = 0 - nums[i]

           while(first < last){
               var subsum = nums[first] + nums[last]
               if(subsum == sum){

                   arr.add(listOf(nums[i],nums[first],nums[last]))
                   while (nums[last] == nums[last - 1] ) last--
                   while (nums[first] == nums[first + 1] ) first--
                   last--
                   first++

               }else if(subsum > sum){
                   last--
               }else {
                   first++
               }
           }

       }
    }
    return arr.toList()
}

 fun fourSum(nums: IntArray, target: Int): List<List<Int>> {
     nums.sort()
     var result = arrayListOf<List<Int>>()

     for(i in 0..nums.lastIndex - 3){
         if(i > 0 && nums[i] == nums[i - 1]){

         }else{
         for(j in i+1..nums.lastIndex - 2){

             if(j == i + 1 && nums[j] == nums[j - 1]){

             }else{
                 var last = nums.lastIndex
                 var first = j + 1
                 var sum = target - nums[i] - nums[j]
                 while (first < last){
                     var subSum = nums[first] + nums[last]
                     if(subSum > sum){
                         last--
                     }else if(subSum < sum){
                         first++
                     }else {
                         result.add(arrayListOf(nums[i],nums[j],nums[first],nums[last]))
                         while (first < last && nums[last - 1] == nums[last]) last--
                         while (first < last && nums[first + 1] == nums[first]) first++
                         last--
                         first++
                     }
                 }

             }}
         }
     }

     return result.toList()

 }


 fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {

 }