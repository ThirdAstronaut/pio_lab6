import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class UserTest {

    private User user;

    @BeforeEach
    void setUp(){
        user = new User();
    }

    @Test
    void setSurname() {
        String surname = "xaasdas";
        user.setSurname(surname);
        assertEquals(surname, user.getSurname());
    }

    /**assert null*/
    @Test
    void setWrongSurname() {
        String surname = "";
        user.setSurname(surname);
        assertNull(user.getSurname());
    }

    @Test
    void setIDCardNo() {
        String IDCardNo = "CAV23132";
        user.setIDCardNo(IDCardNo);
        assertEquals(IDCardNo, user.getIDCardNo());
    }
    @Test
    void setWrongIDCardNo() {
        String IDCardNo = "C";
        user.setSurname(IDCardNo);
        assertNull(user.getIDCardNo());
    }


    @Test
    void setPESELno() {
        String PESELno = "99192939485";
        user.setPESELno(PESELno);
        assertEquals(PESELno, user.getPESELno());
    }
    @Test
    void setWrongPESELNo() {
        String PESELno = "99aasasas5";
        user.setPESELno(PESELno);
        assertNull(user.getPESELno());
    }

    @Test
    void setWrongPhoneNo() {
        String phoneNo = "1234";
        user.setPhoneNo(phoneNo);
        assertNull(user.getPhoneNo());
    }

    @Test
    void setPhoneNo() {
        String phoneNo = "123456789";
        user.setPhoneNo(phoneNo);
        assertEquals(phoneNo, user.getPhoneNo());
    }

    @Test
    void setAge() {
        user.setAge(15);
        assertEquals(15, user.getAge());
    }

    @Test
    void setWrongAge() {
        assertThrows(IllegalArgumentException.class, () -> {
            user.setAge(155);
        });

    }
}