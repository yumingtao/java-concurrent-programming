package com.ymt.demo.disruptor;

import com.lmax.disruptor.RingBuffer;
import lombok.extern.slf4j.Slf4j;

import java.nio.ByteBuffer;

/**
 * Description
 *
 * @author yumingtao
 * @date 4/6/21 3:00 PM
 */
@Slf4j
public class LongEventProducer {
    private final RingBuffer<LongEvent> ringBuffer;

    public LongEventProducer(RingBuffer<LongEvent> ringBuffer) {
        this.ringBuffer = ringBuffer;
    }

    public void onData(ByteBuffer bb){
        long sequence = ringBuffer.next();
        log.info("The sequence: {}", sequence);
        try {
            LongEvent event = ringBuffer.get(sequence);
            event.setValue(bb.getLong(0));
        }finally {
            ringBuffer.publish(sequence);
        }
    }
}
