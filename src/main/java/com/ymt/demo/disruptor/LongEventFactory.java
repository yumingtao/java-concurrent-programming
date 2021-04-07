package com.ymt.demo.disruptor;

import com.lmax.disruptor.EventFactory;

/**
 * Description
 *
 * @author yumingtao
 * @date 4/6/21 10:46 AM
 */
public class LongEventFactory implements EventFactory<LongEvent> {
    @Override
    public LongEvent newInstance() {
        return new LongEvent();
    }
}
