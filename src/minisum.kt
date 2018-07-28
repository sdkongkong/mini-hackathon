object minisum {
    data class Range(val from: Int, val to: Int)

    @JvmStatic
    fun main(args: Array<String>) {
        val r1 = Range(3, 7)
        val r2 = Range(1, 3)
        val r3 = Range(-2, 0)
        val r4 = Range(-8, -3)
        val rangeList = listOf(r1, r2, r3, r4)
        val result = calaGap(rangeList)
        print(result)
    }

    @JvmStatic
    fun calaGap(inputList: List<Range>): Int {
        if (inputList === null || inputList.size < 2) return 0
        var smallestEnd = 0
        var largestStart = 0
        for (item in inputList) {
            largestStart = Math.max(largestStart, item.from)
            smallestEnd = Math.min(smallestEnd, item.to)
        }
        val gap = largestStart - smallestEnd
        return if (gap > 0)
            gap
        else
            0
    }
}