package cn.hassan.model.site.bimmodel.query;

import lombok.Data;

@Data
public class BimfileQuery {
    private String nodeId;
    private String fileId;
    private int source;
    private String fileName;

    @Override
    public String toString() {
        return "BimfileQuery{" +
                "nodeId='" + nodeId + '\'' +
                ", fileId='" + fileId + '\'' +
                ", source=" + source +
                '}';
    }
}
