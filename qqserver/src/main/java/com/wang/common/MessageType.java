package com.wang.common;

/**
 * @Author wsz
 * @Description 不同的常量的值，表示不同的消息类型.
 * @Date 2023/4/7
 */
public enum MessageType {

    MESSAGE_LOGIN_SUCCEED("1", "登录成功"),

    MESSAGE_LOGIN_FAIL("2", "登录失败"),

    MESSAGE_COMM_MES("3", "普通信息包"),

    MESSAGE_GET_ONLINE_FRIEND("4", "要求返回在线用户列表"),
    MESSAGE_RET_ONLINE_FRIEND("5", "返回在线用户列表"),

    MESSAGE_CLIENT_EXIT("6", "客户端请求退出"),
    MESSAGE_TO_ALL_MES("7", "群发消息报"),
    MESSAGE_FILE_MES("8", "文件消息(发送文件)");

    private final String code;
    private final String message;

    MessageType(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
