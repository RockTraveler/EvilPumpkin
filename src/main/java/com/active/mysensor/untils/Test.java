package com.active.mysensor.untils;

public class Test {
    private static final String CODE_SPACE ="&nbsp;";
    public static void main(String[] args) {
        System.out.println(getSpace(3));
    }

    private static String getSpace(int x){
        StringBuffer sb = new StringBuffer();
        for (int i=0;i<x;i++){
            sb.append(CODE_SPACE);
        }
        return sb.toString();
    }
}
