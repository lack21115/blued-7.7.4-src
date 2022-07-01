package org.chromium.device.nfc;

import android.nfc.tech.TagTechnology;
import java.io.IOException;

public final class NfcTagHandler {
  final TagTechnology mTech;
  
  final NfcTagHandler$TagTechnologyHandler mTechHandler;
  
  private boolean mWasConnected;
  
  NfcTagHandler(TagTechnology paramTagTechnology, NfcTagHandler$TagTechnologyHandler paramNfcTagHandler$TagTechnologyHandler) {
    this.mTech = paramTagTechnology;
    this.mTechHandler = paramNfcTagHandler$TagTechnologyHandler;
  }
  
  public final void connect() {
    if (!this.mTech.isConnected()) {
      this.mTech.connect();
      this.mWasConnected = true;
    } 
  }
  
  public final boolean isTagOutOfRange() {
    try {
      connect();
      return false;
    } catch (IOException iOException) {
      return this.mWasConnected;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\device\nfc\NfcTagHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */