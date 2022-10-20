package com.frank.netty.timeserver;

import java.text.SimpleDateFormat;
import java.util.Date;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @author kst
 * @date 2020��1��2�� ����3:39:24
 * 
 */
public class TimeClientHandler extends ChannelInboundHandlerAdapter {

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		ByteBuf m = (ByteBuf) msg;
		try {
			long currentTimeMillis = (m.readUnsignedInt() - 2208988800L) * 1000L;
			Date currentTime = new Date(currentTimeMillis);
			System.out.println("ԭ�����ڣ�" + currentTime.toString());
			SimpleDateFormat sf = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
			System.out.println("��ʽ�����ڣ�" + sf.format(currentTime));
		} finally {
			m.release();
		}
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		cause.getStackTrace();
		ctx.close();
	}
}
