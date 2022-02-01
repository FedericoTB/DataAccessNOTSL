import controller.LoginController;
import dao.Login;
import dao.Programmer;
import dto.LoginDTO;
import manager.HibernateController;
import repository.LoginRepository;
import service.LoginService;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class DataAccessNOSL {

    private static DataAccessNOSL instance;
    private DataAccessNOSL () {

    }

    public static DataAccessNOSL getInstance() {
        if (instance == null) {
            instance = new DataAccessNOSL();
        }
        return instance;
    }

    public void Login () {
        LoginRepository repo = new LoginRepository(HibernateController.getInstance());
        LoginService service = new LoginService(repo);
        LoginController controller = LoginController.getInstance(service);

        Programmer programmer1 = new Programmer();
        programmer1.setId(UUID.randomUUID().toString());
        programmer1.setName("Sergio");
        programmer1.setMail("sps169@outlook.es");
        programmer1.setEntryDate(Date.from(Instant.now()));
        programmer1.setSalary(2000);
        programmer1.setPassword("holi");

        LoginDTO login1 = new LoginDTO();
        login1.setTime(Date.from(Instant.now()));
        login1.setActive(true);
        login1.setToken(UUID.randomUUID());
        login1.setProgrammer(programmer1);

        LoginDTO login2 = new LoginDTO();
        login2.setTime(Date.from(Instant.now()));
        login2.setActive(false);
        login2.setToken(UUID.randomUUID());
        login2.setProgrammer(programmer1);

        controller.insertLogin(login1);
        controller.insertLogin(login2);
//        List<LoginDTO> logins = controller.getAllLogins();
//        logins.forEach(System.out::println);
//        logins.forEach(controller::deleteLogin);
    }
}
