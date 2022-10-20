package com.frank.netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;

/**
 * �����������ͨ��
 * 
 * @author kst
 * @date 2019��11��29�� ����4:34:36
 * 
 */
public class DiscardServerHandler extends ChannelInboundHandlerAdapter {

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		// super.channelRead(ctx, msg);
		ByteBuf in = (ByteBuf) msg;
		try {
			while (in.isReadable()) {
				System.out.println((char) in.readByte());
				System.out.flush();
			}
		} catch (Exception e) {
			throw new Exception();
		} finally {
			ReferenceCountUtil.release(msg);
		}
		// ����ֱ�Ӵ�ӡ
		System.out.println("Yes,A new client in = " + ctx.name());
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		// super.exceptionCaught(ctx, cause);
		// �����쳣ʱ�ر�����
		cause.printStackTrace();
		ctx.close();
	}
}
