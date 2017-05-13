package zookeeper.niorpc;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

import org.apache.log4j.Logger;
/**
 * 
 * NIOServer.java 2016-8-20
 *
 * Copyright zhaocj  Inc. All rights reserved.
 * Love Me Like Love Justin Bieber
 */
public class NIOServer {
	private static final Logger log = Logger.getLogger(NIOServer.class);
	public static void main(String[] args) throws IOException { 		
		//创建ServerSocketChannel
				ServerSocketChannel ssc=ServerSocketChannel.open(); 
				//绑定端口
				ssc.bind(new InetSocketAddress(8888));		
				//设置通道为非阻塞
				ssc.configureBlocking(false);		
				//创建通道选择器   管理通道 都必须是 非阻塞的
				Selector selector=Selector.open();		
				//将通道注册到通道选择器中 
				ssc.register(selector, SelectionKey.OP_ACCEPT);		
				//遍历通道选择器
				while(true){
					log.info("  我在8888监听.....  ");
					int nums=selector.select();
					if(nums<1) continue;
					//获取所有的keys（通道 、事件类型）
					Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
				    while(iterator.hasNext()){
				    	SelectionKey key = iterator.next();//（通道 、事件类型）
				    	if(key.isAcceptable()){
				    		//获取通道
				    		ServerSocketChannel channel = (ServerSocketChannel) key.channel();
				    		SocketChannel socketChannel = channel.accept();
				    		socketChannel.configureBlocking(false);
				    		socketChannel.register(selector, SelectionKey.OP_READ);
				    	}if(key.isReadable()){
				    		SocketChannel socketChannel=(SocketChannel) key.channel();		    		
				    		//读数据
				    		ByteBuffer buffer=ByteBuffer.allocate(1024);
				    		ByteArrayOutputStream bos=new ByteArrayOutputStream();
				    		int len=-1;
				    		while(true){
				    			buffer.clear();
				    			len=socketChannel.read(buffer);
				    			if(len==-1) break;
				    			buffer.flip();
				    			while(buffer.hasRemaining()){
				    				bos.write(buffer.get());
				    			}
				    		}		    		
				    		//写数据给客户端
				    		socketChannel.register(selector, SelectionKey.OP_WRITE,bos);//将变量和channel绑定		    		
				    	}if(key.isWritable()){		    		
				    		SocketChannel socketChannel=(SocketChannel) key.channel();
				    		ByteArrayOutputStream attachment = (ByteArrayOutputStream) key.attachment();
				    		attachment.write("\t服务器回复 ： 青草 青草 您的信息我还没有收到 ".getBytes());		    		
				    		ByteBuffer buffer=ByteBuffer.allocate(attachment.size());
				    		buffer.put(attachment.toByteArray());
				    		buffer.flip();
				    		socketChannel.write(buffer);		    		
				    		socketChannel.close();
				    	}
				    	iterator.remove();
				    }
				}
	}
}
