package org.chromium.device.nfc;

import android.annotation.TargetApi;
import android.app.Activity;
import android.nfc.FormatException;
import android.nfc.NdefMessage;
import android.nfc.NfcAdapter;
import android.nfc.NfcManager;
import android.nfc.TagLostException;
import android.os.Build;
import android.os.Handler;
import android.os.Process;
import android.util.SparseArray;
import java.net.MalformedURLException;
import java.net.URL;
import org.chromium.base.ContextUtils;
import org.chromium.base.Log;
import org.chromium.device.mojom.Nfc;
import org.chromium.device.mojom.NfcClient;
import org.chromium.device.mojom.NfcError;
import org.chromium.device.mojom.NfcMessage;
import org.chromium.device.mojom.NfcPushOptions;
import org.chromium.device.mojom.NfcRecord;
import org.chromium.device.mojom.NfcWatchOptions;
import org.chromium.mojo.bindings.Callbacks;
import org.chromium.mojo.system.MojoException;

public class NfcImpl implements Nfc {
  Activity mActivity;
  
  private NfcClient mClient;
  
  private final NfcDelegate mDelegate;
  
  private final boolean mHasPermission;
  
  private final int mHostId;
  
  private final NfcAdapter mNfcAdapter;
  
  private final NfcManager mNfcManager;
  
  private NfcImpl$PendingPushOperation mPendingPushOperation;
  
  private final Handler mPushTimeoutHandler;
  
  private Runnable mPushTimeoutRunnable;
  
  private NfcImpl$ReaderCallbackHandler mReaderCallbackHandler;
  
  NfcTagHandler mTagHandler;
  
  private int mWatcherId;
  
  private final SparseArray mWatchers;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public NfcImpl(int paramInt, NfcDelegate paramNfcDelegate) {
    boolean bool;
    this.mWatchers = new SparseArray();
    this.mPushTimeoutHandler = new Handler();
    this.mHostId = paramInt;
    this.mDelegate = paramNfcDelegate;
    if (ContextUtils.sApplicationContext.checkPermission("android.permission.NFC", Process.myPid(), Process.myUid()) == 0) {
      bool = true;
    } else {
      bool = false;
    } 
    this.mHasPermission = bool;
    NfcImpl$1 nfcImpl$1 = new NfcImpl$1(this);
    this.mDelegate.trackActivityForHost(this.mHostId, nfcImpl$1);
    if (!this.mHasPermission || Build.VERSION.SDK_INT < 19) {
      Log.w("NfcImpl", "NFC operations are not permitted.", new Object[0]);
      this.mNfcAdapter = null;
      this.mNfcManager = null;
      return;
    } 
    this.mNfcManager = (NfcManager)ContextUtils.sApplicationContext.getSystemService("nfc");
    if (this.mNfcManager == null) {
      Log.w("NfcImpl", "NFC is not supported.", new Object[0]);
      this.mNfcAdapter = null;
      return;
    } 
    this.mNfcAdapter = this.mNfcManager.getDefaultAdapter();
  }
  
  private void cancelPushTimeoutTask() {
    if (this.mPushTimeoutRunnable == null)
      return; 
    this.mPushTimeoutHandler.removeCallbacks(this.mPushTimeoutRunnable);
    this.mPushTimeoutRunnable = null;
  }
  
  private NfcError checkIfReady() {
    return (!this.mHasPermission || this.mActivity == null) ? createError(0) : ((this.mNfcManager == null || this.mNfcAdapter == null) ? createError(1) : (!this.mNfcAdapter.isEnabled() ? createError(2) : null));
  }
  
  private boolean checkIfReady(Callbacks.Callback1 paramCallback1) {
    NfcError nfcError = checkIfReady();
    if (nfcError == null)
      return true; 
    paramCallback1.call(nfcError);
    return false;
  }
  
  private void completePendingPushOperation(NfcError paramNfcError) {
    if (this.mPendingPushOperation == null)
      return; 
    cancelPushTimeoutTask();
    this.mPendingPushOperation.complete(paramNfcError);
    this.mPendingPushOperation = null;
    disableReaderModeIfNeeded();
  }
  
  private static NfcError createError(int paramInt) {
    NfcError nfcError = new NfcError((byte)0);
    nfcError.errorType = paramInt;
    return nfcError;
  }
  
  private void disableReaderModeIfNeeded() {
    if (this.mPendingPushOperation == null && this.mWatchers.size() == 0)
      disableReaderMode(); 
  }
  
