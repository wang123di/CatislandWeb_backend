package cloud.catisland.ivory.common.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cloud.catisland.ivory.common.dao.model.User;
import cloud.catisland.ivory.common.dao.model.enums.UserRegStatus;
import cloud.catisland.ivory.common.dao.repository.UserRepository;
import cloud.catisland.ivory.system.model.BO.RegBO;

/**
 * UserService
 * @Author: Xy718
 * @Date: 2020-06-05 11:29:37
 * @LastEditors: Xy718
 * @LastEditTime: 2020-06-13 05:50:00
 */
@Service
public class UserService {

    @Autowired
    UserRepository uRepo;

    /**
     * 根据用户名检测一个用户是否已注册
     * @param username
     * @return {@link UserRegStatus}
     */
    public UserRegStatus checkUserRegedByUsername(String username){
        //TODO add：根据传入的所有内容检测非空Unique字段是否已被占用
        return uRepo.findByUserName(username) == null ? UserRegStatus.UnRegist : UserRegStatus.Registed;
    }

    public Optional<User> registUser(RegBO regBO){
        User inSaveUser=new User(regBO);
        return Optional.ofNullable(uRepo.save(inSaveUser));
    }

	public Optional<User> findByUserName(String username) {
		return Optional.of(uRepo.findByUserName(username));
	}

	public Optional<User> findById(long uid) {
		return uRepo.findById(uid);
	}

	public User save(User user) {
		return uRepo.save(user);
	}
}