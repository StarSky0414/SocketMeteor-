package db.mysql;

import db.mysql.entity.UserFollowEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface  UserMapper {
    @Select("select * from user_follow where id=#{id}")
    public UserFollowEntity getUserById(int id);


}
