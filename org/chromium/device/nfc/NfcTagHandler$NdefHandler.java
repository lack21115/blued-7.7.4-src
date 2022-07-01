package org.chromium.device.nfc;

import android.nfc.NdefMessage;
import android.nfc.tech.Ndef;

final class NfcTagHandler$NdefHandler implements NfcTagHandler$TagTechnologyHandler {
  private final Ndef mNdef;
  
  NfcTagHandler$NdefHandler(Ndef paramNdef) {
    this.mNdef = paramNdef;
  }
  
  public final NdefMessage read() {
    return this.mNdef.getNdefMessage();
  }
  
  public final void write(NdefMessage paramNdefMessage) {
    this.mNdef.writeNdefMessage(paramNdefMessage);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\device\nfc\NfcTagHandler$NdefHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */