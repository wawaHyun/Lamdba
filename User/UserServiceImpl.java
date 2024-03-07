
package User;

import common.AbstractService;
import common.UtilServiceImpl;
import enums.Messenger;
import member.Member;
import common.UtilService;

import java.sql.SQLException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class UserServiceImpl extends AbstractService<Member> implements UserService {
    private static UserServiceImpl instance = new UserServiceImpl();
    private static UserRepository repository;
    Map<String, Member> users;

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
        users.put(member.getMemberId(), member);
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
        return users.getOrDefault(memberParam.getMemberId(), Member.builder().memberPw("").build())
                .getMemberPw()
                .equals(memberParam.getMemberPw())
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
        users.get(member.getName()).setMemberPw(member.getMemberPw());
        return "Password change complete";
    }

    @Override
    public String delete(Member member) {
        users.remove(member.getMemberId());
        return "member delete.";
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
                .toList();
    }

    // ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ>>>왜 NLNAME을 Key값으로 해서 헀는데 결과가 나오는가?
    @Override
    public Map<String, ?> findUsersByNemeFramMap(String memberid) {
        System.out.println("11 :" + memberid);
        return users
                .entrySet()
                .stream()
                .filter(i -> i.getKey().equals(memberid))
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
    public Optional<Member> getOne(String memberid) {
        return Optional.of(users.get(memberid));
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
                            .memberId(i)
                            .memberPw("1111")
                            .name(util.createRandomName())
                            .job(util.createRandomJob())
                            .address(util.createRandomMemberId())
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

}