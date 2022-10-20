package com.frank.netty.timeserver;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * 时间客户端
 * 
 * @author kst
 * @date 2020年1月2日 下午3:19:29
 * 
 */
public class TimeClient {

	public static void main(String[] args) throws InterruptedException {
		String host = args[0];
		int port = Integer.parseInt(args[1]);
		EventLoopGroup workerGroup = new NioEventLoopGroup();
		try {
			Bootstrap b = new Bootstrap();
			b.group(workerGroup);
			b.channel(NioSocketChannel.class);
			b.option(ChannelOption.SO_KEEPALIVE, true);
			b.handler(new ChannelInitializer<SocketChannel>() {

				@Override
				protected void initChannel(SocketChannel ch) throws Exception {
					ch.pipeline().addLast(new TimeClientHandler());
				}
			});

			// 启动客户端
			ChannelFuture cf = b.connect(host, port).sync();
			cf.channel().closeFuture().sync();
		} finally {
			workerGroup.shutdownGracefully();
		}
	}
}
