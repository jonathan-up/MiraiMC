package me.dreamvoid.miraimc.velocity.event.message.postsend;

import me.dreamvoid.miraimc.api.bot.MiraiFriend;
import me.dreamvoid.miraimc.velocity.VelocityPlugin;
import net.mamoe.mirai.event.events.FriendMessagePostSendEvent;

/**
 * (bungee) Mirai 核心事件 - 消息 - 主动发送消息后 - 好友消息
 */
public class MiraiFriendMessagePostSendEvent extends AbstractMessagePostSendEvent {

    public MiraiFriendMessagePostSendEvent(FriendMessagePostSendEvent event) {
        super(event);
        this.event = event;

        VelocityPlugin.INSTANCE.getServer().getEventManager().fire(new me.dreamvoid.miraimc.velocity.event.MiraiFriendMessagePostSendEvent(event));
    }

    private final FriendMessagePostSendEvent event;

    /**
     * 返回目标好友的QQ号
     * @return 好友QQ号
     */
    public long getFriendID(){
        return event.getTarget().getId();
    }

    /**
     * 返回目标好友的昵称
     * @return 昵称
     */
    public String getFriendNickName(){ return event.getTarget().getNick(); }

    /**
     * 返回目标好友的备注名
     * @return 备注名
     */
    public String getFriendRemark(){ return event.getTarget().getRemark(); }

    /**
     * 获取好友实例
     * @return MiraiFriend 实例
     */
    public MiraiFriend getFriend(){
        return new MiraiFriend(event.getBot(), event.getTarget().getId());
    }
}