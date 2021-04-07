package com.ymt.demo.disruptor;

import com.lmax.disruptor.EventHandler;
import lombok.extern.slf4j.Slf4j;

/**
 * Description
 *
 * @author yumingtao
 * @date 4/6/21 10:51 AM
 */
@Slf4j
public class LongEventHandler implements EventHandler<LongEvent> {
    @Override
    public void onEvent(LongEvent longEvent, long l, boolean b) throws Exception {
        log.info("Event: {}", longEvent);
    }
}
