package fun.sast.sastpancake.pojo;

import lombok.Data;

@Data
public class Pancake {

    private int id;
    private String title;
    private String createTime;
    private String ddl;
    private boolean isDone;
}
