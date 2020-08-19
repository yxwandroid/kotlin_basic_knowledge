import utils.FileUtil

fun main(){
    print("wilson")

//    FileUtil.touch("/Users/wilson/Downloads/ee.amr")
    FileUtil.saveTo("/Users/wilson/Downloads/ee.amr","wilson")

}



class Person {
    val name:String = "Person"
    lateinit var mListen: (String) -> Unit // 声明mListen是一个函数（单方法接口）,入参String，无返回值

    fun setListeren(listener: (String) -> Unit){
        this.mListen = listener
        this.mListen("invoke :" +name) //等于 mListen?.invoke("invoke :" +name)  X()等同于X.invoke()

    }

    //不再需要声明接口类！
}
