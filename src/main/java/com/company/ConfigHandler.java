package com.company;

import com.company.config.Config;
import com.company.config.hosts.DestinationHost;
import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

public class ConfigHandler {
    public static Path configPath;

    private static ConfigHandler configHandler;

    Config config;

    public static ConfigHandler getInstance() throws FileNotFoundException {
        return getInstance(configPath);
    }


    public static ConfigHandler getInstance(Path configPath) throws FileNotFoundException {
        if(configHandler == null) {
            configHandler = new ConfigHandler(configPath);
        }
        return configHandler;
    }


    private ConfigHandler(Path configPath) throws FileNotFoundException {
        this.config = loadConfig(configPath);
    }


    public Config loadConfig(Path configPath) throws FileNotFoundException {
        Constructor constructor = new Constructor(Config.class);
        Yaml yaml = new Yaml(constructor);
        return yaml.load(new FileInputStream(configPath.toFile()));
    }


    public void dumpConfig() throws IllegalArgumentException, IllegalAccessException, IOException {
        dumpConfig(this.config, this.configPath);
    }


    public void dumpConfig(Config config, Path configPath) throws IllegalArgumentException, IllegalAccessException, IOException {
        DumperOptions options = new DumperOptions();
        options.setDefaultFlowStyle(DumperOptions.FlowStyle.BLOCK);
        options.setPrettyFlow(true);
        Yaml yml = new Yaml(options);
        yml.dump(config, new FileWriter(configPath.toFile()));
    }

    public DestinationHost getDestinationHosts(String destinationHostName) {
        return this.config.getDestinationHosts().get(destinationHostName);
    }

    public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException, IOException, NoSuchFieldException, SecurityException {
        File config = new File("./config.yml");
        if(!config.exists()) {
            System.out.println("Creating new config");
            config.createNewFile();
            BufferedInputStream defaultConfig = new BufferedInputStream(new FileInputStream(Objects.requireNonNull(ConfigHandler.class.getClassLoader().getResource("config.yml")).getFile()));
            new FileOutputStream(config).write(defaultConfig.readAllBytes());
        }
        ConfigHandler.configPath = config.toPath();
        ConfigHandler handler = ConfigHandler.getInstance();
        handler.dumpConfig();
    }
}
