package dao;

import pojo.SelectItem;

import java.util.List;

public interface SelectItemMapper {
    void create (SelectItem selectItem);
    SelectItem findById(int id);
    List<SelectItem> findByQuestionId(int id);
}
