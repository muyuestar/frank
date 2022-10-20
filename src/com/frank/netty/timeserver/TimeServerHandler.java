package com.frank.netty.timeserver;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * 时间服务器服务端
 * @author kst
 * @date 2020年1月2日 下午2:55:49
 * 
 */
public class TimeServerHandler extends ChannelInboundHandlerAdapter {

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		final ByteBuf time = ctx.alloc().buffer(4);
		time.writeInt((int)(System.currentTimeMillis() / 1000L +2208988800L));
		final ChannelFuture f = ctx.writeAndFlush(time);
		f.addListener(new ChannelFutureListener() {
			
			@Override
			public void operationComplete(ChannelFuture future) throws Exception {
				assert f == future;
				ctx.close();
			}
		});
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		cause.printStackTrace();
		ctx.close();
	}
}
