package kotlin_basic

import kotlin.Int as Object

fun main() {
    /// 声明变量的时候添加? 代表变量可以为null
//    var ss:String?="dee"
//    println(ss)
//    ss=null
//    print(ss)
    val f1 = Foo(30, 49)
    val f2 = Foo(0, 39)

    val f3 = (f1 + f2);
    println(f3)

    for (i in 1..10) {
        print(i)
    }

    val property2 = User.property2
    val tag = User.tag
    val property21 = User.Companion.property2

    val value:String by lazy { "33" }
    print(value)

}

data class Foo(val x: Object, val y: Object) {
    operator fun plus(other: Foo): Foo = Foo(x + other.x, y + other.y);
}

class User {
    companion object {
        const val tag = "companion"
        private val property = "user_companion"
        val property2 = "user_companion2"

        fun newInstance(): User {
            return User()
        }
    }
}

