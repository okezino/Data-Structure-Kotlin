import java.math.BigInteger

class BinarySearch {

    fun mySqrt(x: Int): Int {
        var one = 1
        var two = 2
        var first : BigInteger = one.toBigInteger()
        var last = x.toBigInteger()
        var value : BigInteger = x.toBigInteger()


        while (first < last){
            val middle  : BigInteger = first + (last - first)/two.toBigInteger()
            if(middle * middle == value) return middle.toInt() else if(
                middle * middle > value
            ){
                last = middle
            }else{
                first = middle + one.toBigInteger()
            }
        }
        println(last - one.toBigInteger())
        return (last - one.toBigInteger()).toInt()
    }

    fun searchInsert(nums: IntArray, target: Int): Int {
        var first = 0
        var last = nums.lastIndex


        while (first <= last){
            var mid = first + (last - first)/2

            if(target == nums[mid]){

                return  mid
            }else if(target > nums[mid]){

                first = mid + 1

            } else {
                last = mid  - 1
            }
        }

        return first

    }
}