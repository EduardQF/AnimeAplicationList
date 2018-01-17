/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m;

import java.util.ArrayList;
import c.Body;
import java.io.File;

/**
 *
 * @author Eduard QF
 */
public final class Listanime {

    private static Listanime instance = null;
    private ArrayList<Anime> anmeSee;
    private Body bd;

    private Listanime() {
        anmeSee = new ArrayList<>();
        bd = Body.getInstance();
        
        if (Boolean.valueOf(bd.valueGeneral("typeLoad"))) {
            loadAnimes();
        } else {
            loadAnimeFolder();
        }
    }
    
    

    public void loadAnimes() {
        System.out.println("bd.valueGeneral(\"see\"):" + bd.valueGeneral("see"));
        String[] dates = DataReader.readData(bd.valueGeneral("see"));
        System.out.println("dates.length:" + dates.length);
        //name,seasson,folder,download,see,description
        if (dates.length != 1) {
            for (String datea : dates) {
                //System.out.println("anime:"+datea);
                String dt[] = datea.split(",");
                Anime an = Anime.anime(dt[0],
                        Integer.valueOf(dt[1]),
                        dt[2],
                        Boolean.valueOf(dt[3]),
                        Boolean.valueOf(dt[4]),
                        dt[5]);

                    anmeSee.add(an);


            }
        }
    }

    public void loadAnimeFolder() {
        System.out.println("\n******************read Animes of folder***********************");
        String path = bd.valueGeneral("ofFolder");
        File f = new File(path);
        File[] files;
        System.out.println("path" + path);
        if (f.exists()) {
            files = f.listFiles();
            System.out.println("files.length:" + files.length);
            for (File fil : files) {
                if (!fil.getName().contains(".")) {
                    int temp = 1;
                    System.out.println(fil.getName());
                    if (fil.getName().contains("t2")) {
                        temp = 2;
                    }
                    anmeSee.add(Anime.anime(fil.getName(), temp, fil.getPath(), true, false,""));

                }
            }
        }
    }

    public ArrayList<Anime> getAnmeSee() {
        return anmeSee;
    }


    public static Listanime listAnime() {
        if (instance == null) {
            instance = new Listanime();
        }
        return instance;
    }
    
    public static Listanime reListanime(){
        instance=null;
        return listAnime();
    }
}
