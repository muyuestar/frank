package com.frank.netty.timeserver;

import java.text.SimpleDateFormat;
import java.util.Date;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @author kst
 * @date 2020年1月2日 下午3:39:24
 * 
 */
public class TimeClientHandler extends ChannelInboundHandlerAdapter {

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		ByteBuf m = (ByteBuf) msg;
		try {
			long currentTimeMillis = (m.readUnsignedInt() - 2208988800L) * 1000L;
			Date currentTime = new Date(currentTimeMillis);
			System.out.println("原生日期：" + currentTime.toString());
			SimpleDateFormat sf = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
			System.out.println("格式化日期：" + sf.format(currentTime));
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
