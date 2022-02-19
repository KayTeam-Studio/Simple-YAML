package org.simpleyaml.configuration.builder;

import org.simpleyaml.configuration.file.YamlFile;

public class YamlBuilder {

    private final YamlFile yamlFile;

    public YamlBuilder(String pathFile) {
        yamlFile = new YamlFile(pathFile);
        try {
            if (!yamlFile.exists()) {
                System.out.println("New file has been created: " + yamlFile.getFilePath() + "\n");
                yamlFile.createNewFile(true);
            } else {
                System.out.println(yamlFile.getFilePath() + " already exists, loading configurations...\n");
            }
            yamlFile.load(); // Loads the entire file
            // If your file has comments inside you have to load it with yamlFile.loadWithComments()
        } catch (final Exception e) {
            e.printStackTrace();
        }
    }

    public YamlFile getYamlFile() {
        return yamlFile;
    }

}