package com.company;

import com.company.config.Config;
import org.yaml.snakeyaml.Yaml;

import java.io.*;
import java.util.Objects;

class SSHTunnelApp  {

    public static void main(String[] args) throws IOException {
        Yaml yaml = new Yaml();
        File configFile = new File("config.yaml");

        InputStream configInputStream;
        try {
            configInputStream = new FileInputStream(configFile);
        } catch (FileNotFoundException e) {
            if(!configFile.createNewFile())
                throw new IOException();
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(configFile));
            bufferedOutputStream.write(Objects.requireNonNull(SSHTunnelApp.class.getClassLoader().getResourceAsStream("config.yaml")).readAllBytes());
            bufferedOutputStream.flush();
            configInputStream = new FileInputStream(configFile);
        }

        Config config = yaml.loadAs(configInputStream, Config.class);

        System.out.println(config);


        //SshClient client = SshClient.setUpDefaultClient();
    }
}