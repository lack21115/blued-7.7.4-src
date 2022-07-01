package org.chromium.device.gamepad;

import android.annotation.SuppressLint;
import android.content.Context;
import android.hardware.input.InputManager;
import android.view.InputDevice;
import android.view.InputEvent;
import android.view.KeyEvent;
import android.view.MotionEvent;
import java.util.Arrays;
import org.chromium.base.annotations.CalledByNative;

public class GamepadList {
  private int mAttachedToWindowCounter;
  
  private final GamepadDevice[] mGamepadDevices = new GamepadDevice[4];
  
  private InputManager.InputDeviceListener mInputDeviceListener = new GamepadList$1(this);
  
  private InputManager mInputManager;
  
  private boolean mIsGamepadAPIActive;
  
  private final Object mLock = new Object();
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  private GamepadList() {}
  
  private void detachedFromWindow() {
    // Byte code:
    //   0: aload_0
    //   1: getfield mAttachedToWindowCounter : I
    //   4: iconst_1
    //   5: isub
    //   6: istore_1
    //   7: aload_0
    //   8: iload_1
    //   9: putfield mAttachedToWindowCounter : I
    //   12: iload_1
    //   13: ifne -> 67
    //   16: aload_0
    //   17: getfield mLock : Ljava/lang/Object;
    //   20: astore_2
    //   21: aload_2
    //   22: monitorenter
    //   23: iconst_0
    //   24: istore_1
    //   25: iload_1
    //   26: iconst_4
    //   27: if_icmpge -> 44
    //   30: aload_0
    //   31: getfield mGamepadDevices : [Lorg/chromium/device/gamepad/GamepadDevice;
    //   34: iload_1
    //   35: aconst_null
    //   36: aastore
    //   37: iload_1
    //   38: iconst_1
    //   39: iadd
    //   40: istore_1
    //   41: goto -> 25
    //   44: aload_2
    //   45: monitorexit
    //   46: aload_0
    //   47: getfield mInputManager : Landroid/hardware/input/InputManager;
    //   50: aload_0
    //   51: getfield mInputDeviceListener : Landroid/hardware/input/InputManager$InputDeviceListener;
    //   54: invokevirtual unregisterInputDeviceListener : (Landroid/hardware/input/InputManager$InputDeviceListener;)V
    //   57: aload_0
    //   58: aconst_null
    //   59: putfield mInputManager : Landroid/hardware/input/InputManager;
    //   62: return
    //   63: aload_2
    //   64: monitorexit
    //   65: aload_3
    //   66: athrow
    //   67: return
    //   68: astore_3
    //   69: goto -> 63
    // Exception table:
    //   from	to	target	type
    //   30	37	68	finally
    //   44	46	68	finally
    //   63	65	68	finally
  }
  
  public static boolean dispatchKeyEvent(KeyEvent paramKeyEvent) {
    return !isGamepadEvent(paramKeyEvent) ? false : GamepadList$LazyHolder.access$300().handleKeyEvent(paramKeyEvent);
  }
  
  private GamepadDevice getDevice(int paramInt) {
    assert false;
    throw new AssertionError();
  }
  
  private GamepadDevice getDeviceById(int paramInt) {
    for (int i = 0; i < 4; i++) {
      GamepadDevice gamepadDevice = this.mGamepadDevices[i];
      if (gamepadDevice != null && gamepadDevice.mDeviceId == paramInt)
        return gamepadDevice; 
    } 
    return null;
  }
  
  private GamepadDevice getGamepadForEvent(InputEvent paramInputEvent) {
    return getDeviceById(paramInputEvent.getDeviceId());
  }
  
