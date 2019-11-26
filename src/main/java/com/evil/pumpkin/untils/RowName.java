package com.evil.pumpkin.untils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SuppressWarnings("all")
public class RowName {

    private static final List<String> currentStatus = new ArrayList<>(Arrays.asList("当前状态", "Current Status"));
    private static final List<String> currentHour = new ArrayList<>(Arrays.asList("整点状态", "Current Hour"));
    private static final List<String> bootInfo = new ArrayList<>(Arrays.asList("启动信息", "Boot Info"));
    private static final List<String> dataProvided = new ArrayList<>(Arrays.asList("信息提供", "Data Provided"));
    private static final List<String> projectName = new ArrayList<>(Arrays.asList("邪恶南瓜", "Evil Pumpkin"));
    private static final List<String> hello = new ArrayList<>(Arrays.asList("邪恶南瓜已成功启动", "Evil Pumpkin has been booted."));



    /**
     * Base information.
     */
    private static final List<String> baseInfo = new ArrayList<>(Arrays.asList("**基本信息**", "**Base Information**"));
    private static final List<String> hostname = new ArrayList<>(Arrays.asList("主机名称", "Hostname"));
    private static final List<String> dualWanOrProxy = new ArrayList<>(Arrays.asList("多WAN或代理", "Dual WAN or Proxy"));
    private static final List<String> firstInternetIP = new ArrayList<>(Arrays.asList("公网IP", "Internet IP"));
    private static final List<String> secondInternetIP = new ArrayList<>(Arrays.asList("公网IP", "Internet IP"));
    private static final List<String> yes = new ArrayList<>(Arrays.asList("是", "Yes"));
    private static final List<String> no = new ArrayList<>(Arrays.asList("否", "No"));
    private static final List<String> akamai = new ArrayList<>(Arrays.asList("(由Akamai提供数据)", "(Provided by Akamai)"));
    private static final List<String> amazon = new ArrayList<>(Arrays.asList("(由Amazon提供数据)", "(Provided by Amazon)"));
    private static final List<String> ipipNet = new ArrayList<>(Arrays.asList("(由ipip.net提供数据)", "(Provided by ipip.net)"));
    private static final List<String> osName = new ArrayList<>(Arrays.asList("操作系统", "OS"));
    private static final List<String> sysTime = new ArrayList<>(Arrays.asList("系统时间", "System Time"));
    private static final List<String> osBootTime = new ArrayList<>(Arrays.asList("启动时间", "OS Boot Time"));
    private static final List<String> osUptime = new ArrayList<>(Arrays.asList("运行时间", "OS  Uptime"));
    private static final List<String> cpuLoad = new ArrayList<>(Arrays.asList("处理器负载", "CPU Load"));
    private static final List<String> availableMemory = new ArrayList<>(Arrays.asList("可用内存", "Available Memory"));
    private static final List<String> cpuTemperature = new ArrayList<>(Arrays.asList("CPU温度", "CPU Temperature"));
    private static final List<String> fanSpeed = new ArrayList<>(Arrays.asList("风扇转速", "Fan Speed"));
    private static final List<String> cpuVoltage = new ArrayList<>(Arrays.asList("CPU电压", "CPU Voltage"));
    private static final List<String> mark = new ArrayList<>(Arrays.asList("标记", "Mark"));
    private static final List<String> networkTraffic = new ArrayList<>(Arrays.asList("网络流量", "Network Traffic"));


    /**
     * Operation System Part
     */
    private static final List<String> osInfo = new ArrayList<>(Arrays.asList("系统信息", "OS Information"));
    private static final List<String> osVersion = new ArrayList<>(Arrays.asList("系统版本", "OS Version"));
    private static final List<String> osArch = new ArrayList<>(Arrays.asList("系统架构", "OS Arch"));

    /**
     * Hardware Part
     */
    //Processor
    private static final List<String> hardware = new ArrayList<>(Arrays.asList("硬件信息", "Hardware"));
    private static final List<String> processor = new ArrayList<>(Arrays.asList("处理器", "Processor"));
    private static final List<String> processorPackage = new ArrayList<>(Arrays.asList("处理器封装数", "Processor Package"));
    private static final List<String> processorCore = new ArrayList<>(Arrays.asList("处理器核心数", "Processor Core"));
    private static final List<String> processorLogical = new ArrayList<>(Arrays.asList("逻辑处理器数", "Logical Processor"));

    //Memory
    private static final List<String> memory = new ArrayList<>(Arrays.asList("内存", "Memory"));
    private static final List<String> memoryTotalSize = new ArrayList<>(Arrays.asList("内存", "Memory Total"));
    private static final List<String> physicalMemoryCount = new ArrayList<>(Arrays.asList("物理内存数", "Physical Memory Count"));
    private static final List<String> physicalMemorySize = new ArrayList<>(Arrays.asList("物理内存容量", "Physical Memory Capacity"));
    private static final List<String> physicalMemoryBankLabel = new ArrayList<>(Arrays.asList("物理内存插槽", "Memory Bank Label"));
    private static final List<String> physicalMemoryClockSpeed = new ArrayList<>(Arrays.asList("物理内存速率", "Physical Memory Speed"));
    private static final List<String> physicalMemoryType = new ArrayList<>(Arrays.asList("物理内存类型", "Physical Memory Type"));
    private static final List<String> physicalMemoryManufacturer = new ArrayList<>(Arrays.asList("厂商", "Manufacturer"));

    //Storage
    private static final List<String> storage = new ArrayList<>(Arrays.asList("存储设备", "Storage"));
    private static final List<String> diskName = new ArrayList<>(Arrays.asList("磁盘名称", "Disk Name"));
    private static final List<String> diskCapacity = new ArrayList<>(Arrays.asList("磁盘容量", "Disk Capacity"));

    //Network Interface
    private static final List<String> networkInterface = new ArrayList<>(Arrays.asList("网络接口", "Network Interface"));
    private static final List<String> interfaceName = new ArrayList<>(Arrays.asList("接口名称", "Interface Name"));
    private static final List<String> IPv4Addr = new ArrayList<>(Arrays.asList("IPv4 地址", "IPv4 Address"));
    private static final List<String> IPv6Addr = new ArrayList<>(Arrays.asList("IPv6 地址", "IPv6 Address"));

    //Network Parameters
    private static final List<String> networkParameters = new ArrayList<>(Arrays.asList("网络信息", "Network Parameters"));
    private static final List<String> dns = new ArrayList<>(Arrays.asList("DNS", "DNS"));
    private static final List<String> IPv4Gateway = new ArrayList<>(Arrays.asList("IPv4 网关", "IPv4 Gateway"));
    private static final List<String> IPv6Gateway = new ArrayList<>(Arrays.asList("IPv6 网关", "IPv6 Gateway"));

    /**
     * File System
     */
    private static final List<String> fileSystem = new ArrayList<>(Arrays.asList("文件系统", "File System"));
    private static final List<String> volumeName = new ArrayList<>(Arrays.asList("卷名", "Volume Name"));
    private static final List<String> fileSystemType = new ArrayList<>(Arrays.asList("文件系统类型", "File System Type"));
    private static final List<String> usedSpace = new ArrayList<>(Arrays.asList("已使用", "Used Space"));
    private static final List<String> freeSpace = new ArrayList<>(Arrays.asList("剩余", "Free Space"));
    private static final List<String> totalSpace = new ArrayList<>(Arrays.asList("总容量", "Total Space"));
    private static final List<String> usedRate = new ArrayList<>(Arrays.asList("利用率", "Used Rate"));
    private static final List<String> volume = new ArrayList<>(Arrays.asList("卷", "Volume"));
    private static final List<String> logicalVolume = new ArrayList<>(Arrays.asList("逻辑卷", "Logical Volume"));
    private static final List<String> mountPoint = new ArrayList<>(Arrays.asList("挂载点", "Mount"));
    private static final List<String> fsUuid = new ArrayList<>(Arrays.asList("UUID", "UUID"));
    private static final List<String> fsDescp = new ArrayList<>(Arrays.asList("描述", "Description"));

    /**
     * System Processes
     */
    private static final List<String> systemProcess = new ArrayList<>(Arrays.asList("系统进程", "System Processes"));
    private static final List<String> processOrder = new ArrayList<>(Arrays.asList("进程排序", "Order By"));
    private static final List<String> cpuUsage = new ArrayList<>(Arrays.asList("CPU占用率", "CPU Usage"));
    private static final List<String> memoryUsage = new ArrayList<>(Arrays.asList("内存占用率", "Memory Usage"));

    /**
     * Network
     */

    private static final List<String> networkTrafficInfo = new ArrayList<>(Arrays.asList("网络流量信息", "Network Traffic Information"));


    //External Part: Exception Part
    private static final List<String> internetIPException = new ArrayList<>(Arrays.asList("获取IP失败", "Get Internet IP failed"));
    private static final List<String> temperatureException = new ArrayList<>(Arrays.asList("获取CPU温度失败", "Get temperature failed"));
    private static final List<String> sensorOrVMException = new ArrayList<>(Arrays.asList("无传感器或运行于虚拟机", "No sensor or run on VM"));
    private static final List<String> temperatureAdminException = new ArrayList<>(Arrays.asList("非管理员权限，无法获取温度", "Failed, Please run as Administrator or root."));
    private static final List<String> fanSpeedException = new ArrayList<>(Arrays.asList("获取风扇转速失败", "Get fan speed failed"));
    private static final List<String> cpuVoltageException = new ArrayList<>(Arrays.asList("获取CPU电压失败", "Get cpu voltage failed"));
    private static final List<String> markException = new ArrayList<>(Arrays.asList("无标记", "Mark doesn't existed."));
    private static final List<String> networkTrafficException = new ArrayList<>(Arrays.asList("未获取到流量", "Network Traffic can't be read"));
    private static final List<String> networkInterfaceException = new ArrayList<>(Arrays.asList("无网络接口", "Network Interface not found"));
    private static final List<String> unsupportSystem = new ArrayList<>(Arrays.asList("不支持的系统类型(缺失系统文件)", "Unsupport System delected(key system file missing)"));


    /**
     *  Nofity
     */
    private static final List<String> propertiesUpdated = new ArrayList<>(Arrays.asList("配置保存成功", "Properties has been updated."));
    private static final List<String> sendMeg = new ArrayList<>(Arrays.asList("消息已重新发送，请查收。", "Notify has been sent out, please check with your wechat."));
    private static final List<String> sendFail = new ArrayList<>(Arrays.asList("未获取到URL，或URL格式不正确", "Cann't fetch URL or incorrect URL format."));
}
