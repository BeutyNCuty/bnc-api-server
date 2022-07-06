package com.bnc.common.member.domain;

import com.bnc.common.support.BaseEntity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.logging.log4j.util.Strings;

import javax.persistence.*;
import java.time.OffsetDateTime;

import static com.google.common.base.Preconditions.checkArgument;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(
        uniqueConstraints = {
                @UniqueConstraint(name="uq_user_Id",columnNames="user_Id")
        }
)
public class Member extends BaseEntity {
    @Column(nullable = false, name = "user_Id")
    private String userId;
    private String password;
    private String addr;
    private String phone;

    @Enumerated(EnumType.STRING)
    public Grade grade = Grade.Bronze;

    private long totalPrice = 0;

    private OffsetDateTime creatAt = OffsetDateTime.now();

    @Enumerated(EnumType.STRING)
    private MemberStatus memberStatus= MemberStatus.CREATED;

    public Member(String userId, String password, String addr, String phone) {
        checkArgument(Strings.isNotBlank(userId));
        checkArgument(Strings.isNotBlank(password));
        checkArgument(Strings.isNotBlank(addr));
        checkArgument(Strings.isNotBlank(phone));

        this.userId = userId;
        this.password = password;
        this.addr = addr;
        this.phone = phone;
    }

    public void change(String password, String addr, String phone){
        checkArgument(Strings.isNotBlank(password));
        checkArgument(Strings.isNotBlank(addr));
        checkArgument(Strings.isNotBlank(phone));

        this.password = password;
        this.addr = addr;
        this.phone = phone;
    }

    public Member(String password, String addr, String phone) {
        this.password = password;
        this.addr = addr;
        this.phone = phone;
    }

    public void changePassword(String password){
        checkArgument(Strings.isNotBlank(password));

        this.password = password;
    }

    public void delete(){
        this.memberStatus = memberStatus.DELETED;
    }

    public void checkGrade(long price){

        if(price >= 0 && price < 200000){
            this.grade = Grade.Bronze;
        }else if(price >= 200000 && price <= 500000){
            this.grade = Grade.Silver;
        }else{
            this.grade = Grade.Gold;
        }
    }
}