  private boolean handleKeyEvent(KeyEvent paramKeyEvent) {
    synchronized (this.mLock) {
      boolean bool1 = this.mIsGamepadAPIActive;
      boolean bool = false;
      if (!bool1)
        return false; 
      GamepadDevice gamepadDevice = getGamepadForEvent((InputEvent)paramKeyEvent);
      if (gamepadDevice == null)
        return false; 
      if (isGamepadEvent(paramKeyEvent)) {
        int i = paramKeyEvent.getKeyCode();
        if (GamepadDevice.$assertionsDisabled || i < 256) {
          if (paramKeyEvent.getAction() == 0) {
            gamepadDevice.mRawButtons[i] = 1.0F;
          } else if (paramKeyEvent.getAction() == 1) {
            gamepadDevice.mRawButtons[i] = 0.0F;
          } 
          gamepadDevice.mTimestamp = paramKeyEvent.getEventTime();
          bool = true;
          return bool;
        } 
        throw new AssertionError();
      } 
      return bool;
    } 
  }
  
  private boolean handleMotionEvent(MotionEvent paramMotionEvent) {
    synchronized (this.mLock) {
      boolean bool1 = this.mIsGamepadAPIActive;
      boolean bool = false;
      int i = 0;
      if (!bool1)
        return false; 
      GamepadDevice gamepadDevice = getGamepadForEvent((InputEvent)paramMotionEvent);
      if (gamepadDevice == null)
        return false; 
      if (isGamepadEvent(paramMotionEvent)) {
        while (i < gamepadDevice.mAxes.length) {
          int j = gamepadDevice.mAxes[i];
          gamepadDevice.mRawAxes[j] = paramMotionEvent.getAxisValue(j);
          i++;
        } 
        gamepadDevice.mTimestamp = paramMotionEvent.getEventTime();
        bool = true;
      } 
      return bool;
    } 
  }
  
  private void initializeDevices() {
    int[] arrayOfInt = this.mInputManager.getInputDeviceIds();
    for (int i = 0; i < arrayOfInt.length; i++) {
      InputDevice inputDevice = InputDevice.getDevice(arrayOfInt[i]);
      if (isGamepadDevice(inputDevice))
        registerGamepad(inputDevice); 
    } 
  }
  
  private static boolean isGamepadDevice(InputDevice paramInputDevice) {
    return (paramInputDevice == null) ? false : (((paramInputDevice.getSources() & 0x1000010) == 16777232));
  }
  
  private static boolean isGamepadEvent(KeyEvent paramKeyEvent) {
    int i = paramKeyEvent.getKeyCode();
    switch (i) {
      default:
        return KeyEvent.isGamepadButton(i);
      case 19:
      case 20:
      case 21:
      case 22:
        break;
    } 
    return true;
  }
  
  private static boolean isGamepadEvent(MotionEvent paramMotionEvent) {
    return ((paramMotionEvent.getSource() & 0x1000010) == 16777232);
  }
  
  private native void nativeSetGamepadData(long paramLong1, int paramInt, boolean paramBoolean1, boolean paramBoolean2, String paramString, long paramLong2, float[] paramArrayOffloat1, float[] paramArrayOffloat2);
  
  public static void onAttachedToWindow(Context paramContext) {
    assert false;
    throw new AssertionError();
  }
  
  @SuppressLint({"MissingSuperCall"})
  public static void onDetachedFromWindow() {
    assert false;
    throw new AssertionError();
  }
  
  public static boolean onGenericMotionEvent(MotionEvent paramMotionEvent) {
    return !isGamepadEvent(paramMotionEvent) ? false : GamepadList$LazyHolder.access$300().handleMotionEvent(paramMotionEvent);
  }
  
  private boolean registerGamepad(InputDevice paramInputDevice) {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: iload_2
    //   3: iconst_4
    //   4: if_icmpge -> 25
    //   7: aload_0
    //   8: iload_2
    //   9: invokespecial getDevice : (I)Lorg/chromium/device/gamepad/GamepadDevice;
    //   12: ifnonnull -> 18
    //   15: goto -> 27
    //   18: iload_2
    //   19: iconst_1
    //   20: iadd
    //   21: istore_2
    //   22: goto -> 2
    //   25: iconst_m1
    //   26: istore_2
    //   27: iload_2
    //   28: iconst_m1
    //   29: if_icmpne -> 34
    //   32: iconst_0
    //   33: ireturn
    //   34: new org/chromium/device/gamepad/GamepadDevice
    //   37: dup
    //   38: iload_2
    //   39: aload_1
    //   40: invokespecial <init> : (ILandroid/view/InputDevice;)V
    //   43: astore_1
    //   44: aload_0
    //   45: getfield mGamepadDevices : [Lorg/chromium/device/gamepad/GamepadDevice;
    //   48: iload_2
    //   49: aload_1
    //   50: aastore
    //   51: iconst_1
    //   52: ireturn
  }
  
