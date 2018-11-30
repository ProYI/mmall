package vip.proyi.mmall.dao;

import org.apache.ibatis.annotations.Param;
import vip.proyi.mmall.pojo.User;

import java.util.List;

public interface UserMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    /**
    * 检查用户名是否已存在
    * @param
    * @return
    */
    int checkUsername(String username);
    /**
     * 检查email是否已存在
     * @param
     * @return
     */
    int checkEmail(String email);
    /**
    * 用户登录
    * @param
    * @return
    */
    User selectLogin(@Param("username") String username, @Param("password") String password);
}