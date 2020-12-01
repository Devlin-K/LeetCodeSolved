package org.dkwork.javatemplate.common.domain;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

public class PageUtil {
    // 包装分页控制对象
    public static <T> Page<T> createQueryPage(Long current, Long size) {
        Page<T> page = new Page<>();
        page.setCurrent(current == null ? 1L : current);
        //默认每页20条
        page.setSize(size == null ? 20L : size);
        return page;
    }
}
