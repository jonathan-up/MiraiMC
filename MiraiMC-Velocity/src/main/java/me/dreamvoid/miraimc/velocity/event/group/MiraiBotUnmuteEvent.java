package me.dreamvoid.miraimc.velocity.event.group;

import me.dreamvoid.miraimc.velocity.VelocityPlugin;
import net.mamoe.mirai.event.events.BotUnmuteEvent;

/**
 * (bungee) Mirai 核心事件 - 群 - 机器人被取消禁言
 */
public class MiraiBotUnmuteEvent extends AbstractGroupEvent {
    public MiraiBotUnmuteEvent(BotUnmuteEvent event) {
        super(event);
        this.event = event;

        VelocityPlugin.INSTANCE.getServer().getEventManager().fire(new me.dreamvoid.miraimc.velocity.event.MiraiGroupBotUnmuteEvent(event));
    }

    private final BotUnmuteEvent event;

    /**
     * 返回执行解除禁言操作的管理员。
     * @return 管理员QQ
     */
    public long getOperatorID() {
        return event.getOperator().getId();
    }
}