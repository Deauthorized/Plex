package me.totalfreedom.plex.event;

import me.totalfreedom.plex.command.source.CommandSource;
import me.totalfreedom.plex.player.PlexPlayer;
import me.totalfreedom.plex.rank.enums.Rank;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class AdminSetRankEvent extends Event
{
    private static final HandlerList handlers = new HandlerList();

    private CommandSource sender;
    private PlexPlayer plexPlayer;
    private Rank rank;

    public AdminSetRankEvent(CommandSource sender, PlexPlayer plexPlayer, Rank rank)
    {
        this.sender = sender;
        this.plexPlayer = plexPlayer;
        this.rank = rank;
    }

    @Override
    public HandlerList getHandlers()
    {
        return handlers;
    }

    public static HandlerList getHandlerList()
    {
        return handlers;
    }

    public PlexPlayer getPlexPlayer()
    {
        return plexPlayer;
    }

    public Rank getRank()
    {
        return rank;
    }

    public CommandSource getSender() {
        return sender;
    }
}