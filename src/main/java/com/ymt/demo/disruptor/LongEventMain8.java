package com.ymt.demo.disruptor;

import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.util.DaemonThreadFactory;
import lombok.extern.slf4j.Slf4j;

import java.nio.ByteBuffer;
import java.util.concurrent.TimeUnit;

/**
 * Description
 *
 * @author yumingtao
 * @date 4/6/21 10:42 AM
 */
@Slf4j
public class LongEventMain8 {
    public static void main(String[] args) throws InterruptedException {
        LongEventFactory factory = new LongEventFactory();
        int bufferSize = 1024;

        Disruptor<LongEvent> disruptor = new Disruptor<>(LongEvent::new, bufferSize, DaemonThreadFactory.INSTANCE);

        disruptor.handleEventsWith((event, sequence, endOfBatch)-> log.info("Event: {}", event));

        log.info("starting...");
        disruptor.start();

        RingBuffer<LongEvent> ringBuffer = disruptor.getRingBuffer();

        ByteBuffer bb = ByteBuffer.allocate(8);
        for (long i = 0; true; i++) {
            log.info(">i: {}", i);
            bb.putLong(0, i);
            ringBuffer.publishEvent((event, sequence, buffer)-> event.setValue(buffer.getLong(0)), bb);
            TimeUnit.SECONDS.sleep(1);
        }
    }
}
