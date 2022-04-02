
//var  nums = [-1,0,1,2,-1,-4]
 var numb = intArrayOf(2,7,11,15)
var nums = intArrayOf(-2,0,0,2,2)

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