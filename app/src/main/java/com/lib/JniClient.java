package com.lib;

public class JniClient {

  static {
    System.loadLibrary("HomeLinkNdk");
  }

  static public native String GetAppId(Object contextObject);

  static public native String GetAppSecret(Object contextObject);
}
