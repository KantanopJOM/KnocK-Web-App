package com.example.demo.repository;

import com.example.demo.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface MemberRepository extends JpaRepository<Member, UUID> {
    Member findByUsername(String username);
    Member findByFirstName(String firstName);
    Member findByLastName(String lastName);
    Member findByTel(String tel);
    Member findByAddress(String address);
}
