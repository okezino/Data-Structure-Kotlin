import java.text.FieldPosition
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

class  Person @JvmOverloads constructor(val name: String, val date: Date = Date()){
    var age : Int = 0
    private set


}

object MemoizationAndRecursion {

     // Fibonacci
        fun fib(num : Long, hashMap: HashMap<Long,Long> = HashMap()) : Long{
            if(num in hashMap.keys) return hashMap[num]!!
            if(num <= 2) return num
            hashMap[num] = fib(num-1,hashMap) + fib(num-2,hashMap)
            return hashMap[num]!!
        }

    // GridTravel

        @JvmStatic
        fun gridTravel(m : Int, n:Int, hashMap: HashMap<String, Int> =  HashMap() ) : Int{
            val key = "$m,$n"
            if(key in hashMap.keys) return  hashMap[key]!!

            if(m == 0 || n == 0) return 0
            if(m == 1 && n == 1) return 1

            hashMap[key] = gridTravel(m - 1, n, hashMap) + gridTravel(m, n-1, hashMap)

            return hashMap[key]!!
        }

    // Can Make Change

        fun canSum(target : Int, arr : Array<Int>) : Boolean{
            if(target == 0) return true
            if(target < 0) return false

            for(i in arr){
                var newTarget = target - 1
                if(canSum(newTarget,arr)) return true
            }
            return false
        }

    fun shortestCombination(target : Int, arr : Array<Int>) : ArrayList<Int>?{
        if(target == 0) return arrayListOf()
        if(target < 0) return null
        var shortest : ArrayList<Int>?= null

        for(i in arr){
            var rem = target - i
               shortest  = shortestCombination(rem, arr)
            shortest?.add(i)
            println(shortest)
        }

        return shortest

    }



    fun coinChange(target : Int, arr : Array<Int>, position: Int = 0) : Int{

        if(target == 0) return 1
        if(target < 0) return 0
        var count = 0
        for(i in position..arr.lastIndex){
            var newTarget = target - arr[i]
            count += coinChange(newTarget, arr, i)
        }
        return count
    }

    fun magic(s: Array<Array<Int>>) : Int{
        var magi = s
        var count = 0
        if(magi[1][1] != 5) {
            magi[1][1] = 5
            count++
        }

        if(magi[0].sum() != 15){
            var maxIndex = magi[0].indexOf(s[0].max())
            magi[0][maxIndex] = 15 - magi[0].filter { it != s[0].max() }.sum()
            count++

        }

        if(magi[1].sum() != 15){
            var maxIndex = magi[1].indexOf(s[1].max())
            magi[1][maxIndex] = 15 - magi[1].filter { it != s[1].max() }.sum()
            count++
        }

        if(magi[0][0] + magi[1][0] + magi[2][0] != 15){
            magi[2][0] = 15 - (magi[0][0] + magi[1][0])
            count++
        }
        if(magi[0][1] + magi[1][1] + magi[2][1] != 15){
            magi[2][1] = 15 - (magi[0][1] + magi[1][1])
            count++
        }
        if(magi[0][2] + magi[1][2] + magi[2][2] != 15){
            magi[2][0] = 15 - (magi[0][2] + magi[1][2])
            count++
        }



        println(magi[0].toList())
        println(magi[1].toList())
        println(magi[2].toList())

        return count
    }


    }
