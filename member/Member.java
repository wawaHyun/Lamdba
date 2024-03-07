
package member;
import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@ToString(exclude = {"id"})
public class Member {
    private Long id;
    private String memberId;
    private String memberPw;
    private String name;
    private int socialNum;
    private int phoneNum;
    private String address;
    private String job;
    private int height;
    private int weight;
    @Builder(builderClassName = "builder")
    public Member(Long id,String memberId, String memberPw, String name, int socialNum, int phoneNum, String address, String job, int height, int weight){
        this.id = id;
        this.memberId = memberId;
        this.memberPw = memberPw;
        this.name = name;
        this.socialNum = socialNum;
        this.phoneNum = phoneNum;
        this.address = address;
        this.job = job;
        this.height = height;
        this.weight = weight;
    }
}