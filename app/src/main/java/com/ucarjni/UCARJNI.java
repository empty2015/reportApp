package com.ucarjni;

/**
 * Created by mac on 1/15/17.
 */

public class UCARJNI {

    static {
        System.loadLibrary("UcarSign");
    }

    public native String appId();
    public native String signKey();
}
