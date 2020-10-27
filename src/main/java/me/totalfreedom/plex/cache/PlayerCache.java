package me.totalfreedom.plex.cache;

import com.google.common.collect.Maps;
import me.totalfreedom.plex.player.PlexPlayer;
import me.totalfreedom.plex.player.PunishedPlayer;

import java.util.Map;
import java.util.UUID;

public class PlayerCache
{

    private static Map<UUID, PlexPlayer> plexPlayerMap = Maps.newHashMap();
    private static Map<UUID, PunishedPlayer> punishedPlayerMap = Maps.newHashMap();

    public static Map<UUID, PunishedPlayer> getPunishedPlayerMap() {
        return punishedPlayerMap;
    }

    public static Map<UUID, PlexPlayer> getPlexPlayerMap() {
        return plexPlayerMap;
    }
}