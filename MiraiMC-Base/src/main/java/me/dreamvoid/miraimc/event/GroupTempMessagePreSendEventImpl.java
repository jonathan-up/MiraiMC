package me.dreamvoid.miraimc.event;

import java.util.List;

/**
 * 主动发送消息前 - 群临时会话消息
 */
public interface GroupTempMessagePreSendEventImpl {
    /**
     * 返回接收这条信息的机器人ID
     * @return 机器人ID
     */
    long getBotID();

    /**
     * 返回目标好友的QQ号
     * @return 好友QQ号
     */
    long getSenderID();

    /**
     * 返回目标群成员的昵称
     * @return 昵称
     */
    String getSenderNickName();

    /**
     * 返回目标群成员的群名片
     * @return 群名片
     */
    String getSenderNameCard();

    /**
     * 返回目标群成员的备注名
     * @return 备注名
     */
    String getRemark();

    /**
     * 返回接收到的消息内容转换到字符串的结果<br>
     * 此方法使用 contentToString()<br>
     * QQ 对话框中以纯文本方式会显示的消息内容，这适用于MC与QQ的消息互通等不方便展示原始内容的场景。<br>
     * 无法用纯文字表示的消息会丢失信息，如任何图片都是 [图片]
     * @return 转换字符串后的消息内容
     */
    String getMessage();

    /**
     * 返回接收到的消息内容转换到字符串的结果<br>
     * 此方法使用 contentToString()<br>
     * QQ 对话框中以纯文本方式会显示的消息内容，这适用于MC与QQ的消息互通等不方便展示原始内容的场景。<br>
     * 无法用纯文字表示的消息会丢失信息，如任何图片都是 [图片]
     * @return 转换字符串后的消息内容
     * @see #getMessage() 
     * @deprecated 
     */
    @Deprecated
    String getMessageContent();

    /**
     * 返回接收到的消息内容<br>
     * 此方法使用 toString()<br>
     * Java 对象的 toString()，会尽可能包含多的信息用于调试作用，行为可能不确定<br>
     * 如需处理常规消息内容，请使用;
     * @return 原始消息内容
     */
    String getMessageToString();

    /**
     * 返回目标群成员解除禁言的剩余时间(如果已被禁言)
     * 此方法会同时判断目标群是否开启全员禁言，如果开启，则返回 -1
     * @return 时间(秒)
     */
    int getMemberMuteRemainTime();

    /**
     * 获取目标群成员在目标群的管理权限
     * @return 0 - 普通成员 | 1 - 管理员 | 2 - 群主
     */
    int getMemberPermission();

    // 群事件公有方法
    /**
     * 返回机器人解除禁言的剩余时间(如果已被禁言)
     * 此方法会同时判断目标群是否开启全员禁言，如果开启，则返回 -1
     * @return 禁言时间(秒) - 全员禁言返回 -1
     */
    int getBotMuteRemainTime();

    /**
     * 获取目标群的群成员列表
     * 此方法只返回QQ号
     * @return 群成员列表
     */
    List<Long> getGroupMemberList();

    /**
     * 获取机器人在目标群的管理权限
     * @return 0 - 普通成员 | 1 - 管理员 | 2 - 群主
     */
    int getBotPermission();

    /**
     * 判断目标群是否允许普通成员邀请新成员
     * @return 允许返回true，不允许返回false
     */
    boolean isAllowMemberInvite();

    /**
     * 判断目标群是否允许匿名聊天
     * @return 允许返回true，不允许返回false
     */
    boolean isAnonymousChatEnabled();

    /**
     * 判断目标群是否全员禁言
     * @return 全员禁言返回true，否则返回false
     */
    boolean isMuteAll();

    /**
     * 判断目标群是否启用自动加群审批
     * @return 启用返回true，禁用返回false
     */
    boolean isAutoApproveEnabled();

    /**
     * 获取原始事件内容<br>
     * [!] 不推荐使用
     * @return 原始事件内容
     */
    String eventToString();
}
