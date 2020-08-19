import java.util.concurrent.locks.ReentrantLock

/**
 * 两个线程交替打印0-100  方式三
 * 使用reentrantLock 进行处理
 */
class AlternateNumDemo3 {
    private val lock = ReentrantLock()
    private val condition1 = lock.newCondition()
    private val condition2 = lock.newCondition()

    internal inner class ThreadA : Thread() {
        override fun run() {
            while (count < 100) {
                try {
                    lock.lock()
                    while (count and 1 != 0) {
                        condition1.await()
                    }
                    println("偶数--$count")
                    count++
                    condition2.signal()
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                } finally {
                    lock.unlock()
                }
            }
        }
    }

    internal inner class ThreadB : Thread() {
        override fun run() {
            while (count < 100) {
                try {
                    lock.lock()
                    while (count and 1 != 1) {
                        condition2.await()
                    }
                    println("奇数--$count")
                    count++
                    condition1.signal()
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                } finally {
                    lock.unlock()
                }
            }
        }
    }

    fun start() {
        try {
            ThreadA().start()
            Thread.sleep(10)
            ThreadB().start()
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }
    }

    companion object {
        private var count = 0

        @JvmStatic
        fun main(args: Array<String>) {
            val alternateNumDemo3 = AlternateNumDemo3()
            alternateNumDemo3.start()
        }
    }
}