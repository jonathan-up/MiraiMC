package me.dreamvoid.miraimc.bungee.event;

import net.mamoe.mirai.event.events.GroupTempMessageEvent;
import net.md_5.bungee.api.plugin.Event;

/**
 * 被动收到消息 - 群临时会话消息
 */
public class MiraiGroupTempMessageEvent extends Event {

    public MiraiGroupTempMessageEvent(GroupTempMessageEvent event) {
        this.event = event;
    }
    private final GroupTempMessageEvent event;

    /**
     * 返回接收到这条信息的机器人ID
     * @return 机器人ID
     */
    public long getBotID(){
        return event.getBot().getId();
    }

    /**
     * 返回接收到这条信息的群号
     * @return 群号
     */
    public long getGroupID(){
        return event.getGroup().getId();
    }

    /**
     * 返回接收到这条信息的群名称
     * @return 群名称
     */
    public String getGroupName(){
        return event.getGroup().getName();
    }

    /**
     * 返回发送这条信息的发送者ID
     * @return 发送者ID
     */
    public long getSenderID(){
        return event.getSender().getId();
    }

    /**
     * 返回发送这条信息的发送者群名片
     * @return 发送者群名片
     */
    public String getSenderNameCard(){
        return event.getSender().getNameCard();
    }

    /**
     * 返回发送这条信息的发送者昵称
     * @return 发送者昵称
     */
    public String getSenderNick(){
        return event.getSender().getNick();
    }

    /**
     * 返回接收到的消息内容
     * @return 消息内容
     */
    public String getMessage(){
        return event.getMessage().serializeToMiraiCode();
    }

    /**
     * 返回接收到这条信息的时间
     * @return 发送时间
     */
    public int getTime(){
        return event.getTime();
    }

}
