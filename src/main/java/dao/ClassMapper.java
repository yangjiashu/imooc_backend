package dao;

import pojo.Classes;

public interface ClassMapper {
    Classes findById(int id);
    Classes findByName(String name);
}
