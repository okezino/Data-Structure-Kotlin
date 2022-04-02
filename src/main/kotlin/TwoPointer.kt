

 var numb = intArrayOf(2,7,11,15)
var nums = intArrayOf(-2,0,0,2,2)

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
  *
  */

fun twoSum(numbers: IntArray, target: Int): IntArray {

    var first = 0
    var last = numbers.lastIndex
    var sum = numbers[first] + numbers[last]

    while(sum != target){
        if(sum > target){
            last--
            sum = numbers[first] + numbers[last]
        }else {
            first++
            sum = numbers[first] + numbers[last]
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