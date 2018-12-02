package vip.proyi.mmall.dao;

import org.apache.ibatis.annotations.Param;
import vip.proyi.mmall.pojo.User;

public interface UserMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    /**
    * 检查用户名是否已存在
    * @param username
    * @return
    */
    int checkUsername(String username);
    /**
     * 检查email是否已存在
     * @param email
     * @return
     */
    int checkEmail(String email);
    /**
    * 用户登录
    * @param username
    * @param password
    * @return
    */
    User selectLogin(@Param("username") String username, @Param("password") String password);
    /**
    * 查找密保问题
    * @param username
    * @return
    */
    String selectQuestionByUsername(String username);
    /**
    * 找回密码问题答案是否正确
    * @param username
    * @param question
    * @param answer
    * @return
    */
    int checkAnswer(@Param("username") String username, @Param("question") String question, @Param("answer") String answer);
    /**
    * 忘记密码的重置密码
    * @param username
    * @param passwordNew
    * @return
    */
    int updatePasswordByUsername(@Param("username") String username, @Param("passwordNew") String passwordNew);
    /**
    * 检查原密码是否正确
    * @param
    * @return
    */
    int checkPassword(@Param("password") String password, @Param("userId") Integer userId);
    /**
    * 检查email是否存在并是否属于该用户
    * @param
    * @return
    */
    int checkEmailByUserId(@Param("email") String email, @Param("userId") Integer userId);
}