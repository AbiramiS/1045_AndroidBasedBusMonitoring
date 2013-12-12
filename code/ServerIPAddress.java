package com.android;

public class ServerIPAddress {
  private static String ipaddress = null;
  private static String source = null;
  public static String getSource() {
	return source;
}

public static void setSource(String source) {
	ServerIPAddress.source = source;
}

public static String getDestination() {
	return destination;
}

public static void setDestination(String destination) {
	ServerIPAddress.destination = destination;
}

private static String destination = null;
  

public static String getIpaddress() {
	return ipaddress;
}

public static void setIpaddress(String ipaddress) {
	ServerIPAddress.ipaddress = ipaddress;
}


  
}
