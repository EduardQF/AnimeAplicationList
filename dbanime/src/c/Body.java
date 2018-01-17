/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c;

import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Eduard QF
 */
public class Body {

    private static Body instance = null;
    private Properties general;
    private Properties language;

    public static Body getInstance() {
        if (instance == null) {
            System.out.println("instance=null");
            instance = new Body();
        }
        System.out.println("instance!=null");
        return instance;
    }
    
    public static Body reStartInstance(){
        instance=null;
        return getInstance();
    }

    private Body() {
        chargeProperties();
    }

    private void chargeProperties() {
        general = ReadProperties.read("General");
        language = ReadProperties.read("language//" + general.getProperty("language"));
    }

    public String valueLanguage(String key) {
        return language.getProperty(key);
    }

    public String valueGeneral(String key) {
        return general.getProperty(key);
    }

    public void setLanguage(String lang) {
        switch (lang) {
            case "Español":
                lang = "Esp";
                break;
            case "Ingles":
                lang = "Eng";
        }
        general.setProperty("language", lang);
        ReadProperties.write(general, "General");
    }

    public void setTypeCharge(String type) {
        switch (type) {
            case "Data Base":
                type = "true";
                break;
            case "Of Folder":
                type = "false";
                break;
        }
        general.setProperty("typeLoad", type);
        ReadProperties.write(general, "General");
    }

    public void setPropertie(String key, String value) {
        general.setProperty(key, value);
    }
    
    public void setFolder(String value) {
        general.setProperty("ofFolder", value);
    }

    public void playVideo(String link) {
        try {
            ProcessBuilder pb = new ProcessBuilder(general.getProperty("player"), link);
            Process start = pb.start();
        } catch (IOException ex) {
            Logger.getLogger(Body.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
