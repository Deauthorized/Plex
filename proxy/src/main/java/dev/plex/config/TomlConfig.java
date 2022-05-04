package dev.plex.config;

import dev.plex.Plex;
import com.moandjiezana.toml.Toml;
import com.moandjiezana.toml.TomlWriter;
import lombok.Getter;
import lombok.Setter;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.function.Consumer;

@Getter
public class TomlConfig
{
    private final File file;
    private Toml toml;

    @Setter
    private Consumer<Toml> onCreate;

    @Setter
    private Consumer<Toml> onLoad;

    public TomlConfig(String fileName)
    {
        this.file = new File(Plex.get().getDataFolder(), fileName);
        this.toml = new Toml();
    }

    public void create(boolean loadFromFile)
    {
        if (loadFromFile)
        {
            try
            {
                Files.copy(Plex.get().getClass().getResourceAsStream("/" + this.file.getName()), this.file.toPath());
                this.load();
                if (this.onCreate != null)
                {
                    this.onCreate.accept(this.toml);
                }
            } catch (IOException e)
            {
                e.printStackTrace();
            }
            return;
        } else if (!this.file.exists())
        {
            try
            {
                this.file.createNewFile();
                this.load();
                if (this.onCreate != null)
                {
                    this.onCreate.accept(this.toml);
                }
            } catch (IOException e)
            {
                e.printStackTrace();
            }
            return;
        }
        this.load();
    }

    public void load()
    {
        this.toml = new Toml().read(this.file);
        if (onLoad != null)
        {
            this.onLoad.accept(this.toml);
        }
    }

    public <T> T as(Class<T> clazz)
    {
        return this.toml.to(clazz);
    }

    public <T> void write(T object)
    {
        TomlWriter writer = new TomlWriter();
        try
        {
            writer.write(object, this.file);
            this.load();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
