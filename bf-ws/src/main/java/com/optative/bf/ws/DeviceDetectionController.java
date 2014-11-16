package com.optative.bf.ws;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.mobile.device.Device;
import org.springframework.mobile.device.DeviceUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DeviceDetectionController {

	@RequestMapping("/detect-device")
	public @ResponseBody String detectDevice(Device device) {
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

	@RequestMapping("/detect-device1")
	public @ResponseBody String preHandle(HttpServletRequest request,
			HttpServletResponse arg1, Object arg2) throws Exception {
		Device device = DeviceUtils.getCurrentDevice(request);
		String deviceType = "unknown";
		if (device.isNormal()) {
			deviceType = "normal";
		} else if (device.isMobile()) {
			deviceType = "mobile";
		} else if (device.isTablet()) {
			deviceType = "tablet";
		}
		return deviceType;
	}
}
