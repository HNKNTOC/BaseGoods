package com.BaseGoods.Client.BaseData.LocalData;


import com.BaseGoods.Client.BaseData.Base;
import com.BaseGoods.Client.Logic.Goods;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by HNKNTOC on 29.07.2015.
 */
public class LocalBase implements Base {

    private HashMap<String,Goods> goodsList = new HashMap<>();
    private String directorySave="D:\\HalenDouglas Base Local";

    public LocalBase() {
    }

    /**
     * Вызывает диалоговое окно для выбора директории.
     */
    public void addDirectory(){
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        fileChooser.setAcceptAllFileFilterUsed(false);

        int i=fileChooser.showDialog(null,"Выберите папку");

        switch (i){
            case JFileChooser.CANCEL_OPTION: return;
            case JFileChooser.ERROR_OPTION: System.out.println("Error showOpenDialog"); return;
            case JFileChooser.APPROVE_OPTION:
                directorySave=fileChooser.getSelectedFile().getAbsolutePath();
        }

    }


    public HashMap<String, Goods> getGoodsList() {
        return goodsList;
    }

    public boolean addGoods(Goods goods){
        goodsList.put(goods.getId(),goods);
        return true;
    }


    public HashMap getAllGods() {
        return goodsList;
    }

    public  boolean save(){
        if(!connectBase()){
            addDirectory();
        }
        try {
            FileOutputStream fileStream = new FileOutputStream(directorySave+"\\ListGods.ser");
            ObjectOutputStream os = new ObjectOutputStream(fileStream);

            os.writeObject(goodsList);
            os.close();

        } catch (Exception e) {
            System.out.println("База не сохранена: \n" + e.toString());
            return false;
        }
        return true;
    }

    public boolean open(){
        if(!connectBase()){
            addDirectory();
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(directorySave+"/ListGods.ser");
            ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);

            ArrayList arrayList = (ArrayList) inputStream.readObject();

            goodsList.clear();

            for(Object o:arrayList){
                Goods goods=(Goods)o;
                goodsList.put(goods.getId(),goods);
            }

            for(Goods goods:goodsList.values()){
                System.out.println(goods.toString());
            }



        } catch (Exception e) {
            e.printStackTrace();
        }

        return true;
    }

    @Override
    public boolean connectBase() {
        File dirBase = new File(directorySave);
        if(!dirBase.exists()) {
            return dirBase.mkdir();
        }
        return true;
    }

    @Override
    public Goods getGoods(String id) {
        if(goodsList==null){System.out.println("goodsList==null"); return null;}

        for(Goods goods:goodsList.values()){
            if(goods.getId().equals(id)) return goods;
        }
        System.out.println(id+" НЕ НАЙДЕН");
        return null;
    }

    @Override
    public void setGoods(String id) {

    }


    public Image getImage(String id) {
        File file = new File(directorySave+"\\res.image\\"+id);
        System.out.println(file.getAbsolutePath());
        if (!file.exists()) {
            System.out.println("NULL res.image");
            return null;
        }
        return new ImageIcon(file.getAbsolutePath()).getImage();
    }




    private boolean addImage(File file,String id) {
        try {
            BufferedImage img = ImageIO.read(file);
            File fileNew = new File(directorySave+"\\res.image\\"+ id);
            System.out.println(fileNew.getPath());

            File dir = fileNew.getParentFile();//Создают директорию если её нет

            if (!fileNew.exists()) {
                if(!dir.mkdir()) return false;
            }
            if(!fileNew.createNewFile()) return false;

            ImageIO.write(img, "png", fileNew);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public int getSizeBase() {
        return 0;
    }

    @Override
    public HashMap<String, Goods> getAllGoods() {
        return null;
    }

    @Override
    public boolean sellGoods(String id) {
        return false;
    }
}