  private static boolean matchesWatchOptions(NfcMessage paramNfcMessage, NfcWatchOptions paramNfcWatchOptions) {
    if (paramNfcWatchOptions.mode == 0 && (paramNfcMessage.url == null || paramNfcMessage.url.isEmpty()))
      return false; 
    if (!matchesWebNfcId(paramNfcMessage.url, paramNfcWatchOptions.url))
      return false; 
    if ((paramNfcWatchOptions.mediaType == null || paramNfcWatchOptions.mediaType.isEmpty()) && paramNfcWatchOptions.recordFilter == null)
      return true; 
    for (int i = 0; i < paramNfcMessage.data.length; i++) {
      boolean bool;
      boolean bool1;
      if (paramNfcWatchOptions.mediaType == null || paramNfcWatchOptions.mediaType.isEmpty()) {
        bool1 = true;
      } else {
        bool1 = paramNfcWatchOptions.mediaType.equals((paramNfcMessage.data[i]).mediaType);
      } 
      if (paramNfcWatchOptions.recordFilter == null || paramNfcWatchOptions.recordFilter.recordType == (paramNfcMessage.data[i]).recordType) {
        bool = true;
      } else {
        bool = false;
      } 
      if (bool1 && bool)
        return true; 
    } 
    return false;
  }
  
  private static boolean matchesWebNfcId(String paramString1, String paramString2) {
    if (paramString1 != null && !paramString1.isEmpty() && paramString2 != null && !paramString2.isEmpty())
      try {
        URL uRL1 = new URL(paramString1);
        URL uRL2 = new URL(paramString2);
        if (!uRL1.getProtocol().equals(uRL2.getProtocol()))
          return false; 
        String str = uRL1.getHost();
        StringBuilder stringBuilder = new StringBuilder(".");
        stringBuilder.append(uRL2.getHost());
        if (!str.endsWith(stringBuilder.toString()) && !uRL1.getHost().equals(uRL2.getHost()))
          return false; 
        if (uRL2.getPath().equals("/*"))
          return true; 
        boolean bool = uRL1.getPath().startsWith(uRL2.getPath());
        return bool;
      } catch (MalformedURLException malformedURLException) {
        return false;
      }  
    return true;
  }
  
  private void pendingPushOperationCompleted(NfcError paramNfcError) {
    completePendingPushOperation(paramNfcError);
    if (paramNfcError != null)
      this.mTagHandler = null; 
  }
  
  public final void cancelAllWatches(Nfc.CancelAllWatchesResponse paramCancelAllWatchesResponse) {
    if (!checkIfReady((Callbacks.Callback1)paramCancelAllWatchesResponse))
      return; 
    if (this.mWatchers.size() == 0) {
      paramCancelAllWatchesResponse.call(createError(3));
      return;
    } 
    this.mWatchers.clear();
    paramCancelAllWatchesResponse.call(null);
    disableReaderModeIfNeeded();
  }
  
  public final void cancelPush(int paramInt, Nfc.CancelPushResponse paramCancelPushResponse) {
    if (!checkIfReady((Callbacks.Callback1)paramCancelPushResponse))
      return; 
    if (paramInt == 1) {
      paramCancelPushResponse.call(createError(1));
      return;
    } 
    if (this.mPendingPushOperation == null) {
      paramCancelPushResponse.call(createError(3));
      return;
    } 
    completePendingPushOperation(createError(5));
    paramCancelPushResponse.call(null);
  }
  
  public final void cancelWatch(int paramInt, Nfc.CancelWatchResponse paramCancelWatchResponse) {
    if (!checkIfReady((Callbacks.Callback1)paramCancelWatchResponse))
      return; 
    if (this.mWatchers.indexOfKey(paramInt) < 0) {
      paramCancelWatchResponse.call(createError(3));
      return;
    } 
    this.mWatchers.remove(paramInt);
    paramCancelWatchResponse.call(null);
    disableReaderModeIfNeeded();
  }
  
  public void close() {
    this.mDelegate.stopTrackingActivityForHost(this.mHostId);
    disableReaderMode();
  }
  
  @TargetApi(19)
  final void disableReaderMode() {
    if (Build.VERSION.SDK_INT < 19)
      return; 
    if (this.mReaderCallbackHandler == null)
      return; 
    this.mReaderCallbackHandler = null;
    if (this.mActivity != null && this.mNfcAdapter != null && !this.mActivity.isDestroyed())
      this.mNfcAdapter.disableReaderMode(this.mActivity); 
  }
  
  final void enableReaderModeIfNeeded() {
    if (Build.VERSION.SDK_INT < 19)
      return; 
    if (this.mReaderCallbackHandler == null && this.mActivity != null) {
      if (this.mNfcAdapter == null)
        return; 
      if (this.mPendingPushOperation == null && this.mWatchers.size() == 0)
        return; 
      this.mReaderCallbackHandler = new NfcImpl$ReaderCallbackHandler(this);
      this.mNfcAdapter.enableReaderMode(this.mActivity, this.mReaderCallbackHandler, 15, null);
      return;
    } 
  }
  
  public final void onConnectionError(MojoException paramMojoException) {
    close();
  }
  
