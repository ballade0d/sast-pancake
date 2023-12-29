package fun.sast.sastpancake.pojo;

import lombok.Data;

@Data
public class ResultData {

    private int status;
    private String message;
    private Object data;

    private ResultData() {
    }

    public static ResultData success(String message, Object data) {
        ResultData resultData = new ResultData();
        resultData.setStatus(200);
        resultData.setMessage(message);
        resultData.setData(data);
        return resultData;
    }

    public static ResultData success(Object data) {
        ResultData resultData = new ResultData();
        resultData.setStatus(200);
        resultData.setMessage("OK");
        resultData.setData(data);
        return resultData;
    }

    public static ResultData success(String message) {
        ResultData resultData = new ResultData();
        resultData.setStatus(200);
        resultData.setMessage(message);
        return resultData;
    }

    public static ResultData fail(int code, String message) {
        ResultData resultData = new ResultData();
        resultData.setStatus(code);
        resultData.setMessage(message);
        return resultData;
    }
}
