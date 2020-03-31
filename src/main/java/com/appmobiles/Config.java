package com.appmobiles;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

@ApplicationScoped
public class Config {

    private static final Logger log = LoggerFactory.getLogger( Config.class );

    private Values values;

    @PostConstruct
    private void init(){
        final Path path = Paths.get("config.yaml");
        log.info(" $ init : " + path.toAbsolutePath());

        final ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        try {
            values = mapper.readValue(path.toFile(), Values.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Values values(){
        return values;
    }

    public static class Values {

        public int width;
        public int height;
        public String title;

        public String name;
        public int age;
        public Map<String, String> address;
        public String[] roles;
    }
}
