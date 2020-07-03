package handler

fun main(){
    print("进行调用事件分发\n")
    CommandDispatcher.dispatch(110,"www".toByteArray())
}
