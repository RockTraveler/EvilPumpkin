package com.active.mysensor.untils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RowName {

    private static final List<String> currentStatus = new ArrayList<>(Arrays.asList("当前状态","Current Status"));



    private static final List<String> baseInfo = new ArrayList<>(Arrays.asList("**基本信息**","**Base Information**"));
    private static final List<String> hostname = new ArrayList<>(Arrays.asList("主机名称","Hostname"));
    private static final List<String> temperature = new ArrayList<>(Arrays.asList("温度","temperature"));

    public static void main(String[] args) {
        System.out.println(hostname.get(0));
    }
}
