package org.chromium.device.nfc;

import android.annotation.TargetApi;
import android.nfc.NfcAdapter;
import android.nfc.Tag;

@TargetApi(19)
final class NfcImpl$ReaderCallbackHandler implements NfcAdapter.ReaderCallback {
  private final NfcImpl mNfcImpl;
  
  public NfcImpl$ReaderCallbackHandler(NfcImpl paramNfcImpl) {
    this.mNfcImpl = paramNfcImpl;
  }
  
  public final void onTagDiscovered(Tag paramTag) {
    // Byte code:
    //   0: aload_0
    //   1: getfield mNfcImpl : Lorg/chromium/device/nfc/NfcImpl;
    //   4: astore_2
    //   5: aload_1
    //   6: ifnull -> 67
    //   9: aload_1
    //   10: invokestatic get : (Landroid/nfc/Tag;)Landroid/nfc/tech/Ndef;
    //   13: astore_3
    //   14: aload_3
    //   15: ifnull -> 38
    //   18: new org/chromium/device/nfc/NfcTagHandler
    //   21: dup
    //   22: aload_3
    //   23: new org/chromium/device/nfc/NfcTagHandler$NdefHandler
    //   26: dup
    //   27: aload_3
    //   28: invokespecial <init> : (Landroid/nfc/tech/Ndef;)V
    //   31: invokespecial <init> : (Landroid/nfc/tech/TagTechnology;Lorg/chromium/device/nfc/NfcTagHandler$TagTechnologyHandler;)V
    //   34: astore_1
    //   35: goto -> 69
    //   38: aload_1
    //   39: invokestatic get : (Landroid/nfc/Tag;)Landroid/nfc/tech/NdefFormatable;
    //   42: astore_1
    //   43: aload_1
    //   44: ifnull -> 67
    //   47: new org/chromium/device/nfc/NfcTagHandler
    //   50: dup
    //   51: aload_1
    //   52: new org/chromium/device/nfc/NfcTagHandler$NdefFormattableHandler
    //   55: dup
    //   56: aload_1
    //   57: invokespecial <init> : (Landroid/nfc/tech/NdefFormatable;)V
    //   60: invokespecial <init> : (Landroid/nfc/tech/TagTechnology;Lorg/chromium/device/nfc/NfcTagHandler$TagTechnologyHandler;)V
    //   63: astore_1
    //   64: goto -> 69
    //   67: aconst_null
    //   68: astore_1
    //   69: aload_2
    //   70: aload_1
    //   71: putfield mTagHandler : Lorg/chromium/device/nfc/NfcTagHandler;
    //   74: aload_2
    //   75: invokevirtual processPendingWatchOperations : ()V
    //   78: aload_2
    //   79: invokevirtual processPendingPushOperation : ()V
    //   82: aload_2
    //   83: getfield mTagHandler : Lorg/chromium/device/nfc/NfcTagHandler;
    //   86: ifnull -> 129
    //   89: aload_2
    //   90: getfield mTagHandler : Lorg/chromium/device/nfc/NfcTagHandler;
    //   93: getfield mTech : Landroid/nfc/tech/TagTechnology;
    //   96: invokeinterface isConnected : ()Z
    //   101: ifeq -> 129
    //   104: aload_2
    //   105: getfield mTagHandler : Lorg/chromium/device/nfc/NfcTagHandler;
    //   108: getfield mTech : Landroid/nfc/tech/TagTechnology;
    //   111: invokeinterface close : ()V
    //   116: return
    //   117: astore_1
    //   118: ldc 'NfcImpl'
    //   120: ldc 'Cannot close NFC tag connection.'
    //   122: iconst_0
    //   123: anewarray java/lang/Object
    //   126: invokestatic w : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   129: return
    // Exception table:
    //   from	to	target	type
    //   104	116	117	java/io/IOException
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\device\nfc\NfcImpl$ReaderCallbackHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */