/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m;

import java.io.File;
import javax.swing.ImageIcon;

/**
 *
 * @author Eduard QF
 */
public class Anime {

    private int seassons;
    private String name = null;
    private String folder = null;
    private String description=null;
    private boolean download = false;
    private boolean see = false;
    private ImageIcon icon = null;

    public int getSeassons() {
        return seassons;
    }

    public String getName() {
        return name;
    }

    public String getFolder() {
        return folder;
    }

    public boolean isDownload() {
        return download;
    }

    public boolean isSee() {
        return see;
    }

    public ImageIcon geticon() {
        return icon;
    }

    public String getDescription() {
        return description;
    }
    

    private void setSeassons(int seassons) {
        this.seassons = seassons;
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setFolder(String folder) {
        System.out.println("folder:"+folder);
        this.folder = folder;
    }

    private void setDownload(boolean download) {
        this.download = download;
    }

    private void setSee(boolean see) {
        this.see = see;
    }

    private void setDescription(String description) {
        this.description = description;
    }

    
    private void setIcon(String folder) {
        System.out.println("folder:" + folder);
        if (!folder.isEmpty()) {
            File f = new File(folder);
            if (f.exists()) {

                File[] files = f.listFiles();

                for (File fil : files) {
                    //System.out.println("fil:"+fil);
                    if (fil.getName().contains("img")) {
                        icon = new ImageIcon(fil.getPath());
                        System.out.println("direccion:" + fil.getPath());
                        break;
                    }
                }
            }
        }

    }

    @Override
    public String toString() {
        return "Anime{" + "seassons=" + seassons + ", name=" + name + ", folder=" + folder + ", download=" + download + ", see=" + see + '}';
    }

    public static Anime anime(String name, int seasson, String folder, boolean download, boolean see,String description) {
        Anime anime = new Anime();
        anime.setName(name);
        anime.setSeassons(seasson);
        anime.setDownload(download);
        anime.setFolder(folder);
        anime.setSee(see);
        anime.setDescription(description);
        anime.setIcon(folder);
        return anime;
    }

}
