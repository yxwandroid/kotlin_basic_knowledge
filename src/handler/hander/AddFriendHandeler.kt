package handler.hander

class AddFriendHandeler: CommandHandler {
    override val forCmdType: Int
        get() = 110

    override fun handle(body: ByteArray): CmdExecuteResult {
        print("进行事件的处理\n")
        return CmdExecuteResult.success(110, "110")
    }
}