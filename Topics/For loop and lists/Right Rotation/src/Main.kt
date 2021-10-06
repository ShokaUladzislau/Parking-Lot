internal object Main {
    // Function to right-rotate an array by one position
    private fun rightRotateByOne(A: ArrayList<Int>) {
        val last = A[A.size - 1]
        for (i in A.size - 2 downTo 0) {
            A[i + 1] = A[i]
        }
        A[0] = last
    }

    // Function to right-rotate an array by `k` positions
    private fun rightRotate(A: ArrayList<Int>, k: Int) {
        // base case: invalid input
        if (k < 0 || k >= A.size) {
            return
        }
        for (i in 0 until k) {
            rightRotateByOne(A)
        }
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val arr = ArrayList<Int> ()
        repeat(readLine()!!.toInt()) {
            arr.add(readLine()!!.toInt())
        }
        val k = readLine()!!.toInt()
        if (k >= arr.size) {
            rightRotate(arr, k % arr.size)
        } else {
            rightRotate(arr, k)
        }
        for (i in arr) {
            print("$i ")
        }
    }
}