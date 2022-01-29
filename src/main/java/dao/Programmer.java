package dao;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;
@NoArgsConstructor
@AllArgsConstructor
@Entity
@NamedQueries({
        @NamedQuery(name = "Programmer.findAll", query = "SELECT l FROM Programmer l")
})
public class Programmer {
    private String id;
    private String name;
    private String mail;
    private LocalDateTime entryDate;
    private Department department;
    private double salary;
    private String password;
//    private Set<Technology> technologies;
    private Set<Project> activeProjects;
    private Set<Commit> commits;
    private Set<Issue> issues;
    private Set<Login> logins;

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name="uuid", strategy="uuid2")
    @Type(type = "objectid")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String nombre) {
        this.name = nombre;
    }

    @Basic
    @Column(nullable = false)
    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Column(name = "entryDate", nullable = false)
    public LocalDateTime getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(LocalDateTime entry_date) {
        this.entryDate = entry_date;
    }

    @ManyToOne
    @JoinColumn(name = "department", referencedColumnName = "id")
    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Basic
    @Column(name = "salary", nullable = false)
    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Basic
    @Column(name = "password", nullable = false)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

//    @ElementCollection
//    public Set<Technology> getTechnologies() {
//        return technologies;
//    }

//    public void setTechnologies(Set<Technology> technologies) {
//        this.technologies = technologies;
//    }

    @ManyToMany
    @JoinTable(
            name = "project_assignment",
            joinColumns = @JoinColumn(name = "id_programmer"),
            inverseJoinColumns = @JoinColumn(name = "id_project"))
    public Set<Project> getActiveProjects() {
        return activeProjects;
    }

    public void setActiveProjects(Set<Project> activeProjects) {
        this.activeProjects = activeProjects;
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "programmer", cascade = CascadeType.DETACH)
    public Set<Commit> getCommits() {
        return commits;
    }

    public void setCommits(Set<Commit> commits) {
        this.commits = commits;
    }

    @ManyToMany
    @JoinTable(
            name = "issue_assignment",
            joinColumns = @JoinColumn(name = "id_programmer"),
            inverseJoinColumns = @JoinColumn(name = "id_issue"))
    public Set<Issue> getIssues() {
        return issues;
    }

    public void setIssues(Set<Issue> issues) {
        this.issues = issues;
    }

    @OneToMany
    public Set<Login> getLogins() {
        return logins;
    }

    public void setLogins(Set<Login> logins) {
        this.logins = logins;
    }

    public String basicToString() {
        return "Programmer{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", mail='" + mail + '\'' +
                ", entryDate=" + entryDate +
                ", department=" + department.basicToString() +
                ", salary=" + salary +
                '}';
    }
}
