import java.util.Map;

public class ListData {
    private Map<Long, Node> list;
    private Long visible_count;
    private Long total_count;

    public Map<Long, Node> getList() {
        return list;
    }

    public void setList(Map<Long, Node> list) {
        this.list = list;
    }

    public Long getVisible_count() {
        return visible_count;
    }

    public void setVisible_count(Long visible_count) {
        this.visible_count = visible_count;
    }

    public Long getTotal_count() {
        return total_count;
    }

    public void setTotal_count(Long total_count) {
        this.total_count = total_count;
    }
}
