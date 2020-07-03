package handler.hander


interface CommandHandler {

    val forCmdType: Int

    fun handle(body: ByteArray): CmdExecuteResult

    fun success(seq: Long, toWechatCmd: String? = null): CmdExecuteResult {
        return CmdExecuteResult.success(seq, toWechatCmd)
    }

    fun error(seq: Long, errMsg: String): CmdExecuteResult {
        return CmdExecuteResult.error(seq, errMsg)
    }

}

class CmdExecuteResult private constructor(
    val seq: Long,
    val success: Boolean,
    val toWechatCmd: String?,
    val errMsg: String?,
    val data: String?
) {
    companion object {



        fun success(seq: Long, toWechatCmd: String? = null): CmdExecuteResult {
            return CmdExecuteResult(seq, true, toWechatCmd, null, null)
        }

        fun success(seq: Long, toWechatCmd: String?, data: String?): CmdExecuteResult {
            return CmdExecuteResult(seq, true, toWechatCmd, null, data)
        }

        fun error(seq: Long, errMsg: String): CmdExecuteResult {
            return CmdExecuteResult(seq, false, null, errMsg, null)
        }

        fun error(seq: Long, toWechatCmd: String?, errMsg: String): CmdExecuteResult {
            return CmdExecuteResult(seq, false, toWechatCmd, errMsg, null)
        }
    }
}