package com.anish;

import com.anish.dao.VykladachDao;
import com.anish.pojo.Vykladach;

public class App {
    public static void main(String[] args) {
        Vykladach vykladach = new Vykladach();
        vykladach.setId(1);
        vykladach.setLocation("Fizyka");
        vykladach.setName("Matematyka");

        VykladachDao dao = new VykladachDao();
        dao.save(vykladach);
    }
