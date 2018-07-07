package cn.hassan.model.jms.enums;


/**
 * Created with IntelliJ IDEA.
 * Author: hassan
 * Date: 2018/7/7 18:56
 * Description:
 */
public enum DestinationEnums {

    SEND_USER_DESTINATION       ("send_user_destination","注册用户队列")
    ;

    private String title;

    private String description;

    public String value() {
        return title;
    }


    public String description() {
        return description;
    }


    DestinationEnums(String title, String description) {
        this.title = title;
        this.description = description;
    }
}
