package org.craft.atom.protocol.rpc.model;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Represents a RPC header field.
 * <p>
 * 
 * The RPC header fields use the generic format as follows:
 * <pre>
 * 000-------------------------------------------------------------------015-------------------------------------------------------------------031
 * |                                 magic                                |                                header size                           |                      
 * 032--------------------------------039-----------044----045----046----047--------------------------------055--------------------------------063
 * |                version            |      st     |  hb  |  tw  |  rp  |        status code               |            reserved               |                
 * 064-----------------------------------------------------------------------------------------------------------------------------------------095
 * |                                                                 message id                                                                  |
 * |                                                                                                                                             |
 * 096-----------------------------------------------------------------------------------------------------------------------------------------127
 * |                                                                  body size                                                                  |
 * 128-----------------------------------------------------------------------------------------------------------------------------------------159
 * 
 * st = serialization type.
 * hb = heartbeat flag, set '0000 0100' means it is a heatbeat message.
 * tw = two way   flag, set '0000 0010' means it is tway message, the client wait for a response.
 * rp = response  flag, set '0000 0001' means it is response message, otherwise it's a request message.
 * </pre>
 * 
 * @author mindwind
 * @version 1.0, Jul 18, 2014
 */
@ToString
public class RpcHeader implements Serializable {

	
	private static final long   serialVersionUID   = -67119913240566784L;
	private static final byte   ST_MASK            = (byte) 0x1f        ;
	private static final byte   HB_MASK            = (byte) 0x20        ;
	private static final byte   TW_MASK            = (byte) 0x40        ;
	private static final byte   RP_MASK            = (byte) 0x80        ;
	
	
	@Getter @Setter private short magic      = (short) 0xcaf6;
	@Getter @Setter private short headerSize = (short) 20    ;
	@Getter @Setter private byte  version    = (byte)  1     ;
	@Getter		    private byte  st         = (byte)  1     ;
	@Getter		    private byte  hb         = (byte)  0     ;
	@Getter		    private byte  tw         = (byte)  0     ;
	@Getter		    private byte  rp         = (byte)  0     ;
	@Getter @Setter private byte  statusCode = (byte)  0     ;
	@Getter @Setter private byte  reserved   = (byte)  0     ;
	@Getter @Setter private long  id         = (long)  0     ;
	@Getter @Setter private int   bodySize   = (int)   0     ;
	
	
	public void setSt(byte st) {
		this.st = (byte) (st & ST_MASK);
	}
	
	public void setHb() {
		this.hb = HB_MASK;
	}
	
	public void setTw() {
		this.tw = TW_MASK;
	}
	
	public void setRp() {
		this.rp = RP_MASK;
	}

}