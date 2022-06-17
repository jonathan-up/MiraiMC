package me.dreamvoid.miraimc.sponge.event.group;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.event.cause.Cause;
import net.mamoe.mirai.event.events.BotGroupPermissionChangeEvent;

/**
 * (bungee) Mirai 核心事件 - 群 - 机器人在群里的权限被改变
 */
public class MiraiBotGroupPermissionChangeEvent extends AbstractGroupEvent {
    public MiraiBotGroupPermissionChangeEvent(BotGroupPermissionChangeEvent event, Cause cause) {
        super(event, cause);
        this.event = event;

        Sponge.getEventManager().post(new me.dreamvoid.miraimc.sponge.event.MiraiGroupBotPermissionChangeEvent(event, cause));
    }

    private final BotGroupPermissionChangeEvent event;

    /**
     * 返回机器人的原有权限。
     * @return 0 - 普通成员 | 1 - 管理员 | 2 - 群主
     */
    public int getOriginPermission() {
        return event.getOrigin().getLevel();
    }

    /**
     * 返回机器人的新权限。
     * @return 0 - 普通成员 | 1 - 管理员 | 2 - 群主
     */
    public int getNewPermission() {
        return event.getNew().getLevel();
    }
}