package com.hhtswitch;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bripackage com.hhtswitch

import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReactContextBaseJavaModule
import com.facebook.react.bridge.ReactMethod
import com.facebook.react.bridge.Callback

import com.rscja.deviceapi.RFIDWithUHF

class UhfModule(reactContext:ReactApplicationContext):
ReactContextBaseJavaModule(reactContext) {

    private var uhf:RFIDWithUHF?=null

    init
    {
        uhf = RFIDWithUHF.getInstance()
    }

    override fun

    getName(): String {
        return "UhfModule"
    }

    @ReactMethod
    fun initUHF(callback: Callback) {
        val init = uhf?.init() ?: false
        callback.invoke(init)
    }

    @ReactMethod
    fun setScanMode(mode: Int, callback: Callback) {
        val result = uhf?.setInvMode(mode) ?: false
        callback.invoke(result)
    }

    @ReactMethod
    fun startScan(callback: Callback) {
        val result = uhf?.startInventoryTag() ?: false
        callback.invoke(result)
    }

    @ReactMethod
    fun stopScan(callback: Callback) {
        uhf?.stopInventory()
        callback.invoke()
    }
}dge.Callback
;

import com.rscja.deviceapi.RFIDWithUHF;

public class UhfModule extends ReactContextBaseJavaModule {
    private static RFIDWithUHF uhf;

    UhfModule(ReactApplicationContext context) {
        super(context);
        uhf = RFIDWithUHF.getInstance();
    }

    @Override
    public String getName() {
        return "UhfModule";
    }

    @ReactMethod
    public void initUHF(Callback callback) {
        boolean init = uhf.init();
        callback.invoke(init);
    }

    @ReactMethod
    public void setScanMode(int mode, Callback callback) {
        boolean result = uhf.setInvMode(mode);
        callback.invoke(result);
    }

    @ReactMethod
    public void startScan(Callback callback) {
        boolean result = uhf.startInventoryTag();
        callback.invoke(result);
    }

    @ReactMethod
    public void stopScan(Callback callback) {
        uhf.stopInventory();
        callback.invoke();
    }
}