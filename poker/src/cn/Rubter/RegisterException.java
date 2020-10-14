package cn.Rubter;

import sun.plugin2.message.Message;

/**
 * 继承Exception：必须处理，throw抛出异常，或者try，catch处理异常
 * 继承RuntimeException：可以不处理，交给Jvm处理（交给虚拟机处理）
 */

public class RegisterException extends Exception {
    public RegisterException() {
        super();
    }

    public RegisterException(String massage) {
        super(massage);
    }
}
