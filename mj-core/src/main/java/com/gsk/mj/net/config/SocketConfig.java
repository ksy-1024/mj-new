package com.gsk.mj.net.config;

import com.gsk.mj.net.Handle.FrontMsgHandle;
import com.gsk.mj.net.codedec.GameProtocolcodecFactory;
import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
import org.apache.mina.core.filterchain.IoFilter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.executor.ExecutorFilter;
import org.apache.mina.transport.socket.SocketSessionConfig;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

/**
 * Created by Administrator on 2017/7/5.
 *
 */
@Configuration
public class SocketConfig {
    private static final Logger logger = LoggerFactory.getLogger(SocketConfig.class);
    @Autowired
    private FrontMsgHandle frontMsgHandle;

    private static final int frontListenPort = 10122;


    @Bean
    public NioSocketAcceptor frontAcceptor(){
        NioSocketAcceptor acceptor = new NioSocketAcceptor();
        acceptor.setBacklog(1000);
        acceptor.setReuseAddress(true);
        acceptor.setHandler(frontMsgHandle);

        DefaultIoFilterChainBuilder chain = acceptor.getFilterChain();
        IoFilter protocol = new ProtocolCodecFilter(new GameProtocolcodecFactory());
        chain.addLast("codec", protocol);
//		threadpool = new OrderedThreadPoolExecutor(1000);
//		threadpool.setThreadFactory(new ServerThreadFactory("OrderedThreadPool"));
//		chain.addLast("threadPool", new ExecutorFilter(threadpool));

        chain.addLast("ThreadPool",new ExecutorFilter(Executors.newCachedThreadPool()));

        int recsize = 1024*1024*2;
        int sendsize = 1024*1024*2;
        int timeout = 10;
        //
        SocketSessionConfig sc = acceptor.getSessionConfig();
        sc.setReuseAddress(true);// 设置每一个非主监听连接的端口可以重用
        sc.setReceiveBufferSize(recsize);// 设置输入缓冲区的大小
        sc.setSendBufferSize(sendsize);// 设置输出缓冲区的大小
        sc.setReadBufferSize(recsize);
        sc.setTcpNoDelay(true);// flush函数的调用 设置为非延迟发送，为true则不组装成大包发送，收到东西马上发出
        sc.setSoLinger(0);
        //设置超时
        sc.setIdleTime(IdleStatus.BOTH_IDLE, timeout);
        try {
            acceptor.bind(new InetSocketAddress(frontListenPort));
        }catch (Exception e){

        }
        logger.info("start socket at port " + frontListenPort);
        return acceptor;
    }
}
