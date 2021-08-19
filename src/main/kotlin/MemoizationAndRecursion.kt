object MemoizationAndRecursion {


        fun fib(num : Long, hashMap: HashMap<Long,Long> = HashMap()) : Long{
            if(num in hashMap.keys) return hashMap[num]!!
            if(num <= 2) return 1
            hashMap[num] = fib(num-1,hashMap) + fib(num-2,hashMap)

            return hashMap[num]!!

        }

        fun gridTravel(m : Int, n:Int, hashMap: HashMap<String, Int> =  HashMap() ) : Int{
            val key = "$m,$n"
            if(key in hashMap.keys) return  hashMap[key]!!

            if(m == 0 || n == 0) return 0
            if(m == 1 && n == 1) return 1

            hashMap[key] = gridTravel(m - 1, n, hashMap) + gridTravel(m, n-1, hashMap)

            return hashMap[key]!!
        }
    }