  final void processPendingPushOperation() {
    if (this.mTagHandler != null) {
      if (this.mPendingPushOperation == null)
        return; 
      if (this.mTagHandler.isTagOutOfRange()) {
        this.mTagHandler = null;
        return;
      } 
      try {
        this.mTagHandler.connect();
        NfcTagHandler nfcTagHandler = this.mTagHandler;
        NdefMessage ndefMessage = NfcTypeConverter.toNdefMessage(this.mPendingPushOperation.nfcMessage);
        nfcTagHandler.mTechHandler.write(ndefMessage);
        pendingPushOperationCompleted(null);
        return;
      } catch (InvalidNfcMessageException invalidNfcMessageException) {
        Log.w("NfcImpl", "Cannot write data to NFC tag. Invalid NfcMessage.", new Object[0]);
        pendingPushOperationCompleted(createError(4));
        return;
      } catch (TagLostException tagLostException) {
        Log.w("NfcImpl", "Cannot write data to NFC tag. Tag is lost.", new Object[0]);
        pendingPushOperationCompleted(createError(8));
        return;
      } catch (FormatException|IllegalStateException|java.io.IOException formatException) {
        Log.w("NfcImpl", "Cannot write data to NFC tag. IO_ERROR.", new Object[0]);
        pendingPushOperationCompleted(createError(8));
        return;
      } 
    } 
  }
  
  final void processPendingWatchOperations() {
    if (this.mTagHandler != null && this.mClient != null) {
      if (this.mWatchers.size() == 0)
        return; 
      if (this.mPendingPushOperation != null && this.mPendingPushOperation.nfcPushOptions.ignoreRead)
        return; 
      if (this.mTagHandler.isTagOutOfRange()) {
        this.mTagHandler = null;
        return;
      } 
      try {
        this.mTagHandler.connect();
        NdefMessage ndefMessage1 = this.mTagHandler.mTechHandler.read();
        NdefMessage ndefMessage2 = ndefMessage1;
        try {
          if (ndefMessage1.getByteArrayLength() > 32768) {
            Log.w("NfcImpl", "Cannot read data from NFC tag. NfcMessage exceeds allowed size.", new Object[0]);
            return;
          } 
        } catch (TagLostException tagLostException) {
          Log.w("NfcImpl", "Cannot read data from NFC tag. Tag is lost.", new Object[0]);
          NdefMessage ndefMessage = ndefMessage1;
        } catch (FormatException|IllegalStateException|java.io.IOException formatException) {}
      } catch (TagLostException tagLostException) {
        tagLostException = null;
      } catch (FormatException|IllegalStateException|java.io.IOException formatException1) {
        formatException1 = null;
        Log.w("NfcImpl", "Cannot read data from NFC tag. IO_ERROR.", new Object[0]);
      } 
    } else {
      return;
    } 
    Log.w("NfcImpl", "Cannot read data from NFC tag. Tag is lost.", new Object[0]);
    FormatException formatException2 = formatException1;
  }
  
  public final void push(NfcMessage paramNfcMessage, NfcPushOptions paramNfcPushOptions, Nfc.PushResponse paramPushResponse) {
    int i;
    if (!checkIfReady((Callbacks.Callback1)paramPushResponse))
      return; 
    byte b = 0;
    if (paramNfcMessage == null || paramNfcMessage.data == null || paramNfcMessage.data.length == 0) {
      i = b;
    } else {
      i = 0;
      while (true) {
        if (i < paramNfcMessage.data.length) {
          boolean bool;
          NfcRecord nfcRecord = paramNfcMessage.data[i];
          if (nfcRecord != null && (nfcRecord.recordType == 0 || (nfcRecord.data != null && nfcRecord.mediaType != null && !nfcRecord.mediaType.isEmpty()))) {
            bool = true;
          } else {
            bool = false;
          } 
          if (!bool) {
            i = b;
            break;
          } 
          i++;
          continue;
        } 
        i = 1;
        break;
      } 
    } 
    if (i == 0) {
      paramPushResponse.call(createError(4));
      return;
    } 
    if (paramNfcPushOptions.target == 1 || paramNfcPushOptions.timeout < 0.0D || (paramNfcPushOptions.timeout > 9.223372036854776E18D && !Double.isInfinite(paramNfcPushOptions.timeout))) {
      paramPushResponse.call(createError(1));
      return;
    } 
    if (this.mPendingPushOperation != null) {
      this.mPendingPushOperation.complete(createError(5));
      cancelPushTimeoutTask();
    } 
    this.mPendingPushOperation = new NfcImpl$PendingPushOperation(paramNfcMessage, paramNfcPushOptions, paramPushResponse);
    assert false;
    throw new AssertionError();
  }
  
  public final void resumeNfcOperations() {
    enableReaderModeIfNeeded();
  }
  
  public final void setClient(NfcClient paramNfcClient) {
    this.mClient = paramNfcClient;
  }
  
  public final void suspendNfcOperations() {
    disableReaderMode();
  }
  
  public final void watch(NfcWatchOptions paramNfcWatchOptions, Nfc.WatchResponse paramWatchResponse) {
    NfcError nfcError = checkIfReady();
    int i = 0;
    if (nfcError == null) {
      i = 1;
    } else {
      paramWatchResponse.call(Integer.valueOf(0), nfcError);
    } 
    if (!i)
      return; 
    i = this.mWatcherId + 1;
    this.mWatcherId = i;
    this.mWatchers.put(i, paramNfcWatchOptions);
    paramWatchResponse.call(Integer.valueOf(i), null);
    enableReaderModeIfNeeded();
    processPendingWatchOperations();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\device\nfc\NfcImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */