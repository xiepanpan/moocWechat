package com.imooc.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @author: xiepanpan
 * @Date: 2020/5/27
 * @Description:  实现客户端发出一个请求 服务端返回hello netty
 */
public class HelloServer {
    public static void main(String[] args) throws InterruptedException {

        //定义一对线程组 主线程组用于接受客户端的连接 但不做处理 丢给从线程组处理
        EventLoopGroup bossGroup  = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {

            //netty服务器的创建 ServerBootStrap 是一个启动类
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            //设置主从线程组
            serverBootstrap.group(bossGroup,workerGroup)
                    //设置nio的双向通道
                    .channel(NioServerSocketChannel.class)
                    //子处理器 用于处理workerGroup
                    .childHandler(new HelloServerInitializer());
            //启动server 并且设置8088为启动的端口号 同时启动方式为同步
            ChannelFuture channelFuture = serverBootstrap.bind(8088).sync();
            //监听关闭的channel 设置为同步方式
            channelFuture.channel().closeFuture().sync();
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }

    }
}
