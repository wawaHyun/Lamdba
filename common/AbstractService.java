<<<<<<< HEAD
package common;

import enums.Messenger;

import java.util.List;
import java.util.Optional;

public abstract class AbstractService<T> {
public abstract Messenger save(T t); //craete something
public abstract Messenger save2(T t); //craete something
public abstract List<T> findAll(); //list
public abstract Optional<T> findById(Long id);
public abstract String count(); //수 세는거
public abstract Optional<T> getOne(String memberid);
public abstract String delete(T t);
public abstract Boolean existsById(Long id);
}
=======
package common;

import enums.Messenger;

import java.security.PublicKey;
import java.util.List;
import java.util.Optional;

public abstract class AbstractService<T> {
public abstract Messenger save(T t); //craete something
public abstract Messenger save2(T t); //craete something
public abstract List<T> findAll(); //list
public abstract Optional<T> findById(Long id);
public abstract String count(); //수 세는거
public abstract Optional<T> getOne(String memberid);
public abstract String delete(T t);
public abstract Boolean existsById(Long id);
}
>>>>>>> 2196d46e6208c0beff581b79a883ffc4796605a9
