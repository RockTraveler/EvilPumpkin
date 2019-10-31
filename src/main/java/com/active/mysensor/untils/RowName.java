package com.active.mysensor.untils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RowName {

    private static final List<String> currentStatus = new ArrayList<>(Arrays.asList("当前状态","Current Status"));


    // Part 1: Base information.
    private static final List<String> baseInfo = new ArrayList<>(Arrays.asList("**基本信息**","**Base Information**"));
    private static final List<String> hostname = new ArrayList<>(Arrays.asList("主机名称","Hostname"));
    private static final List<String> internetIP = new ArrayList<>(Arrays.asList("外网IP","Internet IP"));
    private static final List<String> osName = new ArrayList<>(Arrays.asList("操作系统","OS"));
    private static final List<String> osBootTime = new ArrayList<>(Arrays.asList("启动时间","OS Boot Time"));
    private static final List<String> osUptime = new ArrayList<>(Arrays.asList("运行时间","OS  Uptime"));
    private static final List<String> cpuLoad = new ArrayList<>(Arrays.asList("处理器负载","Cpu Load"));
    private static final List<String> availableMemory = new ArrayList<>(Arrays.asList("可用内存","Available Memory"));
    private static final List<String> cpuTemperature = new ArrayList<>(Arrays.asList("CPU温度","CPU temperature"));
    private static final List<String> fanSpeed = new ArrayList<>(Arrays.asList("风扇转速","Fan Speed"));
    private static final List<String> cpuVoltage = new ArrayList<>(Arrays.asList("CPU电压","CPU Voltage"));
    private static final List<String> mark = new ArrayList<>(Arrays.asList("标记","Mark"));
    private static final List<String> networkTraffic = new ArrayList<>(Arrays.asList("网络流量","Network Traffice"));









    //External Part: Exception Part
    private static final List<String> internetIPException = new ArrayList<>(Arrays.asList("获取IP失败","Get Internet IP failed"));
    private static final List<String> temperatureException = new ArrayList<>(Arrays.asList("获取CPU温度失败","Get temperature IP failed"));
    private static final List<String> fanSpeedException = new ArrayList<>(Arrays.asList("获取风扇转速失败","Get fan speed failed"));
    private static final List<String> cpuVoltageException = new ArrayList<>(Arrays.asList("获取CPU电压失败","Get cpu voltage failed"));
    private static final List<String> markException = new ArrayList<>(Arrays.asList("无标记","Mark doesn't existed."));
    private static final List<String> networkTrafficeException = new ArrayList<>(Arrays.asList("未获取到流量","Network Traffic can't be read"));

}
