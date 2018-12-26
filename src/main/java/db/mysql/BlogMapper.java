package db.mysql;

import org.apache.ibatis.annotations.Select;

public interface BlogMapper {
    @Select("SELECT user_phone FROM user_info WHERE id = #{id}")
    Integer selectBlog(int id);
}
