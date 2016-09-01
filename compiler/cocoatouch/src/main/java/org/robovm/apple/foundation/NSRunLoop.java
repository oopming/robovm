/*
 * Copyright (C) 2013-2015 RoboVM AB
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.robovm.apple.foundation;

/*<imports>*/
import java.io.*;
import java.nio.*;
import java.util.*;
import org.robovm.objc.*;
import org.robovm.objc.annotation.*;
import org.robovm.objc.block.*;
import org.robovm.rt.*;
import org.robovm.rt.annotation.*;
import org.robovm.rt.bro.*;
import org.robovm.rt.bro.annotation.*;
import org.robovm.rt.bro.ptr.*;
import org.robovm.apple.corefoundation.*;
import org.robovm.apple.uikit.*;
import org.robovm.apple.coretext.*;
import org.robovm.apple.coreanimation.*;
import org.robovm.apple.coredata.*;
import org.robovm.apple.coregraphics.*;
import org.robovm.apple.coremedia.*;
import org.robovm.apple.security.*;
import org.robovm.apple.dispatch.*;
/*</imports>*/

/*<javadoc>*/

/*</javadoc>*/
/*<annotations>*/@Library("Foundation") @NativeClass/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/NSRunLoop/*</name>*/ 
    extends /*<extends>*/NSObject/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class NSRunLoopPtr extends Ptr<NSRunLoop, NSRunLoopPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(NSRunLoop.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public NSRunLoop() {}
    protected NSRunLoop(Handle h, long handle) { super(h, handle); }
    protected NSRunLoop(SkipInit skipInit) { super(skipInit); }
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "currentRunLoop")
    public static native NSRunLoop getCurrent();
    /**
     * @since Available in iOS 2.0 and later.
     */
    @Property(selector = "mainRunLoop")
    public static native NSRunLoop getMain();
    @Property(selector = "currentMode")
    public native String getCurrentMode();
    /*</properties>*/
    /*<members>*//*</members>*/
    public void addTimer(String mode, NSTimer timer) {
        addTimer0(timer, mode);
    }
    public void addTimer(NSRunLoopMode mode, NSTimer timer) {
        addTimer(mode.value().toString(), timer);
    }
    public void addPort(String mode, NSPort port) {
        addPort0(port, mode);
    }
    public void addPort(NSRunLoopMode mode, NSPort port) {
        addPort0(port, mode.value().toString());
    }
    public void removePort(String mode, NSPort port) {
        removePort0(port, mode);
    }
    public void removePort(NSRunLoopMode mode, NSPort port) {
        removePort0(port, mode.value().toString());
    }
    public NSDate getDateLimit(NSRunLoopMode mode) {
        return getDateLimit(mode.value().toString());
    }
    public void acceptInputUntil(NSRunLoopMode mode, NSDate limitDate) {
        acceptInputUntil(mode.value().toString(), limitDate);
    }
    public boolean runUntil(NSRunLoopMode mode, NSDate limitDate) {
        return runUntil(mode.value().toString(), limitDate);
    }
    public void perform(Selector aSelector, NSObject target, NSObject arg, @MachineSizedUInt long order, NSRunLoopMode...modes) {
        List<String> list = new ArrayList<>();
        for (NSRunLoopMode mode : modes) {
            list.add(mode.value().toString());
        }
        perform(aSelector, target, arg, order, list);
    }
    /*<methods>*/
    @WeaklyLinked
    @Method(selector = "getCFRunLoop")
    public native CFRunLoop asCFRunLoop();
    @Method(selector = "addTimer:forMode:")
    private native void addTimer0(NSTimer timer, String mode);
    @Method(selector = "addPort:forMode:")
    private native void addPort0(NSPort aPort, String mode);
    @Method(selector = "removePort:forMode:")
    private native void removePort0(NSPort aPort, String mode);
    @Method(selector = "limitDateForMode:")
    public native NSDate getDateLimit(String mode);
    @Method(selector = "acceptInputForMode:beforeDate:")
    public native void acceptInputUntil(String mode, NSDate limitDate);
    @Method(selector = "run")
    public native void run();
    @Method(selector = "runUntilDate:")
    public native void runUntil(NSDate limitDate);
    @Method(selector = "runMode:beforeDate:")
    public native boolean runUntil(String mode, NSDate limitDate);
    /**
     * @since Available in iOS 10.0 and later.
     */
    @Method(selector = "performInModes:block:")
    public native void perform(@org.robovm.rt.bro.annotation.Marshaler(NSArray.AsStringListMarshaler.class) List<String> modes, @Block Runnable block);
    /**
     * @since Available in iOS 10.0 and later.
     */
    @Method(selector = "performBlock:")
    public native void perform(@Block Runnable block);
    @Method(selector = "performSelector:target:argument:order:modes:")
    public native void perform(Selector aSelector, NSObject target, NSObject arg, @MachineSizedUInt long order, @org.robovm.rt.bro.annotation.Marshaler(NSArray.AsStringListMarshaler.class) List<String> modes);
    @Method(selector = "cancelPerformSelector:target:argument:")
    public native void cancel(Selector aSelector, NSObject target, NSObject arg);
    @Method(selector = "cancelPerformSelectorsWithTarget:")
    public native void cancel(NSObject target);
    /*</methods>*/
}
