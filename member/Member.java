
package com.turing.api.member;
import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@ToString(exclude = {"id"})
public class Member {
    private Long id;
    private String memId;
    private String memPw;
    private String name;
    private String phone;
    private Long address;
    private String job;
    private Double height;
    private Double weight;
    @Builder(builderClassName = "builder")
    public Member(Long id,String memId, String memPw, String name,
                  String phone, Long address, String job, Double height, Double weight){
        this.id = id;
        this.memId = memId;
        this.memPw = memPw;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.job = job;
        this.height = height;
        this.weight = weight;
    }
}