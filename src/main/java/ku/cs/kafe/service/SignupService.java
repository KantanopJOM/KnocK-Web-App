package ku.cs.kafe.service;

import ku.cs.kafe.entity.Member;
import ku.cs.kafe.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class SignupService {
    @Autowired
    private MemberRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public boolean isUsernameAvailable(String username) {
        if (!username.equals("") && !username.equals("null") && !username.trim().isEmpty() && !username.contains(" ")) {
            System.out.println("in if");
            return repository.findByUsername(username) == null;
        }else {
            return repository.findByUsername(username) != null;
        }
    }

    public void createUser(Member user) {
        Member record = new Member();
        record.setFirstName(user.getFirstName());
        record.setLastName(user.getLastName());
        record.setUsername(user.getUsername());
        record.setTel(user.getTel());
        record.setAddress(user.getAddress());

        String hashedPassword = passwordEncoder.encode(user.getPassword());
        record.setPassword(hashedPassword);

        record.setRole("ROLE_USER");

        repository.save(record);
    }

    public Member getUser(String username) {
        return repository.findByUsername(username);
    }

}
