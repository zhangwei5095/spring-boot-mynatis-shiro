package cn.elvea.core.web.multipart;

import java.util.HashMap;
import java.util.Map;

public class FileUploadProgress {
    private long bytesRead;
    private long contentLength;
    private int items;

    public int getProgress() {
        Double a = Double.parseDouble(getBytesRead() + "");
        Double b = Double.parseDouble(getContentLength() + "");
        return (int) (a / b * 100);
    }

    public boolean isCompleted() {
        return getBytesRead() >= getContentLength();
    }

    public Map<String, Object> getStatusMap() {
        Map<String, Object> statusMap = new HashMap<>();
        statusMap.put("progress", getProgress());
        statusMap.put("completed", isCompleted());
        statusMap.put("item", items);
        return statusMap;
    }

    public long getBytesRead() {
        return bytesRead;
    }

    public void setBytesRead(long bytesRead) {
        this.bytesRead = bytesRead;
    }

    public long getContentLength() {
        return contentLength;
    }

    public void setContentLength(long contentLength) {
        this.contentLength = contentLength;
    }

    public int getItems() {
        return items;
    }

    public void setItems(int items) {
        this.items = items;
    }
}