  @CalledByNative
  static void setGamepadAPIActive(boolean paramBoolean) {
    null = GamepadList$LazyHolder.access$300();
    synchronized (null.mLock) {
      null.mIsGamepadAPIActive = paramBoolean;
      if (paramBoolean)
        for (int i = 0;; i++) {
          if (i < 4) {
            GamepadDevice gamepadDevice = null.getDevice(i);
            if (gamepadDevice != null) {
              Arrays.fill(gamepadDevice.mAxisValues, 0.0F);
              Arrays.fill(gamepadDevice.mRawAxes, 0.0F);
              Arrays.fill(gamepadDevice.mButtonsValues, 0.0F);
              Arrays.fill(gamepadDevice.mRawButtons, 0.0F);
            } 
            continue;
          } 
          return;
        }  
      return;
    } 
  }
  
  @CalledByNative
  static void updateGamepadData(long paramLong) {
    // Byte code:
    //   0: invokestatic access$300 : ()Lorg/chromium/device/gamepad/GamepadList;
    //   3: astore #4
    //   5: aload #4
    //   7: getfield mLock : Ljava/lang/Object;
    //   10: astore_3
    //   11: aload_3
    //   12: monitorenter
    //   13: iconst_0
    //   14: istore_2
    //   15: iload_2
    //   16: iconst_4
    //   17: if_icmpge -> 116
    //   20: aload #4
    //   22: iload_2
    //   23: invokespecial getDevice : (I)Lorg/chromium/device/gamepad/GamepadDevice;
    //   26: astore #5
    //   28: aload #5
    //   30: ifnull -> 100
    //   33: aload #5
    //   35: getfield mMappings : Lorg/chromium/device/gamepad/GamepadMappings;
    //   38: aload #5
    //   40: getfield mAxisValues : [F
    //   43: aload #5
    //   45: getfield mButtonsValues : [F
    //   48: aload #5
    //   50: getfield mRawAxes : [F
    //   53: aload #5
    //   55: getfield mRawButtons : [F
    //   58: invokevirtual mapToStandardGamepad : ([F[F[F[F)V
    //   61: aload #4
    //   63: lload_0
    //   64: iload_2
    //   65: aload #5
    //   67: getfield mMappings : Lorg/chromium/device/gamepad/GamepadMappings;
    //   70: invokevirtual isStandard : ()Z
    //   73: iconst_1
    //   74: aload #5
    //   76: getfield mDeviceName : Ljava/lang/String;
    //   79: aload #5
    //   81: getfield mTimestamp : J
    //   84: aload #5
    //   86: getfield mAxisValues : [F
    //   89: aload #5
    //   91: getfield mButtonsValues : [F
    //   94: invokespecial nativeSetGamepadData : (JIZZLjava/lang/String;J[F[F)V
    //   97: goto -> 124
    //   100: aload #4
    //   102: lload_0
    //   103: iload_2
    //   104: iconst_0
    //   105: iconst_0
    //   106: aconst_null
    //   107: lconst_0
    //   108: aconst_null
    //   109: aconst_null
    //   110: invokespecial nativeSetGamepadData : (JIZZLjava/lang/String;J[F[F)V
    //   113: goto -> 124
    //   116: aload_3
    //   117: monitorexit
    //   118: return
    //   119: aload_3
    //   120: monitorexit
    //   121: aload #4
    //   123: athrow
    //   124: iload_2
    //   125: iconst_1
    //   126: iadd
    //   127: istore_2
    //   128: goto -> 15
    //   131: astore #4
    //   133: goto -> 119
    // Exception table:
    //   from	to	target	type
    //   20	28	131	finally
    //   33	97	131	finally
    //   100	113	131	finally
    //   116	118	131	finally
    //   119	121	131	finally
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\device\gamepad\GamepadList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */