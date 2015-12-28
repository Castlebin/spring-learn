package com.heller.hello.controller;

import org.springframework.mobile.device.Device;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeviceDetectionController {

    @RequestMapping("/detect-device")
    public String detectDevice(Device device) {
        String deviceType = "unknown";
        if (device.isNormal()) {
            deviceType = "normal";
        } else if (device.isMobile()) {
            deviceType = "mobile";
        } else if (device.isTablet()) {
            deviceType = "tablet";
        }

        return "Hello " + deviceType + " browser!";
    }
}
