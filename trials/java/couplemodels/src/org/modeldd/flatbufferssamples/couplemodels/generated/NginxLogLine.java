// automatically generated by the FlatBuffers compiler, do not modify

package org.modeldd.flatbufferssamples.couplemodels.generated;

import java.nio.*;
import java.lang.*;
import java.util.*;
import com.google.flatbuffers.*;

@SuppressWarnings("unused")public final class NginxLogLine extends Table {
  public static NginxLogLine getRootAsNginxLogLine(ByteBuffer _bb) { return getRootAsNginxLogLine(_bb, new NginxLogLine()); }
  public static NginxLogLine getRootAsNginxLogLine(ByteBuffer _bb, NginxLogLine obj) { _bb.order(ByteOrder.LITTLE_ENDIAN); return (obj.__assign(_bb.getInt(_bb.position()) + _bb.position(), _bb)); }
  public void __init(int _i, ByteBuffer _bb) { bb_pos = _i; bb = _bb; }
  public NginxLogLine __assign(int _i, ByteBuffer _bb) { __init(_i, _bb); return this; }

  public String host() { int o = __offset(4); return o != 0 ? __string(o + bb_pos) : null; }
  public ByteBuffer hostAsByteBuffer() { return __vector_as_bytebuffer(4, 1); }
  public ByteBuffer hostInByteBuffer(ByteBuffer _bb) { return __vector_in_bytebuffer(_bb, 4, 1); }
  public String clientIP() { int o = __offset(6); return o != 0 ? __string(o + bb_pos) : null; }
  public ByteBuffer clientIPAsByteBuffer() { return __vector_as_bytebuffer(6, 1); }
  public ByteBuffer clientIPInByteBuffer(ByteBuffer _bb) { return __vector_in_bytebuffer(_bb, 6, 1); }
  public String timestamp() { int o = __offset(8); return o != 0 ? __string(o + bb_pos) : null; }
  public ByteBuffer timestampAsByteBuffer() { return __vector_as_bytebuffer(8, 1); }
  public ByteBuffer timestampInByteBuffer(ByteBuffer _bb) { return __vector_in_bytebuffer(_bb, 8, 1); }
  public String method() { int o = __offset(10); return o != 0 ? __string(o + bb_pos) : null; }
  public ByteBuffer methodAsByteBuffer() { return __vector_as_bytebuffer(10, 1); }
  public ByteBuffer methodInByteBuffer(ByteBuffer _bb) { return __vector_in_bytebuffer(_bb, 10, 1); }
  public String url() { int o = __offset(12); return o != 0 ? __string(o + bb_pos) : null; }
  public ByteBuffer urlAsByteBuffer() { return __vector_as_bytebuffer(12, 1); }
  public ByteBuffer urlInByteBuffer(ByteBuffer _bb) { return __vector_in_bytebuffer(_bb, 12, 1); }
  public String proto() { int o = __offset(14); return o != 0 ? __string(o + bb_pos) : null; }
  public ByteBuffer protoAsByteBuffer() { return __vector_as_bytebuffer(14, 1); }
  public ByteBuffer protoInByteBuffer(ByteBuffer _bb) { return __vector_in_bytebuffer(_bb, 14, 1); }
  public short httpStatus() { int o = __offset(16); return o != 0 ? bb.getShort(o + bb_pos) : 0; }
  public boolean mutateHttpStatus(short httpStatus) { int o = __offset(16); if (o != 0) { bb.putShort(o + bb_pos, httpStatus); return true; } else { return false; } }
  public int responseLen() { int o = __offset(18); return o != 0 ? bb.getInt(o + bb_pos) : 0; }
  public boolean mutateResponseLen(int responseLen) { int o = __offset(18); if (o != 0) { bb.putInt(o + bb_pos, responseLen); return true; } else { return false; } }
  public String referer() { int o = __offset(20); return o != 0 ? __string(o + bb_pos) : null; }
  public ByteBuffer refererAsByteBuffer() { return __vector_as_bytebuffer(20, 1); }
  public ByteBuffer refererInByteBuffer(ByteBuffer _bb) { return __vector_in_bytebuffer(_bb, 20, 1); }
  public String agent() { int o = __offset(22); return o != 0 ? __string(o + bb_pos) : null; }
  public ByteBuffer agentAsByteBuffer() { return __vector_as_bytebuffer(22, 1); }
  public ByteBuffer agentInByteBuffer(ByteBuffer _bb) { return __vector_in_bytebuffer(_bb, 22, 1); }

  public static int createNginxLogLine(FlatBufferBuilder builder,
      int hostOffset,
      int clientIPOffset,
      int timestampOffset,
      int methodOffset,
      int urlOffset,
      int protoOffset,
      short httpStatus,
      int responseLen,
      int refererOffset,
      int agentOffset) {
    builder.startObject(10);
    NginxLogLine.addAgent(builder, agentOffset);
    NginxLogLine.addReferer(builder, refererOffset);
    NginxLogLine.addResponseLen(builder, responseLen);
    NginxLogLine.addProto(builder, protoOffset);
    NginxLogLine.addUrl(builder, urlOffset);
    NginxLogLine.addMethod(builder, methodOffset);
    NginxLogLine.addTimestamp(builder, timestampOffset);
    NginxLogLine.addClientIP(builder, clientIPOffset);
    NginxLogLine.addHost(builder, hostOffset);
    NginxLogLine.addHttpStatus(builder, httpStatus);
    return NginxLogLine.endNginxLogLine(builder);
  }

  public static void startNginxLogLine(FlatBufferBuilder builder) { builder.startObject(10); }
  public static void addHost(FlatBufferBuilder builder, int hostOffset) { builder.addOffset(0, hostOffset, 0); }
  public static void addClientIP(FlatBufferBuilder builder, int clientIPOffset) { builder.addOffset(1, clientIPOffset, 0); }
  public static void addTimestamp(FlatBufferBuilder builder, int timestampOffset) { builder.addOffset(2, timestampOffset, 0); }
  public static void addMethod(FlatBufferBuilder builder, int methodOffset) { builder.addOffset(3, methodOffset, 0); }
  public static void addUrl(FlatBufferBuilder builder, int urlOffset) { builder.addOffset(4, urlOffset, 0); }
  public static void addProto(FlatBufferBuilder builder, int protoOffset) { builder.addOffset(5, protoOffset, 0); }
  public static void addHttpStatus(FlatBufferBuilder builder, short httpStatus) { builder.addShort(6, httpStatus, 0); }
  public static void addResponseLen(FlatBufferBuilder builder, int responseLen) { builder.addInt(7, responseLen, 0); }
  public static void addReferer(FlatBufferBuilder builder, int refererOffset) { builder.addOffset(8, refererOffset, 0); }
  public static void addAgent(FlatBufferBuilder builder, int agentOffset) { builder.addOffset(9, agentOffset, 0); }
  public static int endNginxLogLine(FlatBufferBuilder builder) {
    int o = builder.endObject();
    return o;
  }
}
