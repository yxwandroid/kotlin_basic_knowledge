package handler

import handler.hander.AddFriendHandeler
import handler.hander.CommandHandler

object CommandDispatcher {


    private val COMMAND_HANDLER_HOLDER = HashMap<Int, CommandHandler>()

    init {

//        TODO 方式1 通过反射实现类的加载
//        val commandHandlerClasses = ClassUtils.getAllClassesByBaseClass(
//            "com.android.service.main.oksocket.handler",
//            CommandHandler::class.java
//        )
//        for (commandHandlerClass in commandHandlerClasses) {
//            val cmdHandler = commandHandlerClass.newInstance() as CommandHandler
//            COMMAND_HANDLER_HOLDER[cmdHandler.forCmdType] = cmdHandler
//        }


//      方式2  通过代码实现类加载器

        val cmdHandler = AddFriendHandeler();

        COMMAND_HANDLER_HOLDER[cmdHandler.forCmdType] = cmdHandler



    }




    //事件分发的中央处理器
    fun dispatch(cmdType: Int, data: ByteArray) {
        val cmdHandler = COMMAND_HANDLER_HOLDER[cmdType] ?: return
        val cmdExecuteResult = cmdHandler.handle(data)

    }

}