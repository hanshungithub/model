package cn.hassan.model.common.enums;

import org.jetbrains.annotations.Nullable;

public enum SourceEnum {

    WEB       ((byte)1, "WEB"),
    MOBILE        ((byte)2, "手机"),
    ;
    /**
     * 状态值
     */
    private byte value;
    /**
     * 状态的描述
     */
    private String description;

    SourceEnum(byte value, String description) {
        this.value = value;
        this.description = description;
    }

    public byte value() {
        return value;
    }
    public String description() {
        return description;
    }


    /**
     * 把整数映射到枚举值
     * @param value
     * @return
     */
    @Nullable
    public static SourceEnum valueOf(byte value) {
        for(SourceEnum statusEnum : SourceEnum.values()) {
            if(statusEnum.value() == value) {
                return statusEnum;
            }
        }
        return null;
    }
}
