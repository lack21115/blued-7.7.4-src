package com.qiniu.android.dns.local;

import com.qiniu.android.dns.DnsException;
import com.qiniu.android.dns.Domain;
import com.qiniu.android.dns.IResolver;
import com.qiniu.android.dns.NetworkInfo;
import com.qiniu.android.dns.Record;
import java.io.IOException;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Random;

public final class Resolver implements IResolver {
  private static final Random random = new Random();
  
  final InetAddress address;
  
  private final int timeout;
  
  public Resolver(InetAddress paramInetAddress) {
    this(paramInetAddress, 10);
  }
  
  public Resolver(InetAddress paramInetAddress, int paramInt) {
    this.address = paramInetAddress;
    this.timeout = paramInt;
  }
  
  private byte[] udpCommunicate(byte[] paramArrayOfbyte) throws IOException {
    Exception exception;
    try {
      DatagramSocket datagramSocket = new DatagramSocket();
    } finally {
      exception = null;
    } 
    if (paramArrayOfbyte != null)
      paramArrayOfbyte.close(); 
    throw exception;
  }
  
  public Record[] resolve(Domain paramDomain, NetworkInfo paramNetworkInfo) throws IOException {
    Random random;
    byte[] arrayOfByte;
    synchronized (random) {
      int i = random.nextInt() & 0xFF;
      arrayOfByte = udpCommunicate(DnsMessage.buildQuery(paramDomain.domain, i));
      if (arrayOfByte != null)
        return DnsMessage.parseResponse(arrayOfByte, i, paramDomain.domain); 
      throw new DnsException(paramDomain.domain, "cant get answer");
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\qiniu\android\dns\local\Resolver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */