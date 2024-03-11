
package com.turing.api.User;

import com.turing.api.member.Member;
import common.AbstractService;
import common.UtilServiceImpl;
import enums.Messenger;

import common.UtilService;

import java.sql.SQLException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class UserServiceImpl extends AbstractService<Member> implements UserService {
    private static UserServiceImpl instance = new UserServiceImpl();
    private static UserRepository repository;
    Map<String, Member> users;
    List<Member> userls;

    private UserServiceImpl() {
        this.users = new HashMap<>();
        this.repository = UserRepository.getInstance();
    }

    public static UserServiceImpl getInstance() {
        return instance;
    }


    //-----------------------------------singleton
    @Override
    public Messenger save(Member member) {
        users.put(member.getMemId(), member);
        return Messenger.SUCCESS;
    }

    @Override
    public Messenger save2(Member member) {
        return null;
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(users.values());
    }

    @Override
    public String login(Member memberParam) {
        return users.getOrDefault(memberParam.getMemId(), Member.builder().memPw("").build())
                .getMemPw()
                .equals(memberParam.getMemPw())
                ? "wellcome to back" : "404 Not Found : login fail";
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.of(users
                .values()
                .stream()
                .filter(i -> i.getId().equals(id))
                .collect(Collectors.toList()).get(0));
    }

    @Override
    public String updatePassword(Member member) {
        users.get(member.getName()).setMemPw(member.getMemPw());
        return "Password change complete";
    }

    @Override
    public String delete(Member member) {
        users.remove(member.getMemId());
        return "com.turing.api.member delete.";
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

    // ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ>>>왜 NLNAME을 Key값으로 해서 헀는데 결과가 나오는가?
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

    // ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ>>>왜 NLNAME을 Key값으로 해서 헀는데 결과가 나오는가?
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
                            .address((long)(util.createRandomInteger(10,99)))
                            .build());
                });
        return "add dummy : " + users.size();
    }

    @Override
    public String test() {
        return repository.test();
    }

    @Override
    public List<?> findUsers() throws SQLException {
        return repository.findUsers();
    }

    @Override
    public Messenger touch() {
        return repository.touch();
    }

    @Override
    public String rm() {
        return repository.rm();
    }

    @Override
    public String tain(Member mems) {
        return repository.tain(mems);
    }

    @Override
    public String ls() throws SQLException {
        return repository.ls();
    }


}