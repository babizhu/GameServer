package org.bbz.game;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * user         LIUKUN
 * time         14-3-26 下午7:51
 * <p/>
 * 需要通知到到客户端的异常
 */

@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@Data
public class ClientException extends RuntimeException{

    private final ErrorCode code;
    private final String msg;

}
