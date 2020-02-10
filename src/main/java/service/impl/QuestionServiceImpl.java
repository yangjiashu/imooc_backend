package service.impl;

import dao.ClassMapper;
import dao.QuestionMapper;
import dao.SelectItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.Question;
import pojo.SelectItem;
import service.IQuestionService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class QuestionServiceImpl implements IQuestionService {
    @Autowired
    QuestionMapper questionMapper;
    @Autowired
    ClassMapper classMapper;
    @Autowired
    SelectItemMapper selectItemMapper;

    @Override
    public void create(Question question, int examId, List<String> selectItems) {
        questionMapper.create(question);
        int id = question.getId();

        // 加入选项表
        Map<String, String > map = new HashMap<String, String>(){{
            put("选项1","A");
            put("选项2","B");
            put("选项3","C");
            put("选项4","D");
            put("选项5","E");
            put("选项6","F");
            put("选项7","G");
        }};
        SelectItem selectItem = new SelectItem();
        if (selectItems.size() != 0) {
            int i = 1;
            for (String item: selectItems) {
                selectItem.setQuestionId(id);
                selectItem.setFlag(map.get("选项" + i));
                selectItem.setDesc(item);
                selectItemMapper.create(selectItem);
                i++;
            }
        }
    }

    @Override
    public List<Question> findByExamId(int id) {
        return questionMapper.findByExamId(id);
    }

    @Override
    public void update(Question question) {
        questionMapper.update(question);
    }

    @Override
    public List<SelectItem> findSelectItems(int id) {
        return selectItemMapper.findByQuestionId(id);
    }
}
