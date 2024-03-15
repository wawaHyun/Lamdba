
package com.turing.api.common;



import com.turing.api.enums.Messenger;

import java.security.PublicKey;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public abstract class AbstractService<T> {
public abstract Messenger save(T t) throws SQLException; //craete something
public abstract Messenger save2(T t); //craete something
public abstract List<T> findAll(); //list
public abstract Optional<T> findById(Long id);
public abstract String count(); //수 세는거
public abstract Optional<T> getOne(String memberid);
public abstract Messenger delete(T t);
public abstract Boolean existsById(Long id);
}