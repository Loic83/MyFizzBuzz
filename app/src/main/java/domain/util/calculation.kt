package domain.util

import domain.model.Input

class calculation () {

    companion object {
        fun calculResult(input : Input): Array<Pair<Int, String>> {
            val str1 = input.str1
            val str2 = input.str2
            val limit = input.limit
            val int1 = input.int1
            val int2 = input.int2

            val multiple = int1 * int2

            val map: MutableMap<Int, String> = HashMap()

            for (i in 1..limit) {
                var result: String
                if (i % multiple == 0) {
                    result = str1 + str2
                } else if (i % int1 == 0) {
                    result = str1
                } else if(i % int2 == 0) {
                    result = str2
                } else {
                    result = ""+i
                }

                map[i] = result
            }

            return map.toList().toTypedArray()
        }
    }





}