//package controller;
//
//
//import com.starsky.meteor.db.entity.UserFollowEntity;
//import com.starsky.meteor.db.mapper.UserMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/testboot")
//public class TestBootController {
//    @Autowired
//    private UserMapper userMapper;
//
//    @RequestMapping(value={"/selectUserById"}, method=RequestMethod.GET)
//    public UserFollowEntity selectUserById(){
//        String id="1";
////        userMapper userMapper = new UserMapper();
//        UserFollowEntity userFollowEn = userMapper.getUserById(Integer.parseInt(id));
//        return userFollowEn;
//    }
//}
