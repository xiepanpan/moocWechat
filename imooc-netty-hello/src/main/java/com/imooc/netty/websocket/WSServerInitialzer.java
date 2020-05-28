package com.imooc.netty.websocket;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.stream.ChunkedWriteHandler;

/**
 * @author: xiepanpan
 * @Date: 2020/5/27
 * @Description:
 */
public class WSServerInitialzer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();

        //websocket基于http协议 所以要用http编码器
        pipeline.addLast(new HttpServerCodec());
        //对写大数据流的支持
        pipeline.addLast(new ChunkedWriteHandler());
        //对httpMessage进行聚合 聚合成FullHttpRequest FullHttpResponse
        pipeline.addLast(new HttpObjectAggregator(1024*24));

        // ====================== 以上是用于支持http协议    ======================

        // ====================== 以下是支持httpWebsocket ======================
        /**
         * websocket 服务器处理的协议  用于指定给客户端连接访问的路由 ：/ws
         * 本handler会帮你处理一些繁重的复杂的事
         * 会帮你处理握手动作 handshaking(close,ping,pang)
         * 对websocket而言 都以frames进行传输的 不用数据类型对应frames不同
         */
        pipeline.addLast(new WebSocketServerProtocolHandler("/ws"));
        pipeline.addLast(new ChatHandler());
    }
}
