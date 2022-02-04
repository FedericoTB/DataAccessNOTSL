package dto;

import com.fasterxml.jackson.annotation.JsonValue;
import dao.Programmer;
import dao.Project;

import java.util.Objects;
import java.util.Set;
/**
 * Clase POJO de transporte de datos para department. Implementa
 * etiquetas JSON para su serialización
 */
public class DepartmentDTO {
    private String id;
    private String name;
    private double budget;
    private Set<Project> ongoingProjects;
    private Set<Project> endedProjects;
    private Programmer boss;
    private Set<Programmer> historicBosses;

    public DepartmentDTO(String id, String name, double budget, Set<Project> ongoingProjects,
                         Set<Project> endedProjects, Programmer boss, Set<Programmer> historicBosses) {
        this.id = id;
        this.name = name;
        this.budget = budget;
        this.ongoingProjects = ongoingProjects;
        this.endedProjects = endedProjects;
        this.boss = boss;
        this.historicBosses = historicBosses;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public Set<Project> getOngoingProjects() {
        return ongoingProjects;
    }

    public void setOngoingProjects(Set<Project> ongoingProjects) {
        this.ongoingProjects = ongoingProjects;
    }

    public Set<Project> getEndedProjects() {
        return endedProjects;
    }

    public void setEndedProjects(Set<Project> endedProjects) {
        this.endedProjects = endedProjects;
    }

    public Programmer getBoss() {
        return boss;
    }

    public void setBoss(Programmer boss) {
        this.boss = boss;
    }

    public Set<Programmer> getHistoricBosses() {
        return historicBosses;
    }

    public void setHistoricBosses(Set<Programmer> historicBosses) {
        this.historicBosses = historicBosses;
    }
    /**
     * metodo toString
     * @return String representando al objeto
     */
    @Override
    @JsonValue
    public String toString() {
        return "{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", budget=" + budget +
                ", ongoingProjects=" + ongoingProjects +
                ", endedProjects=" + endedProjects +
                ", boss=" + boss +
                '}';
    }
    /**
     * metodo equals
     * @param o objeto a comparar
     * @return true si la id coincide, false si no
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DepartmentDTO that = (DepartmentDTO) o;
        return Objects.equals(id, that.id);
    }

}
