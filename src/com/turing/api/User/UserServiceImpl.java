
package com.turing.api.User;

import com.turing.api.member.Member;
import com.turing.api.common.AbstractService;
import com.turing.api.common.UtilServiceImpl;
import com.turing.api.enums.Messenger;

import com.turing.api.common.UtilService;

import java.sql.SQLException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class UserServiceImpl extends AbstractService<Member> implements UserService {
    private static UserServiceImpl instance = new UserServiceImpl();
    private static UserRepository repo;
    Map<String, Member> users;

    private UserServiceImpl() {
        this.users = new HashMap<>();
        this.repo = UserRepository.getInstance();
    }

    public static UserServiceImpl getInstance() {
        return instance;
    }


    //-----------------------------------singleton
    @Override
    public Messenger save(Member member) throws SQLException {
        Messenger result = Messenger.FAIL;
        if (!users.containsKey(member.getMemId())) {
            users.put(member.getMemId(), member);
            return repo.tain(member);
        }
        System.out.println("same ID already exists.");
        return Messenger.FAIL;
    }

    @Override
    public Messenger save2(Member member) {
        return null;
    }

    @Override
    public List<Member> findAll() throws SQLException {
//        return new ArrayList<>(users.values());
        List<Member> list = repo.findAll();
        list.forEach(System.out::println);
        System.out.println("Ok!");
        return list;
    }

    @Override
    public String login(Member member) throws SQLException {
        List<String> list = repo.login(member);

        if (!member.getMemId().equals(list.get(0))) {
            return "ID ["+member.getMemId()+"] is wrong ID";
        }
        if (!member.getMemPw().equals(list.get(1))) {
            return "Wrong password input.";
        }
        return "wellcome to back, "+list.get(0);
    }

    @Override
    public Optional<Member> findById(Long id) throws SQLException {
//        return Optional.of(users
//                .values().stream()
//                .filter(i->i.getId().equals(id))
//                .toList().get(0));
        repo.findById(id);
        return null;
    }

    @Override
    public Messenger updatePassword(Member member) throws SQLException {
        if (!member.getMemPw().equals(member.getMemPwRe())) {
            System.out.println("pw and reconfirm pw is Different.");
            return Messenger.FAIL;
        }
        System.out.println("password is same");
        repo.updatePassword(member);

        System.out.println("Password is successful update.");
        return Messenger.SUCCESS;
    }

    @Override
    public Messenger delete(Member member) throws SQLException {
//        users.remove(member.getMemId());
        List<String> list = repo.login(member);
        if (!member.getMemId().equals(list.get(0))) {
            System.out.println("ID ["+member.getMemId()+"] is wrong ID");
            return Messenger.FAIL;
        }
        if (!member.getMemPw().equals(list.get(1))) {
            System.out.println( "Wrong password input.");
            return Messenger.FAIL;
        }
        System.out.println("ID n PW is oK");
        repo.delete(member);
        System.out.println("successful delete.");

        return Messenger.SUCCESS;
    }

    @Override
    public Boolean existsById(Long id) {
        return users.containsKey(id);
    }

    @Override
    public List<Member> findUsersByName(Member name) {

        return users.values()
                .stream()
                .filter(i -> i.getName().equals(name.getName()))
                .collect(Collectors.toList());
    }

    @Override
    public Map<String, ?> findUsersByNemeFramMap(String memid) {
        System.out.println("11 :" + memid);
        return users
                .entrySet()
                .stream()
                .filter(i -> i.getKey().equals(memid))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    @Override
    public List<?> findUsersByJob(String userJob) {
        System.out.println("findUsersByJob 파라미터 : " + userJob);
        users.values()
                .stream().forEach(i -> System.out.println("직업 :" + i.getJob()));
        return users
                .values()
                .stream()
                .filter(i -> i.getJob().equals(userJob))
                .collect(Collectors.toList());
    }

    @Override
    public Map<String, ?> findUsersByJobFromMap(String job) {
        return users
                .entrySet()
                .stream()
                .filter(i -> i.getValue().getJob().equals(job))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    @Override
    public String count() {
        return users.size() + "";
    }

    @Override
    public Optional<Member> getOne(String memid) {
        return Optional.of(users.get(memid));
    }

    @Override
    public Map<String, ?> getUserMap() {
        return null;
    }

    @Override
    public String addUsers() {
        UtilService util = UtilServiceImpl.getInstance();
        IntStream.range(0, 5)
                .mapToObj(i -> util.createRandomMemberId())
                .forEach(i -> {
                    users.put(i, Member.builder()
                            .memId(i)
                            .memPw("1111")
                            .name(util.createRandomName())
                            .job(util.createRandomJob())
                            .address((long) (util.createRandomInteger(10, 99)))
                            .build());
                });
        return "add dummy : " + users.size();
    }

    @Override
    public String test() {
        return repo.test();
    }

    @Override
    public List<?> findUsers() throws SQLException {
        return repo.findUsers();
    }

    @Override
    public Messenger touch() {
        return repo.touch();
    }

    @Override
    public Messenger rm() {
        return repo.rm();
    }

    @Override
    public Messenger tain(Member mems) throws SQLException {
        return repo.tain(mems);
    }

    @Override
    public Messenger ls() throws SQLException {
        return repo.ls();
    }


}