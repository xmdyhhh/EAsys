package sdut.easys.Util;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
public class PageResult<T> {
    private List<T> list;
    private int total;

    public PageResult(List<T> list, int total) {
        this.list = list;
        this.total = total;
    }
}