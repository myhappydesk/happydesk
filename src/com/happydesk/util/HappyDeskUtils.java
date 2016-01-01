package com.happydesk.util;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

/**
 * @author Om Yadav
 * Class for common utility methods
 */
public class HappyDeskUtils {
	
	/**
	 * @return String - returns IP address of local machine (Ethernet address)
	 * @throws HappyDeskException
	 */
	public static String getMachineIPAddress() throws HappyDeskException {
	    try {
	        InetAddress localMachineIPAddress = null;
	        for (Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces(); networkInterfaces.hasMoreElements();) {
	            NetworkInterface networkInterface = (NetworkInterface) networkInterfaces.nextElement();
	            for (Enumeration<InetAddress> enumInetAddresses = networkInterface.getInetAddresses(); enumInetAddresses.hasMoreElements();) {
	                InetAddress inetAddress = (InetAddress) enumInetAddresses.nextElement();
	                if (!inetAddress.isLoopbackAddress()) {

	                    if (inetAddress.isSiteLocalAddress()) {
	                        return inetAddress.getHostAddress();
	                    }
	                    else if (localMachineIPAddress == null) {
	                    	localMachineIPAddress = inetAddress;
	                    }
	                }
	            }
	        }
	        if (localMachineIPAddress != null) {
	            return localMachineIPAddress.getHostAddress();
	        }
	        InetAddress localHost = InetAddress.getLocalHost();
	        if (localHost == null) {
	            throw new HappyDeskException("The InetAddress.getLocalHost() method unexpectedly returned null.");
	        }
	        return localHost.getHostAddress();
	    }catch (Exception e) {
	        HappyDeskException happyDeskUnknownHostEx = new HappyDeskException("Failed to retrieve ethernet address.");
	        happyDeskUnknownHostEx.initCause(e);
	        throw happyDeskUnknownHostEx;
	    }
	}
}
