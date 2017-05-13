package zookeeper.niorpc;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

import org.apache.log4j.Logger;
/**
 * 
 * NIOClient.java 2016-8-20
 *
 * Copyright zhaocj  Inc. All rights reserved.
 * Love Me Like Love Justin Bieber
 */
public class NIOClient {
	private static final Logger log = Logger.getLogger(NIOClient.class);
	public static void main(String[] args) throws IOException {
		//创建一个SocketChannel
		SocketChannel  sc=SocketChannel.open();
		//连接服务器
		sc.connect(new InetSocketAddress("127.0.0.1",8888));		
		//写数据给服务器
		String msg="白菜白菜，我是青草，收到请回答 收到请回答！ ";
		ByteBuffer buffer=ByteBuffer.allocate(msg.getBytes().length);
		buffer.put(msg.getBytes());
		buffer.flip();
		sc.write(buffer);
		sc.shutdownOutput();		
		//读数据
		ByteBuffer readbuffer=ByteBuffer.allocate(1024);
		ByteArrayOutputStream bos=new ByteArrayOutputStream();
		int len=-1;
		while(true){
			readbuffer.clear();
			len=sc.read(readbuffer);
			if(len==-1) break;
			readbuffer.flip();
			while(readbuffer.hasRemaining()){
				bos.write(readbuffer.get());
			}
		}
		log.info("我收到："+new String(bos.toByteArray()));
		sc.close();
	}
}
